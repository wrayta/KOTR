package Gameplay.Life;

import io.ResourceFinder;
import visual.statik.TransformableContent;
import visual.statik.sampled.Content;
import visual.statik.sampled.ContentFactory;

/**
 * class that controls putting the LifeSprites (for the player's lives)
 * on the screen 
 * 
 * @author  Thomas Wray & Joe Cumins
 * @version 1
 */
public class LifeController 
{
	private ContentFactory contentFactory;
	private ResourceFinder finder;
	private int numOfLives;
    /**
     * default constructor  
     */
	public LifeController(int lives)
	{
		finder = ResourceFinder.createInstance(this);       
	    contentFactory = new ContentFactory(finder);
	    numOfLives = lives;
	}
	
    /**
     * setLives- makes the LifeSprite objects and returns them to the 
     * KOTRApp class (when called)
     * 
     * @return the LifeSprite objects
     * InitGameLoop class
     */
	public LifeSprite setLives()
	{
		TransformableContent[] lives;
		
		LifeSprite lifeSprites;
		
		lives = new Content[numOfLives];
		
		int maxLives = numOfLives;
		
		for(int i = 0; i < numOfLives; i++)
		{
			lives[i] = contentFactory.createContent("life" + maxLives + ".png", 4, false);
			maxLives--;
		}

		lifeSprites = new LifeSprite(lives);
		
		return lifeSprites;
	}
	
	
}