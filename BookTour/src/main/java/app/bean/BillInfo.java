package app.bean;

import java.util.Date;

import app.model.Booktour;

public class BillInfo {
	private Integer id;
	private String fullName;
	private String email;
	private String phoneNumber;
	private Date time;
	private String totailMoney;
	private Booktour booktour;

	public BillInfo(Integer id, String fullName, String email, String phoneNumber, Date time, String totailMoney,
			Booktour booktour) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.time = time;
		this.totailMoney = totailMoney;
		this.booktour = booktour;
	}

	public BillInfo() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getTotailMoney() {
		return totailMoney;
	}

	public void setTotailMoney(String totailMoney) {
		this.totailMoney = totailMoney;
	}

	public Booktour getBooktour() {
		return booktour;
	}

	public void setBooktour(Booktour booktour) {
		this.booktour = booktour;
	}

}
