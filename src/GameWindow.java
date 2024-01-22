// author: Jay Patel, 000881881
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// creates GameWindow class
public class GameWindow {
    private Game game; // declare an instance variable of type Game
    private Stage stage; // declare an instance variable of type Stage
    private Label promptLabel; // declare an instance variable of type Label
    private TextField inputField; // declare an instance variable of type TextField
    private Button guessButton; // declare an instance variable of type Button
    private Label resultLabel; // declare an instance variable of type Label

    public GameWindow(Game game, Stage stage) {
        // assign the Game object passed as argument to the instance variable
        this.game = game;
        // assign the Stage object passed as argument to the instance variable
        this.stage = stage;
    }

    // to create view (window)
    public void createView() {
        promptLabel = new Label("Guess a number between 1 and 100:"); // create a new Label object with the given text
        inputField = new TextField(); // create a new TextField object for user input
        guessButton = new Button("Guess"); // create a new Button object with the given text
        resultLabel = new Label(); // create a new Label object to display game results

        VBox window = new VBox(10); // create a new VBox layout with 10 pixels of spacing between elements
        window.setAlignment(Pos.CENTER); // set the alignment of the VBox to center
        window.getChildren().addAll(promptLabel, inputField, guessButton, resultLabel); // add the UI elements to the VBox

        guessButton.setOnAction(e -> { // set an event handler for the Guess button
            handleGuessButton(); // call the handleGuessButton() method when the button is clicked
        });

        Scene sc = new Scene(window, 300, 200); // create a new Scene object with the VBox as the root node, width of 300 pixels and height of 200 pixels
        stage.setScene(sc); // set the current stage's scene to the new Scene object
        stage.setTitle("Number Guessing Game"); // set the title of the stage
        stage.show(); // show the stage with the new Scene
    }


    private void handleGuessButton() {
        try {
            int guess = Integer.parseInt(inputField.getText()); // converts the user input as an integer
            String result = game.guessNumber(guess); // call the guessNumber() method of the Game object and store the result in a String
            resultLabel.setText(result); // set the text of the resultLabel to the game result
            if (result.contains("Hurray... Your guess is correct")) { // if the game result contains the correct guess message
                guessButton.setDisable(true); // disable the Guess button

            }
        } catch (NumberFormatException ex) { // if the user input is not a valid integer
            resultLabel.setText("Invalid input. Please enter a number."); // set the resultLabel text to an error message
        }
    }
 // to reset view
    public void resetView() {
        inputField.clear(); // clear the inputField
        guessButton.setDisable(false); // enable the Guess button
        resultLabel.setText(""); // clear the resultLabel
        game.resetGame(); // call the resetGame() method of the Game object to reset the game
    }
}
