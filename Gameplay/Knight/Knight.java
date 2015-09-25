package Gameplay.Knight;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import visual.dynamic.described.AbstractSprite;
import visual.statik.TransformableContent;

/**
 * Defines what a Knight Object is. Is the subject that the KnightObservers
 * listen to.
 * 
 * @author Thomas Wray & Joe Cumins
 * @version 1
 */
public class Knight extends AbstractSprite implements MouseListener,
	KnightSubject {
    private Random rng;
    private boolean correctGuess;
    private TransformableContent knightFoot;
    private TransformableContent knightRightFoot;
    private TransformableContent knightLeftFoot;
    private TransformableContent knightBalancedFeet;
    private TransformableContent knightIntro;
    private Rectangle2D bounds;
    private int knightID;
    private List<KnightObserver> observers;

    /**
     * constructor
     * 
     * @param knightIntro
     *            knight with no shield just armor (displayed when the game
     *            begins...same for all knights)
     * @param knightRightFoot
     *            knight with right foot in the air
     * @param knightLeftFoot
     *            knight with left foot in the air
     * @param knightBalancedFeet
     *            knight with feet flat on the ground
     * @param x
     *            location x coordinate
     * @param y
     *            location y coordinate
     * @param knightID
     *            number that allows us to differentiate knights
     */
    public Knight(TransformableContent knightIntro,
	    TransformableContent knightRightFoot,
	    TransformableContent knightLeftFoot,
	    TransformableContent knightBalancedFeet, double x, double y,
	    int knightID) {
	super();
	observers = new LinkedList<KnightObserver>();
	bounds = knightIntro.getBounds2D(true);
	this.knightID = knightID;
	this.knightRightFoot = knightRightFoot;
	this.knightLeftFoot = knightLeftFoot;
	this.knightBalancedFeet = knightBalancedFeet;
	this.knightIntro = knightIntro;
	this.knightFoot = knightIntro;
	rng = new Random();
	this.x = x;
	this.y = y;
	correctGuess = false;
	setLocation(x, y);

	setVisible(true);

    }

    /**
     * getContent - returns the TransformableContent of the knight in his
     * current position (right foot up, left foot up, feet flat, or the
     * introduction knight with no shield).
     * 
     * @return the TransformableContent of the knight
     */
    public TransformableContent getContent() {
	return knightFoot;
    }

    /**
     * handleTick - is passed the int representing the time and sets knightFoot
     * (the TransformableContent that is passed to the screen) according to
     * this.
     * 
     * @param the
     *            time (the 10 second count down for each round).
     */
    public void handleTick(int time) {
	double n;

	n = rng.nextDouble();

	if (time < 2000) {
	    knightFoot = knightIntro;
	}

	else if (time >= 11000) {
	    knightFoot = knightBalancedFeet;
	}

	else {
	    if (n < 0.80) {
		knightFoot = knightRightFoot;
	    }

	    else if (n > 0.90) {
		knightFoot = knightBalancedFeet;
	    }

	    n = rng.nextDouble();

	    if (n < 0.20) {
		knightFoot = knightBalancedFeet;
	    }

	    else if (n > 0.80) {
		knightFoot = knightLeftFoot;
	    }
	}

	if (correctGuess) {
	    knightFoot = knightIntro;
	}
    }

    @Override
    public void mouseClicked(MouseEvent event) {

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub

    }

    /**
     * mousePressed - registers if the knights has been clicked
     * 
     * @param event
     *            the click event
     */
    public void mousePressed(MouseEvent event) {
	double x;
	double y;

	x = (double) (event.getX());
	y = (double) (event.getY());

	if (bounds.contains(x, y)) {
	    notifyObserver();
	}

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
    }

    /**
     * addObserver - adds a KnightObserver to the group
     * 
     * @param observer
     *            observers this class
     */
    public void addObserver(KnightObserver observer) {
	observers.add(observer);
    }

    /**
     * removeObserver - removed a KnightObserver from the group
     * 
     * @param observer
     *            observers this class
     */
    public void removeObserver(KnightObserver observer) {
	observers.remove(observer);
    }

    /**
     * notifyObserver - informs that observers of the Knight class the info that
     * need to know
     */
    public void notifyObserver() {
	Iterator<KnightObserver> iterator;
	KnightObserver observer;

	iterator = observers.iterator();

	while (iterator.hasNext()) {
	    observer = iterator.next();
	    observer.handlePatternKey(this);
	}

    }

    /**
     * getKnightID - returns the knightID
     * 
     * @return the number that represents the knight
     */
    public int getKnightID() {

	return knightID;
    }

    @Override
    public void setClickedOn() {
	// TODO Auto-generated method stub
	correctGuess = true;
    }

}
