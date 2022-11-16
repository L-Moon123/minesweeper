package org.example;

public class Square {
    boolean mined;
    boolean uncovered;
    boolean flagged;
    int adjacent_mines;

    int x_coord;
    int y_coord;

    public Square() {
        this.mined = false;
        this.uncovered = false;
        this.flagged = false;
        this.adjacent_mines = 0;
        this.x_coord = 0;
        this.y_coord = 0;

    }

    // Getter methods
    public boolean isMined() {
        return this.mined;
    }

    public boolean isUncovered() {
        return this.uncovered;
    }
    public boolean isFlagged() {
        return this.flagged;
    }
    public int getAdjMines() {
        return this.adjacent_mines;
    }

    public int getX_coord() {
        return this.x_coord;
    }

    public int getY_coord() {
        return this.y_coord;
    }

    // Setter methods
    public void setMined(boolean mined) {
        this.mined = mined;
    }

    public void setUncovered(boolean uncovered) {
        this.uncovered = uncovered;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public void setAdjMines(int adj_mines) {
        this.adjacent_mines = adj_mines;
    }

    public void setX_coord(int x_coord) {
        this.x_coord = x_coord;
    }

    public void setY_coord(int y_coord) {
        this.y_coord = y_coord;
    }
}
