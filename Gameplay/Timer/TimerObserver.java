package Gameplay.Timer;

/**
 *Interface that sets for those that observer the TimerController. Each observer
 *must implement the handleOutOfTime method, which identifies whether the 
 *user is or is not out of time.
 * 
 * @author  Thomas Wray & Joe Cumins
 * @version 1
 */
public interface TimerObserver 
{
	/**
	 * handleOutOfTime - if the player is out of time then the observer
	 * should end the game 
	 */		
   public void handleOutOfTime(TimerSubject source);
}
