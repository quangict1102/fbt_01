package app.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;

import app.dao.CommentDAO;
import app.dao.GenericDAO;
import app.model.Comment;
import app.model.Tour;
import app.model.User;

public class CommentDAOImpl extends GenericDAO<Integer, Comment> implements CommentDAO {
	private static final Logger logger = Logger.getLogger(CommentDAOImpl.class);

	@Override
	public List<Comment> getAllComment() {
		return null;
	}

	@Override
	public List<Object[]> getAllCommentByIdTour(Integer id) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery query = builder.createQuery();
		Root<Comment> root = query.from(Comment.class);
		Join<Comment, User> joinUser = root.join("user", JoinType.INNER);
		Join<Comment, Tour> joinTour = root.join("tour", JoinType.INNER);
		query.multiselect(root, joinUser);

		Predicate getById = builder.and(builder.equal(joinTour.get("id"), id));
		query.where(getById);
		query.orderBy(builder.desc(root.get("id")));
		return getSession().createQuery(query).getResultList();

	}

}
