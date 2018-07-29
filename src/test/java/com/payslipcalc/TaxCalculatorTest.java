package com.payslipcalc;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class TaxCalculatorTest extends TestCase {

    private TaxCalculator taxCalculator;

    @Before
    public void setUp()
    {
        taxCalculator = new TaxCalculator();
    }

    @Test
    public void test_AnnualSalary_InValid() {
        try {
            taxCalculator.calculate(-55000);
        } catch (Exception ex) {
            assertEquals(ex.getMessage(), "Annual Salary must be greater than zero");
        }
    }

    @Test
    public void test_taxableIncome()
            throws Exception {
        double result = taxCalculator.calculate(60050);
        assertEquals(922, (long) result);
    }
}
