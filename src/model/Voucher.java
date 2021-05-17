package model;

public class Voucher implements Constants{
	private Double voucherAmount;
	private static int voucherCounter = 1000;
	private int voucherID;
	
	public Voucher() {
		voucherCounter++;
		setVoucherID(voucherCounter);
		voucherAmount = VOUCHER;
		
	}

	public Double getVoucherAmount() {
		return voucherAmount;
	}

	public void setVoucherAmount(Double voucherAmount) {
		this.voucherAmount = voucherAmount;
	}

	public int getVoucherID() {
		return voucherID;
	}

	public void setVoucherID(int voucherID) {
		this.voucherID = voucherID;
	}
}
