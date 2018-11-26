package app.bean;

import java.util.List;

import app.model.Bill;
import app.model.Tour;
import app.model.User;

public class BookTourInfo {
	private Integer id;
	private TourInfo tour;
	private UserInfo user;
	private String primeTour;
	private int adults;
	private int children;
	private String status;
	private String notel;
	private List<Bill> bills;

	public BookTourInfo() {
	}

	public BookTourInfo(Integer id, TourInfo tour, UserInfo user, String primeTour, int adults, int children, String status,
			String notel, List<Bill> bills) {
		this.id = id;
		this.tour = tour;
		this.user = user;
		this.primeTour = primeTour;
		this.adults = adults;
		this.children = children;
		this.status = status;
		this.notel = notel;
		this.bills = bills;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TourInfo getTour() {
		return tour;
	}

	public void setTour(TourInfo tour) {
		this.tour = tour;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public String getPrimeTour() {
		return primeTour;
	}

	public void setPrimeTour(String primeTour) {
		this.primeTour = primeTour;
	}

	public int getAdults() {
		return adults;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNotel() {
		return notel;
	}

	public void setNotel(String notel) {
		this.notel = notel;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

}
