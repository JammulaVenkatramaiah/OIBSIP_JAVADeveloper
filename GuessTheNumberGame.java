import java.util.Random;
import javax.swing.*;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        int rounds = 3;
        int maxAttempts = 7;
        int totalScore = 0;

        for (int round = 1; round <= rounds; round++) {
            int numberToGuess = new Random().nextInt(100) + 1;
            int attempts = 0;
            boolean guessed = false;

            JOptionPane.showMessageDialog(null, "Round " + round + ": Guess a number between 1 and 100.");

            while (attempts < maxAttempts && !guessed) {
                String input = JOptionPane.showInputDialog("Attempt " + (attempts + 1) + " of " + maxAttempts + ": Enter your guess");
                if (input == null) break; // Cancel was pressed

                int guess;
                try {
                    guess = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer.");
                    continue;
                }

                attempts++;

                if (guess < numberToGuess) {
                    JOptionPane.showMessageDialog(null, "Too low!");
                } else if (guess > numberToGuess) {
                    JOptionPane.showMessageDialog(null, "Too high!");
                } else {
                    int roundScore = (maxAttempts - attempts + 1) * 10; // More score for fewer attempts
                    totalScore += roundScore;
                    JOptionPane.showMessageDialog(null, "Correct! You guessed in " + attempts + " attempts and scored " + roundScore + " points.");
                    guessed = true;
                }
            }

            if (!guessed)
                JOptionPane.showMessageDialog(null, "Out of attempts! The number was " + numberToGuess + ".");
        }

        JOptionPane.showMessageDialog(null, "Game Over!\nTotal Score: " + totalScore + " points over " + rounds + " rounds.");

        System.exit(0);
    }
}
