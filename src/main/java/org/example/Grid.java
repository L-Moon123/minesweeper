package org.example;
import java.util.Random;

public class Grid {
    Square[][] structure;
    int[][] mine_coords = new int[2][5];

    public Grid() {
        //create grid with squares
        structure = new Square[10][10];
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                structure[row][col] = new Square();
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
            for (int j=0; j<mine_coords[i].length; j++) {
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
        for (int i = 0; i < structure.length; i++) {
            for (int j = 0; j < structure[i].length; j++) {
                if (structure[i][j].getMined() == true) {

                }
                else if () {

                }

                structure[x_coord][y_coord].setMined(true);

            }
        }


    }
}
