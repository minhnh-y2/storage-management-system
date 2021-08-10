/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.SwingConstants;

/**
 *
 * @author MinhNH
 */
public class NumberRenderer extends FormatRenderer {

    public NumberRenderer(NumberFormat formatter) {
        super(formatter);
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    public static NumberRenderer getCurrencyRenderer() {
        return new NumberRenderer(NumberFormat.getCurrencyInstance());
    }

    public static NumberRenderer getIntegerRenderer() {
        return new NumberRenderer(NumberFormat.getIntegerInstance());
    }

    public static NumberRenderer getPercentRenderer() {
        return new NumberRenderer(NumberFormat.getPercentInstance());
    }
    
    public static NumberRenderer getNumberRenderer(String pattern) {
        return new NumberRenderer(new DecimalFormat(pattern));
    }
}
