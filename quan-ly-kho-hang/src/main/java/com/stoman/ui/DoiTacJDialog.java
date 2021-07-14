/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.ui;

import com.stoman.dao.DoiTacDAO;
import com.stoman.dao.LoaiDoiTacDAO;
import com.stoman.entity.DoiTac;
import com.stoman.entity.LoaiDoiTac;
import com.stoman.utils.Auth;
import com.stoman.utils.MsgBox;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MinhNH
 */
public class DoiTacJDialog extends javax.swing.JDialog {

    /**
     * Creates new form DoiTacJDialog
     */
    public DoiTacJDialog(java.awt.Frame parent, boolean modal) {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlLoaiDoiTac = new javax.swing.JPanel();
        pnlLstLoaiDoiTac = new javax.swing.JScrollPane();
        lstLDT = new javax.swing.JList<>();
        pnlButtonLoaiDT = new javax.swing.JPanel();
        btnThemList = new javax.swing.JButton();
        btnXoaList = new javax.swing.JButton();
        pnlThongTinDoiTac = new javax.swing.JPanel();
        lblTenDT = new javax.swing.JLabel();
        txtTenDT = new javax.swing.JTextField();
        lblDiaChi = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblDienThoai = new javax.swing.JLabel();
        txtDienThoai = new javax.swing.JTextField();
        lblVaiTro = new javax.swing.JLabel();
        rdoKhachHang = new javax.swing.JRadioButton();
        rdoNhaPhanPhoi = new javax.swing.JRadioButton();
        pnlChucNang = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        pnlChuyen = new javax.swing.JPanel();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        lblTimKiem = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        pnlTblDoiTac = new javax.swing.JScrollPane();
        tblDoiTac = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("StoMan - Quản lý đối tác");
        setAlwaysOnTop(true);

        pnlLoaiDoiTac.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Loại đối tác", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N
        pnlLoaiDoiTac.setLayout(new java.awt.BorderLayout());

        lstLDT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstLDTMouseClicked(evt);
            }
        });
        pnlLstLoaiDoiTac.setViewportView(lstLDT);

        pnlLoaiDoiTac.add(pnlLstLoaiDoiTac, java.awt.BorderLayout.CENTER);

        pnlButtonLoaiDT.setLayout(new java.awt.GridLayout(1, 0));

        btnThemList.setText("Thêm");
        btnThemList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemListActionPerformed(evt);
            }
        });
        pnlButtonLoaiDT.add(btnThemList);

        btnXoaList.setText("Xoá");
        btnXoaList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaListActionPerformed(evt);
            }
        });
        pnlButtonLoaiDT.add(btnXoaList);

        pnlLoaiDoiTac.add(pnlButtonLoaiDT, java.awt.BorderLayout.PAGE_END);

        pnlThongTinDoiTac.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin đối tác", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        lblTenDT.setText("Tên đối tác");

        lblDiaChi.setText("Địa chỉ");

        lblEmail.setText("Email");

        lblDienThoai.setText("Số điện thoại");

        lblVaiTro.setText("Vai trò");

        buttonGroup1.add(rdoKhachHang);
        rdoKhachHang.setSelected(true);
        rdoKhachHang.setText("Khách hàng");

        buttonGroup1.add(rdoNhaPhanPhoi);
        rdoNhaPhanPhoi.setText("Nhà phân phối");

        javax.swing.GroupLayout pnlThongTinDoiTacLayout = new javax.swing.GroupLayout(pnlThongTinDoiTac);
        pnlThongTinDoiTac.setLayout(pnlThongTinDoiTacLayout);
        pnlThongTinDoiTacLayout.setHorizontalGroup(
            pnlThongTinDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinDoiTacLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmail)
                    .addComponent(lblDiaChi)
                    .addComponent(lblDienThoai)
                    .addComponent(lblVaiTro)
                    .addComponent(lblTenDT))
                .addGap(10, 10, 10)
                .addGroup(pnlThongTinDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinDoiTacLayout.createSequentialGroup()
                        .addComponent(rdoKhachHang)
                        .addGap(18, 18, 18)
                        .addComponent(rdoNhaPhanPhoi)
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDienThoai)
                    .addComponent(txtTenDT))
                .addContainerGap())
        );
        pnlThongTinDoiTacLayout.setVerticalGroup(
            pnlThongTinDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinDoiTacLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenDT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlThongTinDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDiaChi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlThongTinDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlThongTinDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDienThoai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlThongTinDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoKhachHang)
                    .addComponent(lblVaiTro)
                    .addComponent(rdoNhaPhanPhoi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlChucNang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N
        pnlChucNang.setLayout(new java.awt.GridLayout(0, 1));

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

        pnlChuyen.setLayout(new java.awt.GridLayout(1, 0));

        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });
        pnlChuyen.add(btnFirst);

        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });
        pnlChuyen.add(btnPrev);

        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        pnlChuyen.add(btnNext);

        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });
        pnlChuyen.add(btnLast);

        lblTimKiem.setText("Tìm kiếm");

        txtTimKiem.setToolTipText("Tìm kiếm theo tên");
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
        });

        tblDoiTac.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDoiTac.getTableHeader().setReorderingAllowed(false);
        tblDoiTac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDoiTacMouseClicked(evt);
            }
        });
        pnlTblDoiTac.setViewportView(tblDoiTac);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTblDoiTac)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlLoaiDoiTac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlThongTinDoiTac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTimKiem)
                        .addGap(282, 282, 282)
                        .addComponent(pnlChuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlThongTinDoiTac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlLoaiDoiTac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlChuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTblDoiTac, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstLDTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstLDTMouseClicked
        // TODO add your handling code here:
        fillToTable();
        updateStatus();
    }//GEN-LAST:event_lstLDTMouseClicked

    private void btnThemListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemListActionPerformed
        // TODO add your handling code here:
        insertLDT();
    }//GEN-LAST:event_btnThemListActionPerformed

    private void btnXoaListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaListActionPerformed
        // TODO add your handling code here:
        deleteLDT();
    }//GEN-LAST:event_btnXoaListActionPerformed

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
        // TODO add your handling code here:
        if (!lstLDT.isSelectionEmpty()) {
            fillToTable();
            clearForm();
        }
    }//GEN-LAST:event_txtTimKiemKeyPressed

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

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void tblDoiTacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDoiTacMouseClicked
        // TODO add your handling code here:
        this.row = tblDoiTac.getSelectedRow();
        edit();
    }//GEN-LAST:event_tblDoiTacMouseClicked

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        first();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        prev();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        last();
    }//GEN-LAST:event_btnLastActionPerformed

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
            java.util.logging.Logger.getLogger(DoiTacJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoiTacJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoiTacJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoiTacJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DoiTacJDialog dialog = new DoiTacJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemList;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaList;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblDienThoai;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblTenDT;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JLabel lblVaiTro;
    private javax.swing.JList<LoaiDoiTac> lstLDT;
    private javax.swing.JPanel pnlButtonLoaiDT;
    private javax.swing.JPanel pnlChucNang;
    private javax.swing.JPanel pnlChuyen;
    private javax.swing.JPanel pnlLoaiDoiTac;
    private javax.swing.JScrollPane pnlLstLoaiDoiTac;
    private javax.swing.JScrollPane pnlTblDoiTac;
    private javax.swing.JPanel pnlThongTinDoiTac;
    private javax.swing.JRadioButton rdoKhachHang;
    private javax.swing.JRadioButton rdoNhaPhanPhoi;
    private javax.swing.JTable tblDoiTac;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDienThoai;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtTenDT;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    private DoiTacDAO dtDAO;
    private LoaiDoiTacDAO ldtDAO;
    private DefaultTableModel tblModel;
    private int row = -1;

    void init() {
        setLocationRelativeTo(null);

        this.dtDAO = new DoiTacDAO();
        this.ldtDAO = new LoaiDoiTacDAO();

        this.tblModel = (DefaultTableModel) tblDoiTac.getModel();
        this.tblModel.setColumnIdentifiers(new Object[]{
            "Mã đối tác", "Tên đối tác", "Địa chỉ", "Email", "Số điện thoại",
            "Vai trò"
        });
        System.out.println(tblDoiTac.getSize());
        tblDoiTac.setAutoCreateRowSorter(true);
        tblDoiTac.setRowHeight(25);
        tblDoiTac.removeColumn(tblDoiTac.getColumnModel().getColumn(0));

        this.fillToList();
        this.updateStatus();
    }

    DoiTac getForm() {
        DoiTac dt = new DoiTac();
        dt.setTenDT(txtTenDT.getText().trim());
        dt.setDiaChi(txtDiaChi.getText());
        dt.setEmail(txtEmail.getText());
        dt.setSoDT(txtDienThoai.getText());
        dt.setVaiTro(rdoKhachHang.isSelected());
        dt.setMaLDT(lstLDT.getSelectedValue().getMaLDT());
        return dt;
    }

    void setForm(DoiTac dt) {
        txtTenDT.setText(dt.getTenDT());
        txtDiaChi.setText(dt.getDiaChi());
        txtEmail.setText(dt.getEmail());
        txtDienThoai.setText(dt.getSoDT());
        if (dt.isVaiTro()) {
            rdoNhaPhanPhoi.setSelected(true);
        } else {
            rdoKhachHang.setSelected(true);
        }
    }

    void clearForm() {
        setForm(new DoiTac());
        this.row = -1;
        tblDoiTac.clearSelection();
        this.updateStatus();
    }

    void updateStatus() {
        boolean isSelectedList = !lstLDT.isSelectionEmpty();
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblDoiTac.getRowCount() - 1);
        
        // Chọn hàng trên bảng
        if (edit) {
            tblDoiTac.setRowSelectionInterval(row, row);
        }
        
        btnThem.setEnabled(!edit && isSelectedList);
        btnSua.setEnabled(edit && isSelectedList);
        btnXoa.setEnabled(edit && isSelectedList);
        btnMoi.setEnabled(isSelectedList);

        btnFirst.setEnabled(edit && !first);
        btnPrev.setEnabled(edit && !first);
        btnNext.setEnabled(edit && !last);
        btnLast.setEnabled(edit && !last);
    }
    
    void edit() {
        int maDT = (int) tblDoiTac.getModel().getValueAt(this.row, 0);
        DoiTac dt = dtDAO.selectByID(maDT);
        this.setForm(dt);
        this.updateStatus();
    }
    
    void first() {
        this.row = 0;
        this.edit();
    }

    void prev() {
        if (this.row > 0) {
            this.row--;
            this.edit();
        }
    }

    void next() {
        if (this.row < (tblDoiTac.getRowCount() - 1)) {
            this.row++;
            this.edit();
        }
    }

    void last() {
        this.row = tblDoiTac.getRowCount() - 1;
        this.edit();
    }

    void fillToList() {
        DefaultListModel lstModel = new DefaultListModel();
        lstModel.removeAllElements();
        try {
            List<LoaiDoiTac> list = ldtDAO.selectAll();
            for (LoaiDoiTac ldt : list) {
                lstModel.addElement(ldt);
            }
            lstLDT.setModel(lstModel);
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
            e.printStackTrace();
        }
    }

    void fillToTable() {
        int maLDT = lstLDT.getSelectedValue().getMaLDT();
        String keyword = txtTimKiem.getText();
        tblModel.setRowCount(0);
        try {
            List<DoiTac> list = dtDAO.selectByKeyword(maLDT, keyword);
            for (DoiTac dt : list) {
                tblModel.addRow(new Object[]{
                    dt.getMaDT(),
                    dt.getTenDT(),
                    dt.getDiaChi(),
                    dt.getEmail(),
                    dt.getSoDT(),
                    dt.isVaiTro() ? "Nhà phân phối" : "Khách hàng"
                });
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
            e.printStackTrace();
        }
    }

    boolean isValidated() {
        String tenDT = txtTenDT.getText();
        String diaChi = txtDiaChi.getText();
        String email = txtEmail.getText();
        String dienThoai = txtDienThoai.getText();
        if (tenDT.isEmpty()) {
            MsgBox.alert(this, "Chưa nhập tên đối tác!");
            txtTenDT.requestFocus();
        } else if (diaChi.isEmpty()) {
            MsgBox.alert(this, "Chưa nhập địa chỉ!");
            txtDiaChi.requestFocus();
        } else if (email.isEmpty()) {
            MsgBox.alert(this, "Chưa nhập email!");
            txtEmail.requestFocus();
        } else if (!email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
            MsgBox.alert(this, "Email không hợp lệ!");
            txtEmail.requestFocus();
        } else if (dienThoai.isEmpty()) {
            MsgBox.alert(this, "Chưa nhập số điện thoại");
            txtDienThoai.requestFocus();
        } else if (!dienThoai.matches("((84)|(0))\\d{9}")) {
            MsgBox.alert(this, "Số điện thoại không hợp lệ!");
            txtEmail.requestFocus();
        } else {
            return true;
        }
        return false;
    }

    void insertLDT() {
        String tenLDT = MsgBox.prompt(this, "Nhập tên loại đối tác mới:");
        if (tenLDT != null && !tenLDT.isEmpty()) {
            LoaiDoiTac loaiDT = new LoaiDoiTac(tenLDT);
            try {
                ldtDAO.insert(loaiDT);
                this.fillToList();
                this.clearForm();
                tblModel.setRowCount(0);
                MsgBox.alert(this, "Thêm mới thành công!");
            } catch (Exception e) {
                MsgBox.alert(this, "Thêm mới thất bại!");
                e.printStackTrace();
            }
        }
    }

    void deleteLDT() {
        if (!Auth.isManager()) {
            MsgBox.alert(this, "Bạn không có quyền xoá loại đối tác!");
        } else if(lstLDT.isSelectionEmpty()) {
            MsgBox.alert(this, "Chưa chọn loại đối tác!");
        } else if (MsgBox.confirm(this, "Bạn chắc chắn muốn xoá loại đối tác này?")) {
            LoaiDoiTac ldt = lstLDT.getSelectedValue();
            try {
                ldtDAO.delete(ldt.getMaLDT());
                this.fillToList();
                this.clearForm();
                tblModel.setRowCount(0);
                MsgBox.alert(this, "Xoá thành công!");
            } catch (Exception e) {
                MsgBox.alert(this, "Xoá thất bại!");
                e.printStackTrace();
            }
        }
    }

    void insert() {
        if (isValidated()) {
            DoiTac dt = getForm();
            try {
                dtDAO.insert(dt);
                this.fillToTable();
                this.clearForm();
                MsgBox.alert(this, "Thêm mới thành công!");
            } catch (Exception e) {
                MsgBox.alert(this, "Thêm mới thất bại!");
                e.printStackTrace();
            }
        }
    }

    void delete() {
        if (Auth.isManager()) {
            MsgBox.alert(this, "Bạn không có quyền xoá đối tác!");
        } else if (MsgBox.confirm(this, "Bạn có chắc chắc muốn xoá đối tác này không?")) {
            int maDT = (int) tblDoiTac.getModel().getValueAt(this.row, 0);
            try {
                dtDAO.delete(maDT);
                this.fillToTable();
                this.clearForm();
                MsgBox.alert(this, "Xoá thành công!");
            } catch (Exception e) {
                MsgBox.alert(this, "Xoá thất bại!");
                e.printStackTrace();
            }
        }
    }
    
    void update() {
        if (isValidated()) {
            DoiTac dt = getForm();
            try {
                dtDAO.update(dt);
                this.fillToTable();
                MsgBox.alert(this, "Cập nhật thành công!");
            } catch (Exception e) {
                MsgBox.alert(this, "Cập nhật thất bại!");
                e.printStackTrace();
            }
        }
    }

}
