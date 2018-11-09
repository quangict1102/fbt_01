package app.service;

import java.util.List;

import app.bean.CityInfo;

public interface CityService extends BaseService<Integer, CityInfo> {
	List<CityInfo> getAllCity();
	List<CityInfo> getAllCityByName(String nameCity);
}
