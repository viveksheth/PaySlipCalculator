package com.payslipcalc;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class OutputFileWriterTest extends TestCase {

    private OutputFileWriter outputFileWriter;

    @Before
    public void setUp(){

        outputFileWriter = new OutputFileWriter();
    }

    @Test
    public void testWriteDataToFile() throws PaySlipCalculatorException {

        Employee employeeOne = mock(Employee.class);
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(employeeOne);
        outputFileWriter.writeToFile("output.txt",employees);
    }
}
