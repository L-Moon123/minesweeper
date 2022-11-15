package org.example;
import java.util.Scanner;

public class Game {

    static Square[][] game_grid = new Grid().structure;
    static int[][] visible_grid = new int[10][10];

// !!!!!!!!!!!!!!INCOMPLETE METHOD (this will also render the visible grid)!!!!!!!!!!!!!!!!!!!
    public static int[][] renderGrid() {
        for (int i=0; i < game_grid.length; i++) {
            for (int j=0; j < game_grid[i].length; j++) {
                if (game_grid[i][j].isUncovered()) {

                    visible_grid[i][j] = game_grid[i][j].getProximity();
                }
            }
        }
        System.out.println(visible_grid);

    }

    public static void revealSquare(int x, int y) {
        if (game_grid[x][y].isFlagged()) {
            System.out.println("You can not reveal a flagged square");
            //BELOW METHOD CALL PROB CORRECT BUT CHECK AT TIME
            //renderGrid();
        }

        else if (game_grid[x][y].isMined()) {
            System.out.println("!!!!!!!!!BOOOOOOOOOOOM!!!!!!!!..........you have hit a mine");
            Scanner scanner = new Scanner(System.in);
            String answer = "";


            while (!answer.equals("y") && !answer.equals("n")) {
                try {
                    if (answer.equals("")) {
                        System.out.println("Do you want to play another game? Enter y for yes or n for no and press enter");
                        scanner = new Scanner(System.in);
                        answer = scanner.next().toLowerCase();
                        scanner.close();
                    }

                    else if (answer.equals("y")) {
                        scanner.close();
                        game_grid = new Grid().structure;
                        visible_grid = new int[10][10];
                        //BELOW METHOD CALL PROB CORRECT BUT CHECK
                        //renderGrid();
                    }


                    else if (answer.equals("n")) {
                        System.out.println("Hope you play again soon!..........laters taters!");
                    }
                }
                catch (Exception e) {
                    System.out.println("Incorrect input, please type either y for yes or n for no.");

                }
            }

        }

        else {
            game_grid[x][y].setUncovered(true);
            //BELOW METHOD CALL PROB CORRECT BUT CHECK AT TIME
            //renderGrid()
        }


    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}