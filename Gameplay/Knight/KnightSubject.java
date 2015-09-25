package Gameplay.Knight;
/**
 *Interface that makes the Knight class a subject that other classes will
 *observer. This gives the Knight class the ability to add, remove, and 
 *notify observers as well as the ability to get knightIDs. 
 * 
 * @author  Thomas Wray & Joe Cumins
 * @version 1
 */
public interface KnightSubject
{ 
	/**
	 * addObserver - add observer to the Knight Class
	 * 
	 * @param the new observer
	 */	
	public void addObserver(KnightObserver observer);
	
	/**
	 * removeObserver - removes an observer from the Knight Class
	 * 
	 * @param the observer that will no longer be an observer
	 */	
	public void removeObserver(KnightObserver observer);
 
	/**
	 * notifyObserver - passes info to all of the Knight class observers
	 */	
	public void notifyObserver();
  
	/**
	 * getKnightID - returns the ID of a Knight
	 * 
	 * @param knight's identification number
	 */	
	public int getKnightID();
	
	public void setClickedOn();
	
}
