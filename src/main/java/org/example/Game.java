package org.example;
import java.util.Scanner;

public class Game {

    static Square[][] game_grid = new Grid().structure;
    static Object[][] visible_grid = new Object[10][10];


    public static Object[][] renderGrid() {
        for (int i=0; i < game_grid.length; i++) {
            for (int j=0; j < game_grid[i].length; j++) {
                if (game_grid[i][j].isUncovered() && !game_grid[i][j].isMined() && !game_grid[i][j].isFlagged()) {

                    visible_grid[i][j] = game_grid[i][j].getAdjMines();
                }

                else if (game_grid[i][j].isFlagged()) {
                    visible_grid[i][j] = "F";

                }

                else if (game_grid[i][j].isUncovered() && game_grid[i][j].isMined()) {
                    visible_grid[i][j] = "M";

                }

                else {
                    visible_grid[i][j] = " ";
                }
            }
        }
        return visible_grid;

    }

    public static void revealSquare(int x, int y) {
        if (game_grid[y][x].isFlagged()) {
            System.out.println("You can not reveal a flagged square");

        }

        else if (game_grid[y][x].isMined()) {
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
                        visible_grid = new Object[10][10];

                        renderGrid();
                    }


                    else if (answer.equals("n")) {
                        System.out.println("Hope you play again soon!..........laters taters!");
                    }
                }
                catch (Exception e) {
                    System.out.println("Incorrect input, please type either y for yes or n for no and press enter.");

                }
            }

        }

        else {
            game_grid[y][x].setUncovered(true);

            renderGrid();
        }
    }

    public static void placeFlag(int x, int y) {
        if (!game_grid[y][x].isFlagged()) {
            game_grid[y][x].setFlagged(true);
            renderGrid();
        }

        else if (game_grid[y][x].isUncovered() && game_grid[y][x].isMined() && game_grid[y][x].isFlagged()) {
            game_grid[y][x].setMined(false);
            System.out.println("Mine cleared!!!!");
            renderGrid();
        }

        else {
            game_grid[y][x].setFlagged(false);
            renderGrid();
        }

    }

    public static void revealAdjSquares(int x, int y) {
        if (game_grid[y][x].isUncovered() && game_grid[y][x].getAdjMines() > 0) {
            if (!game_grid[y][x - 1].isFlagged()) {
                game_grid[y][x - 1].setUncovered(true);

            }

            if (!game_grid[y][x + 1].isFlagged()) {
                game_grid[y][x + 1].setUncovered(true);

            }

            if (!game_grid[y - 1][x].isFlagged()) {
                game_grid[y - 1][x].setUncovered(true);

            }

            if (!game_grid[y + 1][x].isFlagged()) {
                game_grid[y + 1][x].setUncovered(true);

            }

            if (!game_grid[y - 1][x - 1].isFlagged()) {
                game_grid[y - 1][x - 1].setUncovered(true);

            }

            if (!game_grid[y - 1][x + 1].isFlagged()) {
                game_grid[y - 1][x + 1].setUncovered(true);

            }

            if (!game_grid[y + 1][x - 1].isFlagged()) {
                game_grid[y + 1][x - 1].setUncovered(true);

            }

            if (!game_grid[y + 1][x + 1].isFlagged()) {
                game_grid[y + 1][x + 1].setUncovered(true);

            }

            renderGrid();

        }

    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}