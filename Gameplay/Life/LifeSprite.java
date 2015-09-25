package Gameplay.Life;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Gameplay.Pattern.PatternKeySubject;
import Gameplay.Pattern.PatternKeyWrongObserver;
import visual.dynamic.described.AbstractSprite;
import visual.statik.TransformableContent;

/**
 * Setup for a LifeSprite object 
 * @author  Thomas Wray & Joe Cumins
 * @version 1
 */
public class LifeSprite extends AbstractSprite implements PatternKeyWrongObserver, LifeSubject
{
	private List<LifeObserver> observers;
	private int counter;
	private TransformableContent[] lives;
	private TransformableContent currentContent;
	private boolean isLivesAtZero;
	
    /**
     * constructor
     * 
     * @param lives	   TransformableContent representing the user's lives    
     */
	public LifeSprite(TransformableContent[] lives)
	{
		super();
		
		counter = 0;

		currentContent = lives[counter];
		
		isLivesAtZero = false;
		
		this.lives = new TransformableContent[lives.length];
		
		observers = new LinkedList<LifeObserver>();
		
		for (int i = 0; i < lives.length; i++)
		{
			this.lives[i] = lives[i];
		}
		
    	setVisible (true);

	}

    /**
     * handleIncorrectAction - this method is given from the PatternKey
     * the information as to whether the user clicked the correct knight (based
     * on the current shield pattern). 
     * 
     * @param PatternKey source     
     */
	public void handleIncorrectAction(PatternKeySubject source) 
	{

		if(counter == 2)
		{
			isLivesAtZero = true;
		}
		
		if(counter < 2)
		{
			counter++;		
		}	
		
		currentContent = lives[counter];

		notifyObserver();
		
	}

	 /**
     * addObserver - adds a LivesObserver to the group 
     */
	public void addObserver(LifeObserver observer) 
	{
		 observers.add(observer);
	}

     /**
     * removeObserver - removed a LivesObserver from the group 
     */
	public void removeObserver(LifeObserver observer)
	{
		observers.remove(observer);
	}

	 /**
     * notifyObserver - informs that observers of the Lives class the
     * info that need to know
     */
	public void notifyObserver() 
	{
		Iterator<LifeObserver> 	    iterator;
		LifeObserver 				    observer;
		
		iterator = observers.iterator();
		
		while(iterator.hasNext())
		{
			observer = iterator.next();
			observer.handleOutOfLives(this);
					
		}
		
	}


	 /**
     * getOutOfLivesCheck - returns boolean if there are 0 lives (true/false)
     */
	public boolean getOutOfLivesCheck() 
	{
		return isLivesAtZero;
	}


	 /**
     * getContent - get current sprite for lives (which number)
     */
	protected TransformableContent getContent() 
	{
		return currentContent;
	}

	public void handleTick(int arg0) 
	{
		
	}
}
