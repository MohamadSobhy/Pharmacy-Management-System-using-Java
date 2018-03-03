
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class Home extends javax.swing.JInternalFrame {

    Connection con = null;

    public Home() {
        initComponents();
        BasicInternalFrameTitlePane titlePane = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) this.getUI()).getNorthPane();
        this.remove(titlePane);

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        empno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        savetime = new javax.swing.JButton();
        header = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        empno.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        empno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empnoActionPerformed(evt);
            }
        });
        jPanel1.add(empno, new org.netbeans.lib.awtextra.AbsoluteConstraints(572, 308, 462, 66));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel1.setText("رقم الموظف");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1078, 308, 429, 66));

        savetime.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        savetime.setText("تسجيل");
        savetime.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        savetime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savetimeActionPerformed(evt);
            }
        });
        jPanel1.add(savetime, new org.netbeans.lib.awtextra.AbsoluteConstraints(858, 495, 253, 77));

        header.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        header.setText("Welcome to Pharmacy Management System");
        jPanel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 66, 1089, 132));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/pharmacy.jpg"))); // NOI18N
        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void savetimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savetimeActionPerformed

        java.util.Date date = new java.util.Date();
        SimpleDateFormat t = new SimpleDateFormat("hh:mm:ss a");
        String time = t.format(date);

        if (empno.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "لايمكن ترك الاسم فارغا من فضلك ادخل الاسم لتسجيل الحضور");
            return;
        }

        try {
            PreparedStatement stmt = con.prepareStatement("update employee set `وقت الوصول` = ? where ID = ? ");
            stmt.setString(1, time);
            stmt.setInt(2,Integer.parseInt(empno.getText()));
            if(stmt.executeUpdate()>0)
            {
                JOptionPane.showMessageDialog(this,"تم التسجيل بنجاح");
            }
            else
            {
                JOptionPane.showMessageDialog(this,"حدث خطأ ما أثناء التسجيل حاول مرة آخرى");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        empno.setText("");

    }//GEN-LAST:event_savetimeActionPerformed

    private void empnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empnoActionPerformed
        
        savetime.doClick();
        
    }//GEN-LAST:event_empnoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JTextField empno;
    private javax.swing.JLabel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton savetime;
    // End of variables declaration//GEN-END:variables
}
