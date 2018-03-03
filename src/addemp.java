
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.proteanit.sql.DbUtils;

public class addemp extends javax.swing.JInternalFrame {

    Connection con = null;
    public addemp() {
        initComponents();
        BasicInternalFrameTitlePane titlePane = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) this.getUI()).getNorthPane();
        this.remove(titlePane);
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy","root","root");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"ERROR .. Database Connection Failed.");
        }
        updateTable();
    }
    public void updateTable()
    {
        try {
            PreparedStatement stmt = con.prepareStatement("select * from employee order by ID ");
            ResultSet result = stmt.executeQuery();
            empTable.setModel(DbUtils.resultSetToTableModel(result));
        } catch (SQLException ex) {
            Logger.getLogger(addemp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        phone = new javax.swing.JTextField();
        phonelabel = new javax.swing.JLabel();
        empname = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        addresslabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        empTable = new javax.swing.JTable();
        save = new javax.swing.JButton();
        save1 = new javax.swing.JButton();
        save2 = new javax.swing.JButton();
        save3 = new javax.swing.JButton();
        empno = new javax.swing.JTextField();
        empnum = new javax.swing.JLabel();
        check = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        phone.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phoneKeyPressed(evt);
            }
        });

        phonelabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        phonelabel.setText("رقم الموبايل");

        empname.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        empname.setText("اسم الموظف");

        name.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        address.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        addresslabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        addresslabel.setText("العنوان");

        empTable.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        empTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        empTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
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
        empTable.setDragEnabled(true);
        empTable.setEnabled(false);
        empTable.setGridColor(new java.awt.Color(51, 102, 255));
        empTable.setRowHeight(30);
        empTable.getTableHeader().setResizingAllowed(false);
        empTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(empTable);

        save.setBackground(new java.awt.Color(255, 255, 255));
        save.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        save.setText("حفظ");
        save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        save1.setBackground(new java.awt.Color(255, 255, 255));
        save1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        save1.setText("تحديث");
        save1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save1ActionPerformed(evt);
            }
        });

        save2.setBackground(new java.awt.Color(255, 255, 255));
        save2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        save2.setText("تنظيف");
        save2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save2ActionPerformed(evt);
            }
        });

        save3.setBackground(new java.awt.Color(255, 255, 255));
        save3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        save3.setText("مسح");
        save3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save3ActionPerformed(evt);
            }
        });

        empno.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        empno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                empnoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                empnoKeyReleased(evt);
            }
        });

        empnum.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        empnum.setText("رقم الموظف");

        check.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        check.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(220, 220, 220)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(name)
                                    .addComponent(phone, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                                    .addComponent(address))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(empname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(phonelabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addresslabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(save2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(122, 122, 122)
                                        .addComponent(save3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(save1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(122, 122, 122)
                                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(74, 74, 74))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(check, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(empno, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(empnum, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(name)
                    .addComponent(empname, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addresslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phonelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phone))
                .addGap(116, 116, 116)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(empno)
                    .addComponent(empnum, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void phoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneKeyPressed

        phone.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                int a = phone.getText()
                        .length();
                //if you want to accept only numbers add the following `if`:
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {

                    getToolkit().beep();
                    e.consume();

                }
            }
        });
    }//GEN-LAST:event_phoneKeyPressed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed

        if (name.getText().equals("")
                || address.getText().equals("")
                || phone.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "لا يمكن ترك الخانات فارغة املئ جميع البيانات وحاول مرة آخرى");
            return;
        }
        int x=0;
        try{
            x = Integer.parseInt(phone.getText());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "رقم موبايل خاطئ");
            return;
        }
        
        try {
            PreparedStatement stmt = con.prepareStatement("insert into employee ( `اسم الموظف` , `العنوان` , `الموبايل` ) values ( ? , ? , ? )");
            stmt.setString(1,name.getText());
            stmt.setString(2,address.getText());
            stmt.setInt(3, x);
            if(stmt.executeUpdate()>0)
            {
                JOptionPane.showMessageDialog(this,"تم الحفظ بنجاح");
                updateTable();
            }
            else
            {
                JOptionPane.showMessageDialog(this,"فشل الحفظ");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(addemp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_saveActionPerformed

    private void empnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_empnoKeyPressed
        
        empno.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                int a = empno.getText()
                        .length();
                //if you want to accept only numbers add the following `if`:
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {

                    getToolkit().beep();
                    e.consume();

                }
            }
        });
        
    }//GEN-LAST:event_empnoKeyPressed

    private void save1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save1ActionPerformed
        
        if (name.getText().equals("")
                || address.getText().equals("")
                || phone.getText().equals("") ||
                empno.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "لا يمكن ترك الخانات فارغة املئ جميع البيانات وحاول مرة آخرى");
            return;
        }
        int x=0;
        try{
            x = Integer.parseInt(phone.getText());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "رقم موبايل خاطئ");
            return;
        }
        
        try {
            PreparedStatement stmt = con.prepareStatement("update employee set `اسم الموظف` = ? , `العنوان` = ? , `الموبايل` = ? where ID = ?");
            stmt.setString(1,name.getText());
            stmt.setString(2,address.getText());
            stmt.setInt(3, x);
            stmt.setInt(4,Integer.parseInt(empno.getText()));
            if(stmt.executeUpdate()>0)
            {
                JOptionPane.showMessageDialog(this,"تم تحديث البيانات بنجاح");
                updateTable();
            }
            else
            {
                JOptionPane.showMessageDialog(this,"فشل الحفظ");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(addemp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_save1ActionPerformed

    private void save2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save2ActionPerformed
        
        name.setText("");
        address.setText("");
        phone.setText("");
        empno.setText("");
        
    }//GEN-LAST:event_save2ActionPerformed

    private void empnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_empnoKeyReleased
        
        if(empno.getText().equals(""))
        {
            check.setText("");
        }
        try {
            PreparedStatement stmt = con.prepareStatement("select * from employee where ID like ?");
            stmt.setInt(1,Integer.parseInt(empno.getText()));
            ResultSet result = stmt.executeQuery();
            if(result.next())
            {
                name.setText(result.getString(2));
                address.setText(result.getString(3));
                phone.setText(String.valueOf(result.getInt(4)));
            }
            else
            {
                name.setText("");
                address.setText("");
                phone.setText("");
                check.setText("هذا الموظف غير موجود");
            }
                            
                            } catch (SQLException ex) {
            Logger.getLogger(addemp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_empnoKeyReleased

    private void save3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save3ActionPerformed
        
        if(empno.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"يجب كتابة رقم الموظف الذى تريد مسحه");
            return;
        }
        try {
            PreparedStatement stmt = con.prepareStatement("delete from employee where ID = ?");
            stmt.setInt(1,Integer.parseInt(empno.getText()));
            if(stmt.executeUpdate()>0)
            {
                JOptionPane.showMessageDialog(this,"تم المسح بنجاح");
                updateTable();
            }else
            {
                JOptionPane.showMessageDialog(this,"فشل المسح تأكد من صحة رقم الموظف الذى أدخلته");
            }
        } catch (SQLException ex) {
            Logger.getLogger(addemp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_save3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JLabel addresslabel;
    private javax.swing.JLabel check;
    private javax.swing.JTable empTable;
    private javax.swing.JLabel empname;
    private javax.swing.JTextField empno;
    private javax.swing.JLabel empnum;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phone;
    private javax.swing.JLabel phonelabel;
    private javax.swing.JButton save;
    private javax.swing.JButton save1;
    private javax.swing.JButton save2;
    private javax.swing.JButton save3;
    // End of variables declaration//GEN-END:variables
}
