package model.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import model.teaser.TeaserType;

@Entity
public class SudokuUserSolvingInfo extends UserSolvingTeaserTypeInfo {

	@Id
	@GenericGenerator(name="increment", strategy = "increment") 
	@GeneratedValue(generator="increment")
	private final long userId;

	public SudokuUserSolvingInfo(long userId) {
		super(TeaserType.SUDOKU);
		this.userId = userId;
	}
	
	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

}
