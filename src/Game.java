// author: Jay Patel, 000881881
import java.util.Random;

// creates game class
public class Game {
    private int answer; // declare an instance variable of type integer
    private int numOfAttempts; // declare an instance variable of type integer

    // create a constructor for Game class
    public Game() {
        answer = new Random().nextInt(100) + 1; // generates random number between 1 and 100
        numOfAttempts = 0; // at the beginning number of attempts is 0
    }

    //
    public String guessNumber(int guess) {
        // increases number of attempts by 1
        numOfAttempts++;

        // compares with user's guess
        if (guess == answer) {
            // if guess is correct
            return "Congratulations! You guessed the number in " + numOfAttempts + " attempts.";
        }
        else if (guess > answer) {
            // if guess is more than answer
            return "Too high. Guess again.";
        }
        else {
            // if guess is less than answer
            return "Too low. Guess again.";
        }
    }

    // to reset game
    public void resetGame() {
        // generate a new random number between 1 and 100
        answer = new Random().nextInt(100) + 1;

        // resets the number of attempts
        numOfAttempts = 0;
    }
}
