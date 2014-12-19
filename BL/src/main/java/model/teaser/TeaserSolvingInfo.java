package model.teaser;

/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 11:29:45
 */
public class TeaserSolvingInfo {

	private long autoSolvingCount;
	private long countSolved;
	private double difficulty;
	private long hintCount;
	private long teaserId;
	private long totalTime;

	public TeaserSolvingInfo(){

	}

	/**
	 * @param time
	 * @param hintCount
	 * @param autoSolving
	 */
	public void addSolution(long time, long hintCount, boolean autoSolving){

	}

	private void calculateDifficulty(){

	}

	public double getDifficulty(){
		return difficulty;
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