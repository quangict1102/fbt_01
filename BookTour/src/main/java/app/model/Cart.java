package app.model;

public class Cart {
	private int idUser;
	private int idTour;
	private String nameUser;
	private String nameTour;
	private int countCart;
	private String price;

	public Cart(int idUser, int idTour, String nameUser, String nameTour, int countCart, String price) {
		this.idUser = idUser;
		this.idTour = idTour;
		this.nameUser = nameUser;
		this.nameTour = nameTour;
		this.countCart = countCart;
		this.price = price;
	}

	public Cart() {
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdTour() {
		return idTour;
	}

	public void setIdTour(int idTour) {
		this.idTour = idTour;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getNameTour() {
		return nameTour;
	}

	public void setNameTour(String nameTour) {
		this.nameTour = nameTour;
	}

	public int getCountCart() {
		return countCart;
	}

	public void setCountCart(int countCart) {
		this.countCart = countCart;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
