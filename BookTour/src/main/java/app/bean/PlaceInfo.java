package app.bean;

import java.util.List;

import app.model.City;
import app.model.Placeimage;
import app.model.Toursplace;

public class PlaceInfo {
	private Integer id;
	private CityInfo cityInfo;
	private String name;
	private List<Toursplace> toursplaceses;
	private List<Placeimage> placeimages;

	public PlaceInfo() {
	}

	public PlaceInfo(Integer id, CityInfo cityInfo, String name) {
		this.id = id;
		this.cityInfo = cityInfo;
		this.name = name;
	}

	public PlaceInfo(Integer id, CityInfo cityInfo, String name, List<Toursplace> toursplaceses,
			List<Placeimage> placeimages) {
		this.id = id;
		this.cityInfo = cityInfo;
		this.name = name;
		this.toursplaceses = toursplaceses;
		this.placeimages = placeimages;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CityInfo getCityInfo() {
		return cityInfo;
	}

	public void setCityInfo(CityInfo cityInfo) {
		this.cityInfo = cityInfo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Toursplace> getToursplaceses() {
		return toursplaceses;
	}

	public void setToursplaceses(List<Toursplace> toursplaceses) {
		this.toursplaceses = toursplaceses;
	}

	public List<Placeimage> getPlaceimages() {
		return placeimages;
	}

	public void setPlaceimages(List<Placeimage> placeimages) {
		this.placeimages = placeimages;
	}

}
