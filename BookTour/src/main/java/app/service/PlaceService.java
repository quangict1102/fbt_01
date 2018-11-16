package app.service;

import java.util.List;

import app.bean.PlaceInfo;

public interface PlaceService extends BaseService<Integer,PlaceInfo>{
	List<PlaceInfo> getAllPlace();

	List<PlaceInfo> getAllPlaceByIdCity(int id);
}
