package app.service;

import java.util.List;

import app.bean.CommentInfo;
import app.model.Comment;

public interface CommentService extends BaseService<Integer, Comment> {
	List<CommentInfo> getAllComment();
	
	List<CommentInfo> getAllCommentByIdTour(Integer id);
}
