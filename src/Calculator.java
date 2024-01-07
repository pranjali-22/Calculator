import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
    JFrame jFrame;
    JTextField jTextField;
    JPanel jPanel;
    JButton[] numButtons = new JButton[10];
    JButton piButton;
    JButton addButton,subButton,mulButton,divButton,equButton,delButton,clrButton,deciButton,negButton;
    Font font = new Font("", Font.PLAIN,40);
    double num1 = 0, num2 = 0, result = 0;
    char op;
    Calculator() {
        jFrame = new JFrame("CALCULATOR");
        jFrame.setLocation(60,60);
        jFrame.setSize(500,600);
        jFrame.setLayout(null);

        addtextfield();
        addPanel();
        addButtons();

        jFrame.setVisible(true);
    }
    public void addtextfield() {
        jTextField = new JTextField();
        jTextField.setFont(font);
        jTextField.setBounds(20,20,450,50);
        jTextField.setEditable(false);
        jFrame.add(jTextField);
    }
    public void addPanel() {
        jPanel = new JPanel();
        jPanel.setBounds(20,90,450,450);
        jPanel.setBackground(Color.GRAY);
        jPanel.setLayout(new GridLayout(5,4,10,10));

        jFrame.add(jPanel);
    }
    public void addButtons() {
        for(int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(Integer.toString(i));
            numButtons[i].addActionListener(this);
        }


        piButton = new JButton("π");
        addButton = new JButton("+");
        subButton = new JButton("-");
        addButton.setSize(10,10);
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equButton = new JButton("=");
        delButton = new JButton("⌫");
        clrButton = new JButton("C");
        deciButton = new JButton(".");
        negButton = new JButton("(-)");
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        piButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        delButton.addActionListener(this);
        equButton.addActionListener(this);
        clrButton.addActionListener(this);
        deciButton.addActionListener(this);
        negButton.addActionListener(this);
        jPanel.add(numButtons[1]);
        jPanel.add(numButtons[2]);
        jPanel.add(numButtons[3]);
        jPanel.add(addButton);
        jPanel.add(numButtons[4]);
        jPanel.add(numButtons[5]);
        jPanel.add(numButtons[6]);
        jPanel.add(subButton);
        jPanel.add(numButtons[7]);
        jPanel.add(numButtons[8]);
        jPanel.add(numButtons[9]);
        jPanel.add(mulButton);
        jPanel.add(numButtons[0]);
        jPanel.add(deciButton);
        jPanel.add(equButton);
        jPanel.add(divButton);
        jPanel.add(delButton);
        jPanel.add(clrButton);
        jPanel.add(negButton);
        jPanel.add(piButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 10; i++) {
            if(e.getSource() == numButtons[i]) {
                jTextField.setText(jTextField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == addButton) {
            num1 = Double.parseDouble(jTextField.getText());
            op = '+';
            jTextField.setText("");
        }
        if(e.getSource() == subButton) {
            num1 = Double.parseDouble(jTextField.getText());
            op = '-';
            jTextField.setText("");
        }
        if(e.getSource() == mulButton) {
            num1 = Double.parseDouble(jTextField.getText());
            op = '*';
            jTextField.setText("");
        }
        if(e.getSource() == divButton) {
            num1 = Double.parseDouble(jTextField.getText());
            op = '/';
            jTextField.setText("");
        }
        if(e.getSource() == deciButton) {
            num1 = Double.parseDouble(jTextField.getText());
            op = '.';
            jTextField.setText("");
        }
        if(e.getSource() == piButton) {
            num1 = 3.141;
            jTextField.setText("3.141");
        }
        if(e.getSource() == delButton) {
            String string = jTextField.getText();
            jTextField.setText("");
            for(int i = 0; i < string.length() - 1; i++) {
                jTextField.setText(jTextField.getText()+string.charAt(i));
            }

        }
        if(e.getSource() == clrButton) {
            jTextField.setText("");

        }
        if(e.getSource() == equButton) {
            num2 = Double.parseDouble(jTextField.getText());
            switch (op)  {
                case '+':
                    result = num1+num2;
                    break;
                case '-':
                    result = num1-num2;
                    break;
                case '*':
                    result = num1*num2;
                    break;
                case '/':
                    result = num1/num2;
                    break;
            }
            jTextField.setText(Double.toString(result));
        }
        if(e.getSource() == deciButton) {
            jTextField.setText(jTextField.getText().concat("."));
        }
        if(e.getSource() == negButton) {
            double i = Double.parseDouble(jTextField.getText());
            i = i*-1;
            jTextField.setText(Double.toString(i));
        }


    }
}
