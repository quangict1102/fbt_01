package app.service;

import java.util.List;

import app.bean.RatingInfo;
import app.model.Rating;

public interface RatingService extends BaseService<Integer,RatingInfo>{
	List<Rating> getAllRating();
}
