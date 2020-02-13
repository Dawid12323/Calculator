import models.MathOperation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CalculatorGUI {

    private double total1 = 0;
    private double total2 = 0;

    private JPanel panel1;
    private JButton a1Button;
    private JButton a2Button;
    private JTextField textField1;
    private JButton a3Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton a0Button;
    private JButton dodajButton;
    private JButton odejmijButton;
    private JButton ONButton;
    private JButton OFFButton;
    private JButton CLEARButton;
    private JButton pomnozButton;
    private JButton podzielButton;
    private JButton wynikButton;

    private List<MathOperation> operationList = new ArrayList<>();


    public CalculatorGUI() {
        //lol
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a1button = textField1.getText() + a1Button.getText();
                textField1.setText(a1button);
            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a2button = textField1.getText() + a2Button.getText();
                textField1.setText(a2button);
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a3button = textField1.getText() + a3Button.getText();
                textField1.setText(a3button);
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a4button = textField1.getText() + a4Button.getText();
                textField1.setText(a4button);
            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a5button = textField1.getText() + a5Button.getText();
                textField1.setText(a5button);
            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a6button = textField1.getText() + a6Button.getText();
                textField1.setText(a6button);
            }
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a7button = textField1.getText() + a7Button.getText();
                textField1.setText(a7button);
            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a8button = textField1.getText() + a8Button.getText();
                textField1.setText(a8button);
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a9button = textField1.getText() + a9Button.getText();
                textField1.setText(a9button);
            }
        });
        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a0button = textField1.getText() + a0Button.getText();
                textField1.setText(a0button);
            }
        });

        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String buttonText = dodajButton.getText();

//            buttonTextv hh

            }
        });
        odejmijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String button_text = odejmijButton.getText();
                getOperetor(button_text);
            }
        });
        wynikButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                switch (operationList.get(0)) {
                    case PLUS:
                        total2 = total1 + Double.parseDouble(textField1.getText());
                        break;
                    case MINUS:
                        total2 = total1 - Double.parseDouble(textField1.getText());
                        break;
//                    case '*':
//                        total2 = total1 * Double.parseDouble(textField1.getText());
//                        break;
//                    case '/':
//                        total2 = total1 / Double.parseDouble(textField1.getText());
//                        break;
                }
                textField1.setText(Double.toString(total2) );
                total1 = 0;
            }
        });
        CLEARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                total2 = 0;
                textField1.setText("");
            }
        });

        pomnozButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String button_text = pomnozButton.getText();
            getOperetor(button_text);
            }
        });
        podzielButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String button_text = podzielButton.getText();
            getOperetor(button_text);
            }
        });
    }

    private void getOperetor(String button_text) {
    }

    public JPanel getPanel() {
        return panel1;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
