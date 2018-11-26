package app.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import app.bean.CommentInfo;
import app.bean.TourInfo;
import app.bean.UserInfo;
import app.model.Comment;

public class CommentHelper {
	static Function<Comment, CommentInfo> convertCommentToCommentInfo = (Comment cmt) -> {
		CommentInfo cmtInfo = new CommentInfo();
		cmtInfo.setId(cmt.getId());
		cmtInfo.setContext(cmt.getContext());
		cmtInfo.setStatus(cmt.getStatus());
		cmtInfo.setTime(cmt.getTime());
		TourInfo tourInfo = new TourInfo();
		cmtInfo.setTourInfo(tourInfo);
		UserInfo userInfo = new UserInfo();
		cmtInfo.setUserInfo(userInfo);
		return cmtInfo;
	};

	public static List<CommentInfo> convertListCmtToCmtInfo(List<Comment> lcmt) {
		List<CommentInfo> cmtInfo = new ArrayList<>();
		for (Comment c : lcmt) {
			cmtInfo.add(convertCommentToCommentInfo.apply(c));
		}
		return cmtInfo;
	}
}
