/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.utils;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author MinhNH
 */
public class TableNumberCellRenderer extends DefaultTableCellRenderer {

    private Format formatter;

    public TableNumberCellRenderer(NumberFormat formatter) {
        this.formatter = formatter;
        setHorizontalAlignment(SwingConstants.CENTER);
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

    public static TableNumberCellRenderer getCurrencyRenderer() {
        return new TableNumberCellRenderer(NumberFormat.getCurrencyInstance());
    }

    public static TableNumberCellRenderer getIntegerRenderer() {
        return new TableNumberCellRenderer(NumberFormat.getIntegerInstance());
    }

    public static TableNumberCellRenderer getPercentRenderer() {
        return new TableNumberCellRenderer(NumberFormat.getPercentInstance());
    }

    public static TableNumberCellRenderer getDoubleRenderer(String pattern) {
        return new TableNumberCellRenderer(new DecimalFormat(pattern));
    }
}
