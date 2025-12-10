import java.awt.*;
import java.awt.event.*;

public class CalculatorAWT implements ActionListener {
    Frame frame;
    TextField input;
    Button[] numberButtons = new Button[10];
    Button add, sub, mul, div, clr, eq;
    String operator = "";
    double num1 = 0, num2 = 0;

    CalculatorAWT() {
        frame = new Frame("AWT Calculator");
        frame.setSize(400, 500);
        frame.setLayout(null);

        input = new TextField();
        input.setBounds(50, 50, 300, 50);
        frame.add(input);

        // Number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new Button(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        // Operator buttons
        add = new Button("+");
        sub = new Button("-");
        mul = new Button("*");
        div = new Button("/");
        clr = new Button("C");
        eq = new Button("=");

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        clr.addActionListener(this);
        eq.addActionListener(this);

        // Position buttons
        int x = 50, y = 120;
        for (int i = 1; i <= 9; i++) {
            numberButtons[i].setBounds(x, y, 50, 50);
            frame.add(numberButtons[i]);
            x += 60;
            if (i % 3 == 0) {
                x = 50;
                y += 60;
            }
        }
        numberButtons[0].setBounds(110, y, 50, 50);
        frame.add(numberButtons[0]);

        add.setBounds(250, 120, 50, 50);
        sub.setBounds(250, 180, 50, 50);
        mul.setBounds(250, 240, 50, 50);
        div.setBounds(250, 300, 50, 50);
        eq.setBounds(50, 300, 50, 50);
        clr.setBounds(170, 300, 50, 50);

        frame.add(add);
        frame.add(sub);
        frame.add(mul);
        frame.add(div);
        frame.add(eq);
        frame.add(clr);

        frame.setVisible(true);

        // Close window event
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                input.setText(input.getText() + i);
            }
        }

        if (e.getSource() == add) {
            num1 = Double.parseDouble(input.getText());
            operator = "+";
            input.setText(input.getText() + "");
        }
        if (e.getSource() == sub) {
            num1 = Double.parseDouble(input.getText());
            operator = "-";
            input.setText(input.getText() + "");
        }
        if (e.getSource() == mul) {
            num1 = Double.parseDouble(input.getText());
            operator = "*";
            input.setText(input.getText() + "");
        }
        if (e.getSource() == div) {
            num1 = Double.parseDouble(input.getText());
            operator = "/";
            input.setText(input.getText() + "");
        }
        if (e.getSource() == eq) {
            num2 = Double.parseDouble(input.getText());
            switch (operator) {
                case "+":
                    input.setText(String.valueOf(num1 + num2));
                    break;
                case "-":
                    input.setText(String.valueOf(num1 - num2));
                    break;
                case "*":
                    input.setText(String.valueOf(num1 * num2));
                    break;
                case "/":
                    input.setText(String.valueOf(num1 / num2));
                    break;
            }
            num1 = 0;
            num2 = 0;
        }
        if (e.getSource() == clr) {
            input.setText("");
            num1 = 0;
            num2 = 0;
            operator = "";
        }
    }

    public static void main(String[] args) {
        new CalculatorAWT();
    }
}