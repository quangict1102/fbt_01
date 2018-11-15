package app.dao;

import java.util.List;

import app.model.Rating;

public interface RatingDAO extends BaseDAO<Integer,Rating> {
	List<Rating> getAllRating();
}
