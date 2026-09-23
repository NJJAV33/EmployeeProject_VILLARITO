package version5;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRoster {
    private List<Employee> empList;

    public EmployeeRoster() {
        this.empList = new ArrayList<>();
    }

    public EmployeeRoster(int initialCapacity) {
        this.empList = new ArrayList<>(initialCapacity);
    }

    public boolean addEmployee(Employee emp) {
        if (emp == null) {
            return false;
        }
        empList.add(emp);
        return true;
    }

    public Employee removeEmployee(int empID) {
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i).getEmpID() == empID) {
                return empList.remove(i);
            }
        }
        return null;
    }

    public Employee searchEmployee(int empID) {
        for (Employee emp : empList) {
            if (emp.getEmpID() == empID) {
                return emp;
            }
        }
        return null;
    }

    public int countEmployees() {
        return empList.size();
    }

    public int countHE() {
        int c = 0;
        for (Employee emp : empList) {
            if (emp instanceof HourlyEmployee) c++;
        }
        return c;
    }

    public int countPWE() {
        int c = 0;
        for (Employee emp : empList) {
            if (emp instanceof PieceWorkerEmployee) c++;
        }
        return c;
    }

    public int countCE() {
        int c = 0;
        for (Employee emp : empList) {
            if (emp != null && emp.getClass() == CommissionEmployee.class) {
                c++;
            }
        }
        return c;
    }

    public int countBPCE() {
        int c = 0;
        for (Employee emp : empList) {
            if (emp instanceof BasePlusCommissionEmployee) c++;
        }
        return c;
    }

    public void displayAllEmployees() {
        int index = 1;
        for (Employee emp : empList) {
            System.out.println(index + ". " + emp);
            index++;
        }
    }

    public void displayPayroll(int currentMonth) {
        for (Employee emp : empList) {
            double salary = emp.computeSalary(currentMonth);
            boolean isBirthday = emp.getBirthDate() != null && emp.getBirthDate().getMonth() == currentMonth;
            String bonusText = isBirthday ? " (Birthday Bonus Applied)" : "";

            System.out.printf("ID: %-5d | Name: %-22s | Payout: ₱%,.2f%s%n",
                    emp.getEmpID(), emp.getEmpName(), salary, bonusText);
        }
    }
}