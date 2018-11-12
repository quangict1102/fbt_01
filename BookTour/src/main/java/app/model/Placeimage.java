package app.model;

public class Placeimage implements java.io.Serializable {

	private static final long serialVersionUID = 7146035672896975879L;
	private Integer id;
	private Place place;
	private String urlImage;

	public Placeimage() {
	}

	public Placeimage(Integer id, Place place, String urlImage) {
		this.id = id;
		this.place = place;
		this.urlImage = urlImage;
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

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
