/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.utils;

import java.awt.Component;
import javax.swing.JTable;

/**
 *
 * @author MinIT
 */
public class JSpinnerStringEditor extends JSpinnerEditor {
    private String pattern = "#,##0.0";        


    public JSpinnerStringEditor(double value, double minimum, double maximum, double stepSize, String pattern) {
        super(value, minimum, maximum, stepSize);
        this.pattern = pattern;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column){
        spinner.setValue(XNumber.toDouble(((String) value), pattern));
        return spinner;
    }

    @Override
    public Object getCellEditorValue(){
        return XNumber.toString((Double) spinner.getValue(), pattern);
    }
}
