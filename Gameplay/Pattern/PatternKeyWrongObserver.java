package Gameplay.Pattern;

/**
 * PatternKeyWrongObserver - observer to the PatternKeyWrongSubject
 * 
 */	
public interface PatternKeyWrongObserver 
{
	/**
	 * handleIncorrectAction - if a user clicks an incorrect knight
	 */	
	public void handleIncorrectAction(PatternKeySubject source);
}

