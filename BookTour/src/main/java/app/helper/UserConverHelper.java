package app.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import app.bean.UserInfo;
import app.model.User;

public class UserConverHelper {

	private static Function<User, UserInfo> userToUserInfo = (User user) -> {

		UserInfo userInfo = new UserInfo();
		userInfo.setId(user.getId());
		userInfo.setFullName(user.getFullName());
		userInfo.setGender(user.getGender());
		userInfo.setAddress(user.getAddress());
		userInfo.setEmail(user.getEmail());
		userInfo.setPhoneNumber(user.getPhoneNumber());
		userInfo.setPassword(user.getPassword());
		userInfo.setRole(user.getRole());
		return userInfo;
	};

	public static List<UserInfo> convertUserTouserInfo(List<User> userList) {
		List<UserInfo> userInfoList = new ArrayList<>();
		for (User user : userList) {
			userInfoList.add(userToUserInfo.apply(user));
		}
		return userInfoList;
	}

	public static UserInfo convertSingleUserToUserInfo(User user) {
		return userToUserInfo.apply(user);
	}

	private static Function<UserInfo, User> userInfoToUser = (UserInfo userInfo) -> {

		User user = new User();
		user.setId(userInfo.getId());
		user.setFullName(userInfo.getFullName());
		user.setGender(userInfo.getGender());
		user.setAddress(userInfo.getAddress());
		user.setEmail(userInfo.getEmail());
		user.setPhoneNumber(userInfo.getPhoneNumber());
		user.setPassword(userInfo.getPassword());
		user.setRole(userInfo.getRole());
		return user;
	};

	public static List<User> convertUserInfoToUser(List<UserInfo> userInfoList) {
		List<User> userList = new ArrayList<>();
		for (UserInfo userInfo : userInfoList) {
			userList.add(userInfoToUser.apply(userInfo));
		}
		return userList;
	}

	public static User convertSingleUserInfoToUser(UserInfo userInfo) {
		return userInfoToUser.apply(userInfo);

	}
	
}
