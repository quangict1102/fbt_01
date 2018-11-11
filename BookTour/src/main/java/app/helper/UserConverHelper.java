package app.helper;

import java.util.function.Function;

import app.bean.UserInfo;
import app.model.User;

public class UserConverHelper implements Function<User, UserInfo>{

	@Override
	public UserInfo apply(User t) {
		
		UserInfo userInfo = new UserInfo();
		userInfo.setId(t.getId());
		return userInfo;
	}

}
