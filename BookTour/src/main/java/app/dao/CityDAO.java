package app.dao;

import java.util.List;

import app.model.City;

public interface CityDAO extends BaseDAO<Integer, City>{
	List<City> getAllCity();
	List<City> getAllCityByName(String nameCity);
}
