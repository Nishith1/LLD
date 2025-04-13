package entities;

public class Move {
    private Position from;
    private Position to;
    private Piece movedPiece;
    private Piece capturedPiece;

    public Move(Position from, Position to, Piece moved, Piece captured) {
        this.from = from;
        this.to = to;
        this.movedPiece = moved;
        this.capturedPiece = captured;
    }
}
