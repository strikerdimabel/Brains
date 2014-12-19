package model.teaser;

/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 11:29:39
 */
public class TeaserInfo {

	private String name;
	private long teaserId;
	private TeaserType type;

	public TeaserInfo(){

	}

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
	public TeaserType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(TeaserType type) {
		this.type = type;
	}

}