package app.dao;

import java.util.List;

import app.model.Bill;

public interface BillDAO extends BaseDAO<Integer, Bill>{
	List<Bill> loadAll();
	
	List<Object[]> loadAllbyTime();
}
