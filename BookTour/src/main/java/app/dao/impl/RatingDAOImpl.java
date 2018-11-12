package app.dao.impl;

import java.util.List;

import app.dao.GenericDAO;
import app.dao.RatingDAO;
import app.model.Rating;

public class RatingDAOImpl extends GenericDAO<Integer, Rating> implements RatingDAO {

	@Override
	public List<Rating> getAllRating() {
		return getSession().createQuery("from Rating", Rating.class).list();
	}

}
