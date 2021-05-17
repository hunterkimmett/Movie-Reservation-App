package model;

public class Payment {

	private double cost;
	private String creditCard;
	private String name;
	
	public Payment(double price, String card, String s) {
		cost = price;
		creditCard = card;
		name = s;
	}
	
	@Override
	public String toString() {
		return "Cost: " + cost + "\tCredit Card: " + creditCard + "\tName: " + name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}
