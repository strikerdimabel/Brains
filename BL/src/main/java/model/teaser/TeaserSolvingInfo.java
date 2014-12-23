package model.teaser;

import javax.persistence.Entity;
import javax.persistence.Id;

import model.game.GameInfo;

/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 11:29:45
 */
@Entity
public class TeaserSolvingInfo {

	@Id
	private final long teaserId;
	
	private long autoSolvingCount;
	private long countSolved;
	private int difficulty = 10;
	private long hintCount;
	private long totalTime;
	private long averageTime;

	@SuppressWarnings("unused")
	private TeaserSolvingInfo() {
		teaserId = 0;
	}

	public TeaserSolvingInfo(long teaserId) {
		this.teaserId = teaserId;
	}
	
	public TeaserSolvingInfo(long teaserId, int defDifficulty) {
		this.teaserId = teaserId;
		this.difficulty = defDifficulty;
	}

	public void addSolution(GameInfo gameInfo) {
		countSolved++;
		if (gameInfo.isAutoSolved()) {
			autoSolvingCount++;
		}
		hintCount += gameInfo.getHintCount();
		totalTime += gameInfo.time();
		calculateAverageTime(); // call it before calculateDifficulty
		calculateDifficulty();
	}

	private void calculateAverageTime() {
		averageTime = Math.round((double)totalTime / countSolved);
	}
	
	private void calculateDifficulty(){
		difficulty = (int) (1000. * countSolved / (hintCount + 0.00001*totalTime + 10*autoSolvingCount));
	}

	public int getDifficulty(){
		return difficulty;
	}

	/**
	 * @return the averageTime
	 */
	public long getAverageTime() {
		return averageTime;
	}

	/**
	 * @return the teaserId
	 */
	public long getTeaserId() {
		return teaserId;
	}

}