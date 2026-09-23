package version3;

import java.util.Objects;

public class Employee implements Cloneable {
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;

    public Employee() {
        this(0, new Name(), new MyDate(), new MyDate());
    }

    public Employee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        this.empName = empName != null ? empName.clone() : new Name();
        this.birthDate = birthDate != null ? birthDate.clone() : new MyDate();
        this.dateHired = dateHired != null ? dateHired.clone() : new MyDate();
    }

    public int getEmpID() { return empID; }
    public void setEmpID(int empID) { this.empID = empID; }

    public Name getEmpName() { return empName; }
    public void setEmpName(Name empName) {
        this.empName = empName != null ? empName.clone() : new Name();
    }

    public MyDate getBirthDate() { return birthDate; }
    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate != null ? birthDate.clone() : new MyDate();
    }

    public MyDate getDateHired() { return dateHired; }
    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired != null ? dateHired.clone() : new MyDate();
    }

    public double computeSalary(int currentMonth) {
        double bonus = 0.0;
        if (birthDate != null && birthDate.getMonth() == currentMonth) {
            bonus = 5000.00;
        }
        return bonus;
    }

    public double computeSalary() {
        return computeSalary(-1);
    }

    public void displayEmployee() {
        System.out.println("ID: " + empID + ", Name: " + empName +
                ", DOB: " + birthDate + ", Hired: " + dateHired);
    }

    @Override
    public String toString() {
        return String.format("[ID: %d, Name: %s, DOB: %s, Hired: %s]",
                empID, empName, birthDate, dateHired);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return empID == employee.empID &&
                Objects.equals(empName, employee.empName) &&
                Objects.equals(birthDate, employee.birthDate) &&
                Objects.equals(dateHired, employee.dateHired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empID, empName, birthDate, dateHired);
    }

    @Override
    public Employee clone() {
        try {
            Employee cloned = (Employee) super.clone();
            cloned.empName = (this.empName != null) ? this.empName.clone() : null;
            cloned.birthDate = (this.birthDate != null) ? this.birthDate.clone() : null;
            cloned.dateHired = (this.dateHired != null) ? this.dateHired.clone() : null;
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}