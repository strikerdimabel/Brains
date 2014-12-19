package model.game;

/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 11:29:07
 */
public class UserGame {

	private long teaserId;
	private long userId;

	public UserGame(long teaserId, long userId) {
		this.teaserId = teaserId;
		this.userId = userId;
	}

	/**
	 * @param object
	 */
	public boolean equals(Object object){
		return false;
	}

	public int hashCode(){
		return 0;
	}

	/**
	 * @return the gameId
	 */
	public long getTeaserId() {
		return teaserId;
	}

	/**
	 * @param gameId the gameId to set
	 */
	public void setTeaserId(long gameId) {
		this.teaserId = gameId;
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