package loli.datepicker;

import javax.swing.*;

public class DateTimePanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private loli.datepicker.DatePanel datePanel;
    private loli.datepicker.TimePanel timePanel;

    public DateTimePanel(loli.datepicker.Picker picker) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        datePanel = new DatePanel(picker);
        timePanel = new TimePanel(picker);
        add(datePanel);
        add(timePanel);
    }

}
