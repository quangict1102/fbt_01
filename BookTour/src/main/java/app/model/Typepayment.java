package app.model;

import java.util.List;

public class Typepayment implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Bill bill;
	private String namePayment;
	private List<Banking> bankingses;

	public Typepayment() {
	}

	public Typepayment(Integer id, Bill bill, String namePayment, List<Banking> bankingses) {
		this.id = id;
		this.bill = bill;
		this.namePayment = namePayment;
		this.bankingses = bankingses;
	}

	public Typepayment(Integer id, Bill bill, String namePayment) {
		this.id = id;
		this.bill = bill;
		this.namePayment = namePayment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public String getNamePayment() {
		return namePayment;
	}

	public void setNamePayment(String namePayment) {
		this.namePayment = namePayment;
	}

	public List<Banking> getBankingses() {
		return bankingses;
	}

	public void setBankingses(List<Banking> bankingses) {
		this.bankingses = bankingses;
	}

}
