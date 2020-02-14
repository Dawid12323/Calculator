import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CalculatorGUI extends JFrame implements ActionListener {

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


    private List<JButton> list = new ArrayList<>(); //co tu jest

    public CalculatorGUI() {
        initFrame();
        List<Component> tab = getAllComponents(panel1);

        for (Component component : tab) {
            if (component instanceof JButton && (component != OFFButton && component != ONButton)) {
                list.add((JButton) component);
            }
        }

        ONButton.addActionListener(this);
        OFFButton.addActionListener(this);
        initButtons();
    }

    private void initFrame() {
        this.setContentPane(panel1);
        this.setVisible(true);
        this.setSize(250, 250);
    }

    public List<Component> getAllComponents(Container container) {
        Component[] comps = container.getComponents();
        List<Component> compList = new ArrayList<>();
        for (Component comp : comps) {
            compList.add(comp);
            if (comp instanceof Container)
                compList.addAll(getAllComponents((Container) comp));
        }
        return compList;
    }

    private void initButtons() {
        if (!list.isEmpty() && list.get(0).getActionListeners().length == 0) {
            for (JButton button : list) {
                button.addActionListener(this);
            }
        }
    }

    private void removeListeners() {
        for (JButton button : list) {
            button.removeActionListener(this);
        }

    }
//    private void addListeners() {
//        for (JButton button : list) {
//            button.addActionListener(this);
//        }
//
//    }


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
        } else if (event.getSource() == CLEARButton) {
            resultField.setText("");
        } else if (event.getSource() == ONButton) {
            resultField.setText("");
            initButtons();
        } else if (event.getSource() == OFFButton) {
            resultField.setText("");
            removeListeners();
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
