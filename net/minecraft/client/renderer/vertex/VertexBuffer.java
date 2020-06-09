/*    */ package net.minecraft.client.renderer.vertex;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.OpenGlHelper;
/*    */ 
/*    */ 
/*    */ public class VertexBuffer
/*    */ {
/*    */   private int glBufferId;
/*    */   private final VertexFormat vertexFormat;
/*    */   private int count;
/*    */   
/*    */   public VertexBuffer(VertexFormat vertexFormatIn) {
/* 15 */     this.vertexFormat = vertexFormatIn;
/* 16 */     this.glBufferId = OpenGlHelper.glGenBuffers();
/*    */   }
/*    */ 
/*    */   
/*    */   public void bindBuffer() {
/* 21 */     OpenGlHelper.glBindBuffer(OpenGlHelper.GL_ARRAY_BUFFER, this.glBufferId);
/*    */   }
/*    */ 
/*    */   
/*    */   public void bufferData(ByteBuffer data) {
/* 26 */     bindBuffer();
/* 27 */     OpenGlHelper.glBufferData(OpenGlHelper.GL_ARRAY_BUFFER, data, 35044);
/* 28 */     unbindBuffer();
/* 29 */     this.count = data.limit() / this.vertexFormat.getNextOffset();
/*    */   }
/*    */ 
/*    */   
/*    */   public void drawArrays(int mode) {
/* 34 */     GlStateManager.glDrawArrays(mode, 0, this.count);
/*    */   }
/*    */ 
/*    */   
/*    */   public void unbindBuffer() {
/* 39 */     OpenGlHelper.glBindBuffer(OpenGlHelper.GL_ARRAY_BUFFER, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void deleteGlBuffers() {
/* 44 */     if (this.glBufferId >= 0) {
/*    */       
/* 46 */       OpenGlHelper.glDeleteBuffers(this.glBufferId);
/* 47 */       this.glBufferId = -1;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\emlin\Desktop\BetterCraft.jar!\net\minecraft\client\renderer\vertex\VertexBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */