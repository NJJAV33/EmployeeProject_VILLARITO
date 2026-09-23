package version5;

public class Main {
    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("DYNAMIC ROSTER INITIALIZATION (ArrayList Backend)");
        System.out.println("======================================================================");

        EmployeeRoster roster = new EmployeeRoster();

        HourlyEmployee emp1 = new HourlyEmployee(101, new Name("Rafael", "E.", "Torres", ""), new MyDate(14, 9, 1995), new MyDate(5, 1, 2023), 42.0f, 250.0);
        PieceWorkerEmployee emp2 = new PieceWorkerEmployee(201, new Name("Katrina", "O.", "Dizon", ""), new MyDate(20, 3, 1999), new MyDate(12, 8, 2022), 150, 35.0);
        CommissionEmployee emp3 = new CommissionEmployee(301, new Name("Emmanuel", "P.", "Aquino", "Jr."), new MyDate(7, 9, 1991), new MyDate(1, 10, 2020), 120000.0);
        BasePlusCommissionEmployee emp4 = new BasePlusCommissionEmployee(401, new Name("Rowena", "C.", "Gomez", ""), new MyDate(22, 11, 1996), new MyDate(18, 4, 2017), 80000.0, 25000.0);

        roster.addEmployee(emp1);
        System.out.println("Enrolled: " + emp1.getEmpName() + " (Hourly)");

        roster.addEmployee(emp2);
        System.out.println("Enrolled: " + emp2.getEmpName() + " (Piece Worker)");

        roster.addEmployee(emp3);
        System.out.println("Enrolled: " + emp3.getEmpName() + " (Commission)");

        roster.addEmployee(emp4);
        System.out.println("Enrolled: " + emp4.getEmpName() + " (Base Plus Commission)");

        System.out.println("Total Roster Size: " + roster.countEmployees() + " employees");

        System.out.println();
        System.out.println("======================================================================");
        System.out.println("PURE POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");
        System.out.println("[No downcasting; dynamic dispatch via Employee.computeSalary()]");
        System.out.println("======================================================================");
        roster.displayPayroll(9);

        System.out.println();
        System.out.println("======================================================================");
        System.out.println("COLLECTION REMOVAL TEST");
        System.out.println("======================================================================");
        System.out.println("Removing Employee ID 201..." + (roster.removeEmployee(201) != null ? " Successfully removed." : " Not found."));
        System.out.println("Updated Roster Size: " + roster.countEmployees());

        System.out.println();
        System.out.println("Current Active Employees:");
        roster.displayAllEmployees();
        System.out.println("======================================================================");
    }
}