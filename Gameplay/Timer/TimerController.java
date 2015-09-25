package Gameplay.Timer;

import io.ResourceFinder;
import visual.statik.TransformableContent;
import visual.statik.sampled.ContentFactory;

/**
 * class that controls putting the TimerSprites (for the game time)
 * on the screen
 * 
 * @author  Thomas Wray & Joe Cumins
 * @version 1
 */
public class TimerController
{
	private ContentFactory contentFactory;
	private ResourceFinder finder;
	private int amountOfTime;
	
    /**
     * default constructor  
     */
    public TimerController()
    {
    	this(10);
	}
    
    /**
     * constructor
     * 
     * @param amountOfTime	the total amount of time for the round
     */
    public TimerController(int amountOfTime)
    {
    	finder = ResourceFinder.createInstance(this);       
        contentFactory = new ContentFactory(finder);
        this.amountOfTime = amountOfTime;
    }
    
    /**
     * setTime - makes the TimerSprite objects and returns them when 
     * the method is called in the InitGameLoop
     * 
     * @return the TimerSprite objects
     * InitGameLoop class
     */
    public TimerSprite setTime()
    {
    	String[] timeNames;
		TransformableContent[] timeContents;		
		TimerSprite timer;
		
		timeNames = new String[amountOfTime];
		timeContents = new TransformableContent[amountOfTime];
		
		for (int i = 0; i < timeNames.length; i++)
		{
			timeNames[i] = "Num" + i + "_Resized.png";
			timeContents[i] = contentFactory.createContent(timeNames[i], 4, false);
		}

		timer = new TimerSprite(timeContents);
				
		return timer;
    }
	
}
