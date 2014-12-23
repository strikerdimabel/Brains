package model.teaser;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 11:29:36
 */
@MappedSuperclass
public abstract class TeaserCondition {
	
	@Id
	private long teaserId;
	
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