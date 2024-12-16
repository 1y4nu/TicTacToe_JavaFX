package builders;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.ColumnConstraints;

public class TicTacToeBuilder {
    private Runnable handler;

    public TicTacToeBuilder(Runnable handler) {
        this.handler = handler;
    }

    public Region build() {
        GridPane mainPane = new GridPane();
        mainPane.setAlignment(Pos.CENTER);

        ColumnConstraints leftColumn = new ColumnConstraints();
        leftColumn.setPercentWidth(50);
        leftColumn.setHalignment(HPos.LEFT);

        ColumnConstraints rightColumn = new ColumnConstraints();
        rightColumn.setPercentWidth(50);
        rightColumn.setHalignment(HPos.CENTER);

        mainPane.getColumnConstraints().addAll(leftColumn, rightColumn);

        GridPane fieldPane = new GridPane();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button button = new Button();
                button.setPrefSize(70, 70);
                button.setOnAction(e -> handler.run());
                fieldPane.add(button, col, row);
            }
        }
        fieldPane.setAlignment(Pos.CENTER_LEFT);

        Label label = new Label("Current Player:");
        label.setAlignment(Pos.BOTTOM_RIGHT);

        mainPane.add(fieldPane, 0, 0);
        mainPane.add(label, 1, 0);

        return mainPane;
    }
}
