
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ScientificCalculator extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;

    private double num1, num2, result;
    private String operator = "";
    private boolean newNumber = true;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ScientificCalculator frame =
                        new ScientificCalculator();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ScientificCalculator() {

        setTitle("Scientific Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 330);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField = new JTextField("0");
        textField.setBounds(10, 25, 384, 30);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        contentPane.add(textField);

        JButton btnDivide = new JButton("/");
        btnDivide.setBounds(10, 67, 88, 22);
        contentPane.add(btnDivide);

        JButton btn9 = new JButton("9");
        btn9.setBounds(108, 67, 88, 22);
        contentPane.add(btn9);

        JButton btn8 = new JButton("8");
        btn8.setBounds(209, 67, 88, 22);
        contentPane.add(btn8);

        JButton btn7 = new JButton("7");
        btn7.setBounds(306, 67, 88, 22);
        contentPane.add(btn7);

        JButton btnMultiply = new JButton("*");
        btnMultiply.setBounds(10, 100, 88, 22);
        contentPane.add(btnMultiply);

        JButton btn6 = new JButton("6");
        btn6.setBounds(108, 100, 88, 22);
        contentPane.add(btn6);

        JButton btn5 = new JButton("5");
        btn5.setBounds(209, 100, 88, 22);
        contentPane.add(btn5);

        JButton btn4 = new JButton("4");
        btn4.setBounds(306, 100, 88, 22);
        contentPane.add(btn4);

        JButton btnMinus = new JButton("-");
        btnMinus.setBounds(10, 133, 88, 22);
        contentPane.add(btnMinus);

        JButton btn3 = new JButton("3");
        btn3.setBounds(108, 133, 88, 22);
        contentPane.add(btn3);

        JButton btn2 = new JButton("2");
        btn2.setBounds(209, 133, 88, 22);
        contentPane.add(btn2);

        JButton btn1 = new JButton("1");
        btn1.setBounds(306, 133, 88, 22);
        contentPane.add(btn1);

        JButton btnPlus = new JButton("+");
        btnPlus.setBounds(10, 166, 88, 22);
        contentPane.add(btnPlus);

        JButton btnEqual = new JButton("=");
        btnEqual.setBounds(108, 166, 88, 22);
        contentPane.add(btnEqual);

        JButton btnDot = new JButton(".");
        btnDot.setBounds(209, 166, 88, 22);
        contentPane.add(btnDot);

        JButton btn0 = new JButton("0");
        btn0.setBounds(306, 166, 88, 22);
        contentPane.add(btn0);

        JButton btnClear = new JButton("C");
        btnClear.setBounds(10, 199, 88, 22);
        contentPane.add(btnClear);

        JButton btnTan = new JButton("tan");
        btnTan.setBounds(108, 199, 88, 22);
        contentPane.add(btnTan);

        JButton btnCos = new JButton("cos");
        btnCos.setBounds(209, 199, 88, 22);
        contentPane.add(btnCos);

        JButton btnSin = new JButton("sin");
        btnSin.setBounds(306, 199, 88, 22);
        contentPane.add(btnSin);

        JButton btnPercent = new JButton("%");
        btnPercent.setBounds(10, 232, 88, 22);
        contentPane.add(btnPercent);

        JButton btnSquare = new JButton("x^2");
        btnSquare.setBounds(108, 232, 88, 22);
        contentPane.add(btnSquare);

        JButton btnLog = new JButton("log");
        btnLog.setBounds(209, 232, 88, 22);
        contentPane.add(btnLog);

        JButton btnSqrt = new JButton("sqrt");
        btnSqrt.setBounds(306, 232, 88, 22);
        contentPane.add(btnSqrt);

        // Number buttons
        JButton[] numberButtons = {
            btn0, btn1, btn2, btn3, btn4,
            btn5, btn6, btn7, btn8, btn9
        };

        for (JButton button : numberButtons) {
            button.addActionListener(e -> {
                String digit = button.getText();

                if (newNumber || textField.getText().equals("0")
                        || textField.getText().equals("Error")) {
                    textField.setText(digit);
                    newNumber = false;
                } else {
                    textField.setText(
                        textField.getText() + digit);
                }
            });
        }

        // Decimal point
        btnDot.addActionListener(e -> {
            if (newNumber) {
                textField.setText("0.");
                newNumber = false;
            } else if (!textField.getText().contains(".")) {
                textField.setText(textField.getText() + ".");
            }
        });

        // Arithmetic operators
        JButton[] operatorButtons = {
            btnPlus, btnMinus, btnMultiply, btnDivide
        };

        for (JButton button : operatorButtons) {
            button.addActionListener(e -> {
                try {
                    num1 = Double.parseDouble(textField.getText());
                    operator = button.getText();
                    newNumber = true;
                } catch (NumberFormatException ex) {
                    textField.setText("Error");
                }
            });
        }

        // Equal button
        btnEqual.addActionListener(e -> {
            try {
                if (operator.isEmpty()) {
                    return;
                }

                num2 = Double.parseDouble(textField.getText());

                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0) {
                            textField.setText("Cannot divide by zero");
                            operator = "";
                            newNumber = true;
                            return;
                        }
                        result = num1 / num2;
                        break;
                }

                textField.setText(String.valueOf(result));
                operator = "";
                newNumber = true;

            } catch (NumberFormatException ex) {
                textField.setText("Error");
            }
        });

        // Clear button
        btnClear.addActionListener(e -> {
            textField.setText("0");
            num1 = 0;
            num2 = 0;
            result = 0;
            operator = "";
            newNumber = true;
        });

        // Scientific buttons
        btnSin.addActionListener(e -> scientific("sin"));
        btnCos.addActionListener(e -> scientific("cos"));
        btnTan.addActionListener(e -> scientific("tan"));
        btnSqrt.addActionListener(e -> scientific("sqrt"));
        btnLog.addActionListener(e -> scientific("log"));
        btnSquare.addActionListener(e -> scientific("square"));
        btnPercent.addActionListener(e -> scientific("percent"));
    }

    private void scientific(String operation) {
        try {
            double value = Double.parseDouble(textField.getText());

            switch (operation) {
                case "sin":
                    result = Math.sin(Math.toRadians(value));
                    break;
                case "cos":
                    result = Math.cos(Math.toRadians(value));
                    break;
                case "tan":
                    result = Math.tan(Math.toRadians(value));
                    break;
                case "sqrt":
                    if (value < 0) {
                        textField.setText("Invalid input");
                        newNumber = true;
                        return;
                    }
                    result = Math.sqrt(value);
                    break;
                case "log":
                    if (value <= 0) {
                        textField.setText("Invalid input");
                        newNumber = true;
                        return;
                    }
                    result = Math.log10(value);
                    break;
                case "square":
                    result = Math.pow(value, 2);
                    break;
                case "percent":
                    result = value / 100;
                    break;
                default:
                    return;
            }

            textField.setText(String.valueOf(result));
            newNumber = true;

        } catch (NumberFormatException ex) {
            textField.setText("Error");
            newNumber = true;
        }
    }
}
