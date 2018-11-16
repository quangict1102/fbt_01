package app.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import app.dao.GenericDAO;
import app.dao.TourDAO;
import app.model.Tour;

public class TourDAOImpl extends GenericDAO<Integer, Tour> implements TourDAO {
	private static final Logger logger = Logger.getLogger(TourDAOImpl.class);

	@Override
	public List<Tour> loadAllTour() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tour> findByPlace(String place) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> getTourToday(Date dateStart) {
		logger.info("date: " + dateStart);
		/*
		 * CriteriaBuilder builder = getSession().getCriteriaBuilder();
		 * CriteriaQuery<Tour> cr = builder.createQuery(Tour.class); Root<Tour>
		 * root = cr.from(Tour.class); cr.select(root); Predicate tkDate =
		 * builder.and(builder.equal(root.get("dateStart"), dateStart));
		 * cr.where(tkDate);
		 */

		Query tk = getSession().createQuery("select t,max(r.numberRank) as numberRank from Tour t inner join Rating r on r.id = t.id where t.dateStart = :dateStart group by t.id ;");
		return ((org.hibernate.query.Query) tk.setParameter("dateStart", dateStart)).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tour> getAllTourByDateAndCity(int idcity, Date date) {
		String sql = "select t from City c join Place p on c.id = p.city.id join Toursplace tp on tp.place.id = p.id join Tour t on tp.tour.id = t.id where c.id = :idcity and t.dateStart = :date ";
		Query tk = getSession().createQuery(sql, Tour.class);
		tk.setParameter("idcity", idcity);
		tk.setParameter("date", date);
		return tk.getResultList();
	}

}
