package app.model;

public class Rating implements java.io.Serializable {

	private static final long serialVersionUID = 3428821928493594345L;
	private Integer id;
	private Tour tour;
	private User user;
	private String numberRank;

	public Rating() {
	}

	public Rating(Integer id, Tour tour, User user, String numberRank) {
		this.id = id;
		this.tour = tour;
		this.user = user;
		this.numberRank = numberRank;
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

	public String getNumberRank() {
		return numberRank;
	}

	public void setNumberRank(String numberRank) {
		this.numberRank = numberRank;
	}

}
