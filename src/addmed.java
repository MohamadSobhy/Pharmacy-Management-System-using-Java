
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import net.proteanit.sql.DbUtils;

public class addmed extends javax.swing.JInternalFrame {

    Connection con = null;

    public addmed() {

        initComponents();
        BasicInternalFrameTitlePane titlePane = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) this.getUI()).getNorthPane();
        this.remove(titlePane);

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "root");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error Database Connection.");
        }

        setdate();
        updateTable();
        updatetextfields();
    }

    
    public void clear()
    {
        barcode.setText("");
        sname.setText("");
        tname.setText("");
        cname.setText("");
        exdate.setDate(null);
        quan.setText("");
        sprice.setText("");
        bprice.setText("");
        checklabel.setText("");
        search.setText("");
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

    public void updatetextfields() {
        barcode.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        sname.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        cname.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        tname.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        exdate.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        quan.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        bprice.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        sprice.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        checklabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

    }

    public void updateTable() {
        try {
            PreparedStatement stmt = con.prepareStatement("select * from medicine order by medicine.`الاسم العلمى`,medicine.`الاسم التجارى`");
            ResultSet result = stmt.executeQuery();
            medicine.setModel(DbUtils.resultSetToTableModel(result));
            medicine.setShowHorizontalLines(true);
            medicine.setShowVerticalLines(true);
            medicine.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            medicine.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 18));
            medicine.getColumnModel().getColumn(5).setMaxWidth(80);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        mainpanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        sname = new javax.swing.JTextField();
        company = new javax.swing.JLabel();
        tname = new javax.swing.JTextField();
        tradename = new javax.swing.JLabel();
        cname = new javax.swing.JTextField();
        sciname = new javax.swing.JLabel();
        barcode = new javax.swing.JTextField();
        bcode = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        exdate = new com.toedter.calendar.JDateChooser();
        quan = new javax.swing.JTextField();
        quantity = new javax.swing.JLabel();
        bprice = new javax.swing.JTextField();
        buyprice = new javax.swing.JLabel();
        sprice = new javax.swing.JTextField();
        sellprice = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        medicine = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        update = new javax.swing.JButton();
        save = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        bcodesearch = new javax.swing.JLabel();
        checklabel = new javax.swing.JLabel();
        clock = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        sname.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        company.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        company.setText("اسم الشركة");

        tname.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        tradename.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tradename.setText("الاسم التجارى");

        cname.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        sciname.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        sciname.setText("الاسم العلمى");

        barcode.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        barcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                barcodeKeyReleased(evt);
            }
        });

        bcode.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        bcode.setText("الباركود");

        date.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        date.setText("تاريخ الصلاحية");

        exdate.setBackground(new java.awt.Color(204, 204, 204));
        exdate.setDateFormatString("dd/MM/yyyy");
        exdate.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        quan.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        quan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quanKeyPressed(evt);
            }
        });

        quantity.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        quantity.setText("الكمية");

        bprice.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        bprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bpriceKeyPressed(evt);
            }
        });

        buyprice.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        buyprice.setText("سعر الشراء");

        sprice.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        sprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                spriceKeyPressed(evt);
            }
        });

        sellprice.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        sellprice.setText("سعر البيع");

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
        jScrollPane1.setViewportView(medicine);
        if (medicine.getColumnModel().getColumnCount() > 0) {
            medicine.getColumnModel().getColumn(0).setResizable(false);
            medicine.getColumnModel().getColumn(1).setResizable(false);
            medicine.getColumnModel().getColumn(2).setResizable(false);
            medicine.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        update.setBackground(new java.awt.Color(255, 255, 255));
        update.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/update_icon.png"))); // NOI18N
        update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        save.setBackground(new java.awt.Color(255, 255, 255));
        save.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/add_icon.png"))); // NOI18N
        save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(255, 255, 255));
        delete.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/delete_icon.png"))); // NOI18N
        delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        clear.setBackground(new java.awt.Color(255, 255, 255));
        clear.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/clear_icon.png"))); // NOI18N
        clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        search.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        bcodesearch.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        bcodesearch.setText("الباركود");

        checklabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        checklabel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96)
                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96)
                                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(checklabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bcodesearch, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(169, 169, 169))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcodesearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checklabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        clock.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(sprice, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(476, 476, 476))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(sellprice)
                                        .addGap(18, 18, 18)
                                        .addComponent(bprice, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)))
                                .addComponent(buyprice))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(sname, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(sciname))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tname, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tradename, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(company, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(quan, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(91, 91, 91)
                                        .addComponent(quantity))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(78, 78, 78)
                                                .addComponent(bcode))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(exdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(date))))))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(clock, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(clock, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bcode, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(barcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(sname)
                                .addComponent(sciname, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tname)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tradename, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(date)))
                            .addComponent(exdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cname)
                            .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(company, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buyprice, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bprice)
                            .addComponent(sellprice, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sprice))
                        .addGap(45, 45, 45)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void spriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spriceKeyPressed

        sprice.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                int a = sprice.getText()
                        .length();
                //if you want to accept only numbers add the following `if`:
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    if(c!='.'){
                    getToolkit().beep();
                    e.consume();
                    }
                }
            }
        });

    }//GEN-LAST:event_spriceKeyPressed

    private void bpriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bpriceKeyPressed

        bprice.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                int a = bprice.getText()
                        .length();
                //if you want to accept only numbers add the following `if`:
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    if(c!='.'){
                    getToolkit().beep();
                    e.consume();
                }
                }
            }
        });

    }//GEN-LAST:event_bpriceKeyPressed

    private void quanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quanKeyPressed

        quan.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                int a = quan.getText()
                        .length();
                //if you want to accept only numbers add the following `if`:
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    if(c!='.'){
                    getToolkit().beep();
                    e.consume();
                }
                }
            }
        });

    }//GEN-LAST:event_quanKeyPressed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed

        try {
            if (barcode.getText().equals("")
                    || sname.getText().equals("")
                    || tname.getText().equals("")
                    || cname.getText().equals("")
                    || exdate.getDate() == null
                    || quan.getText().equals("")
                    || sprice.getText().equals("")
                    || bprice.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "لا يمكن ترك الخانات فارغة من فضلك قم بملئ جميع البيانات المطلوبة");
                return;
            }
            PreparedStatement stmt2 = con.prepareStatement("select  الباركود from medicine ");
            ResultSet result = stmt2.executeQuery();
            while (result.next()) {
                if (result.getString(1).equals(barcode.getText())) {
                    JOptionPane.showMessageDialog(this, "هذا الدواء موجود بالفعل ");
                    return;
                }
            }

            PreparedStatement stmt = con.prepareStatement("insert into medicine values(?,?,?,?,?,?,?,?)");

            stmt.setString(1, barcode.getText());
            stmt.setString(2, sname.getText());
            stmt.setString(3, tname.getText());
            stmt.setString(4, cname.getText());
            stmt.setString(5, ((JTextField) exdate.getDateEditor().getUiComponent()).getText());
            stmt.setInt(6, Integer.parseInt(quan.getText()));
            stmt.setInt(7, Integer.parseInt(bprice.getText()));
            stmt.setInt(8, Integer.parseInt(sprice.getText()));
            if (stmt.executeUpdate() > 0) {
                updateTable();
                JOptionPane.showMessageDialog(this, "تم حفظ الدواء بنجاح");
            } else {
                JOptionPane.showMessageDialog(this, "لم يتم الحفظ هناك خطأ ما قم باصلاحه ثم حاول مرة آخرى");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "لم يتم الحفظ هناك خطأ ما قم باصلاحه ثم حاول مرة آخرى");
        }
        
        String date = ((JTextField) exdate.getDateEditor().getUiComponent()).getText();
        int year = Integer.parseInt( date.substring(6,10));
        int month = Integer.parseInt(date.substring(3,5));
        int day = Integer.parseInt(date.substring(0,2));
        
        try {
            PreparedStatement stmt = con.prepareStatement("insert into expired values(?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, barcode.getText());
            stmt.setString(2, sname.getText());
            stmt.setString(3, tname.getText());
            stmt.setString(4, cname.getText());
            stmt.setInt(5,year);
            stmt.setInt(6,month);
            stmt.setInt(7,day);
            stmt.setInt(8, Integer.parseInt(quan.getText()));
            stmt.setInt(9, Integer.parseInt(bprice.getText()));
            stmt.setInt(10, Integer.parseInt(sprice.getText()));
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(addmed.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

    }//GEN-LAST:event_saveActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        barcode.setText("");
        sname.setText("");
        tname.setText("");
        cname.setText("");
        exdate.setDate(null);
        quan.setText("");
        sprice.setText("");
        bprice.setText("");
        checklabel.setText("");
        search.setText("");

    }//GEN-LAST:event_clearActionPerformed


    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

        try {
            if (search.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "من فضلك قم بكتابة الباركود الخاص بالدواء المراد حذفه فى خانة البحث");
                return;
            }
            PreparedStatement stmt = con.prepareStatement("delete from medicine where الباركود = ?");
            stmt.setString(1, search.getText());
            if (stmt.executeUpdate() > 0) {
                updateTable();
                JOptionPane.showMessageDialog(this, "تم مسح الدواء بنجاح");
                barcode.setText("");
                sname.setText("");
                tname.setText("");
                cname.setText("");
                exdate.setDate(null);
                quan.setText("");
                sprice.setText("");
                bprice.setText("");
                checklabel.setText("");
                search.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "الدواء غير موجود");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "فشل فى المسح ");
            Logger.getLogger(addmed.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_deleteActionPerformed

    private void barcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barcodeKeyReleased


    }//GEN-LAST:event_barcodeKeyReleased

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased

        try {
            PreparedStatement stmt = con.prepareStatement("select * from medicine where الباركود =?");
            stmt.setString(1, search.getText());
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
                barcode.setText(result.getString(1));
                sname.setText(result.getString(2));
                tname.setText(result.getString(3));
                cname.setText(result.getString(4));
                try {
                    exdate.setDate(df.parse(result.getString(5)));
                } catch (ParseException ex) {
                    Logger.getLogger(addmed.class.getName()).log(Level.SEVERE, null, ex);
                }
                quan.setText(result.getString(6));
                bprice.setText(result.getString(7));
                sprice.setText(result.getString(8));
                checklabel.setText("");
            } else {
                checklabel.setText("هذا الدواء غير موجود");
                barcode.setText("");
                sname.setText("");
                tname.setText("");
                cname.setText("");
                exdate.setDate(null);
                quan.setText("");
                sprice.setText("");
                bprice.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(addmed.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_searchKeyReleased

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

        try {
            boolean check = true;
            if (barcode.getText().equals("")
                    || sname.getText().equals("")
                    || tname.getText().equals("")
                    || cname.getText().equals("")
                    || exdate.getDate() == null
                    || quan.getText().equals("")
                    || sprice.getText().equals("")
                    || bprice.getText().equals("")
                    || search.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "لا يمكن ترك الخانات فارغة من فضلك قم بملئ جميع البيانات المطلوبة");
                return;
            }

            PreparedStatement stmt = con.prepareStatement("update medicine set الباركود = ? , `الاسم العلمى` = ? , `الاسم التجارى` = ? , `اسم الشركة` = ? , `تاريخ الصلاحية`= ? , `الكمية`= ? , `سعر الشراء` = ? , `سعر البيع` = ? where الباركود = ? ");
            stmt.setString(1, barcode.getText());
            stmt.setString(2, sname.getText());
            stmt.setString(3, tname.getText());
            stmt.setString(4, cname.getText());
            stmt.setString(5, ((JTextField) exdate.getDateEditor().getUiComponent()).getText());
            stmt.setInt(6, Integer.parseInt(quan.getText()));
            stmt.setInt(7, Integer.parseInt(bprice.getText()));
            stmt.setInt(8, Integer.parseInt(sprice.getText()));
            stmt.setString(9, search.getText());
            if (stmt.executeUpdate() > 0) {
                updateTable();
                JOptionPane.showMessageDialog(this, "تم تحديث بيانات الدواء بنجاح");
            } else {
                JOptionPane.showMessageDialog(this, "خطأ..  لم يتم تحديث بيانات الدواء تاكد من صحة البيانات ثم حاول مرة آخرى");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "فشل التحديث تاكد من صحة البيانات ثم حاول مرة آخرى");
        }
        
        
        
        String date = ((JTextField) exdate.getDateEditor().getUiComponent()).getText();
        int year = Integer.parseInt( date.substring(6,10));
        int month = Integer.parseInt(date.substring(3,5));
        int day = Integer.parseInt(date.substring(0,2));
        
        
        try {
            PreparedStatement stmt = con.prepareStatement("update expired set  `السنة`= ?, `الشهر` = ?, `اليوم` = ? where الباركود = ? ");
            stmt.setInt(1,year);
            stmt.setInt(2,month);
            stmt.setInt(3,day);
            stmt.setString(4, search.getText());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(addmed.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_updateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField barcode;
    private javax.swing.JLabel bcode;
    private javax.swing.JLabel bcodesearch;
    private javax.swing.JTextField bprice;
    private javax.swing.JLabel buyprice;
    private javax.swing.JLabel checklabel;
    private javax.swing.JButton clear;
    private javax.swing.JLabel clock;
    private javax.swing.JTextField cname;
    private javax.swing.JLabel company;
    private javax.swing.JLabel date;
    private javax.swing.JButton delete;
    private com.toedter.calendar.JDateChooser exdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JTable medicine;
    private javax.swing.JTextField quan;
    private javax.swing.JLabel quantity;
    private javax.swing.JButton save;
    private javax.swing.JLabel sciname;
    private javax.swing.JTextField search;
    private javax.swing.JLabel sellprice;
    private javax.swing.JTextField sname;
    private javax.swing.JTextField sprice;
    private javax.swing.JTextField tname;
    private javax.swing.JLabel tradename;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
