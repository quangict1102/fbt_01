package app.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import app.bean.CityInfo;
import app.model.City;

public class CityCovertHelper {
	static Function<City, CityInfo> cityToCityInfo = (City city) -> {
		CityInfo cityInfo = new CityInfo();
		cityInfo.setId(city.getId());
		cityInfo.setName(city.getName());
		return cityInfo;
	};

	public static List<CityInfo> convertCityToCityInfo(List<City> lcity) {
		List<CityInfo> lCityInfo = new ArrayList<>();
		for (City city : lcity) {
			lCityInfo.add(cityToCityInfo.apply(city));
		}
		return lCityInfo;
	}

	public static CityInfo convertSingleCityToCityInfo(City city) {
		return cityToCityInfo.apply(city);
	}

	static Function<CityInfo, City> cityInfoToCity = (CityInfo cityInfo) -> {
		City city = new City();
		city.setId(cityInfo.getId());
		city.setName(cityInfo.getName());
		return city;
	};

	public static List<City> convertCityInfoToCity(List<CityInfo> lCityInfo) {
		List<City> lCity = new ArrayList<>();
		for (CityInfo cityInfo : lCityInfo) {
			lCity.add(cityInfoToCity.apply(cityInfo));
		}
		return lCity;
	}

	public static City convertSingleCityInfoToCity(CityInfo cityInfo) {
		return cityInfoToCity.apply(cityInfo);
	}
}
