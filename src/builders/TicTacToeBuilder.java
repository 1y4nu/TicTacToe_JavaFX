package builders;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

public class TicTacToeBuilder {
    private Runnable handler;

    public TicTacToeBuilder(Runnable handler) {
        this.handler = handler;
    }

    public Region build() {
        GridPane pane = new GridPane();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col ++) {
                Button button = new Button();
                button.setPrefSize(100,100);
                button.setOnAction(evt -> handler.run());
                pane.add(button, col, row);
            }
        }
        return pane;
    }
}
