package version4;

public class Main {
    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("EMPLOYEE ROSTER INITIALIZATION & ENROLLMENT");
        System.out.println("======================================================================");

        EmployeeRoster roster = new EmployeeRoster(6);

        HourlyEmployee emp1 = new HourlyEmployee(101, new Name("Carlos", "G.", "Santos", ""), new MyDate(22, 9, 1999), new MyDate(1, 6, 2022), 45.0f, 200.0);
        PieceWorkerEmployee emp2 = new PieceWorkerEmployee(201, new Name("Bea", "T.", "Cruz", ""), new MyDate(14, 2, 2001), new MyDate(10, 5, 2023), 135, 30.0);
        CommissionEmployee emp3 = new CommissionEmployee(301, new Name("Gabriel", "V.", "Villanueva", ""), new MyDate(8, 9, 1988), new MyDate(15, 2, 2021), 80000.0);
        BasePlusCommissionEmployee emp4 = new BasePlusCommissionEmployee(401, new Name("Jasmine", "R.", "Lim", ""), new MyDate(30, 11, 1994), new MyDate(12, 4, 2019), 100000.0, 20000.0);
        HourlyEmployee emp5 = new HourlyEmployee(102, new Name("Lucas", "B.", "Gomez", ""), new MyDate(5, 12, 1996), new MyDate(15, 7, 2022), 40.0f, 200.0);
        HourlyEmployee empExtra = new HourlyEmployee(103, new Name("Zoe", "K.", "Pascual", ""), new MyDate(19, 1, 2002), new MyDate(1, 9, 2024), 10.0f, 150.0);

        System.out.println("Added: " + emp1.getEmpName() + " (Hourly) -> " + (roster.addEmployee(emp1) ? "Success" : "Failed"));
        System.out.println("Added: " + emp2.getEmpName() + " (Piece Worker) -> " + (roster.addEmployee(emp2) ? "Success" : "Failed"));
        System.out.println("Added: " + emp3.getEmpName() + " (Commission) -> " + (roster.addEmployee(emp3) ? "Success" : "Failed"));
        System.out.println("Added: " + emp4.getEmpName() + " (Base Plus Commission) -> " + (roster.addEmployee(emp4) ? "Success" : "Failed"));
        System.out.println("Added: " + emp5.getEmpName() + " (Hourly) -> " + (roster.addEmployee(emp5) ? "Success" : "Failed"));

        // Capacity and Boundary Test
        System.out.println("Added: " + empExtra.getEmpName() + " (Hourly) -> " + (roster.addEmployee(empExtra) ? "Success" : "Failed"));

        HourlyEmployee empFull = new HourlyEmployee(104, new Name("Nathaniel", "D.", "Ramos", ""), new MyDate(3, 3, 1990), new MyDate(1, 1, 2024), 10.0f, 100.0);
        System.out.println("Attempting to add beyond capacity (Max: " + roster.getMax() + ") -> " + (roster.addEmployee(empFull) ? "Success" : "Failed (Capacity Reached)"));

        System.out.println();
        System.out.println("--- ROSTER COMPOSITION COUNTS ---");
        System.out.println("Total Employees: " + roster.getCount() + " / " + roster.getMax());
        System.out.println("Hourly Employees: " + roster.countHE());
        System.out.println("Piece Worker Employees: " + roster.countPWE());
        System.out.println("Commission Employees (Pure): " + roster.countCE());
        System.out.println("Base Plus Commission Employees: " + roster.countBPCE());

        System.out.println();
        System.out.println("======================================================================");
        System.out.println("ROSTER PAYROLL REPORT (Target Month: Sep)");
        System.out.println("======================================================================");
        roster.displayPayroll(9);

        System.out.println();
        System.out.println("======================================================================");
        System.out.println("TESTING EMPLOYEE REMOVAL & ARRAY COMPACTION");
        System.out.println("======================================================================");
        System.out.println("Removing Employee ID 201 (Cruz, Bea T.)... " + (roster.removeEmployee(201) != null ? "Successfully removed." : "Not found."));
        System.out.println("Current Employee Count: " + roster.getCount());

        System.out.println();
        System.out.println("Remaining Employees in Roster:");
        roster.displayAllEmployees();
        System.out.println("======================================================================");
    }
}