package app.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Tour implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private int maxPeople;
	private String describe;
	private String primeAdults;
	private String primeChilden;
	private int placeFromId;
	private int placeToId;
	private int durationTime;
	private Date dateStart;
	private List<Booktour> booktourses;
	private List<Toursplace> toursplaceses;
	private List<Rating> ratingses;
	private List<Comment> commentses;

	public Tour() {
	}

	public Tour(String name, int maxPeople, String describe, String primeAdults, String primeChilden, int placeFromId,
			int placeToId, int durationTime, Date dateStart) {
		super();
		this.name = name;
		this.maxPeople = maxPeople;
		this.describe = describe;
		this.primeAdults = primeAdults;
		this.primeChilden = primeChilden;
		this.placeFromId = placeFromId;
		this.placeToId = placeToId;
		this.durationTime = durationTime;
		this.dateStart = dateStart;
	}

	public Tour(Integer id, String name, int maxPeople, String describe, String primeAdults, String primeChilden,
			int placeFromId, int placeToId, int durationTime, Date dateStart) {
		this.id = id;
		this.name = name;
		this.maxPeople = maxPeople;
		this.describe = describe;
		this.primeAdults = primeAdults;
		this.primeChilden = primeChilden;
		this.placeFromId = placeFromId;
		this.placeToId = placeToId;
		this.durationTime = durationTime;
		this.dateStart = dateStart;
	}

	public Tour(Integer id, String name, int maxPeople, String describe, String primeAdults, String primeChilden,
			int placeFromId, int placeToId, int durationTime, Date dateStart, List<app.model.Booktour> booktourses,
			List<Toursplace> toursplaceses, List<app.model.Rating> ratingses, List<app.model.Comment> commentses) {
		this.id = id;
		this.name = name;
		this.maxPeople = maxPeople;
		this.describe = describe;
		this.primeAdults = primeAdults;
		this.primeChilden = primeChilden;
		this.placeFromId = placeFromId;
		this.placeToId = placeToId;
		this.durationTime = durationTime;
		this.dateStart = dateStart;
		this.booktourses = booktourses;
		this.toursplaceses = toursplaceses;
		this.ratingses = ratingses;
		this.commentses = commentses;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxPeople() {
		return maxPeople;
	}

	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getPrimeAdults() {
		return primeAdults;
	}

	public void setPrimeAdults(String primeAdults) {
		this.primeAdults = primeAdults;
	}

	public String getPrimeChilden() {
		return primeChilden;
	}

	public void setPrimeChilden(String primeChilden) {
		this.primeChilden = primeChilden;
	}

	public int getPlaceFromId() {
		return placeFromId;
	}

	public void setPlaceFromId(int placeFromId) {
		this.placeFromId = placeFromId;
	}

	public int getPlaceToId() {
		return placeToId;
	}

	public void setPlaceToId(int placeToId) {
		this.placeToId = placeToId;
	}

	public int getDurationTime() {
		return durationTime;
	}

	public void setDurationTime(int durationTime) {
		this.durationTime = durationTime;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public List<Booktour> getBooktourses() {
		return booktourses;
	}

	public void setBooktourses(List<Booktour> booktourses) {
		this.booktourses = booktourses;
	}

	public List<Toursplace> getToursplaceses() {
		return toursplaceses;
	}

	public void setToursplaceses(List<Toursplace> toursplaceses) {
		this.toursplaceses = toursplaceses;
	}

	public List<Rating> getRatingses() {
		return ratingses;
	}

	public void setRatingses(List<Rating> ratingses) {
		this.ratingses = ratingses;
	}

	public List<Comment> getCommentses() {
		return commentses;
	}

	public void setCommentses(List<Comment> commentses) {
		this.commentses = commentses;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
