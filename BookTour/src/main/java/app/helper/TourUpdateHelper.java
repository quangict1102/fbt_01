package app.helper;

import app.model.Tour;

public class TourUpdateHelper {

	public static Tour update(Tour tour, Tour tourUpdate) {
		tourUpdate.setId(tour.getId());
		tourUpdate.setName(tour.getName());
		tourUpdate.setMaxPeople(tour.getMaxPeople());
		tourUpdate.setDescribe(tour.getDescribe());
		tourUpdate.setPrimeAdults(tour.getPrimeAdults());
		tourUpdate.setPrimeChilden(tour.getPrimeChilden());
		tourUpdate.setDurationTime(tour.getDurationTime());
		tourUpdate.setPlaceFromId(tour.getPlaceFromId());
		tourUpdate.setPlaceToId(tour.getPlaceToId());
		tourUpdate.setDateStart(tour.getDateStart());
		return tourUpdate;
	}

}
