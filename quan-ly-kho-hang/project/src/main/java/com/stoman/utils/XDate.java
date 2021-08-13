/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 *
 * @author Huy
 */
public class XDate {
    private static SimpleDateFormat formater = new SimpleDateFormat();
    
    /**
     * Bien doi chuoi thanh kieu du lieu ngay thang
     * @param date chuoi the hien ngay
     * @param pattern dinh dang ngay cua chuoi
     * @return kieu du lieu ngay thang
     */
    public static Date toDate(String date, String pattern){
        try{
            formater.applyPattern(pattern);
            return formater.parse(date);
        } catch (ParseException e){
            throw new IllegalArgumentException(e);
        }
    }
    
    
    /**
     * Bien doi kieu du lieu ngay thanh kieu chuoi
     * @param date du lieu ngay can bien doi
     * @param pattern dinh dang ngay
     * @return kieu chuoi cua du lieu ngay theo dinh dang da cho
     */
    public static String toString(Date date, String pattern){
        if(date == null) return null;
        formater.applyPattern(pattern);
        return formater.format(date);
    }
    
    /**
     * 
     * @param date
     * @param days
     * @return 
     */
    public static Date addDays(Date date, long days){
        date.setTime(date.getTime() + days*24*60*60*1000);
        return date;
    }
    
    /**
     * Hàm hổ trợ tính tuổi
     * @param birthDate ngày sinh
     * @return tuổi
     */
    public static int calculateAge(Date birthDate) {
        LocalDate birth = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate today = LocalDate.now();
        Period age = Period.between(birth, today);
        return age.getYears();
    }
    
    /**
     * Hàm hổ trợ tính ngày kể từ ngày hôm nay
     * @param date
     * @return 
     */
    public static long calculateDayBetween(Date Sdate, Date Edate) {
        LocalDate start = Sdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate end = Edate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return ChronoUnit.DAYS.between(start, end);
    }
}
