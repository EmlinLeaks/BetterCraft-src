/*    */ package net.minecraft.util;
/*    */ 
/*    */ 
/*    */ public abstract class LazyLoadBase<T>
/*    */ {
/*    */   private T value;
/*    */   private boolean isLoaded;
/*    */   
/*    */   public T getValue() {
/* 10 */     if (!this.isLoaded) {
/*    */       
/* 12 */       this.isLoaded = true;
/* 13 */       this.value = load();
/*    */     } 
/*    */     
/* 16 */     return this.value;
/*    */   }
/*    */   
/*    */   protected abstract T load();
/*    */ }


/* Location:              C:\Users\emlin\Desktop\BetterCraft.jar!\net\minecraf\\util\LazyLoadBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */