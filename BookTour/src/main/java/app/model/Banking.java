package app.model;

import java.io.Serializable;

public class Banking implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Typepayment typepayment;
	private String namebanking;

	public Banking(Integer id, Typepayment typepayment, String namebanking) {
		this.id = id;
		this.typepayment = typepayment;
		this.namebanking = namebanking;
	}

	public Banking() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Typepayment getTypepayment() {
		return typepayment;
	}

	public void setTypepayment(Typepayment typepayment) {
		this.typepayment = typepayment;
	}

	public String getNamebanking() {
		return namebanking;
	}

	public void setNamebanking(String namebanking) {
		this.namebanking = namebanking;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
