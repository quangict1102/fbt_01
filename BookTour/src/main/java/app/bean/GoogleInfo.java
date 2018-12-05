package app.bean;

public class GoogleInfo {
	private String id;
	private String email;
	private boolean verified_email;
	private String link;
	private String picture;

	public GoogleInfo() {
	}

	public GoogleInfo(String id, String email, boolean verified_email, String link, String picture) {
		super();
		this.id = id;
		this.email = email;
		this.verified_email = verified_email;
		this.link = link;
		this.picture = picture;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isVerified_email() {
		return verified_email;
	}

	public void setVerified_email(boolean verified_email) {
		this.verified_email = verified_email;
	}

}
