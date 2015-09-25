package Gameplay.Timer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Gameplay.Pattern.PatternKeyObserver;
import Gameplay.Pattern.PatternKeySubject;
import visual.dynamic.described.AbstractSprite;
import visual.statik.TransformableContent;

/**
 *  Setup for a TimerSprite object 
 * @author  Thomas Wray & Joe Cumins
 * @version 1
 */
public class TimerSprite extends AbstractSprite implements PatternKeyObserver, TimerSubject
{
	private List<TimerObserver> observers;
	private TransformableContent time;
	private ArrayList<TransformableContent> times;
	
	private boolean isOutOfTime;
	
    /**
     * constructor
     * 
     * @param timeContents		the digits 0-9 for the time   
     */
	public TimerSprite(TransformableContent[] timeContents)
	{
		super();

		isOutOfTime = false;
		
		observers = new LinkedList<TimerObserver>();
				
		this.times = new ArrayList<TransformableContent>();

		this.time = timeContents[timeContents.length - 1];
		
		for(int i = 0; i < timeContents.length; i++)
		{
			this.times.add(timeContents[i]);
		}

		setLocation(260, 190);
		setVisible(true);
	}
	
    /**
     *  getContent - get the current TransformableContent to display for the 
     *  time
     * 
     *  @return the current TransformableContent number to represent the time
     */
	protected TransformableContent getContent() 
	{
		return time;
	}

    /**
     * handleTick - based on the passed in second, time is set accordingly. 
     * In getContent it is retrieved to use on the stage. 
     * 
     * @param sec		the current second   
     */
	public void handleTick(int sec) 
	{
		
		
		notifyObserver();

			if (sec >= 0 && sec < 2000)
			{
				time = null;
			}
			
			else if (sec >= 2000 && sec < 3000)
			{
				if (1 <= times.size())
				{
					time = times.get(times.size() - 1);
				}

			}
			
			else if (sec >= 3000 && sec < 4000)
			{
				if (2 <= times.size())
				{
					time = times.get(times.size() - 2);
				}

			}
			
			else if (sec >= 4000 && sec < 5000)
			{
				if (3 <= times.size())
				{
					time = times.get(times.size() - 3);
				}

			}
			
			else if (sec >= 5000 && sec < 6000)
			{
				if (4 <= times.size())
				{
					time = times.get(times.size() - 4);
				}

			}
			
			else if (sec >= 6000 && sec < 7000)
			{
				if (5 <= times.size())
				{
					time = times.get(times.size() - 5);
				}

			}
			
			else if (sec >= 7000 && sec < 8000)
			{
				if (6 <= times.size())
				{
					time = times.get(times.size() - 6);
				}

			}
			
			else if (sec >= 8000 && sec < 9000)
			{
				if (7 <= times.size())
				{
					time = times.get(times.size() - 7);
				}

			}
			
			else if (sec >= 9000 && sec < 10000)
			{
				if (8 <= times.size())
				{
					time = times.get(times.size() - 8);
				}

			}
			
			else if (sec >= 10000 && sec < 11000)
			{
				if (9 <= times.size())
				{
					time = times.get(times.size() - 9);
				}
			}
			
			else
			{
				if (10 <= times.size())
				{
					time = times.get(times.size() - 10);
					
					isOutOfTime = true;
				}
			}

	}
	
    /**
     * handleFunctionalityMethods - As an observer to the PatternKey, 
     * TimerSprite accept the PatternKeySubject source so that it can know 
     * if what the user clicked matched the pattern in the key
     * 
     * @param PatternKey source     
     */
	public void handleFunctionalityMethods(PatternKeySubject source)
	{
		if (source.getRemainingPatternKey() == 0)
		{

		}
	}

    /**
     * addObserver - adds a PatternKeyObserver to the group 
     */
	public void addObserver(TimerObserver observer)
	{
	   observers.add(observer);
	}

    /**
     * removeObserver - removed a PatternKeyObserver from the group 
     */
	public void removeObserver(TimerObserver observer) 
	{
		observers.remove(observer);
	}

	 /**
     * notifyObserver - informs that observers of the PatternKey class the
     * info that need to know
     */
	public void notifyObserver() 
	{
		Iterator<TimerObserver> 	iterator;
		TimerObserver 				    observer;
		
		iterator = observers.iterator();
		
		while(iterator.hasNext())
		{
			observer = iterator.next();
			observer.handleOutOfTime(this);
					
		}
		
	}

	/**
	 * getOutOfTimeCheck() - 
	 * 
	 * @param the observer that will no longer be an observer
	 */	
	public boolean getOutOfTimeCheck()
	{
	  return isOutOfTime;
	}
	
}
