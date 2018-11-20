package app.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import app.bean.RankOfTourInfo;
import app.model.RankOfTour;

public class RankOfTourHelper {
	static Function<RankOfTour, RankOfTourInfo> rankTourToRankTourInfo = (RankOfTour t) -> {
		RankOfTourInfo info = new RankOfTourInfo();
		info.setId(t.getId());
		info.setName(t.getName());
		info.setMaxPeople(t.getMaxPeople());
		info.setPrimeAdults(t.getPrimeAdults());
		info.setPrimeChilden(t.getPrimeChilden());
		info.setDateStart(t.getDateStart());
		info.setRankTour(t.getRankTour());
		return info;

	};

	public static List<RankOfTourInfo> convertRankTourToRankTourInfo(List<RankOfTour> lRankOfTour) {
		List<RankOfTourInfo> arr = new ArrayList<>();
		for (RankOfTour r : lRankOfTour) {
			arr.add(rankTourToRankTourInfo.apply(r));
		}
		return arr;
	}

	public static RankOfTourInfo convertSingleRankTourToRankTourInfo(RankOfTour t) {
		return rankTourToRankTourInfo.apply(t);
	}
}
