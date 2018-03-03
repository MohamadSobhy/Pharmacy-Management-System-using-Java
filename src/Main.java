
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

    addmed add = new addmed();
    Home home = new Home();
    show sh = new show();
    sell sales = new sell();
    sales sale = new sales();
    expired exp = new expired();
    addemp addem = new addemp();
    employee emp = new employee();
    settings sett = new settings();

    
    Connection con = null;
    public Main() {
        initComponents();
        setIcon();
        this.setLocationRelativeTo(null);
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy","root","root");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"ERROR .. Database Connection Failed.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel = new javax.swing.JPanel();
        homebutt = new javax.swing.JButton();
        addmed = new javax.swing.JButton();
        menubutt = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        main = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        mainpanel.setBackground(new java.awt.Color(204, 204, 204));
        mainpanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        homebutt.setBackground(new java.awt.Color(255, 255, 255));
        homebutt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/home icon.png"))); // NOI18N
        homebutt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homebutt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebuttActionPerformed(evt);
            }
        });

        addmed.setBackground(new java.awt.Color(255, 255, 255));
        addmed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/add icon pic.png"))); // NOI18N
        addmed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addmed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addmedActionPerformed(evt);
            }
        });

        menubutt.setBackground(new java.awt.Color(255, 255, 255));
        menubutt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/medicine_icon.png"))); // NOI18N
        menubutt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menubutt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menubuttActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/sell_icon.png"))); // NOI18N
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/sales_icon.png"))); // NOI18N
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mohamad Sobhy\\Desktop\\Pharmacy Management  System\\Photos\\expired_icon.png")); // NOI18N
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/addemp_icon.png"))); // NOI18N
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/employee_icon.png"))); // NOI18N
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/settings_icon.png"))); // NOI18N
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 127, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 114, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menubutt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addmed, javax.swing.GroupLayout.PREFERRED_SIZE, 109, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(homebutt, javax.swing.GroupLayout.PREFERRED_SIZE, 109, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(homebutt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menubutt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addmed, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                .addContainerGap())
        );

        main.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                mainComponentResized(evt);
            }
        });

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(main)
                    .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(main)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homebuttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebuttActionPerformed

        main.removeAll();
        Dimension desktopSize = main.getSize();
        Dimension jInternalFrameSize = home.getSize();
        home.setLocation((desktopSize.width - jInternalFrameSize.width),
                (desktopSize.height - jInternalFrameSize.height));
        main.add(home);
        home.setVisible(true);
        main.setVisible(true);


    }//GEN-LAST:event_homebuttActionPerformed

    private void mainComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_mainComponentResized

        Dimension desktopSize = main.getSize();
        Dimension jInternalFrameSize = add.getSize();
        add.setSize(main.getWidth(), main.getHeight());
        home.setSize(main.getWidth(), main.getHeight());
        sh.setSize(main.getWidth(), main.getHeight());
        sales.setSize(main.getWidth(), main.getHeight());
        sale.setSize(main.getWidth(),main.getHeight());
        exp.setSize(main.getWidth(),main.getHeight());
        addem.setSize(main.getWidth(),main.getHeight());
        emp.setSize(main.getWidth(),main.getHeight());
        sett.setSize(main.getWidth(),main.getHeight());
        

    }//GEN-LAST:event_mainComponentResized

    private void addmedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addmedActionPerformed

        main.removeAll();
        add.clear();
        Dimension desktopSize = main.getSize();
        Dimension jInternalFrameSize = add.getSize();
        add.setLocation((desktopSize.width - jInternalFrameSize.width),
                (desktopSize.height - jInternalFrameSize.height));
        main.add(add);
        add.setVisible(true);
        main.setVisible(true);

    }//GEN-LAST:event_addmedActionPerformed

    private void menubuttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menubuttActionPerformed
        
        
        sh.clearsearch();
        sh.updateTable();
        main.removeAll();
        Dimension desktopSize = main.getSize();
        Dimension jInternalFrameSize = sh.getSize();
        sh.setLocation((desktopSize.width - jInternalFrameSize.width),
                (desktopSize.height - jInternalFrameSize.height));
        main.add(sh);
        sh.setVisible(true);
        main.setVisible(true);
        
    }//GEN-LAST:event_menubuttActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        
        
        main.removeAll();
        Dimension desktopSize = main.getSize();
        Dimension jInternalFrameSize = sales.getSize();
        sales.setLocation((desktopSize.width - jInternalFrameSize.width),
                (desktopSize.height - jInternalFrameSize.height));
        main.add(sales);
        sales.setVisible(true);
        main.setVisible(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        sale.setsearchtext();
        sale.updateTable();
        main.removeAll();
        Dimension desktopSize = main.getSize();
        Dimension jInternalFrameSize = sale.getSize();
        sale.setLocation((desktopSize.width - jInternalFrameSize.width),
                (desktopSize.height - jInternalFrameSize.height));
        main.add(sale);
        sale.setVisible(true);
        main.setVisible(true);
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       
        exp.settext();
        main.removeAll();
        Dimension desktopSize = main.getSize();
        Dimension jInternalFrameSize = exp.getSize();
        exp.setLocation((desktopSize.width - jInternalFrameSize.width),
                (desktopSize.height - jInternalFrameSize.height));
        main.add(exp);
        exp.setVisible(true);
        main.setVisible(true);
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        
        addem.updateTable();
        main.removeAll();
        Dimension desktopSize = main.getSize();
        Dimension jInternalFrameSize = addem.getSize();
        addem.setLocation((desktopSize.width - jInternalFrameSize.width),
                (desktopSize.height - jInternalFrameSize.height));
        main.add(addem);
        addem.setVisible(true);
        main.setVisible(true);
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        main.removeAll();
        Dimension desktopSize = main.getSize();
        Dimension jInternalFrameSize = home.getSize();
        home.setLocation((desktopSize.width - jInternalFrameSize.width),
                (desktopSize.height - jInternalFrameSize.height));
        main.add(home);
        home.setVisible(true);
        main.setVisible(true);
        
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        try {
            PreparedStatement stmt = con.prepareStatement("update employee set `وقت الوصول` = ? ");
            stmt.setString(1,"");
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_formWindowClosing

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        
        emp.clearsearch();
        emp.updateTable();
        main.removeAll();
        Dimension desktopSize = main.getSize();
        Dimension jInternalFrameSize = emp.getSize();
        emp.setLocation((desktopSize.width - jInternalFrameSize.width),
                (desktopSize.height - jInternalFrameSize.height));
        main.add(emp);
        emp.setVisible(true);
        main.setVisible(true);
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        
        sett.update();
        main.removeAll();
        Dimension desktopSize = main.getSize();
        Dimension jInternalFrameSize = sett.getSize();
        home.setLocation((desktopSize.width - jInternalFrameSize.width),
                (desktopSize.height - jInternalFrameSize.height));
        main.add(sett);
        sett.setVisible(true);
        main.setVisible(true);
        
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    private void setIcon() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("drug icon.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addmed;
    private javax.swing.JButton homebutt;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JDesktopPane main;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JButton menubutt;
    // End of variables declaration//GEN-END:variables
}
