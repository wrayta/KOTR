import java.awt.Color;
import java.util.Iterator;

import javax.swing.JPanel;

import visual.VisualizationView;
import visual.dynamic.described.Stage;
import visual.statik.TransformableContent;
import visual.statik.sampled.Content;
import EndGame.GameOver;
import Gameplay.Knight.DisplayKnight;
import Gameplay.Knight.Knight;
import Gameplay.Life.LifeController;
import Gameplay.Life.LifeObserver;
import Gameplay.Life.LifeSprite;
import Gameplay.Life.LifeSubject;
import Gameplay.Pattern.DisplayPattern;
import Gameplay.Pattern.Pattern;
import Gameplay.Pattern.PatternKey;
import Gameplay.Pattern.PatternKeyObserver;
import Gameplay.Pattern.PatternKeySubject;
import Gameplay.Score.ScoreController;
import Gameplay.Sound.GameSound;
import Gameplay.Timer.TimerController;
import Gameplay.Timer.TimerObserver;
import Gameplay.Timer.TimerSprite;
import Gameplay.Timer.TimerSubject;
import Initializers.Background;
import Initializers.GoldFrame;
import app.AbstractMultimediaApp;

//import Timer.Timer;

/**
 * KOTRApp - gathers all the necessary content from other classes to sets up the
 * stage with the init method
 */
