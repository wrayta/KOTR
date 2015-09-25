package Gameplay.Score;
import io.ResourceFinder;
import visual.dynamic.described.AbstractSprite;
import visual.statik.TransformableContent;
import visual.statik.sampled.ContentFactory;

/**
 * the displayed scored values
 * 
 * @author Joe Cumins and Thomas Wray    
 */
public class ScoreSprite extends AbstractSprite
{
	private TransformableContent[] potentialScores;
	private static final int NUM_OF_DIGITS = 10;
	private ContentFactory contentFactory;
	private ResourceFinder finder;
	private TransformableContent currentScore;
	private int counter;
	
    /**
     *constructor    
     */
    public ScoreSprite()
    {
    	super();
    	finder = ResourceFinder.createInstance(this);       
	    contentFactory = new ContentFactory(finder);
	    
    	String[] namesOfPotentialScores;
    	
    	namesOfPotentialScores = new String[NUM_OF_DIGITS];
    	
    	potentialScores = new TransformableContent[NUM_OF_DIGITS];
    	
    	for (int i = 0; i < NUM_OF_DIGITS; i++)
    	{
    		namesOfPotentialScores[i] = "score" + i + ".png";
    		potentialScores[i] = contentFactory.createContent(namesOfPotentialScores[i], 4, false);
    	}
    	
    	counter = 0;
    	
    	currentScore = potentialScores[counter];
        	
    	setVisible (true);
    	    	
    }
    
	@Override
	protected TransformableContent getContent() 
	{		
		return currentScore;
	}

	@Override
	public void handleTick(int arg0) 
	{
	}
	
    /**
     * getCounter - gives counter
     * 
     * @return the counter 
     */
	public int getCounter()
	{
		return counter;
	}
	
    /**
     * incrementScore - increase the score by 1
     * 
     * 
     */
	public void incrementScore()
	{
		counter += 1;

		currentScore = potentialScores[counter % 10];
	}
}
