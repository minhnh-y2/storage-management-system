/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.utils;

import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author MinhNH
 */
public class DoubleComparator implements Comparator<String> {
    
    private String pattern;
    
    public DoubleComparator(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public int compare(String o1, String o2) {
        Double n1 = XNumber.toDouble(o1, pattern);
        Double n2 = XNumber.toDouble(o2, pattern);
        return n1.compareTo(n2);
    }

    @Override
    public boolean equals(Object o2) {
        return this.equals(o2);
    }
    
}
