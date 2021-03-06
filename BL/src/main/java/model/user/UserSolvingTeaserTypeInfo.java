package model.user;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import model.game.GameInfo;
import model.teaser.TeaserType;

/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 11:30:04
 */
@MappedSuperclass
public abstract class UserSolvingTeaserTypeInfo {

	@Id
	private final long userId;
	
	private long countAutoSolved;
	private long countSolved;
	private long hintCount;
	private long rating;
	private final TeaserType teaserType;
	private long totalTime;
	private long averageTime;

	public UserSolvingTeaserTypeInfo(TeaserType teaserType2, long userId) {
		this.teaserType = teaserType2;
		this.userId = userId;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}
	
	public void addSolution(GameInfo gameInfo){
		if (gameInfo.isAutoSolved()) {
			countAutoSolved++;
		}
		countSolved++;
		hintCount += gameInfo.getHintCount();
		totalTime += gameInfo.time();
		calculateAverageTime(); // call it before calculateRating()
		calculateRating();
	}

	private void calculateAverageTime() {
		averageTime = Math.round((double)totalTime / countSolved);
	}
	
	private void calculateRating() {
		rating = (int) (1000. * countSolved / (hintCount + 0.00001*totalTime + 10*countAutoSolved));
	}

	public long getRating(){
		return rating;
	}

	/**
	 * @return the averageTime
	 */
	public long getAverageTime() {
		return averageTime;
	}

	/**
	 * @return the teaserType
	 */
	public TeaserType getTeaserType() {
		return teaserType;
	}

	/**
	 * @return the countAutoSolved
	 */
	public long getCountAutoSolved() {
		return countAutoSolved;
	}

	/**
	 * @return the countSolved
	 */
	public long getCountSolved() {
		return countSolved;
	}

	/**
	 * @return the hintCount
	 */
	public long getHintCount() {
		return hintCount;
	}

	/**
	 * @return the totalTime
	 */
	public long getTotalTime() {
		return totalTime;
	}

}