package Gameplay.Pattern;

/**
 * Interface that makes the PatternKey class a subject that other classes will
 * observer. This gives the PatternKey class the ability to add, remove, and
 * notify observers as well as the ability to ..... wrongObserver?
 * 
 * @author Thomas Wray & Joe Cumins
 * @version 1
 */
public interface PatternSubject {
    /**
     * addObserver - add observer to the PatternKey Class
     * 
     * @param the
     *            new observer
     */
    public void addObserver(PatternObserver observer);

    /**
     * notifyObserver - passes info to all of the PatternKey class observers
     */
    public void notifyObservers();

    /**
     * removeObserver - removes an observer from the PatternKey Class
     * 
     * @param the
     *            observer that will no longer be an observer
     */
    public void removeObserver(PatternObserver observer);

    public void setClickedOn();
}
