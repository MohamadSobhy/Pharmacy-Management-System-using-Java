
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class sell extends javax.swing.JInternalFrame {

    Connection con = null;

    public sell() {
        initComponents();
        BasicInternalFrameTitlePane titlePane = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) this.getUI()).getNorthPane();
        this.remove(titlePane);
        billTable.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 20));
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "root");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error Database Connection.");
        }
        //updateCombo();

        DefaultTableModel d = (DefaultTableModel) billTable.getModel();
        if (d.getRowCount() > 0) {
            for (int i = d.getRowCount() - 1; i > -1; i--) {
                d.removeRow(i);
            }
        }

    }

    public void update()
    {
        Remove.doClick();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel = new javax.swing.JPanel();
        edicinename = new javax.swing.JLabel();
        ClearButton = new javax.swing.JButton();
        quan = new javax.swing.JTextField();
        quantity = new javax.swing.JLabel();
        avalibe = new javax.swing.JLabel();
        ave = new javax.swing.JLabel();
        exdate = new javax.swing.JTextField();
        expire = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        pricelabel = new javax.swing.JLabel();
        TextAmt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ButtonAdd = new javax.swing.JButton();
        billno = new javax.swing.JLabel();
        billnolabel = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        datelabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        billTable = new javax.swing.JTable();
        Remove = new javax.swing.JButton();
        TextAmount = new javax.swing.JLabel();
        TextDiscount = new javax.swing.JTextField();
        precent = new javax.swing.JLabel();
        LabelTotal = new javax.swing.JLabel();
        ButtonCalculate = new javax.swing.JButton();
        save = new javax.swing.JButton();
        layoutlabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        medname = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        mainpanel.setBackground(new java.awt.Color(204, 204, 204));

        edicinename.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        edicinename.setText(" اسم الدواء أو الباركود");

        ClearButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ClearButton.setText("تنظيف");
        ClearButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        quan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        quan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quanKeyReleased(evt);
            }
        });

        quantity.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        quantity.setText("الكمية");

        avalibe.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        avalibe.setText("المتاح");

        ave.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ave.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        exdate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        expire.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        expire.setText("تاريخ الصلاحية");

        price.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        pricelabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pricelabel.setText("السعر");

        TextAmt.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        TextAmt.setText("0");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setText("الفاتورة");

        ButtonAdd.setBackground(new java.awt.Color(255, 255, 255));
        ButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photos/add cell.png"))); // NOI18N
        ButtonAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddActionPerformed(evt);
            }
        });

        billno.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        billno.setText("رقم الفاتورة");

        billnolabel.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        billnolabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        date.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        date.setText("التاريخ");

        datelabel.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        datelabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        billTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        billTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "الثمن", "السعر", "الكمية", "تاريخ الصلاحية", "اسم الدواء"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        billTable.setToolTipText("");
        billTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        billTable.setGridColor(new java.awt.Color(102, 153, 255));
        billTable.setRowHeight(30);
        billTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                billTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(billTable);
        if (billTable.getColumnModel().getColumnCount() > 0) {
            billTable.getColumnModel().getColumn(0).setResizable(false);
            billTable.getColumnModel().getColumn(1).setResizable(false);
            billTable.getColumnModel().getColumn(2).setResizable(false);
            billTable.getColumnModel().getColumn(3).setResizable(false);
            billTable.getColumnModel().getColumn(4).setResizable(false);
        }

        Remove.setBackground(new java.awt.Color(255, 255, 255));
        Remove.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Remove.setText("مسح العنصر");
        Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveActionPerformed(evt);
            }
        });

        TextAmount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextAmount.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TextDiscount.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        TextDiscount.setText("0");
        TextDiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TextDiscountKeyPressed(evt);
            }
        });

        precent.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        precent.setText("%");

        LabelTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ButtonCalculate.setBackground(new java.awt.Color(255, 255, 255));
        ButtonCalculate.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        ButtonCalculate.setText("الإجمالى");
        ButtonCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCalculateActionPerformed(evt);
            }
        });

        save.setBackground(new java.awt.Color(255, 255, 255));
        save.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        save.setText("حفظ و طباعة");
        save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        jLabel10.setText("الفاتورة الكلية");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        jLabel11.setText("الخصم");

        medname.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        medname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mednameKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addContainerGap(69, Short.MAX_VALUE)
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainpanelLayout.createSequentialGroup()
                                .addComponent(ButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)))
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainpanelLayout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(pricelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(exdate, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(mainpanelLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(expire, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(avalibe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ave, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(quantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(quan, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(medname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(edicinename, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                                .addComponent(datelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(date)
                                .addGap(18, 18, 18)
                                .addComponent(billnolabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(billno, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(layoutlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(ClearButton)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addComponent(Remove, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(precent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LabelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(TextDiscount))
                .addGap(18, 18, 18)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonCalculate, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(164, 164, 164))
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(billno, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(billnolabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(datelabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(39, 39, 39)
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(avalibe, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(expire, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(edicinename, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pricelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(layoutlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exdate, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quan)
                            .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TextAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(medname, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainpanelLayout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(Remove, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainpanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(46, 46, 46)
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TextAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TextDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(precent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ButtonCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(58, 58, 58))
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

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed

        exdate.setText("");
        TextAmt.setText("0");
        quan.setText("");
        price.setText("");
        medname.setText("");
        ave.setText("");
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void ButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddActionPerformed

        if (medname.getText().equals("")
                || quan.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "من فضلك قم بتحديد اسم الدواء والكمية المطلوبة");
            return;
        }
        Double qty = Double.parseDouble(quan.getText());
        Double qtyav = Double.parseDouble(ave.getText());
        Double amount = Double.parseDouble(TextAmt.getText());
        if (qty > qtyav) {
            JOptionPane.showMessageDialog(this, "من فضلك قم بإدخال رقم أقل من او يساوى الكمية الموجودة");

        } else {

            String name = medname.getText();
            String billno = billnolabel.getText();
            String medprice = price.getText();

            String exp = exdate.getText();
            String date = datelabel.getText();
            DefaultTableModel d = (DefaultTableModel) billTable.getModel();

            // d.addRow(new Object[]{" ","  "," "," ","  "," "});
            ///Double aaa=qty;
            int qtyint = qty.intValue();//convert double to int

            {

                int rows = d.getRowCount();
                d.addRow(new Object[]{amount, medprice, qtyint, exp, name});

                quan.setText("");
                qtyav = qtyav - qty;
                DecimalFormat df = new DecimalFormat("##");
                df.setRoundingMode(RoundingMode.DOWN);
                ave.setText(df.format(qtyav));

                int i = 0;
                Double total = 0.0;
                while (i <= rows) {
                    String amt = (String.valueOf(d.getValueAt(i, 0)));
                    Double amounta = Double.parseDouble(amt);

                    total = total + amounta;
                    //  Double amount2a=Double.parseDouble(jTextField14.getText());
                    //jLabel35.setText("Rs. "+total);
                    DecimalFormat dft = new DecimalFormat("##.##");
                    dft.setRoundingMode(RoundingMode.DOWN);
                    TextAmount.setText(dft.format(total));

                    LabelTotal.setText(dft.format(total));
                    i++;
                }

            }

        }
        ButtonCalculate.doClick();

    }//GEN-LAST:event_ButtonAddActionPerformed
    int x;
    private void billTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billTableMouseClicked

        int row = billTable.getSelectedRow();
        String Table_click = (billTable.getModel().getValueAt(row, 4).toString());
        int row_num = (billTable.getSelectedRow());
        x = row_num;
        Remove.setText("مسح  " + Table_click);

        // TODO add your handling code here:
    }//GEN-LAST:event_billTableMouseClicked

    private void RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveActionPerformed
        ClearButton.doClick();
        DefaultTableModel d = (DefaultTableModel) billTable.getModel();
        int row_click = x;
        int rows = d.getRowCount();
        d.removeRow(row_click);
        ////////////////////////

        if (!billTable.getRowSelectionAllowed()) {
            return;
        }
        TextAmount.setText("");
        LabelTotal.setText("");
        int i = 0;
        Double total = 0.0;
        while (i <= rows) {
            String amt = (String.valueOf(d.getValueAt(i, 0)));
            Double amounta = Double.parseDouble(amt);

            total = total + amounta;
            DecimalFormat dft = new DecimalFormat("##.##");
            dft.setRoundingMode(RoundingMode.DOWN);
            TextAmount.setText(dft.format(total));
            LabelTotal.setText(dft.format(total));
            i++;

        }
    }//GEN-LAST:event_RemoveActionPerformed

    private void ButtonCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCalculateActionPerformed

        Double total = 0.0;
        Double amount = Double.parseDouble(TextAmount.getText());
        Double discount = Double.parseDouble(TextDiscount.getText());

        Double dis = discount / 100 * amount;
        total = amount - dis;
        DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.DOWN);
        LabelTotal.setText(df.format(total));


    }//GEN-LAST:event_ButtonCalculateActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        String b_id = billnolabel.getText();

        try {

            DefaultTableModel d = (DefaultTableModel) billTable.getModel();
            int rows = d.getRowCount();
            int i = 0;
            //  for(int i=0;i<=rows;i++){
            try {
                while (i <= rows) {

                    String billno = billnolabel.getText();
                    String date = datelabel.getText();
                    String totalamt = LabelTotal.getText();
                    String disc = TextDiscount.getText();
                    String amtbeforedisc = TextAmount.getText();
                    //problem is from here
                    String name = (d.getValueAt(i, 4).toString());
                    String qty = (billTable.getModel().getValueAt(i, 2).toString());
                    String mrp = (billTable.getModel().getValueAt(i, 1).toString());
                    String amount = (billTable.getModel().getValueAt(i, 0).toString());
                    String exp = (billTable.getModel().getValueAt(i, 3).toString());

                    String sql = "insert into sales values ('" + billno + "','" + name + "','" + qty + "','" + date + "','" + exp + "','" + mrp + "','" + disc + "','" + amtbeforedisc + "','" + totalamt + "' , '" + amount + "' ) ";
                    PreparedStatement stmt = con.prepareStatement(sql);
                    stmt.executeUpdate();

                    String sql2 = "update medicine set الكمية=الكمية-'" + qty + "' where `الاسم التجارى` like  '" + name + "'  ";
                    PreparedStatement stmt2 = con.prepareStatement(sql2);
                    stmt2.executeUpdate(sql2);
                    i++;
                }

                
            } catch (SQLException e) {
                Logger.getLogger(sell.class.getName()).log(Level.SEVERE, null, e);
            } finally {

                bill m = new bill(b_id);
                m.setVisible(true);

            }

        } catch (Exception e) {

        }
    }//GEN-LAST:event_saveActionPerformed

    private void quanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quanKeyReleased

        if (quan.getText().equals("")) {
            TextAmt.setText("0");
        }
        double qtyav1 = Double.parseDouble(ave.getText());
        int qty1 = Integer.parseInt(quan.getText());
        double mrp = Double.parseDouble(price.getText());
        double amt = qty1 * mrp;

        DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.DOWN);
        TextAmt.setText(df.format(amt));

    }//GEN-LAST:event_quanKeyReleased

    private void mednameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mednameKeyReleased

        String tmp = medname.getText();
        String sql = "select * from medicine where `الاسم التجارى` like '" + tmp + "' or `الباركود` like '" + tmp + "' ";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String date = rs.getString("تاريخ الصلاحية");
                exdate.setText(date);
                String bprice = rs.getString("سعر البيع");
                price.setText(bprice);
                String add5 = rs.getString("الكمية");
                ave.setText(add5);
                medname.setText(rs.getString("الاسم التجارى"));

            } else {
                exdate.setText("");
                price.setText("");
                ave.setText("");
            }

        } catch (Exception e1) {
            //JOptionPane.showMessageDialog(this, e1.getMessage());
        }

    }//GEN-LAST:event_mednameKeyReleased

    private void TextDiscountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextDiscountKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {//if we press enter, it will login

            ButtonCalculate.doClick();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_TextDiscountKeyPressed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated

        try {

            PreparedStatement stmt = con.prepareStatement("select max(`رقم الفاتورة`)as `رقم الفاتورة` from sales");
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int billno = rs.getInt("رقم الفاتورة");
                int billnodisplay = billno + 1;
                billnolabel.setText("" + billnodisplay);

            } else {
                billnolabel.setText("1");
            }

        } catch (Exception e1) {
            JOptionPane.showMessageDialog(this, e1.getMessage());
        }

        try {

            java.util.Date date = new java.util.Date();
            SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
            datelabel.setText(s.format(date));

        } catch (Exception e1) {
            JOptionPane.showMessageDialog(this, e1.getMessage());
        }

        DefaultTableModel d = (DefaultTableModel) billTable.getModel();

        int rows = d.getRowCount();
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                d.removeRow(0);
            }
        }

    }//GEN-LAST:event_formInternalFrameActivated


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAdd;
    private javax.swing.JButton ButtonCalculate;
    private javax.swing.JButton ClearButton;
    private javax.swing.JLabel LabelTotal;
    private javax.swing.JButton Remove;
    private javax.swing.JLabel TextAmount;
    private javax.swing.JTextField TextAmt;
    private javax.swing.JTextField TextDiscount;
    private javax.swing.JLabel avalibe;
    private javax.swing.JLabel ave;
    private javax.swing.JTable billTable;
    private javax.swing.JLabel billno;
    private javax.swing.JLabel billnolabel;
    private javax.swing.JLabel date;
    private javax.swing.JLabel datelabel;
    private javax.swing.JLabel edicinename;
    private javax.swing.JTextField exdate;
    private javax.swing.JLabel expire;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel layoutlabel;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JTextField medname;
    private javax.swing.JLabel precent;
    private javax.swing.JTextField price;
    private javax.swing.JLabel pricelabel;
    private javax.swing.JTextField quan;
    private javax.swing.JLabel quantity;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
}
