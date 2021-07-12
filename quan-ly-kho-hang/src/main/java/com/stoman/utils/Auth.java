/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.utils;

import com.stoman.entity.NhanVien;

/**
 *
 * @author Huy
 */
public class Auth {
    public static NhanVien user = null;
    
    /**
     * xoa bo nguoi dung hien tai
     */
    public static void clear(){
        Auth.user = null;
    }
    
    /**
     * kiem tra dang nhap hay chua
     * @return 
     */
    public static boolean isLogin(){
        return Auth.user != null;
    }
    
    /**
     * kiem tra nguoi dung co phai Truong Phong
     * @return 
     */
    public static boolean isManager(){
        return Auth.isLogin() && user.isVaiTRo();
    }
}
