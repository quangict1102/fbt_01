package app.service.impl;

import app.dao.TourDAO;
import app.dao.UserDAO;

public class BaseServiceImpl {

	protected UserDAO userDAO;
	protected TourDAO tourDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public BaseServiceImpl(TourDAO tourDAO) {
		this.tourDAO = tourDAO;
	}

	public BaseServiceImpl() {
	}

	public TourDAO getTourDAO() {
		return tourDAO;
	}

	public void setTourDAO(TourDAO tourDAO) {
		this.tourDAO = tourDAO;
	}

}
