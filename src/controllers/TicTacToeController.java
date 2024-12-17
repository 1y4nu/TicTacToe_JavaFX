package controllers;

import builders.TicTacToeBuilder;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.Node;
import java.util.Random;

public class TicTacToeController {
    private char user;
    private char computer;
    private char[][] board;
    private GridPane gridPane;
    TicTacToeBuilder builder;
    Random random;

    public TicTacToeController() {
        user = 'X';
        computer = 'O';
        board = new char[3][3];
        builder = new TicTacToeBuilder(this::handleCellClick);
        random = new Random();
    }

    public Region initialize() {
        gridPane = (GridPane) builder.build();
        return gridPane;
    }

    public void handleCellClick() {
        Button clickedButton = (Button) gridPane.getScene().getFocusOwner();
        Integer col = GridPane.getColumnIndex(clickedButton);
        Integer row = GridPane.getRowIndex(clickedButton);

        if (board[row][col] == '\0') {
            board[row][col] = user;
            clickedButton.setText(String.valueOf(user));
            System.out.println("Button clicked at row " + row + ", col " + col);

            if (!hasEmptyCells()) return;

            computerMove();
        }
    }

    private void computerMove() {
        int[] position = findEmptyCell();
        int row = position[0];
        int col = position[1];

        board[row][col] = computer;

        for (Node node : gridPane.getChildren()) {
            Integer nodeCol = GridPane.getColumnIndex(node);
            Integer nodeRow = GridPane.getRowIndex(node);

            if (nodeRow != null && nodeCol != null && nodeRow == row && nodeCol == col) {
                Button button = (Button) node;
                button.setText(String.valueOf(computer));
                System.out.println("Computer moved at row " + row + ", col " + col);
                break;
            }
        }
    }

    private int[] findEmptyCell() {
        while (true) {
            int row = random.nextInt(3);
            int col = random.nextInt(3);
            if (board[row][col] == '\0') {
                return new int[]{row, col};
            }
        }
    }

    private boolean hasEmptyCells() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == '\0') {
                    return true;
                }
            }
        }
        System.out.println("No empty cells left. Game over!");
        return false;
    }
}

