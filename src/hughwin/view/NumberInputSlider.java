package hughwin.view;

import javax.swing.*;

public class NumberInputSlider {

    private final JSlider slider;
    private JFormattedTextField field;
    private final JPanel numberInputSlider;
    private final int HIGHER_BOUND;
    private final int LOWER_BOUND;
    private final int INITIAL;

    public NumberInputSlider(String text, int lowerBound, int higherBound) {
        JPanel panel = new JPanel(); // flowLayout
        this.numberInputSlider = panel;
        this.LOWER_BOUND = lowerBound;
        this.HIGHER_BOUND = higherBound;
        this.INITIAL = higherBound / lowerBound;

        JLabel jLabel = new JLabel(text);

        JSlider slider = new JSlider(JSlider.HORIZONTAL, LOWER_BOUND, HIGHER_BOUND, INITIAL);
        this.slider = slider;
        slider.addChangeListener(e -> {
            JSlider source = (JSlider) e.getSource();
            if (!source.getValueIsAdjusting()) {
                int value = source.getValue();
                System.out.println(value);
            }
        });
        slider.setMinimum(LOWER_BOUND);
        slider.setMaximum(HIGHER_BOUND);
        slider.setValue(50);
        slider.setMajorTickSpacing(100);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintTrack(true);
        slider.setPaintLabels(true);

        panel.add(jLabel);
        panel.add(slider);
    }

    public JPanel getField() {
        return numberInputSlider;
    }

    public int getValue() {
        return slider.getValue();
    }

}
