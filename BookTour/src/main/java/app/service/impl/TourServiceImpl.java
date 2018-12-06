package app.service.impl;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import app.bean.RankOfTourInfo;
import app.bean.TourInfo;
import app.dao.impl.TourDAOImpl;
import app.helper.ConvertDateSql;
import app.helper.RankOfTourHelper;
import app.helper.TourConvertHelper;
import app.helper.TourUpdateHelper;
import app.model.Place;
import app.model.RankOfTour;
import app.model.Tour;
import app.model.Toursplace;
import app.service.TourService;

public class TourServiceImpl extends BaseServiceImpl implements TourService {
	private static final Logger logger = Logger.getLogger(TourDAOImpl.class);

	@Override
	public List<TourInfo> loadAllTour() {
		return TourConvertHelper.convertTourToTourInfo(getTourDAO().loadAllTour());
	}

	@Override
	public List<TourInfo> findByPlace(String place) {
		return null;
	}

	@Override
	public List<TourInfo> getTourToday(Date date) {
		try {
			return TourConvertHelper.convertTourToTourInfo(getTourDAO().getTourToday(date));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<RankOfTourInfo> getAllTourByDateAndCity(int city, Date date) {
		try {
			List<Object[]> arrObject = getTourDAO().getAllTourByDateAndCity(city, date);
			List<RankOfTour> arrRankOfTour = new ArrayList<>();
			List<Tour> arrTour = new ArrayList<>();
			List<String> arrRating = new ArrayList<>();
			for (Object[] o : arrObject) {
				Tour tour = (Tour) o[0];
				arrTour.add(tour);
				String rating = (String) o[1];
				arrRating.add(rating);
			}
			for (int i = 0; i < arrTour.size(); i++) {
				RankOfTour rankOfTour = new RankOfTour();
				rankOfTour.setId(arrTour.get(i).getId());
				rankOfTour.setName(arrTour.get(i).getName());
				rankOfTour.setMaxPeople(arrTour.get(i).getMaxPeople());
				rankOfTour.setPrimeAdults(arrTour.get(i).getPrimeAdults());
				rankOfTour.setPrimeChilden(arrTour.get(i).getPrimeChilden());
				rankOfTour.setDateStart(arrTour.get(i).getDateStart());
				rankOfTour.setRankTour(Integer.valueOf(arrRating.get(i)));
				arrRankOfTour.add(rankOfTour);
			}
			return RankOfTourHelper.convertRankTourToRankTourInfo(arrRankOfTour);
		} catch (Exception e) {
			logger.error("Error getAllTourByDateAndCity: ", e);
			return null;
		}

	}

	@Override
	public Tour saveOrUpdate(String strDate, Tour entity) {
		entity.setDateStart(ConvertDateSql.convertStringtoDate(strDate));
		try {
			if (entity.getId() == null) {

				Place placeFrom = getPlaceDAO().findById(entity.getPlaceFromId());
				Place tourTo = getPlaceDAO().findById(entity.getPlaceToId());

				Toursplace tourPlaceFrom = new Toursplace();
				tourPlaceFrom.setPlace(placeFrom);
				tourPlaceFrom.setTour(getTourDAO().findTourLast());

				Toursplace tourPlaceTo = new Toursplace();
				tourPlaceTo.setPlace(tourTo);
				tourPlaceTo.setTour(getTourDAO().findTourLast());

				List<Toursplace> listTourPlace = new ArrayList<>();
				listTourPlace.add(tourPlaceFrom);
				listTourPlace.add(tourPlaceTo);

				entity.setToursplaceses(listTourPlace);

				return getTourDAO().saveOrUpdate(entity);
			}
			Tour tour = tourDAO.findByIdLock(entity.getId());
			return getTourDAO().saveOrUpdate(TourUpdateHelper.update(entity, tour));
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}

	}

	@Override
	public boolean deleteTour(Integer id) {
		try {
			Tour tour = getTourDAO().findByIdLock(id);
			if (tour == null) {
				return false;
			}
			return deleteTour(tour);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

	@Override
	public TourInfo findById(Serializable key) {
		return TourConvertHelper.convertSingleTourToTourInfo(getTourDAO().findById(key));
	}

	@Override
	public TourInfo saveOrUpdate(TourInfo entity) {
		return null;
	}

	@Override

	public boolean delete(TourInfo entity) {
		try {
			Tour tour = TourConvertHelper.convertSingleTourInfoToTour(entity);
			getTourDAO().delete(tour);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean deleteTour(Tour tour) {
		try {
			getTourDAO().delete(tour);
			return true;
		} catch (Exception e) {
			throw e;

		}
	}

	@Override
	public Tour findTourLast() {
		return null;
	}

	@Override
	public TourInfo getAllById(Integer id) {
		try {
			return TourConvertHelper.convertSingleTourToTourInfo(getTourDAO().findById(id));
		} catch (Exception e) {
			throw e;

		}
	}

	@Override
	public List<TourInfo> searchTourAndPlace(String search) {
		try {
			return TourConvertHelper.convertTourToTourInfo(getTourDAO().searchTourAndPlace(search));
		} catch (Exception e) {
			throw e;

		}
	}

}
