package Gameplay.Knight;

/**
 *Interface that sets for those that observer the Knight class. Each observer
 *must implement the handlePatternKey method, gives the PatternKey class 
 *information to be able to create the game's key
 * 
 * @author  Thomas Wray & Joe Cumins
 * @version 1
 */
public interface KnightObserver 
{
	/**
	 * handlePatternKey - observers are given the KnightSubject source 
	 * The PatternKey class can use this info to complete their specific task. 
	 */	
   public void handlePatternKey(KnightSubject source);
  
}
