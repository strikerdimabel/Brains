package model.teaser;

import java.util.EnumMap;
import java.util.Map;

public class TeaserConditionClasses {

	private static final Map<TeaserType, Class<? extends TeaserCondition>> classes = new EnumMap<>(TeaserType.class);
	
	static {
		classes.put(TeaserType.SUDOKU, SudokuTeaserCondition.class);
	}
	
	private TeaserConditionClasses() {
	}
	
	public static Class<? extends TeaserCondition> getTeaserConditionClass(TeaserType teaserType) {
		return classes.get(teaserType);
	}
	
}
