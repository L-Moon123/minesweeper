package org.example;
import java.util.Scanner;

public class Game {

    static Square[][] game_grid = new Grid().structure;
    static Object[][] visible_grid = new Object[10][10];

    static boolean game_over = false;


    public static Object[][] renderGrid() {
        for (int i=0; i < game_grid.length - 1; i++) {
            for (int j=0; j < game_grid[i].length - 1; j++) {
                if (game_grid[i][j].isUncovered() && !game_grid[i][j].isMined() && !game_grid[i][j].isFlagged()) {

                    visible_grid[i][j] = game_grid[i][j].getAdjMines();
                }

                else if (game_grid[i][j].isUncovered() && game_grid[i][j].isMined() && !game_grid[i][j].isFlagged()) {
                    visible_grid[i][j] = "M";

                }

                else if (game_grid[i][j].isFlagged()) {
                    visible_grid[i][j] = "F";

                }


                else {
                    visible_grid[i][j] = "[]";
                }
            }
        }
        return visible_grid;

    }

    public static Object[][] revealSquare(int x, int y) {
        if (game_grid[y][x].isFlagged()) {
            System.out.println("You can not reveal a flagged square");

        }

        else if (game_grid[y][x].isMined()) {
            System.out.println("!!!!!!!!!BOOOOOOOOOOOM!!!!!!!!.....game over.....you have hit a mine");
            System.out.println("/////////////////////////////////////////////////////////////////////////////////////");

            String answer = "";


            while (!answer.equals("y") && !answer.equals("n")) {
                try {
                    System.out.println("Do you want to play another game? Enter y for yes or n for no and press enter");
                    Scanner scanner = new Scanner(System.in);

                    if (answer.equals("")) {
                        System.out.println("Do you want to play another game? Enter y for yes or n for no and press enter");
                        scanner = new Scanner(System.in);
                        answer = scanner.next().toLowerCase();
                    }

                    else if (answer.equals("y")) {

                        game_grid = new Grid().structure;
                        visible_grid = new Object[10][10];

                        visible_grid = renderGrid();
                        System.out.println("Press C and press enter to reveal a square");
                        System.out.println("Press F and press enter to place or remove a flag");
                        System.out.println("Press A and press enter to reveal adjacent squares");
                    }


                    else if (answer.equals("n")) {
                        System.out.println("Hope you play again soon!..........laters taters!");
                        game_over = true;
                    }

                    scanner.close();
                }
                catch (Exception e) {
                    System.out.println("Incorrect input, please type either y for yes or n for no and press enter.");

                }
            }

        }

        else {
            game_grid[y][x].setUncovered(true);
            visible_grid = renderGrid();
        }

        return visible_grid;
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
        try {
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
        catch (ArrayIndexOutOfBoundsException e) {

        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Minesweeper!");
        System.out.println("Select single squares on the grid to reveal them, if there are no mines present, " +
                "you will reveal how many mines are adjacent to that square.....but if you hit a mine you lose!");
        System.out.println("You can plant flags to mark where suspected mines are, sometimes these mines will already be uncovered, " +
                "if this is the case then the mine will be cleared");
        System.out.println("If a square is uncovered and has at least one adjacent mine next to it, you can select that square " +
                "using an alternative command, this will make all adjacent squares around it visible");
        System.out.println("Once all mines are flagged and all squares are cleared, you win!");
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////");

        //!!!!!WHILE LOOP STARTS HERE (and ends when game_over == true)!!!!!!!!!!
        while (game_over == false) {
            System.out.println("Press the C key and press enter to reveal a square");
            System.out.println("Press the F key and press enter to plant a flag (you can also use this to remove a flag if a flag is already " +
                    "present on the square, this will remove the uncovered mine if it is present)");
            System.out.println("Press the A key and press enter to reveal all adjacent squares around your chosen square (remember this can " +
                    "only be done with a square that is uncovered and contains at least one adjacent mine)");
            try {
                Scanner scanner = new Scanner(System.in);
                String choice = scanner.next().toLowerCase();

                if (choice.equals("c")) {
                    System.out.println("Input the X coordinate of the square you want to reveal (0-9)");
                    scanner = new Scanner(System.in);
                    int x_coord = Integer.parseInt(scanner.next());


                    System.out.println("Input the y coordinate of the square you want to reveal (0-9)");
                    scanner = new Scanner(System.in);
                    int y_coord = Integer.parseInt(scanner.next());


                    Object[][] output = revealSquare(x_coord, y_coord);
                    for (int i=0; i < output.length - 1; i++) {
                        for (int j=0; j < output[i].length - 1; j++) {
                            System.out.println(output[j][i]);

                        }

                    }


                } else if (choice.equals("f")) {
                    System.out.println("Input the X coordinate of the square you want to place/remove the flag (0-9)");
                    scanner = new Scanner(System.in);
                    int x_coord = Integer.parseInt(scanner.next());


                    System.out.println("Input the y coordinate of the square you want to place/remove the flag (0-9)");
                    scanner = new Scanner(System.in);
                    int y_coord = Integer.parseInt(scanner.next());


                    placeFlag(x_coord, y_coord);

                } else if (choice.equals("a")) {
                    System.out.println("Input the X coordinate of the square whose adjacent squares you wish to reveal (0-9)");
                    scanner = new Scanner(System.in);
                    int x_coord = Integer.parseInt(scanner.next());


                    System.out.println("Input the y coordinate of the square whose adjacent squares you wish to reveal (0-9)");
                    scanner = new Scanner(System.in);
                    int y_coord = Integer.parseInt(scanner.next());


                    revealAdjSquares(x_coord, y_coord);

                }



            } catch (ArrayIndexOutOfBoundsException aie) {

            } catch (NumberFormatException nfe) {
                System.out.println("Only whole numbers between 0-9 can be used, please try again");

            } catch (Exception e) {
                System.out.println("Invalid input, please try again");

            }
        }
    }
}