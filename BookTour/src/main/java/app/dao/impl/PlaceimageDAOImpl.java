package app.dao.impl;

import app.dao.GenericDAO;
import app.dao.PlaceimageDAO;
import app.model.Placeimage;

public class PlaceimageDAOImpl extends GenericDAO<Integer, Placeimage> implements PlaceimageDAO {
	@Override
	public Placeimage findPlaceimageLast() {
		return (Placeimage) getSession().createQuery("FROM Placeimage WHERE id IN( SELECT Max(id) FROM Placeimage)").getSingleResult();
	}
}
