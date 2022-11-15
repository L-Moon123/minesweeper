package org.example;
import java.util.Random;

public class Grid {
    Square[][] structure;
    int[][] mine_coords = new int[2][5];

    public Grid() {
        //create grid with squares and store their coords
        structure = new Square[10][10];
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                structure[row][col] = new Square();
                structure[row][col].setX_coord(row);
                structure[row][col].setY_coord(col);
            }
        }



        //create coords for mines to be deployed
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                mine_coords[i][j] = rand.nextInt(11);
            }
        }

        //deploy the mines
        int x_coord = 0;
        int y_coord = 0;
        for (int i = 0; i < mine_coords.length; i++) {
            for (int j = 0; j < mine_coords[i].length; j++) {
                if (j != 1) {
                    x_coord = mine_coords[i][j];
                }
                else {
                    y_coord = mine_coords[i][j];
                }

            structure[x_coord][y_coord].setMined(true);

            }
        }

        //create proximity values for squares
        int adj_mines = 0;
        for (int i = 0; i < structure.length; i++) {
            for (int j = 0; j < structure[i].length; j++) {
                try {
                    if (structure[i][j].getMined()) {

                    }

                    if (structure[i][j - 1].getMined()) {
                        adj_mines += 1;
                    }

                    if (structure[i][j + 1].getMined()) {
                        adj_mines += 1;

                    }

                    if (structure[i - 1][j].getMined()) {
                        adj_mines += 1;

                    }

                    if (structure[i + 1][j].getMined()) {
                        adj_mines += 1;

                    }

                    if (structure[i - 1][j - 1].getMined()) {
                        adj_mines += 1;

                    }

                    if (structure[i - 1][j + 1].getMined()) {
                        adj_mines += 1;

                    }

                    if (structure[i + 1][j - 1].getMined()) {
                        adj_mines += 1;

                    }

                    if (structure[i + 1][j + 1].getMined()) {
                        adj_mines += 1;

                    }

                    structure[i][j].setAdjMines(adj_mines);
                } catch (ArrayIndexOutOfBoundsException e) {


                }
            }
        }


    }
}
