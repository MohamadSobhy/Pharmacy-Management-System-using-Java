
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.proteanit.sql.DbUtils;

public class expired extends javax.swing.JInternalFrame {

    Connection con = null;

    public expired() {

        initComponents();
        BasicInternalFrameTitlePane titlePane = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) this.getUI()).getNorthPane();
        this.remove(titlePane);

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "root");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERROR .. Datebase Connection Failed.");
        }
        updateTable();
    }

    public void updateTable() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        String date = s.format(d);
        int year = Integer.parseInt(date.substring(6, 10));
        int month = Integer.parseInt(date.substring(3, 5));
        int day = Integer.parseInt(date.substring(0, 2));

        try {
            PreparedStatement stmt = con.prepareStatement("select medicine.* from medicine , expired where ((`السنة` < ?) OR (`السنة` = ? AND `الشهر` < ?) OR ( `السنة` = ? AND `الشهر` = ? AND `اليوم` < ?) OR ( `السنة` = ? AND `الشهر` = ? AND `اليوم` = ?)) AND (medicine.`الباركود` = expired.`الباركود`)");
            stmt.setInt(1, year);
            stmt.setInt(2, year);
            stmt.setInt(3, month);
            stmt.setInt(4, year);
            stmt.setInt(5, month);
            stmt.setInt(6, day);
            stmt.setInt(7, year);
            stmt.setInt(8, month);
            stmt.setInt(9, day);
            ResultSet result = stmt.executeQuery();
            expiredmed.setModel(DbUtils.resultSetToTableModel(result));
        } catch (SQLException ex) {
            Logger.getLogger(expired.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void settext() {
        datech.setDate(null);
        updateTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        datech = new com.toedter.calendar.JDateChooser();
        datelabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        expiredmed = new javax.swing.JTable();
        search = new javax.swing.JButton();
        check = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        datech.setBackground(new java.awt.Color(255, 255, 255));
        datech.setDateFormatString("dd/MM/yyyy");
        datech.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        datelabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        datelabel.setText("الأدوية التى ستنتهى صلاحيتها بحلول ");

        expiredmed.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        expiredmed.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        expiredmed.setModel(new javax.swing.table.DefaultTableModel(
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
        expiredmed.setDragEnabled(true);
        expiredmed.setEnabled(false);
        expiredmed.setGridColor(new java.awt.Color(51, 102, 255));
        expiredmed.setRowHeight(30);
        expiredmed.getTableHeader().setResizingAllowed(false);
        expiredmed.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(expiredmed);

        search.setBackground(new java.awt.Color(255, 255, 255));
        search.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        search.setText("بحث");
        search.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        check.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        check.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1176, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(datech, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(datelabel))
                            .addComponent(check, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(265, 265, 265)
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(check, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(datelabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(datech, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
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

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed

        String date = ((JTextField) datech.getDateEditor().getUiComponent()).getText();
        int year = Integer.parseInt(date.substring(6, 10));
        int month = Integer.parseInt(date.substring(3, 5));
        int day = Integer.parseInt(date.substring(0, 2));

        if (((JTextField) datech.getDateEditor().getUiComponent()).getText().equals("")) {
            check.setText("يجب اختيار التاريخ ثم البحث");
            return;
        } else {
            check.setText("");
        }
        try {
            PreparedStatement stmt = con.prepareStatement("select medicine.* from medicine , expired where ((`السنة` < ?) OR (`السنة` = ? AND `الشهر` < ?) OR ( `السنة` = ? AND `الشهر` = ? AND `اليوم` < ?) OR ( `السنة` = ? AND `الشهر` = ? AND `اليوم` = ?)) AND (medicine.`الباركود` = expired.`الباركود`)");
            stmt.setInt(1, year);
            stmt.setInt(2, year);
            stmt.setInt(3, month);
            stmt.setInt(4, year);
            stmt.setInt(5, month);
            stmt.setInt(6, day);
            stmt.setInt(7, year);
            stmt.setInt(8, month);
            stmt.setInt(9, day);

            ResultSet result = stmt.executeQuery();
            expiredmed.setModel(DbUtils.resultSetToTableModel(result));
        } catch (SQLException ex) {
            Logger.getLogger(expired.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_searchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel check;
    private com.toedter.calendar.JDateChooser datech;
    private javax.swing.JLabel datelabel;
    private javax.swing.JTable expiredmed;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
