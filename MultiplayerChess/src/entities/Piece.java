package entities;


import entities.enums.Color;

public abstract class Piece {
    private Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() { return color; }

    public abstract boolean isValidMove(Board board, Position from, Position to);
}
