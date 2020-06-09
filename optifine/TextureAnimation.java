/*     */ package optifine;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.Properties;
/*     */ import net.minecraft.client.renderer.GLAllocation;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.texture.ITextureObject;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class TextureAnimation
/*     */ {
/*  13 */   private String srcTex = null;
/*  14 */   private String dstTex = null;
/*  15 */   ResourceLocation dstTexLoc = null;
/*  16 */   private int dstTextId = -1;
/*  17 */   private int dstX = 0;
/*  18 */   private int dstY = 0;
/*  19 */   private int frameWidth = 0;
/*  20 */   private int frameHeight = 0;
/*  21 */   private TextureAnimationFrame[] frames = null;
/*  22 */   private int activeFrame = 0;
/*  23 */   byte[] srcData = null;
/*  24 */   private ByteBuffer imageData = null;
/*     */ 
/*     */   
/*     */   public TextureAnimation(String p_i97_1_, byte[] p_i97_2_, String p_i97_3_, ResourceLocation p_i97_4_, int p_i97_5_, int p_i97_6_, int p_i97_7_, int p_i97_8_, Properties p_i97_9_, int p_i97_10_) {
/*  28 */     this.srcTex = p_i97_1_;
/*  29 */     this.dstTex = p_i97_3_;
/*  30 */     this.dstTexLoc = p_i97_4_;
/*  31 */     this.dstX = p_i97_5_;
/*  32 */     this.dstY = p_i97_6_;
/*  33 */     this.frameWidth = p_i97_7_;
/*  34 */     this.frameHeight = p_i97_8_;
/*  35 */     int i = p_i97_7_ * p_i97_8_ * 4;
/*     */     
/*  37 */     if (p_i97_2_.length % i != 0)
/*     */     {
/*  39 */       Config.warn("Invalid animated texture length: " + p_i97_2_.length + ", frameWidth: " + p_i97_7_ + ", frameHeight: " + p_i97_8_);
/*     */     }
/*     */     
/*  42 */     this.srcData = p_i97_2_;
/*  43 */     int j = p_i97_2_.length / i;
/*     */     
/*  45 */     if (p_i97_9_.get("tile.0") != null)
/*     */     {
/*  47 */       for (int k = 0; p_i97_9_.get("tile." + k) != null; k++)
/*     */       {
/*  49 */         j = k + 1;
/*     */       }
/*     */     }
/*     */     
/*  53 */     String s2 = (String)p_i97_9_.get("duration");
/*  54 */     int l = Config.parseInt(s2, p_i97_10_);
/*  55 */     this.frames = new TextureAnimationFrame[j];
/*     */     
/*  57 */     for (int i1 = 0; i1 < this.frames.length; i1++) {
/*     */       
/*  59 */       String s = (String)p_i97_9_.get("tile." + i1);
/*  60 */       int j1 = Config.parseInt(s, i1);
/*  61 */       String s1 = (String)p_i97_9_.get("duration." + i1);
/*  62 */       int k1 = Config.parseInt(s1, l);
/*  63 */       TextureAnimationFrame textureanimationframe = new TextureAnimationFrame(j1, k1);
/*  64 */       this.frames[i1] = textureanimationframe;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean nextFrame() {
/*  70 */     if (this.frames.length <= 0)
/*     */     {
/*  72 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  76 */     if (this.activeFrame >= this.frames.length)
/*     */     {
/*  78 */       this.activeFrame = 0;
/*     */     }
/*     */     
/*  81 */     TextureAnimationFrame textureanimationframe = this.frames[this.activeFrame];
/*  82 */     textureanimationframe.counter++;
/*     */     
/*  84 */     if (textureanimationframe.counter < textureanimationframe.duration)
/*     */     {
/*  86 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  90 */     textureanimationframe.counter = 0;
/*  91 */     this.activeFrame++;
/*     */     
/*  93 */     if (this.activeFrame >= this.frames.length)
/*     */     {
/*  95 */       this.activeFrame = 0;
/*     */     }
/*     */     
/*  98 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getActiveFrameIndex() {
/* 105 */     if (this.frames.length <= 0)
/*     */     {
/* 107 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 111 */     if (this.activeFrame >= this.frames.length)
/*     */     {
/* 113 */       this.activeFrame = 0;
/*     */     }
/*     */     
/* 116 */     TextureAnimationFrame textureanimationframe = this.frames[this.activeFrame];
/* 117 */     return textureanimationframe.index;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFrameCount() {
/* 123 */     return this.frames.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean updateTexture() {
/* 128 */     if (this.dstTextId < 0) {
/*     */       
/* 130 */       ITextureObject itextureobject = TextureUtils.getTexture(this.dstTexLoc);
/*     */       
/* 132 */       if (itextureobject == null)
/*     */       {
/* 134 */         return false;
/*     */       }
/*     */       
/* 137 */       this.dstTextId = itextureobject.getGlTextureId();
/*     */     } 
/*     */     
/* 140 */     if (this.imageData == null) {
/*     */       
/* 142 */       this.imageData = GLAllocation.createDirectByteBuffer(this.srcData.length);
/* 143 */       this.imageData.put(this.srcData);
/* 144 */       this.srcData = null;
/*     */     } 
/*     */     
/* 147 */     if (!nextFrame())
/*     */     {
/* 149 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 153 */     int k = this.frameWidth * this.frameHeight * 4;
/* 154 */     int i = getActiveFrameIndex();
/* 155 */     int j = k * i;
/*     */     
/* 157 */     if (j + k > this.imageData.capacity())
/*     */     {
/* 159 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 163 */     this.imageData.position(j);
/* 164 */     GlStateManager.bindTexture(this.dstTextId);
/* 165 */     GL11.glTexSubImage2D(3553, 0, this.dstX, this.dstY, this.frameWidth, this.frameHeight, 6408, 5121, this.imageData);
/* 166 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSrcTex() {
/* 173 */     return this.srcTex;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDstTex() {
/* 178 */     return this.dstTex;
/*     */   }
/*     */ 
/*     */   
/*     */   public ResourceLocation getDstTexLoc() {
/* 183 */     return this.dstTexLoc;
/*     */   }
/*     */ }


/* Location:              C:\Users\emlin\Desktop\BetterCraft.jar!\optifine\TextureAnimation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */