package com.payslipcalc;

import java.util.ArrayList;
import java.util.List;

public class PaySlipCalculator {

    public static void main(String[] args)
    {
        if(args.length < 2){
            System.out.print("Command:java -jar target/PaySlipCalculator-1.0-SNAPSHOT.jar <input file> <output file>");
            return;
        }

        PaySlipCalculator paySlipCalculator = new PaySlipCalculator();
        paySlipCalculator.execute(args[0],args[1]);
    }

    private void execute(String inputFile, String outputFile) {

        InputFileReader reader = new InputFileReader();
        List<Employee> employees = null;
        try
        {
            employees = reader.readFile(inputFile);

            for(Employee employee : employees){

                employee.setIncomeTax((int)calculateEmployeeIncomeTax(employee.getAnnualSalary()));
                employee.setSuperAmount((int)calculateEmployeeSuper(employee.grossIncome(),employee.getSuperRate()));
            }

            OutputFileWriter fileWriter = new OutputFileWriter();
            fileWriter.writeToFile(outputFile,employees);

        }
        catch (PaySlipCalculatorException e) {
            e.printStackTrace();
        }

    }

    private long calculateEmployeeIncomeTax(long annualSalary) throws PaySlipCalculatorException {

        TaxCalculator taxCalculator = new TaxCalculator();
        return  taxCalculator.calculate(annualSalary);
    }

    private double calculateEmployeeSuper(int grossIncome, double superRate){
        return (int)Math.round(grossIncome * superRate);
    }
}
