package app.service.impl;

import java.io.Serializable;
import java.util.List;

import app.bean.PlaceInfo;
import app.helper.PlaceConvertHelper;
import app.service.PlaceService;

public class PlaceServiceImpl extends BaseServiceImpl implements PlaceService {

	@Override
	public PlaceInfo findById(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlaceInfo saveOrUpdate(PlaceInfo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(PlaceInfo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PlaceInfo> getAllPlace() {
		try {
			return PlaceConvertHelper.convertPlaceToPlaceInfo(getPlaceDAO().getAllPlace());
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<PlaceInfo> getAllPlaceByIdCity(int id) {
		try {
			return PlaceConvertHelper.convertPlaceToPlaceInfo(getPlaceDAO().getAllPlaceByIdCity(id));
		} catch (Exception e) {
			return null;
		}
	}

}
