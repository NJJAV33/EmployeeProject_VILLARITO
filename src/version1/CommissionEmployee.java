/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee;

/**
 *
 * @author User
 */
public class CommissionEmployee {
    private int empID;
    private String empName;
    private double totalSale;

    public CommissionEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, String empName, double totalSale) {
        this.empID = empID;
        this.empName = empName;
        setTotalSale(totalSale);
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        if (totalSale >= 0) {
            this.totalSale = totalSale;
        } else {
            this.totalSale = 0.0;
        }
    }

    public double getCommissionRate() {
        if (totalSale < 50000) {
            return 0.05;
        } else if (totalSale < 100000) {
            return 0.10;
        } else if (totalSale < 500000) {
            return 0.15;
        } else {
            return 0.20;
        }
    }

    public double computeSalary() {
        return totalSale * getCommissionRate();
    }

    public void displayCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | Total Sales: PHP%.2f%n", 
            empID, empName, totalSale);
    }

    @Override
    public String toString() {
        double ratePercent = getCommissionRate() * 100;
        return String.format("CommissionEmployee [ID: %d, Name: %s, Total Sales: PHP%.2f, Rate: %.0f%%, Total Salary: PHP%.2f]", 
            empID, empName, totalSale, ratePercent, computeSalary());
    }
}
