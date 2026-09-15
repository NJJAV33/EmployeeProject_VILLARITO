/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version2;

/**
 *
 * @author User
 */
public class CommissionEmployee {
    private int empID;
    private Name empName;
    private MyDate dateHired;
    private MyDate birthdate;
    private double totalSale;

    public CommissionEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.dateHired = new MyDate();
        this.birthdate = new MyDate();
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, Name empName) {
        this.empID = empID;
        this.empName = empName;
        this.dateHired = new MyDate();
        this.birthdate = new MyDate();
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, Name empName, double totalSale) {
        this.empID = empID;
        this.empName = empName;
        this.dateHired = new MyDate();
        this.birthdate = new MyDate();
        setTotalSale(totalSale);
    }

    public CommissionEmployee(int empID, Name empName, MyDate dateHired, MyDate birthdate, double totalSale) {
        this.empID = empID;
        this.empName = empName;
        this.dateHired = dateHired;
        this.birthdate = birthdate;
        setTotalSale(totalSale);
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public void setEmpName(Name empName) {
        this.empName = empName;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public MyDate getBirthdate() {
        return birthdate;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
    }

    public void setBirthdate(MyDate birthdate) {
        this.birthdate = birthdate;
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
        double salary = totalSale * getCommissionRate();
        if (birthdate != null) {
            java.time.LocalDate today = java.time.LocalDate.now();
            int currentMonth = today.getMonthValue();

            if (birthdate.getMonth() == currentMonth) {
                salary += 5000.00;
            }
        }
        return salary;
    }

    public void displayCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | Birthdate: %s | Date Hired: %s | Total Sales: PHP%.2f%n",
            empID, empName, birthdate, dateHired, totalSale);
    }

    @Override
    public String toString() {
        double ratePercent = getCommissionRate() * 100;
        return String.format("CommissionEmployee [ID: %d, Name: %s, Birthdate: %s, Date Hired: %s, Total Sales: PHP%.2f, Rate: %.0f%%, Total Salary: PHP%.2f]",
            empID, empName, birthdate, dateHired, totalSale, ratePercent, computeSalary());
    }
}
