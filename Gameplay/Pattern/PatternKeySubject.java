package Gameplay.Pattern;

/**
 *Interface that makes the PatternKey class a subject that other classes will
 *observer. This gives the PatternKey class the ability to add, remove, and 
 *notify observers as well as the ability to ..... wrongObserver?
 * 
 * @author  Thomas Wray & Joe Cumins
 * @version 1
 */
public interface PatternKeySubject
{
	/**
	 * addObserver - add observer to the PatternKey Class
	 * 
	 * @param the new observer
	 */	
	public void addObserver(PatternKeyObserver observer);
	
	/**
	 * addWrongObserver - add a wrong observer from the  PatternKey Class
	 * 
	 * @param the observer that will no longer be an observer
	 */	
	public void addWrongObserver(PatternKeyWrongObserver observer);
	
	/**
	 * notifyObserver - passes info to all of the  PatternKey class observers
	 */	
	public void notifyObservers();
	
	/**
	 * notifyWrongObserver - passes info to all of the  PatternKey class observers
	 */	
	public void notifyWrongObservers();
	
	/**
	 * removeObserver - removes an observer from the  PatternKey Class
	 * 
	 * @param the observer that will no longer be an observer
	 */	
	public void removeObserver(PatternKeyObserver observer);
	
	/**
	 * removeWrongObserver - removes a wrong observer from the  PatternKey Class
	 * 
	 * @param the observer that will no longer be an observer
	 */	
	public void removeWrongObserver(PatternKeyWrongObserver observer);
	
	/**
	 * getRemainingPatternKey - gets the rest of the pattern key
	 * 
	 */	
	public int getRemainingPatternKey();
	
}
