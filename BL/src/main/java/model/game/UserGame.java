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
	public boolean equals(Object object) {
		if (!(object instanceof UserGame)) {
			return false;
		}
		UserGame userGame = (UserGame) object;
		return userGame.teaserId == teaserId && userGame.userId == userId;
	}

	public int hashCode() {
		return (int) ((teaserId>>>32)^(userId>>>32)^teaserId^userId);
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