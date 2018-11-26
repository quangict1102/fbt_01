package app.service;

import java.util.List;

import app.model.Booktour;

public interface BookTourService extends BaseService<Integer, Booktour>{
	List<Booktour> getAll();
}
