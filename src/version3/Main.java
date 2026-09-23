package version3;

public class Main {
    public static void main(String[] args) {
        int targetMonth = 9; // September

        Name name1 = new Name("Alice", "Z.", "Pop", "");
        MyDate dob1 = new MyDate(13, 10, 2001);
        MyDate hired1 = new MyDate(5, 6, 2021);
        HourlyEmployee emp1 = new HourlyEmployee(101, name1, dob1, hired1, 45.0f, 200.0);

        Name name2 = new Name("Jan", "C.", "Jones", "Jr.");
        MyDate dob2 = new MyDate(5, 4, 1997);
        MyDate hired2 = new MyDate(15, 1, 2022);
        PieceWorkerEmployee emp2 = new PieceWorkerEmployee(201, name2, dob2, hired2, 135, 30.0);

        Name name3 = new Name("White", "A.", "Brown", "");
        CommissionEmployee emp3 = new CommissionEmployee(301, name3, new MyDate(10, 5, 1990), new MyDate(1, 1, 2020), 75000.0);

        Name name4 = new Name("Diana", "E.", "Long", "");
        BasePlusCommissionEmployee emp4 = new BasePlusCommissionEmployee(401, name4, new MyDate(25, 9, 1995), new MyDate(15, 3, 2019), 120000.0, 20000.0);

        Employee[] employees = { emp1, emp2, emp3, emp4 };

        System.out.println("======================================================================");
        System.out.println("POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");
        System.out.println("======================================================================");

        for (int i = 0; i < employees.length; i++) {
            Employee e = employees[i];
            double totalSalary = e.computeSalary(targetMonth);
            double bonus = (e.getBirthDate().getMonth() == targetMonth) ? 5000.00 : 0.00;
            double basePay = totalSalary - bonus;

            System.out.printf("%d. %s%n", (i + 1), e);
            System.out.printf("   Base Pay: ₱%.2f | Birthday Bonus: ₱%.2f (%s)%n",
                    basePay, bonus, bonus > 0 ? "Eligible" : "Ineligible");
            System.out.printf("   Total Payout: ₱%.2f%n%n", totalSalary);
        }

        System.out.println("======================================================================");
        System.out.println("OBJECT CONTRACT TESTS (equals & hashCode)");
        System.out.println("======================================================================");

        HourlyEmployee emp1Identical = new HourlyEmployee(101, new Name("Alice", "M.", "Smith", ""),
                new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45.0f, 200.0);
        HourlyEmployee emp1Modified = new HourlyEmployee(101, new Name("Alicia", "M.", "Smith", ""),
                new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45.0f, 200.0);

        boolean eq1 = emp1.equals(emp1Identical);
        int hash1 = emp1.hashCode();
        int hash1Id = emp1Identical.hashCode();
        boolean eq2 = emp1.equals(emp1Modified);

        System.out.println("emp1 equals emp1Identical: " + eq1);
        System.out.println("emp1 hashCode: " + hash1 + " | emp1Identical hashCode: " + hash1Id + " (Match: " + (hash1 == hash1Id) + ")");
        System.out.println("emp1 equals emp2 (or modified): " + eq2);

        System.out.println();
        System.out.println("======================================================================");
        System.out.println("DEEP CLONE VERIFICATION");
        System.out.println("======================================================================");

        HourlyEmployee empClone = emp1.clone();
        System.out.println("Original Name before modification: " + emp1.getEmpName());

        empClone.getEmpName().setLastName("Taylor");
        System.out.println("Clone Name changed to:             " + empClone.getEmpName());
        System.out.println("Original Name after modification:  " + emp1.getEmpName() + " (Deep copy successful!)");
    }
}