/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.utils;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author MinhNH
 */
public class FormatRenderer extends DefaultTableCellRenderer {

    private Format formatter;

    public FormatRenderer(Format formatter) {
        this.formatter = formatter;
    }

    @Override
    public void setValue(Object value) {
        try {
            if (value != null) {
                value = formatter.format(value);
            }
        } catch (IllegalArgumentException e) {
        }

        super.setValue(value);
    }

    public static FormatRenderer getDateTimeRenderer() {
        return new FormatRenderer(DateFormat.getDateTimeInstance());
    }

    public static FormatRenderer getTimeRenderer() {
        return new FormatRenderer(DateFormat.getTimeInstance());
    }
    
    public static FormatRenderer getDateRenderer(String pattern) {
        return new FormatRenderer(new SimpleDateFormat(pattern));
    }
    
}
