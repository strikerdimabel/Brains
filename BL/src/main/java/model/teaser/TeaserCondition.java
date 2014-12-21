package model.teaser;

/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 11:29:36
 */
public abstract class TeaserCondition {

	private long teaserId;
	private TeaserType teaserType;

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

	/**
	 * @return the teaserType
	 */
	public TeaserType getTeaserType() {
		return teaserType;
	}
	
}