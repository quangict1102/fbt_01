package app.bean;

public class RatingInfo {
	private Integer id;
	private TourInfo tourInfo;
	private UserInfo userInfo;
	private String numberRank;

	public RatingInfo() {
	}

	public RatingInfo(Integer id, TourInfo tourInfo, UserInfo userInfo, String numberRank) {
		this.id = id;
		this.tourInfo = tourInfo;
		this.userInfo = userInfo;
		this.numberRank = numberRank;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TourInfo getTourInfo() {
		return tourInfo;
	}

	public void setTourInfo(TourInfo tourInfo) {
		this.tourInfo = tourInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getNumberRank() {
		return numberRank;
	}

	public void setNumberRank(String numberRank) {
		this.numberRank = numberRank;
	}

}
