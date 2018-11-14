package app.model;

import java.util.Date;
import java.util.List;

public class Bill implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String fullName;
	private String email;
	private String phoneNumber;
	private Date time;
	private String totailMoney;
	private List<Typepayment> typepaymentses;
	private List<Booktour> booktourses;

	public Bill() {
	}

	public Bill(Integer id, String fullName, String email, String phoneNumber, Date time, String totailMoney,
			List<Typepayment> typepaymentses, List<Booktour> booktourses) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.time = time;
		this.totailMoney = totailMoney;
		this.typepaymentses = typepaymentses;
		this.booktourses = booktourses;
	}

	public Bill(Integer id, String fullName, String email, String phoneNumber, Date time, String totailMoney) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.time = time;
		this.totailMoney = totailMoney;
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

	public List<Typepayment> getTypepaymentses() {
		return typepaymentses;
	}

	public void setTypepaymentses(List<Typepayment> typepaymentses) {
		this.typepaymentses = typepaymentses;
	}

	public List<Booktour> getBooktourses() {
		return booktourses;
	}

	public void setBooktourses(List<Booktour> booktourses) {
		this.booktourses = booktourses;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
