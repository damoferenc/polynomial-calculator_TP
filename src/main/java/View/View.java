package View;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class View extends JFrame {

    private JButton addButton;
    private JButton substractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton derivateButton;
    private JButton integrateButton;
    private JLabel polynomialText1;
    private JLabel polynomialText2;
    private JLabel resultText;
    private JLabel resultValue;
    private JLabel quotientText;
    private JLabel remainderText;
    private JLabel quotientValue;
    private JLabel remainderValue;
    private JTextField polynomialField1;
    private JTextField polynomialField2;

    public View() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 400);

        JPanel textPanel = new JPanel();
        JPanel textPanel1 = new JPanel();
        JPanel textPanel2 = new JPanel();
        JPanel textPanel3 = new JPanel();
        JPanel textPanel4 = new JPanel();
        JPanel textPanel5 = new JPanel();
        JPanel buttonPanel = new JPanel();

        polynomialText1 = new JLabel ("First polynomial: ");
        polynomialField1 = new JTextField(20);
        polynomialText2 = new JLabel ("Second polynomial: ");
        polynomialField2 = new JTextField(20);
        resultText = new JLabel ("Result: ");
        resultValue = new JLabel ("");
        quotientValue = new JLabel("");
        remainderValue = new JLabel("");
        quotientText = new JLabel("");
        remainderText = new JLabel("");
        textPanel1.add(polynomialText1);
        textPanel1.add(polynomialField1);
        textPanel1.setLayout(new FlowLayout());
        textPanel2.add(polynomialText2);
        textPanel2.add(polynomialField2);
        textPanel2.setLayout(new FlowLayout());
        textPanel3.add(resultText);
        textPanel3.add(resultValue);
        textPanel3.setLayout(new FlowLayout());
        textPanel4.add(quotientText);
        textPanel4.add(quotientValue);
        textPanel4.setLayout(new FlowLayout());
        textPanel5.add(remainderText);
        textPanel5.add(remainderValue);
        textPanel5.setLayout(new FlowLayout());
        textPanel.add(textPanel1);
        textPanel.add(textPanel2);
        textPanel.add(textPanel3);
        textPanel.add(textPanel4);
        textPanel.add(textPanel5);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        addButton = new JButton("Add");
        substractButton = new JButton("Substract");
        multiplyButton = new JButton("Multiply");
        divideButton = new JButton("Divide");
        derivateButton = new JButton("Derivate");
        integrateButton = new JButton("Integrate");
        buttonPanel.add(addButton);
        buttonPanel.add(substractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(derivateButton);
        buttonPanel.add(integrateButton);
        buttonPanel.setLayout(new GridLayout(0,2));

        JPanel p = new JPanel();
        p.add(textPanel);
        p.add(buttonPanel);
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        this.setContentPane(p);
    }

    public void addAddButtonListener(ActionListener al) {
        this.addButton.addActionListener(al);
    }

    public void addSubstractButtonListener(ActionListener al) {
        this.substractButton.addActionListener(al);
    }

    public void addMultiplyButtonListener(ActionListener al) {
        this.multiplyButton.addActionListener(al);
    }

    public void addDivideButtonListener(ActionListener al) {
        this.divideButton.addActionListener(al);
    }

    public void addDerivateButtonListener(ActionListener al) {
        this.derivateButton.addActionListener(al);
    }

    public void addIntegrateButtonListener(ActionListener al) {
        this.integrateButton.addActionListener(al);
    }

    public String getFirstPolynomial() {
        return this.polynomialField1.getText();
    }

    public String getSecondPolynomial() {
        return this.polynomialField2.getText();
    }

    public void showResult(String mess) {
        this.resultValue.setText(mess);
    }

    public void showRemainder(String mess) {
        this.remainderValue.setText(mess);
        this.remainderText.setText("Remainder:");
    }
    public void showQuotient(String mess) {
        this.quotientValue.setText(mess);
        this.quotientText.setText("Quotient:");
    }

    public void setNotDivisionOperation() {
        this.remainderValue.setText("");
        this.quotientValue.setText("");
        this.remainderText.setText("");
        this.quotientText.setText("");
    }

}
