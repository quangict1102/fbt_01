package app.model;

public class Toursplace implements java.io.Serializable {

	private static final long serialVersionUID = 3202937915064230357L;
	private Integer id;
	private Place place;
	private Tour tour;
	private Byte typeFromTo;

	public Toursplace() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Toursplace(Integer id, Place place, Tour tour, Byte typeFromTo) {
		super();
		this.id = id;
		this.place = place;
		this.tour = tour;
		this.typeFromTo = typeFromTo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

	public Byte getTypeFromTo() {
		return typeFromTo;
	}

	public void setTypeFromTo(Byte typeFromTo) {
		this.typeFromTo = typeFromTo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
