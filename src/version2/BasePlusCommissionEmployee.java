/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version2;

/**
 *
 * @author User
 */
public class BasePlusCommissionEmployee {
    private int empID;
    private Name empName;
    private MyDate dateHired;
    private MyDate birthdate;
    private double totalSale;
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.dateHired = new MyDate();
        this.birthdate = new MyDate();
        this.totalSale = 0.0;
        this.baseSalary = 0.0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName) {
        this.empID = empID;
        this.empName = empName;
        this.dateHired = new MyDate();
        this.birthdate = new MyDate();
        this.totalSale = 0.0;
        this.baseSalary = 0.0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate dateHired, MyDate birthdate) {
        this.empID = empID;
        this.empName = empName;
        this.dateHired = dateHired;
        this.birthdate = birthdate;
        this.totalSale = 0.0;
        this.baseSalary = 0.0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate dateHired, MyDate birthdate, double totalSale, double baseSalary) {
        this.empID = empID;
        this.empName = empName;
        this.dateHired = dateHired;
        this.birthdate = birthdate;
        setTotalSale(totalSale);
        setBaseSalary(baseSalary);
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

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
        } else {
            this.baseSalary = 0.0;
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

    public double computeSalary() {
        double salary = baseSalary + (totalSale * getCommissionRate());

        if (birthdate != null) {
            java.time.LocalDate today = java.time.LocalDate.now();
            int currentMonth = today.getMonthValue();

            if (birthdate.getMonth() == currentMonth) {
                salary += 5000.00;
            }
        }
        return salary;
    }

    public void displayBasePlusCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | Birthdate: %s | Date Hired: %s | Total Sales: PHP%.2f | Base Salary: PHP%.2f%n",
            empID, empName, birthdate, dateHired, totalSale, baseSalary);
    }

    @Override
    public String toString() {
        double ratePercent = getCommissionRate() * 100;
        return String.format("BasePlusCommissionEmployee [ID: %d, Name: %s, Birthdate: %s, Date Hired: %s, Sales: PHP%.2f, Base Salary: PHP%.2f, Rate: %.0f%%, Total Salary: PHP%.2f]",
            empID, empName, birthdate, dateHired, totalSale, baseSalary, ratePercent, computeSalary());
    }
}
