package app.dao.impl;

import java.util.List;

import org.hibernate.LockMode;

import app.dao.BookTourDAO;
import app.dao.GenericDAO;
import app.model.Booktour;

public class BookTourDAOImpl extends GenericDAO<Integer, Booktour> implements BookTourDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Booktour> getAll() {
		return getSession().createQuery("from Booktour").getResultList();
	}

	@Override
	public List<Object[]> countCart(Integer id) {
		return getSession()
				.createQuery("select bt,count(*) as countCar from "
						+ "Booktour bt where bt.user.id = :id group by bt.user.id")
				.setParameter("id", id).getResultList();
}

	@Override
	public List<Booktour> getAllByIdUser(Integer id) {
		return getSession()
				.createQuery(
						"select bt from Booktour bt "
								+ "where bt.id not in (select b.booktour.id from Bill b) and bt.user.id = :id",
						Booktour.class)
				.setParameter("id", id).getResultList();
	}

	@Override
	public List<Booktour> getAllById(Integer id) {
		return getSession().createQuery("from Booktour bt where bt.id = :id", Booktour.class).setParameter("id", id)
				.getResultList();
	}

	@Override
	public Booktour findByIdLock(Integer id, boolean lock) {
		if (lock) {
			return getSession().get(Booktour.class, id, LockMode.PESSIMISTIC_WRITE);
		}
		return getSession().get(Booktour.class, id);
	}

	public List<Booktour> searchAllByEmail(String email) {
		return getSession().createQuery("from Booktour where user.email like :email  ")
				.setParameter("email", "%" + email + "%").getResultList();
	}

	@Override
	public List<Booktour> searchAllByNameTour(String tourName) {
		return getSession().createQuery("from Booktour where tour.name like :tourName  ")
				.setParameter("tourName", "%" + tourName + "%").getResultList();
	}

	@Override
	public Booktour findByIdLock(Integer id) {
		logger.info("find id lock: " + id);
		return (Booktour) getSession().load(Booktour.class, id, LockMode.PESSIMISTIC_WRITE);
	}

}
