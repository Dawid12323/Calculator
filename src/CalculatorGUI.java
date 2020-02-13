import models.MathOperation;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CalculatorGUI implements ActionListener {

    private double total1 = 0.0;
    private double total2 = 0.0;

    private JPanel panel1;
    private JButton a1Button;
    private JButton a2Button;
    private JTextField resultField;
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

    private boolean isFunctionChar = false;

    private List<MathOperation> operationList = new ArrayList<>();


    public CalculatorGUI() {


        initButtons();

//        wynikButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//
//                String buttonText = wynikButton.getText();
//
//                switch (operationList.get(0)) {
//                    case PLUS:
//                        total2 = total1 + Double.parseDouble(resultField.getText());
//                        break;
//                    case MINUS:
//                        total2 = total1 - Double.parseDouble(resultField.getText());
//                        break;
//                    case MULTIPLIED:
//                        total2 = total1 * Double.parseDouble(resultField.getText());
//                        break;
//                    case SHARE:
//                        total2 = total1 / Double.parseDouble(resultField.getText());
//                        break;
//                }
//                resultField.setText(Double.toString(total2));
//                total1 = 0;
//
//
//            }
//        });
        CLEARButton.addActionListener(e -> {
            total2 = 0;
            resultField.setText("");
        });

        OFFButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a1Button.removeActionListener(this);
                a2Button.removeActionListener(this);
                a3Button.removeActionListener(this);
                a4Button.removeActionListener(this);
                a5Button.removeActionListener(this);
                a6Button.removeActionListener(this);
                a7Button.removeActionListener(this);
                a8Button.removeActionListener(this);
                a9Button.removeActionListener(this);
                a0Button.removeActionListener(this);
                dodajButton.removeActionListener(this);
                odejmijButton.removeActionListener(this);
                pomnozButton.removeActionListener(this);
                podzielButton.removeActionListener(this);
                wynikButton.removeActionListener(this);
            }
        });
    }
    private void initButtons() {
        a1Button.addActionListener(this);
        a2Button.addActionListener(this);
        a3Button.addActionListener(this);
        a4Button.addActionListener(this);
        a5Button.addActionListener(this);
        a6Button.addActionListener(this);
        a7Button.addActionListener(this);
        a8Button.addActionListener(this);
        a9Button.addActionListener(this);
        a0Button.addActionListener(this);
        dodajButton.addActionListener(this);
        odejmijButton.addActionListener(this);
        pomnozButton.addActionListener(this);
        podzielButton.addActionListener(this);
        wynikButton.addActionListener(this);

    }


    public JPanel getPanel() {
        return panel1;
    }

    private void onNumericButtonClick(JButton button) {
        String buttonText = button.getText();
        resultField.setText(resultField.getText() + buttonText);
        isFunctionChar = false;
    }




    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == odejmijButton || event.getSource() == dodajButton || event.getSource() == pomnozButton || event.getSource() == podzielButton) {
            onFunctionButtonClick((JButton) event.getSource());
        } else if (event.getSource() == wynikButton) {
            createResult();
        } else {
            onNumericButtonClick((JButton) event.getSource());
        }
    }


    private void createResult() {
        String tmp = resultField.getText();
        if (isFunctionChar) {
            tmp = tmp.substring(0, tmp.length() - 1);
        }

        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");

        try {
            resultField.setText(engine.eval(tmp).toString());
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
    private void onFunctionButtonClick(JButton source) {
        if (!isFunctionChar) {
            isFunctionChar = true;
            resultField.setText(resultField.getText() + source.getText());
        } else {
            String result = resultField.getText();
            result = result.substring(0, result.length() - 1);
            resultField.setText(result + source.getText());
        }

    }

}
