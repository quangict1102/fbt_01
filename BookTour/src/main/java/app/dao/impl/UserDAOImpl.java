package app.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import app.dao.GenericDAO;
import app.dao.UserDAO;
import app.helper.Md5Helper;
import app.model.User;

public class UserDAOImpl extends GenericDAO<Integer, User> implements UserDAO {

	private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

	public UserDAOImpl() {
		super(User.class);
	}

	public UserDAOImpl(SessionFactory sessionfactory) {
		setSessionFactory(sessionfactory);
	}

	@Override
	public User findByEmail(String email) {
		logger.info("email: " + email);
		return (User) getSession().createQuery("FROM User where email = :email").setParameter("email", email)
				.uniqueResult();
	}

	@Override
	public List<User> searchUserUsingCretial(String name) {

		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<User> cr = builder.createQuery(User.class);
		Root<User> root = cr.from(User.class);
		cr.select(root);

		Predicate nameRestriction = builder.and(builder.like(root.get("name"), "%" + name + "%"));
		cr.where(nameRestriction);
		return getSession().createQuery(cr).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> loadUsers() {

		return getSession().createQuery("from User ORDER BY id DESC").getResultList();
	}

	@Override
	public User findByIdLock(Integer id, boolean lock) {
		logger.info(" find user id lock: " + id);
		if (lock) {
			return getSession().get(User.class, id, LockMode.PESSIMISTIC_WRITE);
		}
		return getSession().get(User.class, id);

	}

	@Override
	public User findByEmailAndPassword(String email, String password) {
		logger.info("email password " + email + password);
		return (User) getSession().createQuery("FROM User where email = :email AND password=:password")
				.setParameter("email", email).setParameter("password", Md5Helper.getCodeMd5(password)).uniqueResult();
	}

	@Override
	public User findByIdAndPassword(Integer id, String password) {
		logger.info("id password " + id + password);
		return (User) getSession().createQuery("FROM User where id = :id AND password=:password").setParameter("id", id)
				.setParameter("password", Md5Helper.getCodeMd5(password)).uniqueResult();
	}

}
