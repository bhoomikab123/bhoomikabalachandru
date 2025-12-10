import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class NumberGUessAWT implements ActionListener {

    private Frame frame;
    private Label titleLabel;
    private Label promptLabel;
    private TextField inputField;
    private Button guessButton;
    private Button newGameButton;
    private Label feedbackLabel;
    private Label attemptsLabel;

    private int targetNumber;
    private int attempts;
    private final int MAX = 100;

    private final Random rng = new Random();

    public NumberGUessAWT() {

        frame = new Frame("Number Guessing Game (AWT)");

        titleLabel = new Label("Guess a number between 1 to " + MAX, Label.CENTER);
        promptLabel = new Label("Enter your guess:", Label.LEFT);
        inputField = new TextField(10);
        guessButton = new Button("Guess");
        newGameButton = new Button("New Game");
        feedbackLabel = new Label("WELCOME! Make your first guess.", Label.CENTER);
        attemptsLabel = new Label("Attempts: 0", Label.CENTER);

        // event listeners
        guessButton.addActionListener(this);
        newGameButton.addActionListener(this);
        inputField.addActionListener(this);

        // layout design
        frame.setLayout(new BorderLayout(8, 8));
        frame.add(titleLabel, BorderLayout.NORTH);

        Panel center = new Panel(new FlowLayout());
        center.add(promptLabel);
        center.add(inputField);
        center.add(guessButton);
        center.add(newGameButton);
        frame.add(center, BorderLayout.CENTER);

        Panel south = new Panel(new GridLayout(3, 1));
        south.add(feedbackLabel);
        south.add(attemptsLabel);
        frame.add(south, BorderLayout.SOUTH);

        // window close
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });

        startNewGame();

        frame.setSize(4200, 1000);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void startNewGame() {
        targetNumber = rng.nextInt(MAX) + 1;
        attempts = 0;

        feedbackLabel.setText("New Game Started!");
        attemptsLabel.setText("Attempts: 0");

        inputField.setText("");
        inputField.setEnabled(true);
        guessButton.setEnabled(true);
    }

    public void actionPerformed(ActionEvent e) {

        Object src = e.getSource();

        if (src == newGameButton) {
            startNewGame();
            return;
        }

        String text = inputField.getText().trim();

        if (text.isEmpty()) {
            feedbackLabel.setText("Enter a number!");
            return;
        }

        int guess;
        try {
            guess = Integer.parseInt(inputField.getText());
        } catch (NumberFormatException ex) {
            feedbackLabel.setText("Enter a valid integer!");
            inputField.selectAll();
            return;
        }

        if (guess < 1 || guess > MAX) {
            feedbackLabel.setText("Number out of range (1 - " + MAX + ")");
            inputField.selectAll();
            return;
        }

        attempts++;
        attemptsLabel.setText("Attempts: " + attempts);

        if (guess == targetNumber) {
            feedbackLabel.setText("Correct! Number was " + targetNumber);
            inputField.setEnabled(false);
            guessButton.setEnabled(false);
        } else if (guess < targetNumber) {
            feedbackLabel.setText("Too low! Try again.");
            inputField.selectAll();
        } else {
            feedbackLabel.setText("Too high! Try again.");
            inputField.selectAll();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new NumberGUessAWT());
    }
}
