package Gameplay.Pattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Gameplay.Knight.KnightObserver;
import Gameplay.Knight.KnightSubject;
import Gameplay.Sound.GameSound;

/**
 * This class creates the key (the pattern in the frame that changes after each
 * round). The game (in other classes) compares this key to what the user clicks
 * to determine if the two match or not (is the user correct or not). It is a
 * knightObserver (gets info from the Knight class to be able to construct the
 * key). At the same time it is also a subject (feeds information to the classes
 * that need to know what the key is).
 * 
 * @author Thomas Wray & Joe Cumins
 * @version 1
 */
public class PatternKey implements KnightObserver, PatternKeySubject {
    private int[] check;
    private List<PatternKeyObserver> observers;
    private List<PatternKeyWrongObserver> wrongObservers;
    private ArrayList<Integer> answerKey;

    /**
     * constructor
     * 
     * @param size
     *            the size of the pattern
     * @param randomizedPattern
     *            the random pattern of shields
     */
    public PatternKey(int size, int[] randomizedPattern) {
	observers = new LinkedList<PatternKeyObserver>();
	wrongObservers = new LinkedList<PatternKeyWrongObserver>();
	answerKey = new ArrayList<Integer>();

	check = randomizedPattern;

	for (int i = 0; i < size; i++) {
	    answerKey.add(check[i]);
	}

    }

    /**
     * handlePatternKey - takes the information from the Knight class used to
     * help create the key
     * 
     * @param the
     *            KnightSubject
     */
    public void handlePatternKey(KnightSubject source) {
	int retrievedKnightID;

	retrievedKnightID = source.getKnightID();

	if (answerKey.size() > 0) {
	    if (retrievedKnightID == answerKey.get(0)) {
		GameSound sound = new GameSound();
		sound.playTheMusic("clash-strat.wav", false);
		source.setClickedOn();
		answerKey.remove(0);
		notifyObservers();
	    }

	    else {
		GameSound sound = new GameSound();
		sound.playTheMusic("womp2.wav", false);
		notifyWrongObservers();
	    }
	}
    }

    /**
     * addObserver - adds a PatternKeyObserver to the group
     */
    public void addObserver(PatternKeyObserver observer) {
	observers.add(observer);
    }

    /**
     * notifyObserver - informs that observers of the PatternKey class the info
     * that need to know
     */
    public void notifyObservers() {
	Iterator<PatternKeyObserver> iterator;
	PatternKeyObserver observer;

	iterator = observers.iterator();

	while (iterator.hasNext()) {
	    observer = iterator.next();
	    observer.handleFunctionalityMethods(this);
	}

    }

    /**
     * removeObserver - removed a PatternKeyObserver from the group
     */
    public void removeObserver(PatternKeyObserver observer) {
	observers.remove(observer);
    }

    /**
     * getRemainingPatternKey - gets the size of the answer key
     */
    public int getRemainingPatternKey() {
	return answerKey.size();
    }

    /**
     * addWrongObserver - adds a wrong observer to the subject
     */
    public void addWrongObserver(PatternKeyWrongObserver observer) {
	wrongObservers.add(observer);
    }

    /**
     * removeWrongObserver - removes a wrong observer from the subject
     */
    public void removeWrongObserver(PatternKeyWrongObserver observer) {
	wrongObservers.remove(observer);
    }

    /**
     * notifyWrongObserver - notify the observers of this class
     */
    public void notifyWrongObservers() {
	Iterator<PatternKeyWrongObserver> iterator;
	PatternKeyWrongObserver observer;

	iterator = wrongObservers.iterator();

	while (iterator.hasNext()) {
	    observer = iterator.next();
	    observer.handleIncorrectAction(this);
	}
    }

}
