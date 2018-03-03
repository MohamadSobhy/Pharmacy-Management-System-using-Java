
import java.awt.ComponentOrientation;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class bill extends javax.swing.JFrame {

    Connection con = null;

    public bill() {
        initComponents();
        //this.setLocationRelativeTo(null);
        this.setResizable(false);
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "root");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error Database Connection.");
        }
    }
    String id_transfer;

    public bill(String b_id) {    //new constructor
        id_transfer = b_id;
        //this.setLocationRelativeTo(null);
        this.setResizable(false);

        initComponents();
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "root");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error Database Connection.");
        }
        billpanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        setIcon();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        billpanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        billTable = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        totalamount = new javax.swing.JLabel();
        AMT = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        disc = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        dateelabel = new javax.swing.JLabel();
        billnolabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tamt = new javax.swing.JLabel();
        print = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        mainpanel.setBackground(new java.awt.Color(204, 204, 204));

        billpanel.setBackground(new java.awt.Color(255, 255, 255));
        billpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        billTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        billTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        billTable.setGridColor(new java.awt.Color(102, 153, 255));
        billTable.setRowHeight(30);
        billTable.setRowMargin(2);
        jScrollPane1.setViewportView(billTable);

        billpanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 187, 928, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setText("فاتورة مبيعات");
        billpanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 87, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setText("طوخ - القليوبية - مصر");
        billpanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 54, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Pharmacy");
        billpanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 19, -1, -1));

        totalamount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalamount.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        billpanel.add(totalamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 720, 118, 30));

        AMT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AMT.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        billpanel.add(AMT, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 646, 118, 31));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("رقم الفاتورة");
        billpanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(854, 146, -1, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("التاريخ");
        billpanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(888, 102, -1, 31));

        disc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        disc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        billpanel.add(disc, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 684, 118, 29));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("المبلغ");
        billpanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(883, 640, -1, 31));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("الخصم");
        billpanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(877, 678, -1, 35));

        dateelabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        dateelabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        billpanel.add(dateelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(702, 102, 129, 31));

        billnolabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        billnolabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        billpanel.add(billnolabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(702, 146, 129, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("المبلغ النهائي");
        billpanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(826, 720, -1, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("التوقيع");
        billpanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 640, -1, -1));

        jScrollPane2.setViewportView(billpanel);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("المبلغ الكلى");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("فاتورة بيع");

        tamt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tamt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        print.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        print.setText("طباعة");
        print.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(mainpanelLayout.createSequentialGroup()
                            .addComponent(tamt, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel11))
                        .addGroup(mainpanelLayout.createSequentialGroup()
                            .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(236, 236, 236)
                            .addComponent(jLabel1)
                            .addGap(384, 384, 384)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 953, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1))
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tamt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        String id = id_transfer;
        billnolabel.setText(id);
        try {

            java.util.Date date = new java.util.Date();
            SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
            dateelabel.setText(s.format(date));

            PreparedStatement stmt2 = con.prepareStatement("select `رقم الفاتورة`,`اسم الدواء`,`الكمية`,`سعر الدواء`,`ثمن المنتج` from sales where `رقم الفاتورة` = ?");
            stmt2.setInt(1, Integer.parseInt(id));
            ResultSet rs2 = stmt2.executeQuery();
            billTable.setModel(DbUtils.resultSetToTableModel(rs2));

            PreparedStatement stmt = con.prepareStatement("select * from sales where `رقم الفاتورة` = ?");
            stmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = stmt.executeQuery();
            rs.next();
            {
                totalamount.setText(String.valueOf(rs.getInt(9)));
                tamt.setText(String.valueOf(rs.getInt(9)));
                disc.setText(String.valueOf(rs.getInt(7)) + " %");
                AMT.setText(String.valueOf(rs.getInt(8)));

            }

        } catch (Exception e) {
            Logger.getLogger(bill.class.getName()).log(Level.SEVERE, null, e);
        }


    }//GEN-LAST:event_formWindowOpened

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed

        String billno = billnolabel.getText();
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setJobName("Bill No. "+billno);

        pj.setPrintable(new Printable() {
            public int print(Graphics pg, PageFormat pf, int pageNum) {
                if (pageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                billpanel.paint(g2);
                return Printable.PAGE_EXISTS;
            }
        });
        if (pj.printDialog() == false) {
            return;
        }

        try {
            pj.print();
        } catch (PrinterException ex) {
            // handle exception
        }

    }//GEN-LAST:event_printActionPerformed

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
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bill().setVisible(true);
            }
        });
    }
    
    private void setIcon() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("drug icon.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AMT;
    private javax.swing.JTable billTable;
    private javax.swing.JLabel billnolabel;
    private javax.swing.JPanel billpanel;
    private javax.swing.JLabel dateelabel;
    private javax.swing.JLabel disc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JButton print;
    private javax.swing.JLabel tamt;
    private javax.swing.JLabel totalamount;
    // End of variables declaration//GEN-END:variables
}
