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

    public SpinnerEditor(){
        spinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 0.01));
        spinner.setBorder(null);
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column){
        spinner.setValue(Double.parseDouble((String) value));
        return spinner;
    }

    public Object getCellEditorValue(){
        return spinner.getValue().toString();
    }
}