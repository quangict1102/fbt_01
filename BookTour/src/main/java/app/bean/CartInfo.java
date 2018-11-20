package app.bean;

public class CartInfo {
	private Long countCart;

	public CartInfo() {
	}

	public CartInfo(Long countCart) {
		this.countCart = countCart;
	}

	public Long getCountCart() {
		return countCart;
	}

	public void setCountCart(Long countCart) {
		this.countCart = countCart;
	}
	
}
