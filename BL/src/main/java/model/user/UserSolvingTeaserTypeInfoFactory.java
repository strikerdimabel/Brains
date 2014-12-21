package model.user;

import java.util.EnumMap;
import java.util.Map;

import model.teaser.TeaserType;

public class UserSolvingTeaserTypeInfoFactory {
	
	private static interface IUserSolvingTeaserTypeInfoProvider {
		UserSolvingTeaserTypeInfo newUserSolvingTeaserTypeInfo(long userId);
	}
	
	private static final Map<TeaserType, IUserSolvingTeaserTypeInfoProvider> providers = new EnumMap<TeaserType, IUserSolvingTeaserTypeInfoProvider>(TeaserType.class);
	
	static {
		providers.put(TeaserType.SUDOKU, new IUserSolvingTeaserTypeInfoProvider() {
			@Override
			public UserSolvingTeaserTypeInfo newUserSolvingTeaserTypeInfo(long userId) {
				return new SudokuUserSolvingInfo(userId);
			}
		});
	}
	
	private UserSolvingTeaserTypeInfoFactory() {
	}
		
	public static UserSolvingTeaserTypeInfo newUserSolvingTeaserTypeInfo(long userId, TeaserType teaserType) {
		return providers.get(teaserType).newUserSolvingTeaserTypeInfo(userId);
	}
	
}
