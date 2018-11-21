package app.model;

import java.util.List;

public class User  {
//		private static final long serialVersionUID = 1L;
	private Integer id;
	private String fullName;
	private int gender;
	private String address;
	private String email;
	private String phoneNumber;
	private String password;
	private String role;
	private List<Comment> commentses;
	private List<Rating> ratingses;
	private List<Booktour> booktourses;

	public User() {
	}

	public User(String fullName, int gender, String address, String email, String phoneNumber, String password,
			String role) {
		super();
		this.fullName = fullName;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.role = role;
	}

	public User(Integer id, String fullName, int gender, String address, String email, String phoneNumber,
			String password, String role) {
		this.id = id;
		this.fullName = fullName;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.role = role;
	}

	public User(Integer id, String fullName, int gender, String address, String email, String phoneNumber,
			String password, String role, List<Comment> commentses, List<Rating> ratingses,
			List<Booktour> booktourses) {
		this.id = id;
		this.fullName = fullName;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.role = role;
		this.commentses = commentses;
		this.ratingses = ratingses;
		this.booktourses = booktourses;
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

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Comment> getCommentses() {
		return commentses;
	}

	public void setCommentses(List<Comment> commentses) {
		this.commentses = commentses;
	}

	public List<Rating> getRatingses() {
		return ratingses;
	}

	public void setRatingses(List<Rating> ratingses) {
		this.ratingses = ratingses;
	}

	public List<Booktour> getBooktourses() {
		return booktourses;
	}

	public void setBooktourses(List<Booktour> booktourses) {
		this.booktourses = booktourses;
	}

}
