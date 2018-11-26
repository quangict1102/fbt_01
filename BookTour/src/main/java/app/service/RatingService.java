package app.service;

import java.util.List;

import app.model.Rating;

public interface RatingService extends BaseService<Integer,Rating>{
	List<Rating> getAllRating();
}
