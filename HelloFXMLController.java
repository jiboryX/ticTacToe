package cis296project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class HelloFXMLController {
    int [][] board = new int[3][3];
    boolean isXTurn = true;

    @FXML
    private GridPane gPane;

    @FXML
    private Button btn00;

    @FXML
    private Button btn01;

    @FXML
    private Button btn02;

    @FXML
    private Button btn10;

    @FXML
    private Button btn11;

    @FXML
    private Button btn12;

    @FXML
    private Button btn20;

    @FXML
    private Button btn21;

    @FXML
    private Button btn22;
    
    @FXML
    private Label label;

    @FXML
    public void change(ActionEvent e) {
        Button btn = (Button) e.getSource(); 

        Integer rowIndex = GridPane.getRowIndex(btn);
        Integer colIndex = GridPane.getColumnIndex(btn);

        int row = rowIndex == null ? 0 : rowIndex;
        int col = colIndex == null ? 0 : colIndex;

        if (board[row][col] == 0) { 
            if (isXTurn) {
                board[row][col] = 1; 
                btn.setText("X");  
            } else {
                board[row][col] = 2; 
                btn.setText("O"); 
            }
            btn.setDisable(true); 

            isXTurn = !isXTurn; 

            int winner = checkWinner();  
            if (winner != 0) {
                if (winner == 1) {
                    label.setText("X is the winner");
                } else {
                    label.setText("O is the winner");
                }
                disableAllButtons();
            } else if (isDraw()) {
            }
        }
    }
    private void disableAllButtons() {
        for (Button[] row : new Button[][]{ {btn00, btn01, btn02}, {btn10, btn11, btn12}, {btn20, btn21, btn22} }) {
            for (Button button : row) {
                button.setDisable(true);
            }
        }
    }
    private int checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != 0)
                return board[i][0];
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != 0)
                return board[0][i];
    }
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != 0)
            return board[0][0];
        if (board[2][0] == board[1][1] && board[2][0] == board[0][2] && board[2][0] != 0)
            return board[2][0];
        return 0; // No Winner
    }
    private boolean isDraw() {
        for (int[] row : board)
            for (int cell : row)
                if (cell == 0)
                    return false; 
        return true;
    }

    private void setButtonsEnabled(boolean enabled) {
        for (Button[] row : new Button[][]{{btn00, btn01, btn02}, {btn10, btn11, btn12}, {btn20, btn21, btn22}}) {
            for (Button button : row) {
                button.setDisable(!enabled);
            }
        }
    }

    private void updateBoard(int row, int col, int value) {
        Button btn = getButtonAt(row, col);
        if (value == 1) {
            btn.setText("X");
        } else if (value == 2) {
            btn.setText("O");
        }
        btn.setDisable(true);
    }

    private Button getButtonAt(int row, int col) {
        switch (row) {
            case 0:
                return col == 0 ? btn00 : (col == 1 ? btn01 : btn02);
            case 1:
                return col == 0 ? btn10 : (col == 1 ? btn11 : btn12);
            case 2:
                return col == 0 ? btn20 : (col == 1 ? btn21 : btn22);
            default:
                return null;
        }
    }

}