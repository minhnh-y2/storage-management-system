package com.stoman.ui;


import javax.swing.JFileChooser;
import java.io.File;

public class file_chooser {

    public file_chooser() {
    }

//Tao object Filechoser
    public static void main(String[] args) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File("fileToSave.txt"));
        int returnValue = fileChooser.showSaveDialog(null);

//Neu file duoc chon
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

//in thu duong dan file
            System.out.println("getPath : " + selectedFile.getPath());
            System.out.println("getAbsolutePath : " + selectedFile.getAbsolutePath());
            System.out.println("getName : " + selectedFile.getName());

            System.out.println("getName : " + fileChooser.getCurrentDirectory().getPath());
            String st = selectedFile.getPath();
            System.out.print("lay duong dan: " + st);
        }
    }
}
