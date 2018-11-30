package app.service.impl;

import java.io.Serializable;
import java.util.List;

import app.bean.PlaceInfo;
import app.helper.PlaceConvertHelper;
import app.model.Place;
import app.service.PlaceService;

public class PlaceServiceImpl extends BaseServiceImpl implements PlaceService {


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

	@Override
	public Place findById(Serializable key) {
		return getPlaceDAO().findById(key);
	}

	@Override
	public Place saveOrUpdate(Place entity) {
		try {
			if(entity.getId()==null) {
				return getPlaceDAO().saveOrUpdate(entity);
			} 
			getPlaceDAO().findByIdLock(entity.getId());
			return getPlaceDAO().saveOrUpdate(entity);
		} catch (Exception e) {
			throw e;
		}
		
		
	}

	@Override
	public boolean delete(Place entity) {
		try {
			getPlaceDAO().delete(entity);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean deletePlace(Integer id) {
		try {
			Place place=getPlaceDAO().findByIdLock(id);
			if(place==null) {
				return false;
			}
			return delete(place);
		} catch (Exception e) {
			throw e;
		}
	}

}
