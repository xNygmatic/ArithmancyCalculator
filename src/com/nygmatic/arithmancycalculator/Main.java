package com.nygmatic.arithmancycalculator;

import javax.swing.*;

public class Main {

    public static final int WIDTH = 310, HEIGHT = 150;
    public static final String TITLE = "Arithmancy Calculator";
    public static JFrame frame;

    public static void main(String[] args) {
        frame = new CalculatorGUI(TITLE, WIDTH, HEIGHT);
    }
}
