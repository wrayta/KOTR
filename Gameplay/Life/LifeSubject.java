package Gameplay.Life;

 /**
 *Interface that makes the LifeController class a subject that other classes will
 *observer. This gives the LifeController class the ability to add, remove, and 
 *notify observers.
 * 
 * @author  Thomas Wray & Joe Cumins
 * @version 1
 */
  public interface LifeSubject
  {
 
	/**
	 * addObserver - add observer to the LifeController Class
	 * 
	 * @param the new observer
	 */	
	public void addObserver(LifeObserver observer);
	
	/**
	 * removeObserver - removes an observer from the LifeController Class
	 * 
	 * @param the observer that will no longer be an observer
	 */	
	public void removeObserver(LifeObserver observer);
 

	/**
	 * notifyObserver - passes info to all of the LifeController observers
	 */	
	public void notifyObserver();
	
	/**
	 * getOutOfLivesCheck() - 
	 * 
	 * @param the observer that will no longer be an observer
	 */	
	public boolean getOutOfLivesCheck();
}
