package hughwin.view;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

public class NumberInputField {

    private JFormattedTextField field;
    private JPanel numberInputPanel;

    public NumberInputField(String text){
        JPanel panel = new JPanel(); // flowLayout
        this.numberInputPanel = panel;

        JLabel jLabel = new JLabel(text);

        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        // If you want the value to be committed on each keystroke instead of focus lost
        formatter.setCommitsOnValidEdit(true);
        JFormattedTextField field = new JFormattedTextField(formatter);
        field.setText("");
        field.setColumns(30);
        this.field = field;

        panel.add(jLabel);
        panel.add(this.field);
    }

    public JPanel getField (){
        return numberInputPanel;
    }

    public int getInteger() {
        String noCommas = field.getText().replace(",", "").trim();
        return Integer.parseInt(noCommas);
    }

}
