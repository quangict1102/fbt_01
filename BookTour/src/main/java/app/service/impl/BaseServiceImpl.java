package app.service.impl;


import app.dao.CityDAO;
import app.dao.PlaceDAO;
import app.dao.RatingDAO;
import app.dao.TourDAO;
import app.dao.UserDAO;

public class BaseServiceImpl {

	protected UserDAO userDAO;
	protected TourDAO tourDAO;
	protected CityDAO cityDAO;
	protected PlaceDAO placeDAO;
	protected RatingDAO ratingDAO;


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

	public CityDAO getCityDAO() {
		return cityDAO;
	}

	public void setCityDAO(CityDAO cityDAO) {
		this.cityDAO = cityDAO;
	}

	public PlaceDAO getPlaceDAO() {
		return placeDAO;
	}

	public void setPlaceDAO(PlaceDAO placeDAO) {
		this.placeDAO = placeDAO;
	}

	public RatingDAO getRatingDAO() {
		return ratingDAO;
	}

	public void setRatingDAO(RatingDAO ratingDAO) {
		this.ratingDAO = ratingDAO;
	}

}
