package builders;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class TicTacToeBuilder {
    private Runnable handler;

    public TicTacToeBuilder(Runnable handler) {
        this.handler = handler;
    }

    public Region build() {
        GridPane pane = new GridPane();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button button = new Button();
                button.setPrefSize(70, 70); // Set preferred size for each button
                button.setOnAction(e -> handler.run()); // Set the click handler
                pane.add(button, col, row);
            }
        }
        VBox vbox = new VBox();
        vbox.getChildren().add(pane);
        vbox.setAlignment(Pos.CENTER_RIGHT);
        return vbox;
    }
}
