/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.dao;

import java.util.List;

/**
 *
 * @author Huy
 */
public abstract class StoManDAO<E, K> {
    
    /**
     * Them moi thuc the vao CSDL
     * @param entity la thuc the chua bang ghi moi
     */
    abstract public void insert(E entity);
    
    /**
     * Cap nhat thuc the vao CSDL
     * @param entity la thuc the chua bang ghi can cap nhat
     */
    abstract public void update(E entity);
    
    /**
     * Xoa ban ghi khoi CSDL
     * @param key la ma dinh danh cua ban ghi can xoa
     */
    abstract public void delete(K key);
    
    /**
     * Truy van tat ca cac thuc the
     * @return danh sach tat ca thuc the trong CSDL
     */
    abstract public List<E> selectAll();
    
    /**
     * Truy van thuc the theo ma dinh danh
     * @param key la ma dinh danh cua thuc the
     * @return thuc the can truy van
     */
    abstract public E selectByID(K key);
    
    /**
     * Truy van thuc the theo cau lenh SQL
     * @param sql la cau lenh SQL
     * @param args la danh sach cac gia tri duoc cung cap cho cac tham so trong cau lenh SQL
     * @return danh sach thuc the can truy van
     */
    abstract protected List<E> selectBySQL(String sql, Object...args);
}
