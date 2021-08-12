/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 *
 * @author MinhNH
 */
public class JTextFieldCustom extends JTextField {
    public JTextFieldCustom() {
        selectAllText();
    }

    public JTextFieldCustom(String defaultSearchText) {
        selectAllText();
        searchBox(defaultSearchText);
    }

    private void selectAllText() {
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {
                selectAll();
            }
        });
    }

    private void searchBox(String defaultSearchText) {
        setPreferredSize(new Dimension(64, 24));
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        setText(defaultSearchText);
        setBackground(new Color(0, 0, 0, 0));
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {
                if(getText().equals(defaultSearchText)){
                    setText("");
                }
            }
        });
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if(getText().isEmpty()) {
                    setText(defaultSearchText);
                }
            }
            
        });
    }
    
}
