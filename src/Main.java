// author: Jay Patel, 000881881
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private Game game; // declare an instance variable of type Game
    private GameWindow view; // declare an instance variable of type GameWindow

    // main method
    public static void main(String[] args) {
        // start the JavaFX application
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        game = new Game(); // instantiate a new Game object
        view = new GameWindow(game, primaryStage); // instantiate a new GameWindow object with the Game object and primaryStage
        view.createView(); // call the createView() method on the GameWindow object to create the UI and start the game
    }
}
