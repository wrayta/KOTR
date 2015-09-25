package Gameplay.Pattern;

import visual.dynamic.described.AbstractSprite;
import visual.statik.TransformableContent;

/**
 * Defines what a Pattern Object is
 * 
 * @author Thomas Wray & Joe Cumins
 * @version 1
 */
public class Pattern extends AbstractSprite {
    private TransformableContent patternShield;
    private TransformableContent patternShieldIntro;
    private TransformableContent patternShieldDuration;

    /**
     * constructor
     * 
     * @param patternShieldIntro
     *            shield at the intro
     * @param patternShieldDuration
     *            shield throughout the game
     * @param x
     *            location x coordinate
     * @param y
     *            location y coordinate
     */
    public Pattern(TransformableContent patternShieldIntro,
	    TransformableContent patternShieldDuration, double x, double y) {
	super();

	this.patternShieldIntro = patternShieldIntro;
	this.patternShieldDuration = patternShieldDuration;
	this.patternShield = patternShieldIntro;
	setLocation(x, y);

	setVisible(true);
    }

    /**
     * getContent - returns the TransformableContent of the shield in its
     * current state (intro state or normal state during the game)
     * 
     * @return the TransformableContent of the shield
     */
    public TransformableContent getContent() {
	return patternShield;
    }

    /**
     * handleTick - is passed the int representing the time and sets
     * patternShield (the TransformableContent that is passed to the screen)
     * according to this.
     * 
     * @param the
     *            time (the 10 second count down for each round).
     */
    public void handleTick(int time) {
	if (time < 2000) {
	    patternShield = patternShieldIntro;
	}

	else {
	    patternShield = patternShieldDuration;
	}
    }
}
