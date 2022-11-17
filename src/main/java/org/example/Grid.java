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
                structure[col][row] = new Square();
                structure[col][row].setX_coord(col);
                structure[col][row].setY_coord(row);
            }
        }



        //create coords for mines to be deployed
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                mine_coords[j][i] = rand.nextInt(11);
            }
        }

        //deploy the mines
        int x_coord = 0;
        int y_coord = 0;
        for (int i = 0; i < mine_coords.length - 1; i++) {
            for (int j = 0; j < mine_coords[i].length - 1; j++) {
                if (j != 1) {
                }
                else {
                    x_coord = mine_coords[j][i];
                }
            structure[y_coord][x_coord].setMined(true);

            }
        }

        //create proximity values for squares
        int adj_mines = 0;
        for (int i = 0; i < structure.length - 1; i++) {
            for (int j = 0; j < structure[i].length - 1; j++) {
                try {
                    if (structure[i][j].isMined()) {

                    }

                    if (structure[i][j - 1].isMined()) {
                        adj_mines += 1;
                    }

                    if (structure[i][j + 1].isMined()) {
                        adj_mines += 1;

                    }

                    if (structure[i - 1][j].isMined()) {
                        adj_mines += 1;

                    }

                    if (structure[i + 1][j].isMined()) {
                        adj_mines += 1;

                    }

                    if (structure[i - 1][j - 1].isMined()) {
                        adj_mines += 1;

                    }

                    if (structure[i - 1][j + 1].isMined()) {
                        adj_mines += 1;

                    }

                    if (structure[i + 1][j - 1].isMined()) {
                        adj_mines += 1;

                    }

                    if (structure[i + 1][j + 1].isMined()) {
                        adj_mines += 1;

                    }

                    structure[i][j].setAdjMines(adj_mines);

                } catch (ArrayIndexOutOfBoundsException e) {


                }
            }
        }


    }
}
