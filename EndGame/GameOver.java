package EndGame;

import io.ResourceFinder;
import visual.statik.sampled.Content;
import visual.statik.sampled.ContentFactory;

/**
 * Makes the gold frame image contents so that it can be passed to the 
 * InitGameLoop class and added to the stage
 * @author  Thomas Wray & Joe Cumins
 * @version 1
 */
public class GameOver
{
	private ContentFactory contentFactory;
	private ResourceFinder finder;

    /**
     * default constructor
     */
    public GameOver()
    {
        finder = ResourceFinder.createInstance(this);       
        contentFactory = new ContentFactory(finder);
	}
    
    /**
     * setFrame- creates the Content object for the gold frame for that pattern
     * on screen
     * 
     * @return the Content object that will be placed on the stage in the 
     * InitGameLoop class
     */
    public Content setGameOver()
    {
	    Content gameOver;
	    

	    gameOver = contentFactory.createContent("EndScreen.png", 4);
	    
		return gameOver;
    }
}
