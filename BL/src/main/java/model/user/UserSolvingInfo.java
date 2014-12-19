package model.user;

/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 11:30:04
 */
public class UserSolvingInfo {

	private boolean autoSolved;
	private long countSolved;
	private long hintCount;
	private double rating;
	private String teaserType;
	private long totalTime;
	private long userId;

	public UserSolvingInfo(){

	}

	/**
	 * 
	 * @param totalTime
	 * @param hintCount
	 * @param autoSolved
	 */
	public void addSolution(long totalTime, long hintCount, boolean autoSolved){

	}

	private void calculateRating(){

	}

	public double getRating(){
		return rating;
	}

	/**
	 * @return the teaserType
	 */
	public String getTeaserType() {
		return teaserType;
	}

	/**
	 * @param teaserType the teaserType to set
	 */
	public void setTeaserType(String teaserType) {
		this.teaserType = teaserType;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

}