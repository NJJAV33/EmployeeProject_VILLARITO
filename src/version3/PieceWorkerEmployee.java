package version3;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        super();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0.0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                               int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public int getTotalPiecesFinished() { return totalPiecesFinished; }
    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = totalPiecesFinished >= 0 ? totalPiecesFinished : 0;
    }

    public double getRatePerPiece() { return ratePerPiece; }
    public void setRatePerPiece(double ratePerPiece) {
        this.ratePerPiece = ratePerPiece >= 0 ? ratePerPiece : 0.0;
    }

    @Override
    public double computeSalary(int currentMonth) {
        int bonusPieces = totalPiecesFinished / 100;
        double piecePay = (totalPiecesFinished * ratePerPiece) + (bonusPieces * 10 * ratePerPiece);
        return piecePay + super.computeSalary(currentMonth);
    }

    public void displayPieceWorkerEmployee() {
        displayEmployee();
        System.out.printf("Pieces Finished: %d | Rate Per Piece: %.2f%n", totalPiecesFinished, ratePerPiece);
    }

    @Override
    public String toString() {
        return "PieceWorkerEmployee " + super.toString() +
                String.format(" [Pieces: %d, Rate/Piece: ₱%.2f]", totalPiecesFinished, ratePerPiece);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        PieceWorkerEmployee that = (PieceWorkerEmployee) obj;
        return totalPiecesFinished == that.totalPiecesFinished &&
                Double.compare(that.ratePerPiece, ratePerPiece) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalPiecesFinished, ratePerPiece);
    }

    @Override
    public PieceWorkerEmployee clone() {
        return (PieceWorkerEmployee) super.clone();
    }
}