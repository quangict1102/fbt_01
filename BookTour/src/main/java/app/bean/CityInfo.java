package app.bean;

import java.util.List;

import app.model.Place;

public class CityInfo {
	private Integer id;
	private String name;
	private List<Place> placeses;
	
	public CityInfo() {
	}
	public CityInfo(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	public CityInfo(Integer id, String name, List<Place> placeses) {
		this.id = id;
		this.name = name;
		this.placeses = placeses;
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
	
	
}
