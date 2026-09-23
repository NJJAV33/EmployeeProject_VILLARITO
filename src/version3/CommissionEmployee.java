package version3;

import java.util.Objects;

public class CommissionEmployee extends Employee {
    private double totalSale;

    public CommissionEmployee() {
        super();
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale) {
        super(empID, empName, birthDate, dateHired);
        setTotalSale(totalSale);
    }

    public double getTotalSale() { return totalSale; }
    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale >= 0 ? totalSale : 0.0;
    }

    public double getCommissionRate() {
        if (totalSale < 50000.0) {
            return 0.05;
        } else if (totalSale < 100000.0) {
            return 0.10;
        } else if (totalSale < 500000.0) {
            return 0.15;
        } else {
            return 0.20;
        }
    }

    @Override
    public double computeSalary(int currentMonth) {
        double commission = totalSale * getCommissionRate();
        return commission + super.computeSalary(currentMonth);
    }

    public void displayCommissionEmployee() {
        displayEmployee();
        System.out.printf("Total Sales: %.2f | Commission Rate: %.0f%%%n", totalSale, getCommissionRate() * 100);
    }

    @Override
    public String toString() {
        return "CommissionEmployee " + super.toString() +
                String.format(" [Sales: ₱%.2f, Rate: %.0f%%]", totalSale, getCommissionRate() * 100);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        CommissionEmployee that = (CommissionEmployee) obj;
        return Double.compare(that.totalSale, totalSale) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalSale);
    }

    @Override
    public CommissionEmployee clone() {
        return (CommissionEmployee) super.clone();
    }
}