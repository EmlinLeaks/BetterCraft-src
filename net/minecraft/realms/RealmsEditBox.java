/*    */ package net.minecraft.realms;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiTextField;
/*    */ 
/*    */ 
/*    */ public class RealmsEditBox
/*    */ {
/*    */   private final GuiTextField editBox;
/*    */   
/*    */   public RealmsEditBox(int id, int x, int y, int width, int height) {
/* 12 */     this.editBox = new GuiTextField(id, (Minecraft.getMinecraft()).fontRendererObj, x, y, width, height);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getValue() {
/* 17 */     return this.editBox.getText();
/*    */   }
/*    */ 
/*    */   
/*    */   public void tick() {
/* 22 */     this.editBox.updateCursorCounter();
/*    */   }
/*    */ 
/*    */   
/*    */   public void setFocus(boolean p_setFocus_1_) {
/* 27 */     this.editBox.setFocused(p_setFocus_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setValue(String p_setValue_1_) {
/* 32 */     this.editBox.setText(p_setValue_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void keyPressed(char p_keyPressed_1_, int p_keyPressed_2_) {
/* 37 */     this.editBox.textboxKeyTyped(p_keyPressed_1_, p_keyPressed_2_);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isFocused() {
/* 42 */     return this.editBox.isFocused();
/*    */   }
/*    */ 
/*    */   
/*    */   public void mouseClicked(int p_mouseClicked_1_, int p_mouseClicked_2_, int p_mouseClicked_3_) {
/* 47 */     this.editBox.mouseClicked(p_mouseClicked_1_, p_mouseClicked_2_, p_mouseClicked_3_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void render() {
/* 52 */     this.editBox.drawTextBox();
/*    */   }
/*    */ 
/*    */   
/*    */   public void setMaxLength(int p_setMaxLength_1_) {
/* 57 */     this.editBox.setMaxStringLength(p_setMaxLength_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setIsEditable(boolean p_setIsEditable_1_) {
/* 62 */     this.editBox.setEnabled(p_setIsEditable_1_);
/*    */   }
/*    */ }


/* Location:              C:\Users\emlin\Desktop\BetterCraft.jar!\net\minecraft\realms\RealmsEditBox.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */