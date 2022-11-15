package org.example;

public class Game {

    static Square[][] game_grid = new Grid().structure;
    static int[][] visible_grid = new int[10][10];

// !!!!!!!!!!!!!!INCOMPLETE METHOD!!!!!!!!!!!!!!!!!!!
    public static int[][] refreshGrid() {
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
            //refreshGrid()
        }

    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}