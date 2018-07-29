package com.payslipcalc;


public class TaxRates {

	private int maxLimit;
	private int minLimit;
	private double taxRate;
	private double additionCost;
	
	
	public TaxRates(){
		this(0,0,0,0);
	}

	public TaxRates(int minlimit, int maxLimit, double taxRate, double additionCost){
		this.maxLimit = maxLimit;
		this.minLimit = minlimit;
		this.taxRate = taxRate;
		this.additionCost = additionCost;
	}

	
	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}
	
	public double getAdditionCost() {
		return additionCost;
	}

	public void setAdditionCost(double additionCost) {
		this.additionCost = additionCost;
	}

	public int getMaxLimit() {
		return maxLimit;
	}

	public void setMaxLimit(int maxLimit) {
		this.maxLimit = maxLimit;
	}

	public int getMinLimit() {
		return minLimit;
	}

	public void setMinLimit(int minLimit) {
		this.minLimit = minLimit;
	}
}
