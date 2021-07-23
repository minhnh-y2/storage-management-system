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

/**
 *
 * @author MinhNH
 */
public class XPassword {

    public static byte [] getSalt() {
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
    
    /**
     *
     * @param password: mật khẩu chưa muối
     * @param salt: muối
     * @return: mật khẩu muối
     */
    public static String getHashMD5(String password, byte [] salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(salt);
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

    /**
     *
     * @param passwordInput: mật khẩu người dùng nhập vào
     * @param passwordBD: mật khẩu xác minh lấy từ Database
     * @param salt: muối mật khấu
     * @return kết quả xác thực mật khẩu người dùng nhập vào
     */
    public static boolean isValidated(String passwordInput, String passwordBD, byte [] salt){
        String password = getHashMD5(passwordInput, salt);
        return password.equals(passwordBD);
    }
    
}
