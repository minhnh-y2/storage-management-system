/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author MinhNH
 */
public class XPassword {

    public static String getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return new String(salt, StandardCharsets.UTF_8);
    }

    /**
     * Tạo muối theo độ dài tuỳ ý
     */  
    public static String getSalt(int lenght) {
        String abcCapitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String abcLowerCase = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "01234567890123456789";
        String characters = "!@#$%^&*!@#$%%^^&*";

        String total = abcCapitals + abcLowerCase + numbers + characters;

        StringBuilder sb = new StringBuilder();

        char letters[] = new char[lenght];
        for (int i = 0; i < lenght; i++) {
            Random r = new Random();
            char letter = total.charAt(r.nextInt(total.length()));
            letters[i] = letter;
        }
        
        sb.append(letters);

        return sb.toString();
    }

    public static String getHashSHA512(String password, String salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
    
    public static boolean isValidated(String passwordInput, String passwordDB, String salt){
        String password = getHashSHA512(passwordInput, salt);
        return password.equals(passwordDB);
    }
    
}
