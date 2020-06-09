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
/*    */ public class MouseButtonControl
/*    */   implements Control
/*    */ {
/*    */   private int button;
/*    */   
/*    */   public MouseButtonControl(int button) {
/* 18 */     this.button = button;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 25 */     if (o instanceof MouseButtonControl)
/*    */     {
/* 27 */       return (((MouseButtonControl)o).button == this.button);
/*    */     }
/*    */     
/* 30 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 37 */     return this.button;
/*    */   }
/*    */ }


/* Location:              C:\Users\emlin\Desktop\BetterCraft.jar!\org\newdawn\slick\command\MouseButtonControl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */