package app.bean;

import java.util.Date;

import app.model.Rating;

public class TourInfo {
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
	private Rating numberRank;
	/*
	 * private List<Booktours> booktourses; private List<Toursplaces> toursplaceses;
	 * private List<Ratings> ratingses; private List<Comments> commentses;
	 */

	public TourInfo() {
	}

	public TourInfo(String name, int maxPeople, String describe, String primeAdults, String primeChilden,
			int placeFromId, int placeToId, int durationTime, Date dateStart) {
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
	

	public TourInfo(Integer id, String name, int maxPeople, String describe, String primeAdults, String primeChilden,
			int placeFromId, int placeToId, int durationTime, Date dateStart) {
		super();
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

	public TourInfo(Integer id, String name, int maxPeople, String describe, String primeAdults, String primeChilden,
			int placeFromId, int placeToId, int durationTime, Date dateStart, Rating numberRank) {
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
		this.numberRank = numberRank;
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

	public Rating getNumberRank() {
		return numberRank;
	}

	public void setNumberRank(Rating numberRank) {
		this.numberRank = numberRank;
	}

	/*
	 * public List<Booktours> getBooktourses() { return booktourses; }
	 * 
	 * public void setBooktourses(List<Booktours> booktourses) { this.booktourses =
	 * booktourses; }
	 * 
	 * public List<Toursplaces> getToursplaceses() { return toursplaceses; }
	 * 
	 * public void setToursplaceses(List<Toursplaces> toursplaceses) {
	 * this.toursplaceses = toursplaceses; }
	 * 
	 * public List<Ratings> getRatingses() { return ratingses; }
	 * 
	 * public void setRatingses(List<Ratings> ratingses) { this.ratingses =
	 * ratingses; }
	 * 
	 * public List<Comments> getCommentses() { return commentses; }
	 * 
	 * public void setCommentses(List<Comments> commentses) { this.commentses =
	 * commentses; }
	 */

}
