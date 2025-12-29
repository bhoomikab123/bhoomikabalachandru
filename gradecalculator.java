import java.awt.*;
import java.awt.event.*;

public class gradecalculator extends Frame implements ActionListener {
    Label l1, l2, l3, l4, l5, resultLabel1, resultLabel2;
    TextField t1, t2, t3, t4, t5;
    Button b;

    gradecalculator() {
        setTitle("Student grade calculator");
        setSize(400, 420);
        setLayout(null);

        l1 = new Label("subject1 marks:");
        l2 = new Label("subject2 marks:");
        l3 = new Label("subject3 marks:");
        l4 = new Label("subject4 marks:");
        l5 = new Label("subject5 marks:");
        // l1 = new Label("subject6 marks:");

        t1 = new TextField();
        t2 = new TextField();
        t3 = new TextField();
        t4 = new TextField();
        t5 = new TextField();

        resultLabel1 = new Label("");
        resultLabel2 = new Label("");

        b = new Button("calculate");
        b.addActionListener(this);

        l1.setBounds(30, 50, 120, 30);
        t1.setBounds(160, 50, 150, 30);

        l2.setBounds(30, 90, 120, 30);
        t2.setBounds(160, 90, 150, 30);

        l3.setBounds(30, 130, 120, 30);
        t3.setBounds(160, 130, 150, 30);

        l4.setBounds(30, 170, 120, 30);
        t4.setBounds(160, 170, 150, 30);

        l5.setBounds(30, 210, 120, 30);
        t5.setBounds(160, 210, 150, 30);

        b.setBounds(130, 260, 120, 35);

        resultLabel1.setBounds(30, 310, 350, 30); // first result line
        resultLabel2.setBounds(30, 350, 350, 30);

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(l5);
        add(t5);
        add(b);
        add(resultLabel1);
        add(resultLabel2);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        int m1 = Integer.parseInt(t1.getText());
        int m2 = Integer.parseInt(t2.getText());
        int m3 = Integer.parseInt(t3.getText());
        int m4 = Integer.parseInt(t4.getText());
        int m5 = Integer.parseInt(t5.getText());

        int total = m1 + m2 + m3 + m4 + m5;
        float avg = total / 5f;

        String grade;

        if (avg >= 90) {
            grade = "A+";
        } else if (avg >= 80) {
            grade = "A";
        } else if (avg >= 90) {
            grade = "B";
        } else if (avg >= 70) {
            grade = "c";
        } else if (avg >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        String result = (avg >= 35) ? "PASS" : "FAIL";

        resultLabel1.setText("Total: " + total + "   Average: " + avg + "   Grade: " + grade);
        resultLabel2.setText("Result: " + result);
    }

    public static void main(String[] args) {
        new gradecalculator();
    }
}
