package app.service.impl;

import java.io.Serializable;
import java.util.List;

import app.model.Rating;
import app.service.RatingService;

public class RatingServiceImpl extends BaseServiceImpl implements RatingService {

	@Override
	public Rating findById(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rating saveOrUpdate(Rating entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Rating entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Rating> getAllRating() {
		try {
			return getRatingDAO().getAllRating();
		} catch (Exception e) {
			return null;
		}
	}

}
