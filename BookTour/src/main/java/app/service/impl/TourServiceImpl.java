package app.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import app.bean.TourInfo;
import app.dao.impl.TourDAOImpl;
import app.model.Rating;
import app.model.Tour;
import app.service.TourService;

public class TourServiceImpl extends BaseServiceImpl implements TourService {
	private static final Logger logger = Logger.getLogger(TourDAOImpl.class);

	@Override
	public TourInfo findById(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TourInfo saveOrUpdate(TourInfo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(TourInfo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TourInfo> loadAllTour() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TourInfo> findByPlace(String place) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TourInfo> getTourToday(Date date) {
		try {
			List<Object[]> lObject = getTourDAO().getTourToday(date);
			List<Tour> lTour = new ArrayList<>();
			List<Rating> lRating = new ArrayList<>();
			ObjectMapper mapper = new ObjectMapper();
			String json = null;
			for (Object[] o : lObject) {
				Tour tours = (Tour) o[0];
				lTour.add(tours);
				Rating ratings = (Rating) o[1];
				lRating.add(ratings);
				 json = mapper.writeValueAsString(o);
			}
			System.out.println(json);
/*			
			logger.info("date: " + date);
			List<TourInfo> lTourInfo = new ArrayList<>();
			for (int i = 0; i < lTour.size(); i++) {
				TourInfo tourInfo = new TourInfo();
				tourInfo.setId(lTour.get(i).getId());
				tourInfo.setName(lTour.get(i).getName());
				tourInfo.setMaxPeople(lTour.get(i).getMaxPeople());
				tourInfo.setDescribe(lTour.get(i).getDescribe());
				tourInfo.setPrimeAdults(lTour.get(i).getPrimeAdults());
				tourInfo.setPrimeChilden(lTour.get(i).getPrimeChilden());
				tourInfo.setDurationTime(lTour.get(i).getDurationTime());
				tourInfo.setPlaceFromId(lTour.get(i).getPlaceFromId());
				tourInfo.setPlaceToId(lTour.get(i).getPlaceToId());
				tourInfo.setDateStart(lTour.get(i).getDateStart());

				lTourInfo.add(tourInfo);
			}*/
			return null;
		} catch (Exception e) {
			return null;
		}
	}


}
