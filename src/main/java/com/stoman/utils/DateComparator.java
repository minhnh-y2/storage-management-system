/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

/**
 *
 * @author MinhNH
 */
public class DateComparator implements Comparator<String> {
    private String pattern;
    private DateTimeFormatter formatter;
    
    public DateComparator(String pattern) {
        this.pattern = pattern;
        formatter = DateTimeFormatter.ofPattern(pattern);
    }

    @Override
    public int compare(String o1, String o2) {
        LocalDate ld1 = LocalDate.parse(o1, formatter);
        LocalDate ld2 = LocalDate.parse(o2, formatter);
        return ld1.compareTo(ld2);
    }

    @Override
    public boolean equals(Object o2) {
        return this.equals(o2);
    }
    
}
