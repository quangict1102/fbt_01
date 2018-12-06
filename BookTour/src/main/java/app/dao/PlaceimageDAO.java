package app.dao;

import app.model.Placeimage;

public interface PlaceimageDAO extends BaseDAO<Integer, Placeimage> {
	Placeimage findPlaceimageLast();
}
