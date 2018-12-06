package app.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import app.bean.BookTourInfo;
import app.helper.BookTourConvertHelper;
import app.helper.PRIME_TOUR;
import app.model.Booktour;
import app.model.Tour;
import app.model.User;
import app.service.BookTourService;

public class BookTourServiceImpl extends BaseServiceImpl implements BookTourService {
	private static final Logger logger = Logger.getLogger(BookTourServiceImpl.class);

	@Override
	public Booktour findById(Serializable key) {
		return null;
	}

	@Override
	public Booktour saveOrUpdate(Booktour entity) {
		if (entity.getId() == null) {
			return getBooktourDAO().saveOrUpdate(entity);
		}
		Booktour bt = booktourDAO.findByIdLock(entity.getId(), true);
		return getBooktourDAO().saveOrUpdate(bt);

	}

	@Override
	public boolean delete(Booktour entity) {
		try {
			getBooktourDAO().delete(entity);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	public Booktour findId(Integer id) {
		return getBooktourDAO().findByIdLock(id, true);
	}

	@Override
	public boolean deleteBTbtId(Integer id) {
		try {
			Booktour bt = getBooktourDAO().findByIdLock(id, true);
			if (bt == null) {
				return false;
			}
			booktourDAO.delete(bt);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Booktour updateBt(BookTourInfo btInfo) {
		Booktour bt = getBooktourDAO().findByIdLock(btInfo.getId(), true);
		if (bt == null) {
			return null;
		}
		String type_tour = btInfo.getPrimeTour();
		switch (type_tour) {
		case "1":
			bt.setPrimeTour(PRIME_TOUR.selectPrime(PRIME_TOUR.TYPE1));
			break;
		case "2":
			bt.setPrimeTour(PRIME_TOUR.selectPrime(PRIME_TOUR.TYPE2));
			break;
		case "3":
			bt.setPrimeTour(PRIME_TOUR.selectPrime(PRIME_TOUR.TYPE3));
			break;
		default:
			break;
		}
		bt.setStatus(btInfo.getStatus());
		bt.setAdults(btInfo.getAdults());
		bt.setChildren(btInfo.getChildren());
		bt.setNotel(btInfo.getNotel());
		Tour t = new Tour();
		t.setId(btInfo.getTour().getId());
		bt.setTour(t);
		User u = new User();
		u.setId(btInfo.getUser().getId());
		bt.setUser(u);
		return booktourDAO.saveOrUpdate(bt);
	}

	@Override
	public List<Booktour> getAll() {
		return getBooktourDAO().getAll();
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

	@Override
	public List<BookTourInfo> getAllByIdUser(Integer id) {
		return BookTourConvertHelper.convertBtToBtInfo(getBooktourDAO().getAllByIdUser(id));
	}

	@Override
	public List<BookTourInfo> getAllById(Integer id) {
		return BookTourConvertHelper.convertBtToBtInfo(getBooktourDAO().getAllById(id));
	}
	
	public List<Booktour> searchAllByEmail(String email) {
		return getBooktourDAO().searchAllByEmail(email);
	}

	@Override
	public List<Booktour> searchAllByTourName(String tourName) {
		return getBooktourDAO().searchAllByNameTour(tourName);
	}

	@Override
	public boolean deleteBookTour(Integer id) {
		try {
			Booktour booktour = getBooktourDAO().findByIdLock(id);
			if (booktour == null) {
				return false;
			}
			return delete(booktour);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

}
