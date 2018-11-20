package app.bean;

import java.util.Date;

public class RankOfTourInfo {
	private Integer id;
	private String name;
	private int maxPeople;
	private String primeAdults;
	private String primeChilden;
	private Date dateStart;
	private int rankTour;

	public RankOfTourInfo(Integer id, String name, int maxPeople, String primeAdults, String primeChilden, int rankTour,
			Date dateStart) {
		this.id = id;
		this.name = name;
		this.maxPeople = maxPeople;
		this.primeAdults = primeAdults;
		this.primeChilden = primeChilden;
		this.rankTour = rankTour;
		this.dateStart = dateStart;
	}

	public RankOfTourInfo() {
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

	public int getRankTour() {
		return rankTour;
	}

	public void setRankTour(int rankTour) {
		this.rankTour = rankTour;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

}
