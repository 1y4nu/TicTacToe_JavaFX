import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import controllers.TicTacToeController;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        TicTacToeController controller = new TicTacToeController();
        Scene scene = new Scene(controller.initialize(), 500, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
