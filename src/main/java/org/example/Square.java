package org.example;

public class Square {
    boolean mined;
    int proximity;
    boolean uncovered;
    boolean flagged;

    public Square(boolean m, int prox, boolean unc, boolean fl) {
        this.mined = m;
        this.proximity = prox;
        this.uncovered = unc;
        this.flagged = fl;

    }

    // Getter methods
    public boolean getMined() {
        return this.mined;
    }
    public int getProximity() {
        return this.proximity;
    }
    public boolean getUncovered() {
        return this.uncovered;
    }

    public boolean isFlagged() {
        return this.flagged;
    }
}
