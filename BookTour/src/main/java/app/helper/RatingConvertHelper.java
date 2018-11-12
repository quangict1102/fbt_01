package app.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import app.bean.RatingInfo;
import app.bean.TourInfo;
import app.bean.UserInfo;
import app.model.Rating;
import app.model.Tour;
import app.model.User;

public class RatingConvertHelper {
	static Function<Rating, RatingInfo> convertRatingToRatingInfo = (Rating rating) -> {
		RatingInfo ratingInfo = new RatingInfo();
		ratingInfo.setId(rating.getId());
		ratingInfo.setNumberRank(rating.getNumberRank());
		TourInfo tourInfo = new TourInfo();
		ratingInfo.setTourInfo(tourInfo);
		UserInfo userInfo = new UserInfo();
		ratingInfo.setUserInfo(userInfo);
		return ratingInfo;

	};

	public static List<RatingInfo> convertRatingToRatingInfo(List<Rating> lRating) {
		List<RatingInfo> lRatingInfo = new ArrayList<>();
		for (Rating r : lRating) {
			lRatingInfo.add(convertRatingToRatingInfo.apply(r));
		}
		return lRatingInfo;
	}

	public static RatingInfo convertSingleRatingToRatingInfo(Rating r) {
		return convertRatingToRatingInfo.apply(r);
	}

	static Function<RatingInfo, Rating> convertRatingInfoToRating = (RatingInfo ratingInfo) -> {
		Rating rating = new Rating();
		rating.setId(rating.getId());
		rating.setNumberRank(rating.getNumberRank());
		Tour tourInfo = new Tour();
		rating.setTour(tourInfo);
		User user = new User();
		rating.setUser(user);
		return rating;
	};

	public static List<Rating> convertRatingInfoToRating(List<RatingInfo> lRatingInfo) {
		List<Rating> lRating = new ArrayList<>();
		for (RatingInfo r : lRatingInfo) {
			lRating.add(convertRatingInfoToRating.apply(r));
		}
		return lRating;
	}

	public static Rating convertSingleRatingInfoToRating(RatingInfo r) {
		return convertRatingInfoToRating.apply(r);
	}
}
