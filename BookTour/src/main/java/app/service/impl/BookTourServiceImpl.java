package app.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import app.model.Booktour;
import app.service.BookTourService;

public class BookTourServiceImpl extends BaseServiceImpl implements BookTourService {

	@Override
	public Booktour findById(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booktour saveOrUpdate(Booktour entity) {
		// TODO Auto-generated method stub
		return getBooktourDAO().saveOrUpdate(entity);
	}

	@Override
	public boolean delete(Booktour entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Booktour> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countCart(Integer idTour) {
		List<Object[]> arrObject = getBooktourDAO().countCart(idTour);
		Long countCart = null;
		for (Object[] o : arrObject) {
			Long count = (Long) o[1];
			countCart = new Long(count); 
		}
		return countCart;
	}

}
