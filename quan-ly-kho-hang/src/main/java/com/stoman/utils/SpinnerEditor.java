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
public class SpinnerEditor extends AbstractCellEditor implements TableCellEditor {
    JSpinner spinner = new JSpinner();

    public SpinnerEditor(double value, double minimum, double maximum, double stepSize){
        spinner = new JSpinner(new SpinnerNumberModel(value, minimum, maximum, stepSize));
        spinner.setBorder(null);
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column){
        spinner.setValue(XNumber.toDouble(((String) value),"#,##0.0"));
        return spinner;
    }

    public Object getCellEditorValue(){
        return XNumber.toString((Double) spinner.getValue(), "#,##0.0");
    }
}