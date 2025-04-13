package entities;

public class Board {
    private Cell[][] grid = new Cell[8][8];

    public Board() {
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                grid[i][j] = new Cell(i, j);
    }

    public void initialize() {
        // Place all chess pieces (Rooks, Pawns, etc.)
    }

    public Piece getPieceAt(Position pos) {
        return grid[pos.getX()][pos.getY()].getPiece();
    }

    public void movePiece(Position from, Position to) {
        Piece moving = getPieceAt(from);
        grid[to.getX()][to.getY()].setPiece(moving);
        grid[from.getX()][from.getY()].setPiece(null);
    }
}
