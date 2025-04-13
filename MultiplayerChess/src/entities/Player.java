package entities;

import entities.enums.Color;

public class Player {
    private String playerId;
    private String name;
    private Color color;
    private boolean isTurn;

    public Player(String playerId, String name) {
        this.playerId = playerId;
        this.name = name;
    }

    // Getters & Setters
}
