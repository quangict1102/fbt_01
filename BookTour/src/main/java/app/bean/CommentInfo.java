package app.bean;

import java.util.Date;

public class CommentInfo {
	private Integer id;
	private TourInfo tourInfo;
	private UserInfo userInfo;
	private String context;
	private Date time;
	private int status;
	private String nameUser;

	public CommentInfo(Integer id, TourInfo tourInfo, UserInfo userInfo, String context, Date time, int status) {
		this.id = id;
		this.tourInfo = tourInfo;
		this.userInfo = userInfo;
		this.context = context;
		this.time = time;
		this.status = status;
	}

	public CommentInfo() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TourInfo getTourInfo() {
		return tourInfo;
	}

	public void setTourInfo(TourInfo tourInfo) {
		this.tourInfo = tourInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

}
