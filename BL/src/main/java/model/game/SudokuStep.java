package model.game;

/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 11:29:02
 */
public class SudokuStep implements Step {

	private final int value;
	private final int i;
	private final int j;

	public SudokuStep(int row, int cmn, int value) {
		this.value = value;
		this.i = row;
		this.j = cmn;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return i;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return j;
	}
	
	@Override
	public String toString() {
		return "i:"+i+",j:"+j+",value:"+value;
	}

}