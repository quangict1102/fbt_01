package app.service;

import java.util.List;

import app.bean.CityInfo;
import app.model.City;

public interface CityService extends BaseService<Integer, City> {
	List<CityInfo> getAllCity();
	List<CityInfo> getAllCityByName(String nameCity);
}
