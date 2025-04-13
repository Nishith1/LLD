package entities;

import entities.enums.Color;

public class Rook extends Piece {
    public Rook(Color color) { super(color); }

    @Override
    public boolean isValidMove(Board board, Position from, Position to) {
        return from.getX() == to.getX() || from.getY() == to.getY();
    }
}

/// Similar implementations would follow for:
//
//Pawn
//
//Bishop
//
//Queen
//
//Knight
//
//King


