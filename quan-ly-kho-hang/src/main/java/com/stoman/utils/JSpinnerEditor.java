/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.utils;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Huy
 */
public class JSpinnerEditor extends AbstractCellEditor implements TableCellEditor {
    JSpinner spinner = new JSpinner();
    private double newValue;
    private double oldValue;
    
    
    public JSpinnerEditor(double value, double minimum, double maximum, double stepSize){
        spinner = new JSpinner(new SpinnerNumberModel(value, minimum, maximum, stepSize));
        spinner.setBorder(null);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column){
        spinner.setValue(value);
        oldValue = (Double) value;
        return spinner;
    }

    @Override
    public Object getCellEditorValue(){
        newValue = (Double) spinner.getValue();
        return newValue;
    }

    public double getNewValue() {
        return newValue;
    }

    public double getOldValue() {
        return oldValue;
    }  
    
}