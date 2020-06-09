/*    */ package org.newdawn.slick.command;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class KeyControl
/*    */   implements Control
/*    */ {
/*    */   private int keycode;
/*    */   
/*    */   public KeyControl(int keycode) {
/* 19 */     this.keycode = keycode;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 26 */     if (o instanceof KeyControl) {
/* 27 */       return (((KeyControl)o).keycode == this.keycode);
/*    */     }
/*    */     
/* 30 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 37 */     return this.keycode;
/*    */   }
/*    */ }


/* Location:              C:\Users\emlin\Desktop\BetterCraft.jar!\org\newdawn\slick\command\KeyControl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */