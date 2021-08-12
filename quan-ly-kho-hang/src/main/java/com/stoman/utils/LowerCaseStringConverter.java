/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.utils;

import javax.swing.table.TableModel;
import javax.swing.table.TableStringConverter;

/**
 *
 * @author MinhNH
 */
public class LowerCaseStringConverter extends TableStringConverter {

    @Override
    public String toString(TableModel model, int row, int column) {
        return model.getValueAt(row, column).toString().toLowerCase().replaceAll("[,.]", "");
    }
    
}
