/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Huy
 */
public class DateRenderer extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;
    private Date dateValue;
    private SimpleDateFormat sdfNewValue = new SimpleDateFormat("EE MMM dd hh:mm:ss z yyyy");
    private String valueToString = "";

    public DateRenderer(){
        super();
    }

    public DateRenderer(String format){
        super();
        sdfNewValue.applyPattern(format);
    }


    @Override
    public void setValue(Object value) {
        if ((value != null)) {
            String stringFormat = value.toString();
            try {
                dateValue = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH).parse(stringFormat);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            valueToString = sdfNewValue.format(dateValue);
            value = valueToString;
        }
        setText((value == null) ? "" : valueToString);

    }
}
