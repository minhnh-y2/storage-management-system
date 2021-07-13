/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.utils;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Huy
 */
public class MsgBox {
    
    /**
     * form thong bao
     * @param parent
     * @param message 
     */
    public static void alert(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message,
                "Hệ thống quản lý kho hàng", 
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * form xac nhan
     * @param parent
     * @param message
     * @return 
     */
    public static boolean confirm (Component parent, String message) {
        int result = JOptionPane.showConfirmDialog(parent, message,
                "Hệ thống quản lý kho hàng",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        
        return result == JOptionPane.YES_OPTION;
    }
    
    /**
     * form thong bao nhap du lieu
     * @param parent
     * @param message
     * @return 
     */
    public static String prompt(Component parent, String message) {
        return JOptionPane.showInputDialog(parent, message,
                "Hệ thống quản lý kho hàng", 
                JOptionPane.INFORMATION_MESSAGE);
    }

}
