/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.utils;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author Huy
 */
public class XImages {
    
    /**
     * lay icon cua chuong trinh tu file
     * @return icon cua chuong trinh
     */
    public static Image getAppIcon(){
        URL url = XImages.class.getResource("/com/stoman/icons/logo.png");
        return new ImageIcon(url).getImage();
    }
    
    /**
     * Luu file vao duong dan
     * @param src duong dan noi se luu file
     */
    public static void save(File src) {
        File dst = new File("logos", src.getName());
        if(!dst.getParentFile().exists()){
            dst.getParentFile().mkdirs();
        }
        
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Lay icon tu file da duoc chon
     * @param fileName duong dan den file duoc chon
     * @return icon
     */
    public static ImageIcon read(String fileName) {
        File path = new File ("logos", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }
    
    public static ImageIcon getImageScale(ImageIcon imageIcon, int w, int h) {
        Image image = imageIcon.getImage();
        Image imageScale = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return new ImageIcon(imageScale);
    }
}
