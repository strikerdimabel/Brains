package model.teaser;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 11:29:29
 */
@Entity
public class SudokuTeaserCondition extends TeaserCondition {

	private int size = 9;
	private int rowsSmall = 3;
	private int cmnsSmall = 3;
	private int[][] matrix = new int[size][size];

	@Id
	@GenericGenerator(name="increment", strategy = "increment") 
	@GeneratedValue(generator="increment")
	private long teaserId;

	public SudokuTeaserCondition() {
	}
		
	/**
	 * @return the teaserId
	 */
	@Override
	public long getTeaserId() {
		return teaserId;
	}

	/**
	 * @param teaserId the teaserId to set
	 */
	@Override
	public void setTeaserId(long teaserId) {
		this.teaserId = teaserId;
	}

	public SudokuTeaserCondition(int[][] matrix) {
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				this.matrix[i][j] = matrix[i][j];
			}
		}
	}
	
	public int get(int i, int j) {
		return matrix[i][j];
	}

	public void set(int i, int j, int value) {
		matrix[i][j] = value;
	}
	
	public int size() {
		return size;
	}
		
	public int rowsSmallSize() {
		return rowsSmall;
	}

	public int cmnsSmallSize() {
		return cmnsSmall;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				sb.append(matrix[i][j] + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}