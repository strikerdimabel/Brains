package model.teaser;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 11:29:39
 */
@Entity
public class TeaserInfo {

	private String name;
	
	@Id
	@GenericGenerator(name="increment", strategy = "increment") 
	@GeneratedValue(generator="increment")
	private long teaserId;
	
	@Enumerated(EnumType.STRING)
	private TeaserType teaserType;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

	/**
	 * @return the type
	 */
	public TeaserType getTeaserType() {
		return teaserType;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(TeaserType type) {
		this.teaserType = type;
	}

}