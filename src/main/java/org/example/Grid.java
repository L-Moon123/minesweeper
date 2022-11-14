package org.example;

public class Grid {
    Square[][] structure;

    public Grid() {
        structure = new Square[10][10];

        for (int row=0; row<11; row++) {
            for (int col=0; col<11; col++) {
                structure[row][col] = Square();

            }
        }
    }
}
