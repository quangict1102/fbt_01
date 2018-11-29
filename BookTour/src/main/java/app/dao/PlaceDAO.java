package app.dao;

import java.util.List;

import app.model.Place;

public interface PlaceDAO extends BaseDAO<Integer, Place> {
	List<Place> getAllPlace();

	List<Place> getAllPlaceByIdCity(int id);
	
	Place findByIdLock(Integer id);
}
