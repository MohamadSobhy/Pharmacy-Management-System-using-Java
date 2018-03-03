
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import net.proteanit.sql.DbUtils;

public class employee extends javax.swing.JInternalFrame {

    Connection con = null;

    public employee() {
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
        searchbylabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        searchby.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        search.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
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
            PreparedStatement stmt = con.prepareStatement("select * from employee order by ID");
            ResultSet result = stmt.executeQuery();
            medicine.setModel(DbUtils.resultSetToTableModel(result));
            medicine.setShowHorizontalLines(true);
            medicine.setShowVerticalLines(true);
            medicine.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            medicine.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 18));
            //medicine.getColumnModel().getColumn(5).setMaxWidth(80);
            ((DefaultTableCellRenderer) medicine.getTableHeader().getDefaultRenderer())
                    .setHorizontalAlignment(JLabel.RIGHT);
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.RIGHT);
            for (int x = 0; x < medicine.getColumnModel().getColumnCount(); x++) {
                medicine.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
            }
            medicine.setEnabled(false);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }
    public void clearsearch()
    {
        search.setText("");
        searchby.setSelectedIndex(-1);
        searchlabel.setText("");
        checklabel.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        medicine = new javax.swing.JTable();
        clock = new javax.swing.JLabel();
        searchbylabel = new javax.swing.JLabel();
        searchby = new javax.swing.JComboBox<>();
        searchlabel = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        checklabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        mainpanel.setBackground(new java.awt.Color(204, 204, 204));

        medicine.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        medicine.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        medicine.setModel(new javax.swing.table.DefaultTableModel(
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
        medicine.setDragEnabled(true);
        medicine.setEnabled(false);
        medicine.setGridColor(new java.awt.Color(51, 102, 255));
        medicine.setRowHeight(30);
        medicine.getTableHeader().setResizingAllowed(false);
        medicine.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(medicine);

        clock.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        searchbylabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        searchbylabel.setText("البحث عن طريق ");

        searchby.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        searchby.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "رقم الموظف", "اسم الموظف" }));
        searchby.setSelectedIndex(-1);
        searchby.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchby.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbyActionPerformed(evt);
            }
        });

        searchlabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        search.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        checklabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        checklabel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1176, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(clock, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                        .addComponent(checklabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(searchby, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchbylabel, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clock, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checklabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchlabel, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(searchbylabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchby, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(search))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
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

        if (searchby.getSelectedIndex() == -1) {
            checklabel.setText("يرجى اختيار طريقة البحث");
            updateTable();
            return;
        }
        if (search.getText().equals("")) {
            checklabel.setText("يرجى إدخال اسم أو رقم الموظف الذى تبحث عنه");
            updateTable();
            return;
        }
        else
        {
            checklabel.setText("");
        }

        try {

             if(searchby.getSelectedIndex()==0)
            {
                PreparedStatement stmt = con.prepareStatement("select * from employee where ID =?");
                stmt.setString(1, search.getText());
                ResultSet result = stmt.executeQuery();
                checklabel.setText("");
                medicine.setModel(DbUtils.resultSetToTableModel(result));
                 if (!result.first()) {
                    checklabel.setText("هذا الموظف غير موجود");
                }
            }
            else if(searchby.getSelectedIndex()==1)
            {
                PreparedStatement stmt = con.prepareStatement("select * from employee where `اسم الموظف` =?");
                stmt.setString(1, search.getText());
                ResultSet result = stmt.executeQuery();
                checklabel.setText("");
                medicine.setModel(DbUtils.resultSetToTableModel(result));
                 if (!result.first()) {
                    checklabel.setText("هذا الموظف غير موجود");
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(addmed.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_searchKeyReleased

    private void searchbyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbyActionPerformed

        if (searchby.getSelectedIndex() == 0) {
            searchlabel.setText("رقم الموظف");
        } else if (searchby.getSelectedIndex() == 1) {
            searchlabel.setText("اسم الموظف");
        } 
        
    }//GEN-LAST:event_searchbyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel checklabel;
    private javax.swing.JLabel clock;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JTable medicine;
    private javax.swing.JTextField search;
    private javax.swing.JComboBox<String> searchby;
    private javax.swing.JLabel searchbylabel;
    private javax.swing.JLabel searchlabel;
    // End of variables declaration//GEN-END:variables
}
