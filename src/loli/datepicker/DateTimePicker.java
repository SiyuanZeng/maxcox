package loli.datepicker;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

import static zeng.siyuan.C1comehere.C1comehere.c1comehere;

public class DateTimePicker extends loli.datepicker.AbstractPicker {
    {
        format = "yyyy-MM-dd HH:mm:ss";
    }

    public DateTimePicker(final JTextArea field, String format,
            loli.datepicker.DateFilter filter) {
        this.field = field;
        if (format != null)
            this.format = format;
        if (filter == null) {
            filter = new BasicDateFilter();
        }
        this.filter = filter;

        this.field.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {

                String buttonSelected = "";
                for (Enumeration<AbstractButton> buttons = c1comehere.untoggle.bg.getElements(); buttons.hasMoreElements(); ) {
                    AbstractButton button = buttons.nextElement();

                    if (button.isSelected()) {
                        buttonSelected = button.getText();
                    }
                }
                boolean isHow2ForegertCommand = buttonSelected.equalsIgnoreCase("DcodeLSDjaf");

                if (isHow2ForegertCommand ) {

                    if (popup != null) {
                        popup.hide();
                        popup = null;
                        return;
                    }
                    loli.datepicker.DateTimePanel timePanel = new DateTimePanel(DateTimePicker.this);
                    PopupFactory factory = PopupFactory.getSharedInstance();
                    popup = factory.getPopup(field, timePanel, (int) field
                            .getLocationOnScreen().getX(), (int) field
                            .getLocationOnScreen().getY() + field.getHeight());
                    popup.show();
                }
            }
        });
    }

    public loli.datepicker.DateFilter getDateFilter() {
        return new BasicDateFilter();
    }

    public void set(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.getDate());

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date);

        cal.set(Calendar.YEAR, cal2.get(Calendar.YEAR));
        cal.set(Calendar.MONTH, cal2.get(Calendar.MONTH));
        cal.set(Calendar.DAY_OF_MONTH, cal2.get(Calendar.DAY_OF_MONTH));

        cal.set(Calendar.HOUR_OF_DAY, cal2.get(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal2.get(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal2.get(Calendar.SECOND));

        SimpleDateFormat fmt = new SimpleDateFormat(format);
        String result = fmt.format(cal.getTime());
        getField().setText(result);
    }
}
