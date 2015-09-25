package Gameplay.Knight;

import java.util.Random;

/**
 * Randomizes an array of numbers. In this game it is used in two instances:
 * One, to select 5 out of the 8 shields available
 * @author  Thomas Wray & Joe Cumins
 * @version 1
 */
public class PatternOrOrderRandomizer 
{
	private int rangeLow;
	private int rangeHigh;
	
    /**
     * constructor
     * 
     * @param rangeLow		the lowest number in the range
     * @param rangeHigh     thee highest number in the range
     */
	public PatternOrOrderRandomizer(int rangeLow, int rangeHigh)
	{
		this.rangeLow = rangeLow;
		this.rangeHigh = rangeHigh;
	}
	
	/**
	 * RandInt - random into for choosing 5 of 8 knights
	 * 
	 * @return the random number
	 */
	private int randInt() 
	{
	    Random rand;
	    int randomNum;
	    
        rand = new Random();

	    randomNum = rand.nextInt((rangeHigh - rangeLow) + 1) + rangeLow;

	    return randomNum;
	}
	
	/**
	 * RandInt - random into for scrambling up the knights 
	 * (mixes up the indices) 
	 * 
	 * @return the random number 
	 */
	public int randInt(int min, int max) 
	{
	    int randomNum;
	    Random rand;
	    rand = new Random();
	    
	    randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	/**
	 * randomizePatternOrOrderSecond - randomize the chosen 5 knights to 
	 * use in creating the pattern
	 * 
	 * @return the array that will represent be used to create the displayed
	 * pattern onscreen 
	 */
	public int[] randomizePatternOrOderSecond(int max, int[] first)
	{
		int[] compareSearchArray;
				
		compareSearchArray = new int[first.length];
		
        for(int a = 0; a < max; a++)
        {
     	
          compareSearchArray[a] = randInt(0, max - 1);
     	
     	  for(int x = 0; x < a; x++)
          {
     		  
     		if(compareSearchArray[a] == compareSearchArray[x]) 
       		{
     			compareSearchArray[a] = randInt(0, max - 1); //pick new random number
       			
       			x = -1; //check again (has to be -1 because x increases above
       		}
     		  
          } 
     	  
        }
        
        int[] complete = new int[max];
        
        for(int i = 0; i < first.length;i++)
        {
        	complete[i] = first[compareSearchArray[i]];
        }
              
        return complete;
	}

	
	/**
	 * randomizePatternOrOrder - randomize the chosen 5 knights to 
	 *
	 * 
	 * @return the array that will be used to create the displayed
	 * knights onscreen 
	 */
	public int[] randomizePatternOrOder(int max, int[] first)
	{
		int randNum;
		int[] compareSearchArray;
		
		compareSearchArray = new int[first.length];
				
		 //set random shields
        for(int j = 0; j < max; j++)
        {
        	 randNum = randInt(); //assign a random number
        	 first[j] = randNum;
        	 compareSearchArray[j] = randNum;

        	for(int x = 0; x < j; x++)
        	{
        		
        		if(first[j] == first[x]) //compare the number that the shields already have
        		{
        			
        			 randNum = randInt(); //pick new random number
        			 first[j] = randNum;
        			 compareSearchArray[j] = randNum;

        			 x = -1; //check again (has to be -1 because x increases above
        		}
        	}
        }
        
        return compareSearchArray;
	}
}
