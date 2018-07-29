package com.payslipcalc;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputFileWriter {

    public boolean writeToFile(String fileName, List<Employee> employees) throws PaySlipCalculatorException {
        try
        {
            FileWriter fileWriter = new FileWriter(fileName);

            for (Employee employee : employees) {
                fileWriter.append(      employee.getFirstName()+" "+
                                        employee.getLastName()+","+
                                        employee.getPaymentStartDate()+","+
                                        employee.grossIncome()+","+
                                        employee.getIncomeTax()+","+
                                        employee.getNetIncome()+","+
                                        employee.getSuperAmount()
                                );
                fileWriter.append("\n");
            }
            fileWriter.flush();
            fileWriter.close();

        }catch (IOException e) {
            throw new PaySlipCalculatorException("Unable to write to file");
        }
        return true;
    }
}
