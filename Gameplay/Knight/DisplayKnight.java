package Gameplay.Knight;

import io.ResourceFinder;
import visual.statik.TransformableContent;
import visual.statik.sampled.ContentFactory;
import Gameplay.Point.Pnt;

/**
 * DisplayKnight - takes the list of numerical ID's for the 8 knights designed
 * and chooses 5 of those numeric ID's randomly. The class then uses this list
 * of 5 numerical ID's to create a corresponding array of Knight Objects 
 * (A Knight Object contains 4 transformableContent objects, the knightsID, and
 * the knights location).
 * This group of Knights is returned to the KOTRApp class 
 * and are placed on stage.
 * 
 * @author  Thomas Wray & Joe Cumins
 * @version 1
 */
public class DisplayKnight 
{
    private ContentFactory contentFactory;
	private ResourceFinder finder;
    private String[][] clickShields;
    private int[] currentFrameShields;
    private int[] postRandomizationPattern;
    private int[] currentClickShields; 
    private int numberOfClickableKnights;
    private int knightsInPattern;
    private int totalKnightSprites;
    
    /**
     * constructor
     * 
     * @param numberOfClickableKnights   the number of knights displayed     
     */
	public DisplayKnight(int knightsInPattern, int totalKnightSprites, int totalKnightSpriteActions)
	{		
        finder = ResourceFinder.createInstance(this);       
        contentFactory = new ContentFactory(finder);
	    clickShields = new String[totalKnightSprites][totalKnightSpriteActions];
	    this.knightsInPattern = knightsInPattern;
	    this.totalKnightSprites = totalKnightSprites;
	    numberOfClickableKnights = knightsInPattern;
	    
	    int shieldNum = 1;
		for(int rows = 0; rows < clickShields.length; rows++)
		{
			for(int cols = 0; cols < clickShields[rows].length; cols++)
			{
				clickShields[rows][cols] = "shield_" + shieldNum + "_feet_right_v2.png";
				cols++;
				clickShields[rows][cols] = "shield_" + shieldNum + "_feet_left_v2.png";
				cols++;
				clickShields[rows][cols] = "shield_" + shieldNum + "_feet_even_v2.png";
				cols++;
				
				shieldNum++;
			}
		}
	 
	    currentFrameShields = new int[knightsInPattern];
	    postRandomizationPattern = new int[knightsInPattern];
	     
	    currentClickShields = new int[knightsInPattern]; 
	}
	
    /**
     * constructKnights- creates the array of Knight objects 
     * 
     * @return the transformableContent array of knights
     */
	public Knight[] constructKnights()
	{
	    TransformableContent knightRightFootClickable;
	    TransformableContent knightLeftFootClickable;
	    TransformableContent knightBalancedFeetClickable;
	    TransformableContent knightIntro;
	    Pnt clickCoordArray[];
	    String knightNameRight;
	    String knightNameLeft;
	    String knightNameBalancedFeet;
	    String knightNameIntro;
	    int knightID;
	    Knight[] knights;
	    PatternOrOrderRandomizer randomizer;
	    
	    knights = new Knight[this.numberOfClickableKnights];
	    clickCoordArray = new Pnt[] {new Pnt(280.00, 10.00), 
	    						     new Pnt(5.00, 160.00),
	    		                     new Pnt(550.00, 160.00), 
	    		                     new Pnt(5.00, 420.00), 
	    		                     new Pnt(550.00, 420.00)}; 
	
        randomizer = new PatternOrOrderRandomizer(0, totalKnightSprites - 1);
        
        currentFrameShields = randomizer.randomizePatternOrOder(knightsInPattern, 
        		                         currentClickShields);
        
	    randomizer = new PatternOrOrderRandomizer(0, knightsInPattern - 1);
	  
	   
	    postRandomizationPattern = randomizer.randomizePatternOrOderSecond
	    		                            (knightsInPattern, currentFrameShields);
        
        
        for (int i = 0; i < knights.length; i++)
        {
		    knightNameIntro = "KnightThree_Intro_Resized_v2.png";
		    knightNameRight = clickShields[currentClickShields[i]][0]; 
		 	knightNameLeft = clickShields[currentClickShields[i]][1]; 
		 	knightNameBalancedFeet = clickShields[currentClickShields[i]][2];
		 	knightID = currentFrameShields[i];
		 	
		 	knightIntro = contentFactory.createContent
		 			      (knightNameIntro, 4, false);
		 	knightRightFootClickable = contentFactory.createContent
		 			                   (knightNameRight, 4, false);
		    knightLeftFootClickable = contentFactory.createContent
		    		                  (knightNameLeft, 4, false);
			knightBalancedFeetClickable = contentFactory.createContent
					                      (knightNameBalancedFeet, 4, false);
			
			knights[i] = new Knight(knightIntro, knightRightFootClickable, 
					                knightLeftFootClickable, 
					                knightBalancedFeetClickable, 
		                            clickCoordArray[i].getX(), 
		                            clickCoordArray[i].getY(), knightID);
        }
        
        return knights;
	}
	
    /**
     * getCurrentFrameShields - gets the currentFrameShields
     * 
     * @return int array that represents the shields in the frame
     * before they are randomly mixed up
     */
	public int[] getCurrentFrameShields()
	{
		return currentFrameShields;
	}
	
    /**
     * getRandomPattern - gets the pattern that will be displayed in the shields
     * 
     * @return int array that represents the shields in the frame
     */
	public int[] getRandomPattern()
	{
		return postRandomizationPattern;
	}
}
