package Gameplay.Sound;

	import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import io.ResourceFinder;
	/**
	 * handles the use of sound in the game (when clicked and background music)
	 * 
	 * @author  Thomas Wray & Joe Cumins
	 * @version 1
	 */
	public class GameSound
	{
		private ResourceFinder finder;
        private BufferedInputStream bufferedStream;
        private InputStream inputStream;
        private AudioInputStream stream;
        private Clip clip;
	    private boolean loopSong;
        /**
	     * constructor
	     * 
	     * @param filename the file to play    
	     * @throws IOException 
	     * @throws UnsupportedAudioFileException 
	     * @throws LineUnavailableException 
	     */
		public GameSound() 
		{			
	        
	       
		}
		
		
		
        /**
	     *playTheMusic - plays the clip of music 
	     */
		public void playTheMusic(String filename, boolean loop) 
		{
            try 
            {
            	loopSong = loop;
    			
    			finder = ResourceFinder.createInstance(this);
    			
    			inputStream = finder.findInputStream(filename);
    			  
    	        bufferedStream = null;
    	        
    	        bufferedStream = new BufferedInputStream(inputStream);
    	        
    	              
    	        try 
    	        {
					stream = AudioSystem.getAudioInputStream(bufferedStream);
					
					 clip = AudioSystem.getClip();    	
						clip.open(stream);
						
				        clip.start();
				        
				        if(loopSong)
				        {	
				        	clip.loop(Clip.LOOP_CONTINUOUSLY);
				        }
				}
    	        
    	        catch (UnsupportedAudioFileException e) 
    	        {

				}
    	        
    	       
			} 
            
            catch (LineUnavailableException | IOException e) 
            {

			}
	        


	         
		}
		
		
	  
		
	}