public class KOTRApp extends AbstractMultimediaApp implements
	PatternKeyObserver, LifeObserver, TimerObserver {
    private Knight[] clickKnights;
    private Stage stage;
    private TimerSprite timer;
    private Pattern[] patternKeysInFrame;
    private ScoreController score;
    private LifeSprite lives;
    private Content gf;

    // finals
    private final int TOTAL_KNIGHT_SPRITES = 8; // how many knights there are to
						// be loaded in
    private final int TOTAL_KNIGHT_SPRITE_ACTIONS = 3; // left leg, right leg,
						       // even
    private final int KNIGHTS_IN_PATTERN = 5; // how many knights will appear in
					      // the gold frame
    private final int STARTING_LIVES = 3; // how many lives the player will
					  // start with
    private final int STARTING_TIME = 10; // how much initial time is given for
					  // each round

    // finals

    /**
     * initGame - gathers all the necessary content from other classes to sets
     * up the stage with the following components: the background, the gold
     * frame, the actual knights (placed ABOVE the gold frame), the shield
     * pattern (placed INSIDE of the gold frame), the timer, the lives, & the
     * score.
     */
    public void init() {
	VisualizationView stageView;
	Color backgroundColor;
	LifeController lifeController;
	JPanel contentPane;
	int height;
	int width;
	DisplayKnight clickableKnights;
	Background background;
	Content bg;
	GoldFrame goldFrame;
	int[] postRandomizationPattern;
	DisplayPattern patternKeyConstructor;
	PatternKey key;
	TimerController timerController;
	Iterator<TransformableContent> scoreCardIterator;
	TransformableContent currentComp;
	GameSound sound;
	int x;
	int y;

	backgroundColor = new Color(249, 249, 154);
	width = 700;
	height = 800;

	stage = new Stage(50);
	stageView = stage.getView();
	stageView.setBounds(0, 0, width, height);
	stageView.setSize(width, height);
	stageView.setBackground(backgroundColor);

	background = new Background();
	bg = background.setBackground();
	bg.setLocation(0, 0);
	stage.add(bg);

	goldFrame = new GoldFrame();
	gf = goldFrame.setFrame();
	gf.setLocation(20, 475);
	stage.add(gf);

	clickableKnights = new DisplayKnight(KNIGHTS_IN_PATTERN,
		TOTAL_KNIGHT_SPRITES, TOTAL_KNIGHT_SPRITE_ACTIONS);

	// display knights on screen
	clickKnights = clickableKnights.constructKnights();

	// this represents the array of 5 selected scrambled up
	// (this will be displayed in the gold frame)
	postRandomizationPattern = clickableKnights.getRandomPattern();

	patternKeyConstructor = new DisplayPattern(TOTAL_KNIGHT_SPRITES,
		KNIGHTS_IN_PATTERN);

	// putting the shields on screen
	patternKeysInFrame = patternKeyConstructor
		.constructPattern(postRandomizationPattern);

	for (int i = 0; i < patternKeysInFrame.length; i++) {
	    stage.add(patternKeysInFrame[i]);
	}

	// this represents the game key that patterns are compared to
	key = new PatternKey(KNIGHTS_IN_PATTERN, postRandomizationPattern);

	for (int i = 0; i < clickKnights.length; i++) {
	    clickKnights[i].addObserver(key);
	    stage.add(clickKnights[i]);
	    stage.addMouseListener(clickKnights[i]);
	}

	timerController = new TimerController(STARTING_TIME);
	timer = timerController.setTime();
	key.addObserver(timer);
	stage.add(timer);

	score = new ScoreController();
	key.addObserver(score);

	scoreCardIterator = score.iterator();

	x = 10;
	y = 10;

	while (scoreCardIterator.hasNext()) {

	    currentComp = scoreCardIterator.next();
	    currentComp.setLocation(x, y);
	    stage.add(currentComp);
	    x += 40;
	}

	lifeController = new LifeController(STARTING_LIVES);
	lives = lifeController.setLives();

	key.addWrongObserver(lives);
	lives.setLocation(600.00, 10.00);
	stage.add(lives);

	contentPane = (JPanel) rootPaneContainer.getContentPane();
	contentPane.add(stageView);

	key.addObserver(this);
	timer.addObserver(this);
	lives.addObserver(this);

	sound = new GameSound();
	sound.playTheMusic("the-strategy.wav", true);

	stage.start();

    }

    /**
     * handleFunctionalityMethods - As an observer to the PatternKeySubject
     * KOTRApp must implement this to know if the pattern was completed and it
     * should advance to the next round
     * 
     * @param source
     *            the subject that it observers
     */
    public void handleFunctionalityMethods(PatternKeySubject source) {

	if (source.getRemainingPatternKey() == 0) {
	    DisplayKnight clickableKnights;
	    PatternKey key;
	    int[] newPostRandomizationPattern;
	    DisplayPattern newPatternKeyConstructor;
	    TimerController timerController;
	    Iterator<TransformableContent> scoreCardIterator;
	    TransformableContent currentComp;
	    int x;
	    int y;
	    stage.getMetronome().stop();
	    stage.stop();

	    // Remove the stuff that is going to change
	    for (int i = 0; i < patternKeysInFrame.length; i++) {
		stage.remove(patternKeysInFrame[i]);
	    }

	    for (int i = 0; i < clickKnights.length; i++) {
		stage.remove(clickKnights[i]);
		stage.removeMouseListener(clickKnights[i]);
	    }

	    stage.remove(timer);

	    // Add the stuff back in

	    clickableKnights = new DisplayKnight(KNIGHTS_IN_PATTERN,
		    TOTAL_KNIGHT_SPRITES, TOTAL_KNIGHT_SPRITE_ACTIONS);

	    clickKnights = clickableKnights.constructKnights();

	    // this represents the array of 5 selected scrambled up
	    // (this will be displayed in the gold frame)
	    newPostRandomizationPattern = clickableKnights.getRandomPattern();

	    newPatternKeyConstructor = new DisplayPattern(TOTAL_KNIGHT_SPRITES,
		    KNIGHTS_IN_PATTERN);

	    patternKeysInFrame = newPatternKeyConstructor
		    .constructPattern(newPostRandomizationPattern);

	    for (int i = 0; i < patternKeysInFrame.length; i++) {
		stage.add(patternKeysInFrame[i]);
	    }

	    key = new PatternKey(KNIGHTS_IN_PATTERN,
		    newPostRandomizationPattern);

	    for (int i = 0; i < clickKnights.length; i++) {
		clickKnights[i].addObserver(key);
		stage.add(clickKnights[i]);
		stage.addMouseListener(clickKnights[i]);
	    }

	    stage.getMetronome().reset();
	    timerController = new TimerController(STARTING_TIME);
	    timer = timerController.setTime();
	    key.addObserver(timer);
	    stage.add(timer);

	    key.addObserver(score);

	    scoreCardIterator = score.iterator();

	    x = 10;
	    y = 10;

	    while (scoreCardIterator.hasNext()) {
		currentComp = scoreCardIterator.next();
		currentComp.setLocation(x, y);
		stage.add(currentComp);
		x += 40;
	    }

	    key.addWrongObserver(lives);
	    lives.setLocation(600.00, 10.00);
	    stage.add(lives);

	    stage.repaint();

	    key.addObserver(this);
	    timer.addObserver(this);
	    lives.addObserver(this);
	    stage.start();
	}

    }

    /**
     * handleOutOfTime - As an observer of the TimeSubject KOTRApp must
     * implement this...it needs to do this so that it can end the game if the
     * time reaches 0
     * 
     * @param source
     *            the subject that it observers
     */
    public void handleOutOfTime(TimerSubject source) {
	if (timer.getOutOfTimeCheck()) {
	    handleEndGame();
	}

    }

    /**
     * handleOutOfLives - As an observer of the TimeSubject KOTRApp must
     * implement this...it needs to do this so that it can end the game if the
     * lives reach 0
     * 
     * @param source
     *            the subject that it observers
     */
    public void handleOutOfLives(LifeSubject source) {
	if (lives.getOutOfLivesCheck()) {
	    handleEndGame();
	}

    }

    /**
     * handleEndGame - whether the player runs out of lives or runs out of time,
     * the game should end the same way. This method ends the game.
     */
    public void handleEndGame() {
	GameOver gameOver = new GameOver();
	Content gameOverImage;

	gameOverImage = gameOver.setGameOver();

	gameOverImage.setLocation(250, 160);

	for (int i = 0; i < clickKnights.length; i++) {
	    stage.remove(clickKnights[i]);
	    stage.removeMouseListener(clickKnights[i]);
	    stage.remove(patternKeysInFrame[i]);

	}

	stage.remove(gf);
	stage.remove(lives);
	stage.remove(timer);

	stage.add(gameOverImage);
    }
}
