/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package version1;

/**
 *
 * @author User
 */
public class Employee {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("--- Hourly Employee Test ---");

        HourlyEmployee hourly1 =
                new HourlyEmployee(101, "Alice");

        hourly1.setTotalHoursWorked(45.0f);
        hourly1.setRatePerHour(200.00);

        HourlyEmployee hourly2 =
                new HourlyEmployee(102, "Brown", 38.0f, 255.00);

        System.out.println("[displayHourlyEmployee()]");
        hourly1.displayHourlyEmployee();
        hourly2.displayHourlyEmployee();

        System.out.println("\n[toString()]");
        System.out.println(hourly1);
        System.out.println(hourly2);

        System.out.println("\n--- Piece Worker Employee Test ---");

        PieceWorkerEmployee piece1 =
                new PieceWorkerEmployee(201, "Bob");

        piece1.setTotalPieceFinished(250);
        piece1.setRatePerPiece(15.00);

        PieceWorkerEmployee piece2 =
                new PieceWorkerEmployee(202, "Bobina", 0, 23.00);

        System.out.println("[displayPieceWorkerEmployee()]");
        piece1.displayPieceWorkerEmployee();
        piece2.displayPieceWorkerEmployee();

        System.out.println("\n[toString()]");
        System.out.println(piece1);
        System.out.println(piece2);


        System.out.println("\n--- Commission Employee Test ---");

        CommissionEmployee commission1 =
                new CommissionEmployee(301, "Blu");

        commission1.setTotalSale(82000);

        CommissionEmployee commission2 =
                new CommissionEmployee(302, "Brown Jr.", 600000);

        System.out.println("[displayCommissionEmployee()]");
        commission1.displayCommissionEmployee();
        commission2.displayCommissionEmployee();

        System.out.println("\n[toString()]");
        System.out.println(commission1);
        System.out.println(commission2);


        System.out.println("\n--- Base Plus Commission Employee Test ---");

        BasePlusCommissionEmployee basePlus1 =
                new BasePlusCommissionEmployee(401, "George");

        basePlus1.setTotalSale(120000);
        basePlus1.setBaseSalary(15000);

        BasePlusCommissionEmployee basePlus2 =
                new BasePlusCommissionEmployee(
                        402, "Georgina", 30000, 10000
                );

        System.out.println("[displayBasePlusCommissionEmployee()]");
        basePlus1.displayBasePlusCommissionEmployee();
        basePlus2.displayBasePlusCommissionEmployee();

        System.out.println("\n[toString()]");
        System.out.println(basePlus1);
        System.out.println(basePlus2);
    }
}
    

