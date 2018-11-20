package app.service;

import java.util.List;

import app.bean.BookTourInfo;
import app.model.Booktour;

public interface BookTourService extends BaseService<Integer, Booktour> {
	List<Booktour> getAll();

	Long countCart(Integer idTour);
	
	List<BookTourInfo> getAllByIdUser(Integer id);
	
	List<BookTourInfo> getAllById(Integer id);
	
	boolean deleteBTbtId(Integer id);
	
	Booktour updateBt(BookTourInfo bt);
}
