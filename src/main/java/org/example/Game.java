package org.example;
import java.util.Scanner;

public class Game {

    static Square[][] game_grid = new Grid().structure;
    static int[][] visible_grid = new int[10][10];

// !!!!!!!!!!!!!!INCOMPLETE METHOD (this will also render the visible grid)!!!!!!!!!!!!!!!!!!!
    public static int[][] renderGrid() {
        for (int i=0; i < game_grid.length; i++) {
            for (int j=0; j < game_grid[i].length; j++)
            {   if () {

                visible_grid[i][j] = game_grid[i][j].getProximity();
                }
            }
        }

    }

    public static void revealSquare(int x, int y) {
        if (game_grid[x][y].isFlagged()) {
            System.out.println("You can not reveal a flagged square");
            //BELOW METHOD CALL PROB CORRECT BUT CHECK AT TIME
            //renderGrid();
        }

        else if (game_grid[x][y].isMined()) {
            System.out.println("!!!!!!!!!BOOOOOOOOOOOM!!!!!!!!..........you have hit a mine");

            try {
                Scanner scanner;
                String answer;
                System.out.println("Do you want to play another game? Enter y for yes or n for no and press enter");
                scanner = new Scanner(System.in);
                answer = scanner.next().toLowerCase();
                scanner.close();

                if (answer.equals("y")) {
                    game_grid = new Grid().structure;
                    visible_grid = new int[10][10];
                    //BELOW METHOD CALL PROB CORRECT BUT CHECK
                    //renderGrid();
                }

                while (!answer.equals("y") && !answer.equals("n")) {


                    if (answer.equals("y")) {
                        game_grid = new Grid().structure;
                        visible_grid = new int[10][10];
                        //BELOW METHOD CALL PROB CORRECT BUT CHECK
                        //renderGrid();
                    }
                }
            }
        }
        //THIS WILL BE NEEDED SOMEWHERE
        game_grid[i][j].setUncovered(true);

    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}