package com.payslipcalc;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest extends TestCase {

    private Employee employee;

    @Before
    public void setUp() {

        employee = new Employee("David", "Rudd", 42000, 9.5, "01 March - 31 March");
    }

    @Test
    public void test_Employee_Instance_Created()
    {
        assertNotNull(employee);
        assertEquals(employee.getFirstName(),"David");
    }

    @Test
    public void test_AnnualSalary_IsValid() {
        try {
            employee.setAnnualSalary(-100000);
        } catch (PaySlipCalculatorException ex) {
            TestCase.assertEquals("Annual Salary must be a positive", ex.getMessage());
        }
    }

    @Test
    public void test_SuperRate_IsValid() {
        try {
            employee.setSuperRate(-5.2);
        } catch (PaySlipCalculatorException ex) {
            assertEquals("Super rate must be a positive", ex.getMessage());
        }
    }

}
