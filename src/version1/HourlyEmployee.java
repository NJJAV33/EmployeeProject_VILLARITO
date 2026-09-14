/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee;

/**
 *
 * @author User
 */

//empID: int
//empName: String
//totalHoursWorked: float
//ratePerHour: double

public class HourlyEmployee {
    private int empID;
    private String empName;
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalHoursWorked = 0.0f;
        this.ratePerHour = 0.0;
    }

    public HourlyEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = 0.0f;
        this.ratePerHour = 0.0;
    }

    public HourlyEmployee(int empID, String empName, float totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public int getEmpID() {
        return empID;
    }

    public String getEmpName() {
        return empName;
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked >= 0) {
            this.totalHoursWorked = totalHoursWorked;
        } else {
            this.totalHoursWorked = 0.0f;
        }
    }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour >= 0) {
            this.ratePerHour = ratePerHour;
        } else {
            this.ratePerHour = 0.0;
        }
    }
    
    public double computeSalary() {
        double regularPay;
        double overtimePay = 0.0;
        
        if (totalHoursWorked <= 40) {
            regularPay = totalHoursWorked * ratePerHour;
        } else {
            regularPay = 40 * ratePerHour;
            overtimePay = (totalHoursWorked - 40) * (ratePerHour * 1.5);
        }
        return regularPay + overtimePay;
    }

    public void displayHourlyEmployee() {
        System.out.printf("ID: %d | Name: %s | Hours: %.2f | Rate: PHP%.2f/hr%n", 
            empID, empName, totalHoursWorked, ratePerHour);
    }

    @Override
    public String toString() {
        return String.format("HourlyEmployee [ID: %d, Name: %s, Hours: %.2f, Rate: PHP%.2f, Total Salary: PHP%.2f]", 
            empID, empName, totalHoursWorked, ratePerHour, computeSalary());
    }
    
    
    
    
}
