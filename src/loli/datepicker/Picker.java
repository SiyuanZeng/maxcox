package loli.datepicker;

import javax.swing.*;
import java.util.Date;

public interface Picker {

    Date getDate();

    JTextArea getField();

    Popup getPopup();

    void setPopup(Popup popup);

    DateFilter getDateFilter();

    void set(Date date);
    
    void close();
    
    String getFormat();
}
