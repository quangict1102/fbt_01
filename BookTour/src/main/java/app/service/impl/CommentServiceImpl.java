package app.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import app.bean.CommentInfo;
import app.bean.TourInfo;
import app.bean.UserInfo;
import app.helper.CommentHelper;
import app.model.Comment;
import app.model.Tour;
import app.model.User;
import app.service.BaseService;
import app.service.CommentService;

public class CommentServiceImpl extends BaseServiceImpl implements CommentService {
	private static final Logger logger = Logger.getLogger(CommentServiceImpl.class);

	@Override
	public Comment findById(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment saveOrUpdate(Comment entity) {
		try {
			return getCommentDAO().saveOrUpdate(entity);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

	@Override
	public boolean delete(Comment entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<CommentInfo> getAllComment() {
		return null;
	}

	@Override
	public List<CommentInfo> getAllCommentByIdTour(Integer id) {
		try {
			List<Object[]> arrObject = getCommentDAO().getAllCommentByIdTour(id);
			List<Comment> arrCmt = new ArrayList<>();
			List<User> arrUser = new ArrayList<>();
			List<CommentInfo> arrCmtInfo = new ArrayList<>();
			for (Object[] o : arrObject) {
				Comment cmt = (Comment) o[0];
				arrCmt.add(cmt);
				User user = (User) o[1];
				arrUser.add(user);
			}
			for (int i = 0; i < arrCmt.size(); i++) {
				CommentInfo cmtInfo= new CommentInfo();
				cmtInfo.setId(arrCmt.get(i).getId());
				cmtInfo.setContext(arrCmt.get(i).getContext());
				cmtInfo.setStatus(arrCmt.get(i).getStatus());
				cmtInfo.setNameUser(arrUser.get(i).getFullName());
				cmtInfo.setTime(arrCmt.get(i).getTime());
				System.out.println("CommentInfo "+arrUser.get(i).getFullName()+" : "+arrCmt.get(i).getId());
				arrCmtInfo.add(cmtInfo);
			}
			return arrCmtInfo;
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}
}
