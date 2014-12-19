package model.teaser;

/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 11:29:33
 */
public abstract class Teaser {

	private long id;
	private long teaserId;

	public Teaser(){

	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the teaserId
	 */
	public long getTeaserId() {
		return teaserId;
	}

	/**
	 * @param teaserId the teaserId to set
	 */
	public void setTeaserId(long teaserId) {
		this.teaserId = teaserId;
	}

}