package model.user;

import java.util.EnumMap;
import java.util.Map;

import model.teaser.TeaserType;

public class UserSolvingTeaserTypeClasses {

	private static final Map<TeaserType, Class<? extends UserSolvingTeaserTypeInfo>> classes = new EnumMap<>(TeaserType.class);
	
	static {
		classes.put(TeaserType.SUDOKU, SudokuUserSolvingInfo.class);
	}
	
	private UserSolvingTeaserTypeClasses() {
	}
	
	public static Class<? extends UserSolvingTeaserTypeInfo> getUserSolvingTeaserTypeClass(TeaserType teaserType) {
		return classes.get(teaserType);
	}
	
}
