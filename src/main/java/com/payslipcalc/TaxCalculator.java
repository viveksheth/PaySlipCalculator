package com.payslipcalc;

import java.util.ArrayList;
import java.util.List;

public class TaxCalculator {

	private List<TaxRates> incomeTaxRates() {

		List<TaxRates> taxItems =new ArrayList<TaxRates>();

		TaxRates itemOne = new TaxRates(18201, 37000, 0.19, 0);
		TaxRates itemTwo = new TaxRates(37001, 87000, 0.325, 3572);
		TaxRates itemThree = new TaxRates(87001, 180000, 0.37, 19822);
		TaxRates itemFour = new TaxRates(180001, Integer.MAX_VALUE, 0.45, 54232);

		taxItems.add(itemOne);
		taxItems.add(itemTwo);
		taxItems.add(itemThree);
		taxItems.add(itemFour);

		return taxItems;
	}

	public long calculate(long annualSalary)
	throws PaySlipCalculatorException {
		if (annualSalary < 0) {
			throw new PaySlipCalculatorException("Annual Salary must be greater than zero");
		}
		for (TaxRates item : incomeTaxRates()) {
			if (annualSalary > item.getMinLimit() && annualSalary <= item.getMaxLimit()) {
				return Math.round((item.getAdditionCost() + (annualSalary - item.getMinLimit()) * item.getTaxRate()) / 12);
			}
		}
		return annualSalary;
	}
}
