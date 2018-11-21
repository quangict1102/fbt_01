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
import app.model.RankOfTour;
import app.model.Rating;
import app.model.Tour;
import app.service.TourService;

public class TourServiceImpl extends BaseServiceImpl implements TourService {
	private static final Logger logger = Logger.getLogger(TourDAOImpl.class);

/*	@Override
	public TourInfo findById(Serializable key) {
		return null;
	}

	@Override
	public TourInfo saveOrUpdate(TourInfo entity) {
		try {
			Tour tour =TourConvertHelper.convertSingleTourInfoToTour(entity);
			Tour tour1 = getTourDAO().saveOrUpdate(tour);
			
			return TourConvertHelper.convertSingleTourToTourInfo(tour1);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	
	}

	@Override
	public boolean delete(TourInfo entity) {
		// TODO Auto-generated method stub
		return false;
	}*/

	@Override
	public List<TourInfo> loadAllTour() {
		return TourConvertHelper.convertTourToTourInfo(getTourDAO().loadAllTour());
	}

	@Override
	public List<TourInfo> findByPlace(String place) {
		// TODO Auto-generated method stub
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
	public TourInfo saveOrUpdate(String strDate, TourInfo entity) {

		entity.setDateStart(ConvertDateSql.convertStringtoDate(strDate));
		entity.setId(14);
		try {
			getTourDAO().saveOrUpdate(TourConvertHelper.convertSingleTourInfoToTour(entity));
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		return null;
	}

	@Override
	public Tour findById(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tour saveOrUpdate(Tour entity) {
		try {
			/*User user = userDAO.findByIdLock(entity.getId());
			if (user == null) {
				return null;
			}*/
			return getTourDAO().saveOrUpdate(entity);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		
	}

	@Override
	public boolean delete(Tour entity) {
		// TODO Auto-generated method stub
		return false;
	}

}
