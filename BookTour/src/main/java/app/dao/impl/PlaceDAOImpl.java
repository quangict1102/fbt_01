package app.dao.impl;

import java.util.List;

import app.dao.GenericDAO;
import app.dao.PlaceDAO;
import app.model.Place;

public class PlaceDAOImpl extends GenericDAO<Integer, Place> implements PlaceDAO {

	@Override
	public List<Place> getAllPlace() {
		return getSession().createQuery("from Place", Place.class).getResultList();
	}
	@Override
	public List<Place> getAllPlaceByIdCity(int id) {
		return getSession().createQuery("select p from Place p where p.city.id = :id",Place.class).setParameter("id", id).getResultList();
	}

}
