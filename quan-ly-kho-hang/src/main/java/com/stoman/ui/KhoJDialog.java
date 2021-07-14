/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.ui;

import com.stoman.dao.KhoDAO;
import com.stoman.entity.Kho;
import com.stoman.utils.Auth;
import com.stoman.utils.MsgBox;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MinhNH
 */
public class KhoJDialog extends javax.swing.JDialog {

    /**
     * Creates new form KhoJDialog
     */
    public KhoJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlThongTinKho = new javax.swing.JPanel();
        lblMaKho = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        pnlTxtDiaChi = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        txtMaKho = new javax.swing.JFormattedTextField();
        pnlChucNang = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        lblTimKiem = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        pnlTblKho = new javax.swing.JScrollPane();
        tblKho = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("StoMan - Quản lý kho");

        pnlThongTinKho.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin kho", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        lblMaKho.setText("Kho số");

        lblDiaChi.setText("Địa chỉ");

        txtDiaChi.setColumns(20);
        txtDiaChi.setLineWrap(true);
        txtDiaChi.setRows(5);
        txtDiaChi.setWrapStyleWord(true);
        pnlTxtDiaChi.setViewportView(txtDiaChi);

        txtMaKho.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout pnlThongTinKhoLayout = new javax.swing.GroupLayout(pnlThongTinKho);
        pnlThongTinKho.setLayout(pnlThongTinKhoLayout);
        pnlThongTinKhoLayout.setHorizontalGroup(
            pnlThongTinKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinKhoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDiaChi)
                    .addComponent(lblMaKho))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlThongTinKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTxtDiaChi)
                    .addGroup(pnlThongTinKhoLayout.createSequentialGroup()
                        .addComponent(txtMaKho, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlThongTinKhoLayout.setVerticalGroup(
            pnlThongTinKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinKhoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaKho)
                    .addComponent(txtMaKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlThongTinKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinKhoLayout.createSequentialGroup()
                        .addComponent(lblDiaChi)
                        .addGap(0, 57, Short.MAX_VALUE))
                    .addComponent(pnlTxtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlChucNang.setLayout(new java.awt.GridLayout(1, 0));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/stoman/icons/add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        pnlChucNang.add(btnThem);

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/stoman/icons/cancel.png"))); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        pnlChucNang.add(btnXoa);

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/stoman/icons/edit-property.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        pnlChucNang.add(btnSua);

        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/stoman/icons/new-document.png"))); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });
        pnlChucNang.add(btnMoi);

        lblTimKiem.setText("Tìm kiếm");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
        });

        tblKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKho.getTableHeader().setReorderingAllowed(false);
        tblKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhoMouseClicked(evt);
            }
        });
        pnlTblKho.setViewportView(tblKho);
        if (tblKho.getColumnModel().getColumnCount() > 0) {
            tblKho.getColumnModel().getColumn(0).setResizable(false);
            tblKho.getColumnModel().getColumn(1).setResizable(false);
            tblKho.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiem))
                    .addComponent(pnlTblKho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pnlThongTinKho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlThongTinKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTimKiem)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(pnlTblKho, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblKhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhoMouseClicked
        // TODO add your handling code here:
        this.row = tblKho.getSelectedRow();
        this.edit();
    }//GEN-LAST:event_tblKhoMouseClicked

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
        // TODO add your handling code here:
        fillToTable();
        clearForm();
    }//GEN-LAST:event_txtTimKiemKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KhoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                KhoJDialog dialog = new KhoJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblMaKho;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JPanel pnlChucNang;
    private javax.swing.JScrollPane pnlTblKho;
    private javax.swing.JPanel pnlThongTinKho;
    private javax.swing.JScrollPane pnlTxtDiaChi;
    private javax.swing.JTable tblKho;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JFormattedTextField txtMaKho;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    private KhoDAO DAO;
    private DefaultTableModel model;
    private int row = -1;

    void init() {
        setLocationRelativeTo(null);

        this.DAO = new KhoDAO();
        this.model = (DefaultTableModel) tblKho.getModel();
        this.model.setColumnIdentifiers(new Object[]{
            "Mã kho", "Địa chỉ"
        });
        tblKho.getColumnModel().getColumn(0).setMaxWidth(60);
        tblKho.setAutoCreateRowSorter(true);

        this.fillToTable();
        this.updateStatus();
    }

    void fillToTable() {
        model.setRowCount(0);
        String keyword = txtTimKiem.getText();
        try {
            List<Kho> list = DAO.selectByKeyword(keyword);
            for (Kho k : list) {
                model.addRow(new Object[]{
                    k.getMaKho(),
                    k.getDiaChi()
                });
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
            e.printStackTrace();
        }
    }

    void updateStatus() {
        boolean edit = (this.row >= 0);

        txtMaKho.setEditable(!edit);
        btnThem.setEnabled(!edit);
        btnSua.setEnabled(edit);
        btnXoa.setEnabled(edit);
    }

    Kho getForm() {
        Kho k = new Kho();
        k.setMaKho(Integer.parseInt(txtMaKho.getText()));
        k.setDiaChi(txtDiaChi.getText());
        k.setMaTK(Auth.user.getMaNV());
        return k;
    }

    void setForm(Kho k) {
        txtMaKho.setText(String.valueOf(k.getMaKho()));
        txtDiaChi.setText(k.getDiaChi());
    }

    void clearForm() {
        txtMaKho.setText("");
        txtDiaChi.setText("");
        tblKho.clearSelection();
        this.row = -1;
        this.updateStatus();
    }

    void edit() {
        int maKho = (int) tblKho.getValueAt(this.row, 0);
        Kho k = DAO.selectByID(maKho);
        this.setForm(k);
        this.updateStatus();
    }

    boolean isValidated() {
        if (txtMaKho.getText().isEmpty()) {
            MsgBox.alert(this, "Chưa nhập số kho!");
        } else if (txtDiaChi.getText().isEmpty()) {
            MsgBox.alert(this, "Chưa nhập địa chỉ!");
        } else {
            return true;
        }
        return false;
    }
    
    void insert() {
        if(isValidated()){
            Kho k = getForm();
            try {
                DAO.insert(k);
                this.fillToTable();
                this.clearForm();
                MsgBox.alert(this, "Thêm mới thành công!");
            } catch (Exception e) {
                MsgBox.alert(this, "Thêm mới thất bại!");
                e.printStackTrace();
            }
        }
    }
    
    void update() {
        if(isValidated()) {
            Kho k = getForm();
            try {
                DAO.update(k);
                this.fillToTable();
                MsgBox.alert(this, "Cập nhật thành công!");
            } catch (Exception e) {
                MsgBox.alert(this, "Cập nhật thất bại!");
                e.printStackTrace();
            }
        }
    }
    
    void delete() {
        if(!Auth.isManager()){
            MsgBox.alert(this, "Bạn không có quyền xoá kho!");
        } else if (MsgBox.confirm(this, "Bạn có chắc chắn muốn xoá kho hàng này?")) {
            int maKho = (int) tblKho.getValueAt(this.row, 0);
            try {
                DAO.delete(maKho);
                this.fillToTable();
                this.clearForm();
                MsgBox.alert(this, "Xoá kho thành công!");
            } catch (Exception e) {
                MsgBox.alert(this, "Xoá kho thất bại!");
                e.printStackTrace();
            }
        }
    }

}
