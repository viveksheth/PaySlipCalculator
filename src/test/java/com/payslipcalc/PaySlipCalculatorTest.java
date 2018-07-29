package com.payslipcalc;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PaySlipCalculatorTest extends TestCase {

    private PaySlipCalculator paySlipCalculator;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @Before
    public void setUp(){
        paySlipCalculator = new PaySlipCalculator();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void test_InValidArguments(){

        String[] args = {"input.txt"};
        PaySlipCalculator.main(args);
        assertEquals(outContent.toString(), "Command:java -jar target/PaySlipCalculator-1.0-SNAPSHOT.jar <input file> <output file>");

    }
}
