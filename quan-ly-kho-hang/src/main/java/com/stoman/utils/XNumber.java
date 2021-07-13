/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.utils;

import java.text.DecimalFormat;
import java.text.ParseException;

/**
 *
 * @author Huy
 */
public class XNumber {
    private static DecimalFormat formater = new DecimalFormat();
    
    /**
     * chuyển chuỗi thành kiểu số
     * @param num chuổi số
     * @return giá trị số
     */
    public static Double toDouble(String num, String pattern){
        try{
            formater.applyPattern(pattern);
            return formater.parse(num).doubleValue();
        } catch (ParseException e){
            throw new RuntimeException(e);
        }
    }
    
    /**
     * chuyển số thành chuổi theo kiểu
     * @param num giá trị số cần chuyển đổi
     * @param format kiểu biến đổi
     * @return chuổi đã biến đổi từ số 
     */
    public static String toString(Double num, String pattern){
        if(num == null) return null;
        formater.applyPattern(pattern);

        return formater.format(num);
    }
}
