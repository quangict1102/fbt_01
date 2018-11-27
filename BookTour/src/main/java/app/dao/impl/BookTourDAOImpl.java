package app.dao.impl;

import java.util.List;

import app.dao.BookTourDAO;
import app.dao.GenericDAO;
import app.model.Booktour;

public class BookTourDAOImpl extends GenericDAO<Integer, Booktour> implements BookTourDAO {
	@Override
	public List<Booktour> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> countCart(Integer id) {
		return getSession()
				.createQuery("select bt,count(*) as countCar from "
						+ "Booktour bt where bt.user.id = :id group by bt.user.id")
				.setParameter("id", id).getResultList();
	}

}
