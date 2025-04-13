package entities;

import entities.enums.Color;
import entities.enums.GameStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Game {
    private String gameId;
    private Player whitePlayer;
    private Player blackPlayer;
    private Board board;
    private GameStatus status;
    private Color currentTurn;
    private List<Move> moveHistory;

    public Game(Player white, Player black) {
        this.gameId = UUID.randomUUID().toString();
        this.whitePlayer = white;
        this.blackPlayer = black;
        this.board = new Board();
        this.status = GameStatus.ACTIVE;
        this.currentTurn = Color.WHITE;
        this.moveHistory = new ArrayList<>();
        board.initialize();
    }

    public boolean makeMove(Position from, Position to) {
        if (status != GameStatus.ACTIVE) return false;

        Piece piece = board.getPieceAt(from);
        if (piece == null || piece.getColor() != currentTurn) return false;
        if (!piece.isValidMove(board, from, to)) return false;

        Piece captured = board.getPieceAt(to);
        board.movePiece(from, to);

        moveHistory.add(new Move(from, to, piece, captured));
        toggleTurn();

        // TODO: Check/checkmate/draw detection
        return true;
    }

    private void toggleTurn() {
        currentTurn = (currentTurn == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }
}
