package model;

import java.util.List;

import model.teaser.TeaserInfo;
import model.teaser.TeaserSolvingInfo;

public class TeasersModel {

	private final List<TeaserInfo> teasers;
	private final List<TeaserSolvingInfo> solvings;
	
	public TeasersModel(List<TeaserInfo> teasers, List<TeaserSolvingInfo> solvings) {
		this.teasers = teasers;
		this.solvings = solvings;
	}

	/**
	 * @return the teasers
	 */
	public List<TeaserInfo> getTeasers() {
		return teasers;
	}

	/**
	 * @return the solvings
	 */
	public List<TeaserSolvingInfo> getSolvings() {
		return solvings;
	}
	
}
