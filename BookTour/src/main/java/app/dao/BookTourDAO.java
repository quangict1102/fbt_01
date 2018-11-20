package app.dao;

import java.util.List;

import app.model.Booktour;

public interface BookTourDAO extends BaseDAO<Integer, Booktour> {
	List<Booktour> getAll();
}
