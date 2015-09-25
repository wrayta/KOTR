package Initializers;

import io.ResourceFinder;
import visual.statik.sampled.Content;
import visual.statik.sampled.ContentFactory;

/**
 * Makes the background image contents so that it can be passed to the 
 * InitGameLoop class and added to the stage
 * @author  Thomas Wray & Joe Cumins
 * @version 1
 */
public class Background
{
    private ContentFactory contentFactory;
	private ResourceFinder finder;

    /**
     * default constructor
     */
    public Background()
    {
        finder = ResourceFinder.createInstance(this);       
        contentFactory = new ContentFactory(finder);
	}
    
    /**
     * setBackground- creates the Content Object for the background of the game 
     * 
     * @return the Content object that will be placed on the stage in the 
     * InitGameLoop class
     */
    public Content setBackground()
    {
    	Content background;
    	
    	background = contentFactory.createContent("Background_v3.png", 4);

		return background;
    }
}
