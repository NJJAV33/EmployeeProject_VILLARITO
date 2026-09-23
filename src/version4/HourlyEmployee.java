package version4;

import java.util.Objects;

public class HourlyEmployee extends Employee {
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        super();
        this.totalHoursWorked = 0.0f;
        this.ratePerHour = 0.0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                          float totalHoursWorked, double ratePerHour) {
        super(empID, empName, birthDate, dateHired);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    public float getTotalHoursWorked() { return totalHoursWorked; }
    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked >= 0 ? totalHoursWorked : 0.0f;
    }

    public double getRatePerHour() { return ratePerHour; }
    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour >= 0 ? ratePerHour : 0.0;
    }

    public double computeSalary(int currentMonth) {
        double regularPay = 0.0;
        double overtimePay = 0.0;
        if (totalHoursWorked <= 40) {
            regularPay = totalHoursWorked * ratePerHour;
        } else {
            regularPay = 40 * ratePerHour;
            overtimePay = (totalHoursWorked - 40) * (ratePerHour * 1.5);
        }
        double bonus = (getBirthDate() != null && getBirthDate().getMonth() == currentMonth) ? 5000.00 : 0.0;
        return regularPay + overtimePay + bonus;
    }

    public void displayHourlyEmployee() {
        displayEmployee();
        System.out.printf("Hours Worked: %.1f | Rate Per Hour: ₱%.2f%n", totalHoursWorked, ratePerHour);
    }

    @Override
    public String toString() {
        return String.format("HourlyEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s] [Hours: %.1f, Rate: ₱%.2f]",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(), totalHoursWorked, ratePerHour);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        HourlyEmployee that = (HourlyEmployee) obj;
        return Float.compare(that.totalHoursWorked, totalHoursWorked) == 0 &&
                Double.compare(that.ratePerHour, ratePerHour) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalHoursWorked, ratePerHour);
    }

    @Override
    public HourlyEmployee clone() {
        return (HourlyEmployee) super.clone();
    }
}