package app.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import app.bean.CityInfo;
import app.bean.PlaceInfo;
import app.model.City;
import app.model.Place;

public class PlaceConvertHelper {
	static Function<Place, PlaceInfo> placeToPlaceInfo = (Place place) -> {
		PlaceInfo placeInfo = new PlaceInfo();
		placeInfo.setId(place.getId());
		placeInfo.setName(place.getName());
		CityInfo cityInfo = new CityInfo();
		placeInfo.setCityInfo(cityInfo);
		return placeInfo;
	};

	public static List<PlaceInfo> convertPlaceToPlaceInfo(List<Place> lPlace) {
		List<PlaceInfo> lPlaceInfo = new ArrayList<>();
		for (Place p : lPlace) {
			lPlaceInfo.add(placeToPlaceInfo.apply(p));
		}
		return lPlaceInfo;
	}

	public static PlaceInfo convertSinglePlaceToPlaceInfo(Place place) {
		return placeToPlaceInfo.apply(place);
	}

	static Function<PlaceInfo, Place> placeInfoToPlace = (PlaceInfo placeInfo) -> {
		Place place = new Place();
		place.setId(placeInfo.getId());
		place.setName(placeInfo.getName());
		City city = new City();
		place.setCity(city);
		return place;
	};

	public static List<Place> convertPlaceInfoToPlace(List<PlaceInfo> lPlaceInfo) {
		List<Place> lPlace = new ArrayList<>();
		for (PlaceInfo p : lPlaceInfo) {
			lPlace.add(placeInfoToPlace.apply(p));
		}
		return lPlace;
	}

	public static Place convertSinglePlaceInfoToPlace(PlaceInfo placeInfo) {
		return placeInfoToPlace.apply(placeInfo);
	}

}
