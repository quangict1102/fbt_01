package app.dao;

import java.sql.Date;
import java.util.List;

import app.model.RankOfTour;
import app.model.Tour;

public interface TourDAO extends BaseDAO<Integer, Tour> {
	List<Tour> loadAllTour();

	List<Tour> findByPlace(String place);

	List<Tour> getTourToday(Date date);

	List<Object[]> getAllTourByDateAndCity(int city, Date date);
}
