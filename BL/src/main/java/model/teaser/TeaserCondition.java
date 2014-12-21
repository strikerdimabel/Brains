package model.teaser;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 11:29:36
 */
public abstract class TeaserCondition {

	@Id
	@GenericGenerator(name="increment", strategy = "increment") 
	@GeneratedValue(generator="increment")
	private long teaserId;
	
	public abstract long getTeaserId();
	public abstract void setTeaserId(long teaserId);
	
}