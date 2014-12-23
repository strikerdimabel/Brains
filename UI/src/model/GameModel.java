package model;

import model.teaser.TeaserCondition;
import model.teaser.TeaserInfo;

public class GameModel {

	private final TeaserCondition cnd;
	private final TeaserInfo teaserInfo;
	
	public GameModel(TeaserCondition cnd, TeaserInfo teaserInfo) {
		this.cnd = cnd;
		this.teaserInfo = teaserInfo;
	}

	/**
	 * @return the cnd
	 */
	public TeaserCondition getCnd() {
		return cnd;
	}

	/**
	 * @return the teaserType
	 */
	public TeaserInfo getTeaserInfo() {
		return teaserInfo;
	}
	
}
