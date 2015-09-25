package Gameplay.Pattern;

/**
 *Interface that sets for those that observer the PatternKey class. Each observer
 *must implement the handleFunctionalityMethods method, which basically allows them to
 *know whether or not the user successfully clicked on the right knight (based
 *on what the pattern in the gold frame told them).
 * 
 * @author  Thomas Wray & Joe Cumins
 * @version 1
 */
public interface PatternKeyObserver 
{
	/**
	 * handleFunctionalityMethods - observers are given the KnightSubject source 
	 * (which tells them whether the user clicked the correct knight). They 
	 * can use this info to complete their specific task. 
	 */	
	public void handleFunctionalityMethods(PatternKeySubject source);
}
