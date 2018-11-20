package app.model;

import java.util.Date;

public class Comment implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Tour tour;
	private User user;
	private String context;
	private Date time;
	private int status;

	public Comment(Integer id, Tour tour, User user, String context, Date time, int status) {
		this.id = id;
		this.tour = tour;
		this.user = user;
		this.context = context;
		this.time = time;
		this.status = status;
	}

	public Comment() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
