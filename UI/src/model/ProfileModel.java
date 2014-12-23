package model;

import model.user.User;
import model.user.UserInfo;

public class ProfileModel {

	private final UserInfo userInfo;
	private final User user;
	
	public ProfileModel(UserInfo userInfo, User user) {
		this.userInfo = userInfo;
		this.user = user;
	}

	/**
	 * @return the userInfo
	 */
	public UserInfo getUserInfo() {
		return userInfo;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

}
