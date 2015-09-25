package Gameplay.Timer;

/**
 *Interface that makes the Timer class a subject that other classes will
 *observer. This gives the Timer class the ability to add, remove, and 
 *notify observers as well as the ability to get knightIDs. 
 * 
 * @author  Thomas Wray & Joe Cumins
 * @version 1
 */
public interface TimerSubject
{
	/**
	 * addObserver - add observer to the Timer Class
	 * 
	 * @param the new observer
	 */	
	public void addObserver(TimerObserver observer);
	
	/**
	 * removeObserver - removes an observer from the Timer Class
	 * 
	 * @param the observer that will no longer be an observer
	 */	
	public void removeObserver(TimerObserver observer);
 
	/**
	 * getOutOfTimeCheck() - 
	 * 
	 * @param the observer that will no longer be an observer
	 */	
	public boolean getOutOfTimeCheck();

	
	/**
	 * notifyObserver - passes info to all of the Timer class observers
	 */	
	public void notifyObserver();
  
}
