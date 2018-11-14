package app.model;

import java.io.Serializable;
import java.util.List;

public class City implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private List<Place> placeses;

	public City(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public City(Integer id, String name, List<Place> placeses) {
		super();
		this.id = id;
		this.name = name;
		this.placeses = placeses;
	}

	public City() {
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

	public List<Place> getPlaceses() {
		return placeses;
	}

	public void setPlaceses(List<Place> placeses) {
		this.placeses = placeses;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
