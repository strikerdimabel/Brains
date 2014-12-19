package model.game;

/**
 * @author Dmitri
 * @version 1.0
 * @created 19-Dec-2014 11:38:54
 */
public class GameInfo {

	private boolean autoSolved;
	private long hintCount;
	private long begTime;

	public GameInfo(){
		begTime = System.currentTimeMillis();
	}

	/**
	 * @return the autoSolved
	 */
	public boolean isAutoSolved() {
		return autoSolved;
	}

	/**
	 * @param autoSolved the autoSolved to set
	 */
	public void setAutoSolved() {
		this.autoSolved = true;
	}

	/**
	 * @return the hintCount
	 */
	public long incHintCount() {
		return hintCount;
	}

}