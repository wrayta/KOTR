package Gameplay.Score;

import visual.statik.TransformableContent;
import Gameplay.Pattern.PatternKeyObserver;
import Gameplay.Pattern.PatternKeySubject;

/**
 * Setup for a ScoreSprite object
 * 
 * @author Thomas Wray & Joe Cumins
 * @version 1
 */
public class ScoreController extends
		visual.statik.AbstractAggregateContent<TransformableContent> implements
		PatternKeyObserver {
	private ScoreSprite onesPlace;
	private ScoreSprite tensPlace;
	private ScoreSprite hundredsPlace;

	/**
	 * constructor
	 * 
	 * @param scores
	 *            the numbers 0-9 for the score
	 */
	public ScoreController() {
		super();

		onesPlace = new ScoreSprite();
		tensPlace = new ScoreSprite();
		hundredsPlace = new ScoreSprite();

		components.add(hundredsPlace);
		components.add(tensPlace);
		components.add(onesPlace);
	}

	/**
	 * handleFunctionalityMethods - As an observer to the PatternKey,
	 * ScoreSprite accept the PatternKeySubject source so that it can know if
	 * what the user clicked matched the pattern in the key
	 * 
	 * @param PatternKey
	 *            source
	 */
	public void handleFunctionalityMethods(PatternKeySubject source) {

		if (onesPlace.getCounter() == 0 && tensPlace.getCounter() == 0
				&& hundredsPlace.getCounter() == 0) {

			onesPlace.incrementScore();
		}

		else {

			onesPlace.incrementScore();

			if (onesPlace.getCounter() % 10 == 0) {

				tensPlace.incrementScore();

				if (tensPlace.getCounter() % 10 == 0) {
					hundredsPlace.incrementScore();
				}
			}

		}

	}

}
