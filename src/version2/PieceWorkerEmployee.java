/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version2;

/**
 *
 * @author User
 */
public class PieceWorkerEmployee {
    private int empID;
    private Name empName;
    private MyDate dateHired;
    private MyDate birthdate;
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.dateHired = new MyDate();
        this.birthdate = new MyDate();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0.0;
        
    }

    public PieceWorkerEmployee(int empID, Name empName) {
        this.empID = empID;
        this.empName = empName;
        this.dateHired = dateHired;
        this.birthdate = birthdate;
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0.0;
    }

    public PieceWorkerEmployee(int empID, Name empName, int totalPieceFinished, double ratePerPiece) {
        this.empID = empID;
        this.empName = empName;
        this.dateHired = dateHired;
        this.birthdate = birthdate;
        setTotalPieceFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate dateHired, MyDate birthdate, int totalPiecesFinished, double ratePerPiece) {
        this.empID = empID;
        this.empName = empName;
        this.dateHired = dateHired;
        this.birthdate = birthdate;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
    }

    public int getEmpID() {
        return empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public void setEmpName(Name empName) {
        this.empName = empName;
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

    public void setTotalPieceFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public void setRatePerPiece(double ratePerPiece) {
        this.ratePerPiece = ratePerPiece;
    }
    
    public double computeSalary() {
        double basePay = totalPiecesFinished * ratePerPiece;
        int bonusHundreds = totalPiecesFinished / 100;
        double bonusPay = bonusHundreds * (10 * ratePerPiece);

        double salary = basePay + bonusPay;
        if (birthdate != null) {
            java.time.LocalDate today = java.time.LocalDate.now();
            int currentMonth = today.getMonthValue();

            if (birthdate.getMonth() == currentMonth) {
                salary += 5000.00;
            }
        }
        return salary;
    }

    public void displayPieceWorkerEmployee() {
        System.out.printf("ID: %d | Name: %s | Birthdate: %s | Date Hired: %s | Pieces Finished: %d | Rate/Piece: PHP%.2f%n",
            empID, empName, birthdate, dateHired, totalPiecesFinished, ratePerPiece);
    }

    @Override
    public String toString() {
        return String.format("PieceWorkerEmployee [ID: %d, Name: %s, Birthdate: %s, Date Hired: %s, Pieces: %d, Rate: PHP%.2f, Total Salary: PHP%.2f]",
            empID, empName, birthdate, dateHired, totalPiecesFinished, ratePerPiece, computeSalary());
    }
}
