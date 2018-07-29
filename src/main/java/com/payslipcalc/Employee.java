package com.payslipcalc;

public class Employee {

    private String firstName;
    private String lastName;
    private double superRate;
    private long annualSalary;
    private String paymentStartDate;

    private int incomeTax;
    private int superAmount;

    public Employee(){}

    public Employee(String firstName, String lastName, long annualSalary, double superRate, String paymentStartDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = annualSalary;
        this.superRate = superRate;
        this.paymentStartDate = paymentStartDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(long annualSalary) throws PaySlipCalculatorException {

        if(annualSalary <0)
            throw new PaySlipCalculatorException("Annual Salary must be a positive");
        else
            this.annualSalary = annualSalary;

    }

    public double getSuperRate() {
        return superRate;
    }

    public void setSuperRate(double superRate) throws PaySlipCalculatorException {

        if(superRate<0 )
            throw new PaySlipCalculatorException("Super rate must be a positive");
        else
            this.superRate = superRate;
    }

    public String getPaymentStartDate() {
        return paymentStartDate;
    }

    public void setPaymentStartDate(String paymentStartDate) {
        this.paymentStartDate = paymentStartDate;
    }

    public int getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(int incomeTax) {
        this.incomeTax = incomeTax;
    }

    public int getSuperAmount() {
        return superAmount;
    }

    public void setSuperAmount(int superAmount) {
        this.superAmount = superAmount;
    }

    public int grossIncome() {

        return Math.round(annualSalary/12);
    }

    public int getNetIncome()
    {
        return grossIncome()-getIncomeTax();
    }
}
