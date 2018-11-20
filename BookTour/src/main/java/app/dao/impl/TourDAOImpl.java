package app.dao.impl;

import java.sql.Date;
import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import app.dao.GenericDAO;
import app.dao.TourDAO;
import app.model.RankOfTour;
import app.model.Tour;

public class TourDAOImpl extends GenericDAO<Integer, Tour> implements TourDAO {
	private static final Logger logger = Logger.getLogger(TourDAOImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Tour> loadAllTour() {
		return getSession().createQuery("from Tour").getResultList();
	}

	@Override
	public List<Tour> findByPlace(String place) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tour> getTourToday(Date dateStart) {
		logger.info("date: " + dateStart);
		Query tk = getSession().createQuery("select t from Tour t  where t.dateStart > :dateStart");
		return ((org.hibernate.query.Query) tk.setParameter("dateStart", dateStart)).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getAllTourByDateAndCity(int idcity, Date date) {
		logger.info("date: " + date);
		logger.info("idcity: " + idcity);
		String sql=
			"select t,max(r.numberRank) from  Toursplace tp join Place p "
			+ " on tp.place.id = p.id join Tour t on t.id = tp.tour.id join Rating r"
			+ " on r.tour.id=t.id where tp.place.id in "
			+ " (select p.id from City c,Place p where c.id=p.city.id and c.id= :idcity) "
			+ " and t.dateStart > :date group by t.id";
		return getSession().createQuery(sql).setParameter("idcity", idcity).setParameter("date", date).getResultList();
	}

}
