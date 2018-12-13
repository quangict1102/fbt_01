package app.dao;

import java.sql.Date;
import java.util.List;

import app.model.Tour;

public interface TourDAO extends BaseDAO<Integer, Tour> {
	List<Tour> loadAllTour();
	
	List<Tour> loadAllTourPagination(int start);

	Tour getAllById(Integer id);

	List<Tour> findByPlace(String place);

	List<Tour> getTourToday(Date date);

	Tour findByIdLock(Integer id);

	List<Object[]> getAllTourByDateAndCity(int city, Date date);
	
	Tour findTourLast();
	
	List<Tour> searchTourAndPlace(String search);
	
}
