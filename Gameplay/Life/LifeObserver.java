package Gameplay.Life;

/**
 *Interface that sets for those that observer the LifeController class. 
 *Each observer must implement the handleOutOfLives method, gives the observer
 *info about whether the player is or is not out of lives.
 * 
 * @author  Thomas Wray & Joe Cumins
 * @version 1
 */
   public interface LifeObserver
   {

	
		/**
		 * handleOutOfLives - if the player is out of lives then the observer
		 * should end the game 
		 */	
	   public void handleOutOfLives(LifeSubject source);
  }

