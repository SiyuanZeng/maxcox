package loli.datepicker;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatePicker extends AbstractPicker {
    /*
     * Default date format
     */

    {
        format = "yyyy-MM-dd";
    }

    private SimpleDateFormat simpleDateFormat;

    private boolean setTimeAtSetup = false;

    /**
     * Get text of text field
     * 
     * @return text of text field
     */
    public String getDateText() {
        return this.field.getText();
    }

    /**
     * @param field
     *            to add to
     * @param format
     *            date format
     */
    public DatePicker(final JTextArea field, String format, loli.datepicker.DateFilter filter) {
        this.field = field;
        if (format != null) {
            this.format = format;
        }
        this.filter = filter;
        simpleDateFormat = new SimpleDateFormat(this.format);
        if (setTimeAtSetup)
            this.field.setText(simpleDateFormat.format(new Date()));

        this.field.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                if (popup != null) {
                    popup.hide();
                    popup = null;
                    return;
                }
                loli.datepicker.DatePanel timePanel = new loli.datepicker.DatePanel(DatePicker.this);
                PopupFactory factory = PopupFactory.getSharedInstance();

                popup = factory.getPopup(field, timePanel, (int) field
                        .getLocationOnScreen().getX(), (int) field
                        .getLocationOnScreen().getY() + field.getHeight());
                popup.show();
            }
        });
    }

    public DatePicker(JTextArea field) {
        this(field, null, new BasicDateFilter());
    }

    public static SimpleDateFormat getDateFormat(String format) {
        return new SimpleDateFormat(format);
    }

    /**
     * Get year val from text field
     * 
     * @return year val
     */
    public int getShowYear() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getDate());
        return cal.get(Calendar.YEAR);
    }

    /**
     * Get month val from text field
     * 
     * @return month val
     */
    public int getShowMonth() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getDate());
        return cal.get(Calendar.MONDAY);
    }

    /**
     * Set date to text field
     * 
     * @param year
     *            year to set
     * @param month
     *            month to set
     * @param day
     *            day to set
     */
    void selectDay(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);
        Date date = cal.getTime();
        this.field.setText(simpleDateFormat.format(date));
        if (popup != null) {
            popup.hide();
            popup = null;
        }
    }

    /**
     * Add a date picker to a text field
     * 
     * @param field
     *            the text field you want to add to
     */
    public static void datePicker(JTextArea field) {
        datePicker(field, null);
    }

    /**
     * Add a date picker to a text field with date format
     * 
     * @param field
     *            the text field you want to add to
     * @param format
     *            date format string
     */
    public static void datePicker(JTextArea field, String format) {
        new DatePicker(field, format, new BasicDateFilter());
    }

    /**
     * Add a date picker to a text field with date format
     * 
     * @param field
     *            the text field you want to add to
     * @param format
     *            date format string
     * @param filter
     *            filter
     */
    public static void datePicker(JTextArea field, String format,
            loli.datepicker.DateFilter filter) {
        new DatePicker(field, format, filter);
    }

    /**
     * Add a time picker to a text field
     * 
     * @param field
     *            the text field you want to add to
     */
    public static void timePicker(JTextArea field) {
        timePicker(field, null);
    }

    /**
     * Add a time picker to a text field with time format
     * 
     * @param field
     *            the text field you want to add to
     * @param format
     *            time format string
     */
    public static void timePicker(JTextArea field, String format) {
        new TimePicker(field, format);
    }

    /**
     * Add a date time picker to a text field
     * 
     * @param field
     *            the text field you want to add to
     */
    public static void dateTimePicker(JTextArea field) {
        dateTimePicker(field, null);
    }

    /**
     * Add a date time picker to a text field with time format
     * 
     * @param field
     *            the text field you want to add to
     * @param format
     *            date time format string
     */
    public static void dateTimePicker(JTextArea field, String format) {
        dateTimePicker(field, format, new BasicDateFilter());
    }

    /**
     * Add a time picker to a text field with time format
     * 
     * @param field
     *            the text field you want to add to
     * @param format
     *            time format string
     * @param filter
     *            to make some days unclickable
     */
    public static void dateTimePicker(JTextArea field, String format,
            loli.datepicker.DateFilter filter) {
        new DateTimePicker(field, format, filter);
    }

    public loli.datepicker.DateFilter getDateFilter() {
        return filter;
    }

    public void set(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.getDate());

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date);

        cal.set(Calendar.YEAR, cal2.get(Calendar.YEAR));
        cal.set(Calendar.MONTH, cal2.get(Calendar.MONTH));
        cal.set(Calendar.DAY_OF_MONTH, cal2.get(Calendar.DAY_OF_MONTH));

        this.field.setText(simpleDateFormat.format(cal.getTime()));
        close();
    }

}
