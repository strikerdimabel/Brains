package model;

import java.util.List;

import model.user.User;
import model.user.UserSolvingInfo;

public class RatingModel {

	private final List<UserSolvingInfo> usersSolvingInfo;
	private final List<User> users;
	
	public RatingModel(List<UserSolvingInfo> usersSolvingInfo, List<User> users) {
		this.usersSolvingInfo = usersSolvingInfo;
		this.users = users;
	}

	/**
	 * @return the usersSolvingInfo
	 */
	public List<UserSolvingInfo> getSolvings() {
		return usersSolvingInfo;
	}

	/**
	 * @return the usersInfo
	 */
	public List<User> getUsers() {
		return users;
	}

}
