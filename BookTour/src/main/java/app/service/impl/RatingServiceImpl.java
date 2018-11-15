package app.service.impl;

import java.io.Serializable;
import java.util.List;

import app.bean.RatingInfo;
import app.model.Rating;
import app.service.RatingService;

public class RatingServiceImpl extends BaseServiceImpl implements RatingService {

	@Override
	public RatingInfo findById(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RatingInfo saveOrUpdate(RatingInfo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(RatingInfo entity) {
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
