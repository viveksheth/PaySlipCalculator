package com.payslipcalc;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InputFileReaderTest extends TestCase {

    InputFileReader inputFileReader;

    @Before
    public void setUp(){
        inputFileReader = new InputFileReader();
    }

    public void test_isInputFile_InValid(){
        try{
            inputFileReader.readFile("test.txt");
        }catch(PaySlipCalculatorException ex){
            assertEquals("File 'test.txt' not found",ex.getMessage());
        }
    }

    @Test
    public void test_fromPercentageStringToDouble_Invalid(){
        try {
            double value = inputFileReader.fromPercentageStringToDouble("10");
        }catch(PaySlipCalculatorException ex){
            assertEquals("value must have %",ex.getMessage());
        }
    }

    @Test
    public void testFromPercentageToDoubleWithValidValue(){
        try {
            double value = inputFileReader.fromPercentageStringToDouble("10%");
            assertEquals(0.1, value);
        }catch(PaySlipCalculatorException ex){

        }
    }

    @Test
    public void testReadFromValidFile(){

        try{
            List<Employee> employees = inputFileReader.readFile("input.txt");
            assertEquals(2, employees.size());

            Employee employeeOne = employees.get(0);
            assertEquals("David",employeeOne.getFirstName());
            assertEquals("Rudd",employeeOne.getLastName());
            assertEquals("01 March – 31 March",employeeOne.getPaymentStartDate());
            assertEquals(60050,employeeOne.getAnnualSalary());
            assertEquals(0.09,employeeOne.getSuperRate());

            Employee employeeTwo = employees.get(1);
            assertEquals("Ryan",employeeTwo.getFirstName());
            assertEquals("Chen",employeeTwo.getLastName());
            assertEquals("01 March – 31 March",employeeTwo.getPaymentStartDate());
            assertEquals(120000,employeeTwo.getAnnualSalary());
            assertEquals(0.1,employeeTwo.getSuperRate());

        }catch(PaySlipCalculatorException ex){

            System.out.println(ex.getMessage());
        }
    }
}
