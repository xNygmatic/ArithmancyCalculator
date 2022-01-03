package com.nygmatic.arithmancycalculator;

import javax.swing.*;
import java.awt.*;

public class CalculatorGUI extends JFrame {
    private JPanel mainPanel;
    private JTextField nameField;
    private JButton startButton;
    private JLabel textLabel;
    private JLabel characterNumLabel;
    private JLabel socialNumLabel;
    private JLabel heartNumLabel;
    private JLabel scoreLabel;
    private JPanel bottomPanel;
    private JPanel buttonPanel;
    private JPanel topPanel;

    public CalculatorGUI(String title, int width, int height) {
        super(title);
        initialize();
        registerListeners();
        this.setPreferredSize(new Dimension(width, height));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(mainPanel);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }

    private void initialize() {
        textLabel.setText("What is your name?");
        startButton.setText("Calculate");
        characterNumLabel.setText("Character Number: ");
        socialNumLabel.setText("Social Number: ");
        heartNumLabel.setText("Heart Number: ");
        scoreLabel.setText("Arithmancy Scores for ");
        bottomPanel.setVisible(false);
    }

    private void registerListeners() {
        startButton.addActionListener(e -> {
            String text = nameField.getText();
            if (text.isEmpty()) {
                timedMessage(textLabel, "Please enter your name!", 1500);
                return;
            } else if (!text.matches("^[ A-Za-z]+$") || text.length() - text.replaceAll(" ", "")
                    .length() > 1 ) {
                timedMessage(textLabel, "Please enter a valid name!", 1500);
                return;
            }
            String[] split = text.split(" ");
            User user = new User(split[0], split.length > 1 ? split[1] : " ");
            updateGUI(user);
        });
    }

    private void updateGUI(User user) {
        characterNumLabel.setText(characterNumLabel.getText() + user.getCharacterNumber());
        socialNumLabel.setText(socialNumLabel.getText() + user.getSocialNumber());
        heartNumLabel.setText(heartNumLabel.getText() + user.getHeartNumber());
        scoreLabel.setText(scoreLabel.getText() + user.getFirstName() + " " + user.getLastName());
        bottomPanel.setVisible(true);
        topPanel.setVisible(false);
    }

    private void timedMessage(JLabel label, String message, int delay) {
        String originalText = label.getText();
        Color originalColor = label.getForeground();
        label.setForeground(Color.RED);
        label.setText(message);
        Timer timer = new Timer(delay, e -> {
            label.setText(originalText);
            label.setForeground(originalColor);
        });
        timer.setRepeats(false);
        timer.start();
    }
}
