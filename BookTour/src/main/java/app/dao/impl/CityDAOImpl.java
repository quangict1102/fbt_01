package app.dao.impl;

import java.util.List;

import app.dao.CityDAO;
import app.dao.GenericDAO;
import app.model.City;

public class CityDAOImpl extends GenericDAO<Integer, City> implements CityDAO {

	@Override
	public List<City> getAllCity() {
		return getSession().createQuery("from City", City.class).list();
	}

	@Override
	public List<City> getAllCityByName(String nameCity) {
		return getSession().createQuery("from City where name = :nameCity", City.class)
				.setParameter("nameCity", nameCity).getResultList();
	}

}
