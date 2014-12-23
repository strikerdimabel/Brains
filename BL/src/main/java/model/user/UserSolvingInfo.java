package model.user;

import javax.persistence.Entity;
import javax.persistence.Id;

import model.game.GameInfo;

@Entity
public class UserSolvingInfo {

	@Id
	private final long userId;

	private long rating;
	private long countAutoSolved;
	private long countSolved;
	private long hintCount;
	private long totalTime;
	private long averageTime;

	@SuppressWarnings("unused")
	private UserSolvingInfo() {
		userId = 0;
	}
	
	public UserSolvingInfo(long userId) {
		this.userId = userId;
	}

	public void add(long addRating) {
		rating += addRating;
	}

	public void subtract(long subRating) {
		rating -= subRating;
	}
	
	public void addSolution(GameInfo gameInfo){
		if (gameInfo.isAutoSolved()) {
			countAutoSolved++;
		}
		countSolved++;
		hintCount += gameInfo.getHintCount();
		totalTime += gameInfo.time();
		calculateAverageTime();
	}

	private void calculateAverageTime() {
		averageTime = Math.round((double)totalTime / countSolved);
	}

	public double getRating(){
		return rating;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
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

	/**
	 * @return the averageTime
	 */
	public long getAverageTime() {
		return averageTime;
	}

}