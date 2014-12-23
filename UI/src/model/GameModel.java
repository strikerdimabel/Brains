package model;

import model.teaser.Teaser;
import model.teaser.TeaserCondition;
import model.teaser.TeaserInfo;

public class GameModel {

	private final TeaserCondition cnd;
	private final TeaserInfo teaserInfo;
	private final Teaser teaser;
	
	public GameModel(Teaser teaser, TeaserCondition cnd, TeaserInfo teaserInfo) {
		this.cnd = cnd;
		this.teaserInfo = teaserInfo;
		this.teaser = teaser;
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

	/**
	 * @return the teaser
	 */
	public Teaser getTeaser() {
		return teaser;
	}
	
}
