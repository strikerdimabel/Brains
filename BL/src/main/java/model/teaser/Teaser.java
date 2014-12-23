package model.teaser;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 11:29:33
 */
@MappedSuperclass
public abstract class Teaser {
	
	private long teaserId;

	@Id
	@GenericGenerator(name="increment", strategy = "increment") 
	@GeneratedValue(generator="increment")
	private long id;

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