package app.dao;

import java.util.List;

import app.model.Booktour;

public interface BookTourDAO extends BaseDAO<Integer, Booktour> {
	List<Booktour> getAll();

	List<Object[]> countCart(Integer idTour);
	
	List<Booktour> getAllByIdUser(Integer id);
	
	List<Booktour> getAllById(Integer id);
	
	Booktour findByIdLock(Integer id,boolean lock);
	
	List<Booktour> searchAllByEmail(String email);
	
	List<Booktour> searchAllByNameTour(String tourName);
	
	Booktour findByIdLock(Integer id);
}
