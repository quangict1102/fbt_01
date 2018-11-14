package app.service.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;

import app.bean.UserInfo;
import app.service.UserService;

public class UserServiceImpl extends BaseServiceImpl implements UserService {
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Override
	public UserInfo findById(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo saveOrUpdate(UserInfo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(UserInfo entity) {
		// TODO Auto-generated method stub
		return false;
	}

}
