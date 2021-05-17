package model;

public class RefundConfirmation {
	
	private Double creditAmount;
	
	public RefundConfirmation(double refund) {
		creditAmount = refund;
		
	}

	public Double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}
}
