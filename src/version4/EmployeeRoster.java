package version4;

public class EmployeeRoster {
    private Employee[] empList;
    private int max;
    private int count;

    public EmployeeRoster() {
        this(10);
    }

    public EmployeeRoster(int max) {
        this.max = max > 0 ? max : 10;
        this.empList = new Employee[this.max];
        this.count = 0;
    }

    public int getCount() { return count; }
    public int getMax() { return max; }

    public boolean addEmployee(Employee emp) {
        if (emp == null || count >= max) {
            return false;
        }
        empList[count++] = emp;
        return true;
    }

    public Employee removeEmployee(int empID) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (empList[i].getEmpID() == empID) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return null;
        }

        Employee removed = empList[index];

        // Shift elements left to compact array
        for (int i = index; i < count - 1; i++) {
            empList[i] = empList[i + 1];
        }
        empList[count - 1] = null;
        count--;

        return removed;
    }

    public Employee searchEmployee(int empID) {
        for (int i = 0; i < count; i++) {
            if (empList[i].getEmpID() == empID) {
                return empList[i];
            }
        }
        return null;
    }

    public int countHE() {
        int c = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) c++;
        }
        return c;
    }

    public int countPWE() {
        int c = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) c++;
        }
        return c;
    }

    public int countCE() {
        int c = 0;
        for (int i = 0; i < count; i++) {
            // Strictly CommissionEmployee (excludes BasePlusCommissionEmployee)
            if (empList[i] != null && empList[i].getClass() == CommissionEmployee.class) {
                c++;
            }
        }
        return c;
    }

    public int countBPCE() {
        int c = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) c++;
        }
        return c;
    }

    public void displayHE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) {
                ((HourlyEmployee) empList[i]).displayHourlyEmployee();
            }
        }
    }

    public void displayPWE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) {
                ((PieceWorkerEmployee) empList[i]).displayPieceWorkerEmployee();
            }
        }
    }

    public void displayCE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] != null && empList[i].getClass() == CommissionEmployee.class) {
                ((CommissionEmployee) empList[i]).displayCommissionEmployee();
            }
        }
    }

    public void displayBPCE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) {
                ((BasePlusCommissionEmployee) empList[i]).displayBasePlusCommissionEmployee();
            }
        }
    }

    public void displayAllEmployees() {
        for (int i = 0; i < count; i++) {
            Employee e = empList[i];
            System.out.printf("%d. ID: %d | Name: %-18s | Type: %s%n",
                    (i + 1), e.getEmpID(), e.getEmpName(), e.getClass().getSimpleName());
        }
    }

    public void displayPayroll(int currentMonth) {
        for (int i = 0; i < count; i++) {
            Employee e = empList[i];
            double salary = 0.0;
            String typeLabel = "";
            boolean isBirthday = false;

            if (e instanceof HourlyEmployee) {
                HourlyEmployee he = (HourlyEmployee) e;
                salary = he.computeSalary(currentMonth);
                typeLabel = "Hourly";
                isBirthday = he.getBirthDate().getMonth() == currentMonth;
            } else if (e instanceof PieceWorkerEmployee) {
                PieceWorkerEmployee pwe = (PieceWorkerEmployee) e;
                salary = pwe.computeSalary(currentMonth);
                typeLabel = "Piece Worker";
                isBirthday = pwe.getBirthDate().getMonth() == currentMonth;
            } else if (e instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee bpce = (BasePlusCommissionEmployee) e;
                salary = bpce.computeSalary(currentMonth);
                typeLabel = "Base Plus Commission";
                isBirthday = bpce.getBirthDate().getMonth() == currentMonth;
            } else if (e instanceof CommissionEmployee) {
                CommissionEmployee ce = (CommissionEmployee) e;
                salary = ce.computeSalary(currentMonth);
                typeLabel = "Commission";
                isBirthday = ce.getBirthDate().getMonth() == currentMonth;
            }

            String bonusText = isBirthday ? " (Birthday Bonus Applied)" : "";
            System.out.printf("[%s] ID: %d | Name: %s | Salary: ₱%,.2f%s%n",
                    typeLabel, e.getEmpID(), e.getEmpName(), salary, bonusText);
        }
    }
}