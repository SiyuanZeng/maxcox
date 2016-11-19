package loli.datepicker;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractPicker implements loli.datepicker.Picker {

    protected String format;

    protected Popup popup;

    protected JTextArea field;

    protected loli.datepicker.DateFilter filter;

    public loli.datepicker.DateFilter getFilter() {
        return filter;
    }

    public String getFormat() {
        return format;
    }

    public Popup getPopup() {
        return popup;
    }

    public void setPopup(Popup popup) {
        this.popup = popup;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public JTextArea getField() {
        return field;
    }

    public void setField(JTextArea field) {
        this.field = field;
    }

    public void setFilter(DateFilter filter) {
        this.filter = filter;
    }

    public void close() {
        if (getPopup() != null) {
            getPopup().hide();
            setPopup(null);
            return;
        }
    }

    /**
     * Convert text of textfield to Date
     * 
     * @return Date shown at textfield or new Date if failed to parse
     */
    public Date getDate() {
        Date date = new Date();
        try {
            String dateText = field.getText();
            SimpleDateFormat fmt = new SimpleDateFormat(format);
            date = fmt.parse(dateText);
        } catch (Exception e) {
        }
        return date;
    }
}
