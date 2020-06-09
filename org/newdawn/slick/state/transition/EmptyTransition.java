/*    */ package org.newdawn.slick.state.transition;
/*    */ 
/*    */ import org.newdawn.slick.GameContainer;
/*    */ import org.newdawn.slick.Graphics;
/*    */ import org.newdawn.slick.SlickException;
/*    */ import org.newdawn.slick.state.GameState;
/*    */ import org.newdawn.slick.state.StateBasedGame;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EmptyTransition
/*    */   implements Transition
/*    */ {
/*    */   public boolean isComplete() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public void postRender(StateBasedGame game, GameContainer container, Graphics g) throws SlickException {}
/*    */   
/*    */   public void preRender(StateBasedGame game, GameContainer container, Graphics g) throws SlickException {}
/*    */   
/*    */   public void update(StateBasedGame game, GameContainer container, int delta) throws SlickException {}
/*    */   
/*    */   public void init(GameState firstState, GameState secondState) {}
/*    */ }


/* Location:              C:\Users\emlin\Desktop\BetterCraft.jar!\org\newdawn\slick\state\transition\EmptyTransition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */