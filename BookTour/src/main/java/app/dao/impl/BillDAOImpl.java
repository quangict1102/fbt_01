package app.dao.impl;

import java.util.List;

import app.dao.BillDAO;
import app.dao.GenericDAO;
import app.model.Bill;
import app.model.User;

public class BillDAOImpl extends GenericDAO<Integer, Bill> implements BillDAO{

	@Override
	public List<Bill> loadAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> loadAllbyTime() {
		
		return  getSession().createQuery("SELECT time ,count (*) FROM Bill where MONTH(time)=11  group by time").getResultList();
	}

}
