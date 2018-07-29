package com.payslipcalc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputFileReader {

    public List<Employee> readFile(String inputFile) throws PaySlipCalculatorException {

        BufferedReader br=null;
        String line="";
        List<Employee> employees = new ArrayList<Employee>();

        try {
            br = new BufferedReader(new FileReader(inputFile));

            while ((line = br.readLine()) != null) {
                String[] employeeDetails = line.split(",");

                Employee employee = new Employee();
                employee.setFirstName(employeeDetails[0]);
                employee.setLastName(employeeDetails[1]);
                employee.setAnnualSalary(Long.parseLong(employeeDetails[2]));
                employee.setSuperRate(fromPercentageStringToDouble(employeeDetails[3]));
                employee.setPaymentStartDate(employeeDetails[4]);

                employees.add(employee);
            }

        }catch(FileNotFoundException ex) {
            throw new PaySlipCalculatorException("File '" + inputFile + "' not found");
        }catch(Exception ex){
            throw new PaySlipCalculatorException("Unable to read from file");
        }finally{
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return employees;
    }

    public double fromPercentageStringToDouble(String value) throws PaySlipCalculatorException{
        if(!value.endsWith("%")) {
            throw new PaySlipCalculatorException("value must have %");
        }

        return Double.parseDouble(value.substring(0, value.length() - 1)) / 100;
    }
}
