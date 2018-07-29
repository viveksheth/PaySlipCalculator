package com.payslipcalc;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class TaxRatesTest extends TestCase {

    private TaxRates taxRates;

    @Before
    public void setUp(){
        taxRates = new TaxRates(87001, 180000, 0.37, 19822);
    }

    @Test
    public void test_TaxRatesValues()
    {
        assertEquals(87001, taxRates.getMinLimit());
        assertEquals(180000, taxRates.getMaxLimit());
        assertEquals(0.37, taxRates.getTaxRate());
        assertEquals(19822.0, taxRates.getAdditionCost());

    }
}
