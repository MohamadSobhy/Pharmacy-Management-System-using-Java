
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import net.proteanit.sql.DbUtils;

public class sales extends javax.swing.JInternalFrame {

    Connection con = null;

    public sales() {
        try {
            initComponents();
            BasicInternalFrameTitlePane titlePane = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) this.getUI()).getNorthPane();
            this.remove(titlePane);
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(show.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateTable();
        setdate();
        search.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        group.add(bill);
        group.add(dater);
        setsearchtext();
    }
    
    public void setsearchtext()
    {
        datefield.setEnabled(false);
        search.setEnabled(false);
        dater.setSelected(false);
        bill.setSelected(false);
        search.setText("");
        datefield.setText("");
        
    }

    public void setdate() {
        clock.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        ActionListener actiondate = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.Date date = new java.util.Date();
                SimpleDateFormat s = new SimpleDateFormat("yyyy\\MM\\dd");
                SimpleDateFormat t = new SimpleDateFormat("hh:mm:ss a");
                clock.setText("الوقت الآن  " + t.format(date) + "  و تاريخ اليوم هو  " + s.format(date));
            }
        };
        new javax.swing.Timer(1000, actiondate).start();
    }

    public void updateTable() {
        try {
            PreparedStatement stmt = con.prepareStatement("select * from sales order by sales.`رقم الفاتورة`");
            ResultSet result = stmt.executeQuery();
            sales.setModel(DbUtils.resultSetToTableModel(result));
            sales.setShowHorizontalLines(true);
            sales.setShowVerticalLines(true);
            sales.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            sales.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 18));
            //medicine.getColumnModel().getColumn(5).setMaxWidth(80);
            ((DefaultTableCellRenderer) sales.getTableHeader().getDefaultRenderer())
                    .setHorizontalAlignment(JLabel.RIGHT);
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.RIGHT);
            for (int x = 0; x < sales.getColumnModel().getColumnCount(); x++) {
                sales.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
            }
            sales.setEnabled(false);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    public void clearsearch() {
        search.setText("");
        searchlabel.setText("");
        checklabel.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        group = new javax.swing.ButtonGroup();
        mainpanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        sales = new javax.swing.JTable();
        clock = new javax.swing.JLabel();
        searchlabel = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        checklabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        checkdate = new javax.swing.JLabel();
        datefield = new javax.swing.JTextField();
        searchlabel1 = new javax.swing.JLabel();
        dater = new javax.swing.JRadioButton();
        bill = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));

        mainpanel.setBackground(new java.awt.Color(204, 204, 204));

        sales.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        sales.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        sales.setModel(new javax.swing.table.DefaultTableModel(
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
        sales.setDragEnabled(true);
        sales.setEnabled(false);
        sales.setGridColor(new java.awt.Color(51, 102, 255));
        sales.setRowHeight(30);
        sales.getTableHeader().setResizingAllowed(false);
        sales.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(sales);

        clock.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        searchlabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        searchlabel.setText("رقم الفاتورة");

        search.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        checklabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        checklabel.setForeground(new java.awt.Color(255, 0, 0));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("طباعة");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        checkdate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        checkdate.setForeground(new java.awt.Color(255, 0, 0));

        datefield.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        datefield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                datefieldKeyReleased(evt);
            }
        });

        searchlabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        searchlabel1.setText("التاريخ");

        dater.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daterActionPerformed(evt);
            }
        });

        bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1164, Short.MAX_VALUE)
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(mainpanelLayout.createSequentialGroup()
                                .addComponent(clock, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48))
                            .addGroup(mainpanelLayout.createSequentialGroup()
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(checklabel, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkdate, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(datefield, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainpanelLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(searchlabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(dater, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainpanelLayout.createSequentialGroup()
                                .addComponent(searchlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bill, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addComponent(clock, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkdate, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                            .addComponent(dater, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(13, 13, 13))
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(datefield, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchlabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(checklabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bill, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased

        if (search.getText().equals("")) {
            checklabel.setText("يرجى إدخال رقم الفاتورة التى تبحث عنها");
            updateTable();
            return;
        }
        else
        {
            checklabel.setText("");
        }

        try {
                PreparedStatement stmt2 = con.prepareStatement("select * from sales where `رقم الفاتورة` = ?");
                stmt2.setInt(1, Integer.parseInt(search.getText()));
                ResultSet result = stmt2.executeQuery();
                sales.setModel(DbUtils.resultSetToTableModel(result));
                if (!result.first()) {
                    checklabel.setText("هذه الفاتورة غير موجودة");
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(addmed.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_searchKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {
            MessageFormat header = new MessageFormat("قائمة المبيعات");
            MessageFormat footer = new MessageFormat("Page : {0}");
            sales.print(JTable.PrintMode.FIT_WIDTH, header,footer);
        } catch (PrinterException ex) {
            Logger.getLogger(sales.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void datefieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datefieldKeyReleased
        
        if (datefield.getText().equals("")) {
            checkdate.setText("يرجى إدخال تاريخ الفاتورة التى تبحث عنها");
            updateTable();
            return;
        }
        else
        {
            checkdate.setText("");
        }

        try {
                PreparedStatement stmt2 = con.prepareStatement("select * from sales where `تاريخ البيع` = ?");
                stmt2.setString(1, datefield.getText());
                ResultSet result = stmt2.executeQuery();
                sales.setModel(DbUtils.resultSetToTableModel(result));
                if (!result.first()) {
                    checkdate.setText("لا توجد فواتير لهذا اليوم");
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(addmed.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }//GEN-LAST:event_datefieldKeyReleased

    private void daterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daterActionPerformed
        
        datefield.setEnabled(true);
        search.setEnabled(false);
        
    }//GEN-LAST:event_daterActionPerformed

    private void billActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billActionPerformed
       
        search.setEnabled(true);
        datefield.setEnabled(false);
        
    }//GEN-LAST:event_billActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton bill;
    private javax.swing.JLabel checkdate;
    private javax.swing.JLabel checklabel;
    private javax.swing.JLabel clock;
    private javax.swing.JTextField datefield;
    private javax.swing.JRadioButton dater;
    private javax.swing.ButtonGroup group;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JTable sales;
    private javax.swing.JTextField search;
    private javax.swing.JLabel searchlabel;
    private javax.swing.JLabel searchlabel1;
    // End of variables declaration//GEN-END:variables
}
