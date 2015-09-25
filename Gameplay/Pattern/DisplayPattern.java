package Gameplay.Pattern;

import io.ResourceFinder;
import visual.statik.TransformableContent;
import visual.statik.sampled.ContentFactory;


/**
 * Receives the pattern of shields (an array filled in with the numeric ID's
 * that correspond to the chosen shields). This class uses the given array to
 * produce a corresponding array of Pattern Objects. 
 * A Pattern Object consists of: 2 transformableContent objects (used
 * to actually put the shields on the screen), and their locations.
 * This newly created array is returned to the InitGameLoop to be placed on 
 * the stage
 * 
 * @author  Thomas Wray & Joe Cumins
 * @version 1
 */
public class DisplayPattern 
{
    private ContentFactory contentFactory;
	private ResourceFinder finder;
    private String[] frameShields;
    private int[] framePatternNumber;
    private int numberOfPatternKnights;
    
    /**
     * constructor
     * 
     * @param totalKnights	the total number of knight sprites that are loaded in
     * @param numberOfPatternKnights	number of knights our pattern has
     */    
    public DisplayPattern(int totalKnights, int numberOfPatternKnights)
	{
		finder = ResourceFinder.createInstance(this);       
        contentFactory = new ContentFactory(finder);
        this.numberOfPatternKnights = numberOfPatternKnights;
	    framePatternNumber = new int[numberOfPatternKnights];
	    frameShields = new String[totalKnights];
	    
	    int shieldCount = 1;
	    for(int i = 0; i < totalKnights; i++)
	    {
	    	frameShields[i] = "shield_" + shieldCount + "_v2.png";
	    	shieldCount++;
	    }

	}
	
    /**
     * constructPattern - takes the array of numeric ID's representing the 
     * shields to be displayed in the gold frame and creates an array of 
     * Pattern Objects that correspond. Returns this to the InitGameLoop class
     * 
     * @param  postRandomizationPattern		the array of ID's for the shields
     * @return Pattern Object Array
     */  
	public Pattern[] constructPattern(int[] postRandomizationPattern)
	{
	    TransformableContent knightFrameShield;
		TransformableContent knightPlainShield; 
		String knightFrameName;
	    String knightPlainShieldName; 
	    double location[];
	    Pattern[] keys;
	    
	    keys = new Pattern[numberOfPatternKnights];
	          
		location = new double[] {30.00, 170.00, 310.00, 450.00, 585.00};

		for(int i = 0; i < numberOfPatternKnights; i++)
		{
		    knightPlainShieldName = "plain_shield_v2.png";
	
		    knightFrameName = frameShields[postRandomizationPattern[i]];
		    
			knightPlainShield = contentFactory.createContent(knightPlainShieldName, 4, false);
	
	  	    knightFrameShield = contentFactory.createContent(knightFrameName, 4, false);    
	  	   
		  	keys[i] = new Pattern(knightPlainShield, knightFrameShield, location[i], 660.00);
		  	    	   	     
		}
		
		return keys;
	}
	
    /**
     * constructPattern
     * 
     * @return int array that has the frame pattern ID's in the correct order 
     */ 
	public int[] getFramePatternNumber()
	{
		return framePatternNumber;
	} 
}
