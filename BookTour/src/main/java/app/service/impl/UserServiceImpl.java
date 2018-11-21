package app.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import app.bean.UserInfo;
import app.helper.UserConverHelper;
import app.model.User;
import app.service.UserService;

public class UserServiceImpl extends BaseServiceImpl implements UserService {
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Override
	public User saveOrUpdate(User entity) {
		try {
			/*User user = userDAO.findByIdLock(entity.getId());
			if (user == null) {
				return null;
			}*/
			return getUserDAO().saveOrUpdate(entity);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

	@Override
	public boolean deleteUser(Integer id) {
		try {
			User user = getUserDAO().findByIdLock(id);
			if (user == null) {
				return false;
			}
			return delete(user);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

	@Override
	public UserInfo findByEmail(String email) {
		try {
			return UserConverHelper.convertSingleUserToUserInfo(getUserDAO().findByEmail(email));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<UserInfo> searchUser(String name, int gender) {
		try {
			return UserConverHelper.convertUserTouserInfo(getUserDAO().searchUserUsingCretial(name));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<UserInfo> loadUsers() {
		try {
			return UserConverHelper.convertUserTouserInfo(getUserDAO().loadUsers());
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public User findById(Serializable key) {
		try {
			return (getUserDAO().findById(key));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean delete(User entity) {
		try {
			getUserDAO().delete(entity);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public User findByEmailAndPassword(String email, String password) {
		User user = null;
		try {
			user = getUserDAO().findByEmailAndPassword(email, password);
			return user;
		} catch (Exception e) {
			logger.error(e);
		}
		return user;

	}

}
