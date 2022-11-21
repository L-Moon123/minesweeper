package org.example;

public class Square {
    boolean mined;
    boolean uncovered;
    boolean flagged;
    int adjacent_mines;



    public Square() {
        this.mined = false;
        this.uncovered = false;
        this.flagged = false;
        this.adjacent_mines = 0;


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


}
