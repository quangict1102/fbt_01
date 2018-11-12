package app.service.impl;

import java.io.Serializable;
import java.util.List;

import app.bean.CityInfo;
import app.helper.CityCovertHelper;
import app.service.CityService;

public class CityServiceImpl extends BaseServiceImpl implements CityService {

	@Override
	public CityInfo findById(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CityInfo saveOrUpdate(CityInfo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(CityInfo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CityInfo> getAllCity() {
		try {
			return CityCovertHelper.convertCityToCityInfo(getCityDAO().getAllCity());
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<CityInfo> getAllCityByName(String nameCity) {
		try {
			return CityCovertHelper.convertCityToCityInfo(getCityDAO().getAllCityByName(nameCity));
		} catch (Exception e) {
			return null;
		}
	}

}
