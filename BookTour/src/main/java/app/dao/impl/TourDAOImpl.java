package app.dao.impl;

import java.sql.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;

import app.dao.GenericDAO;
import app.dao.TourDAO;
import app.model.City;
import app.model.Place;
import app.model.Rating;
import app.model.Tour;
import app.model.Toursplace;

public class TourDAOImpl extends GenericDAO<Integer, Tour> implements TourDAO {
	private static final Logger logger = Logger.getLogger(TourDAOImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<Tour> loadAllTour() {
		return getSession().createQuery("from Tour ORDER BY id DESC").getResultList();
	}

	@Override
	public List<Tour> findByPlace(String place) {
		return null;
	}

	@Override
	public List<Tour> getTourToday(Date dateStart) {
		logger.info("date: " + dateStart);
		Query tk = getSession().createQuery("select t from Tour t  where t.dateStart = :dateStart");
		return ((org.hibernate.query.Query) tk.setParameter("dateStart", dateStart)).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getAllTourByDateAndCity(int idcity, Date date) {
		logger.info("date: " + date);
		logger.info("idcity: " + idcity);
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery query = builder.createQuery();
		Root<Toursplace> root = query.from(Toursplace.class);

		Subquery<Integer> subquery = query.subquery(Integer.class);
		Root<Place> subroot = subquery.from(Place.class);
		Join<Place, City> subjoinCity = subroot.join("city", JoinType.INNER);
		subquery.select(subroot.get("id")).where(builder.equal(subjoinCity.get("id"), idcity));

		Join<Toursplace, Tour> joinTour = root.join("tour", JoinType.INNER);
		Join<Toursplace, Place> joinPlace = root.join("place", JoinType.INNER);
		Root<Rating> ratingRoot = query.from(Rating.class);
		Join<Rating, Tour> joinRating = ratingRoot.join("tour", JoinType.INNER);
		query.multiselect(joinTour, builder.max(ratingRoot.get("numberRank"))).groupBy(joinTour.get("id"));

		Predicate getByDate = builder.and(builder.greaterThan(joinTour.<Date>get("dateStart"), date));

		Predicate getByIdPlace = builder.and(builder.in(joinPlace.get("id")).value(subquery));

		query.where(getByDate, getByIdPlace);
		return getSession().createQuery(query).getResultList();
	}

	@Override
	public Tour getAllById(Integer id) {
		return getSession().get(Tour.class, id);
	}

	@Override
	public Tour findByIdLock(Integer id) {
		logger.info("find id lock: " + id);
		return (Tour) getSession().load(Tour.class, id, LockMode.PESSIMISTIC_WRITE);
	}

	@Override
	public Tour findTourLast() {
		return (Tour) getSession().createQuery("FROM Tour WHERE id IN( SELECT Max(id) FROM Tour)").getSingleResult();
	}

	@Override
	public List<Tour> searchTourAndPlace(String keyword) {
		/* String query = " select t from Tour t where t.name like :keyword"; */
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery query = builder.createQuery();
		Root<Tour> root = query.from(Tour.class);
		query.select(root);
		Predicate search = builder.and(builder.like(root.get("name").as(String.class), "%" + keyword + "%"));
		query.where(search);
		return getSession().createQuery(query).getResultList();
	}

}
