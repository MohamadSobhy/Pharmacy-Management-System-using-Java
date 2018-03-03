
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

public class settings extends javax.swing.JInternalFrame {

    Connection con = null;
    public settings() {
        initComponents();
        BasicInternalFrameTitlePane titlePane = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) this.getUI()).getNorthPane();
        this.remove(titlePane);
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy","root","root");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"ERROR .. Database Connection Failed.");
        }
        update();
    }

    
    public boolean isExist()
    {
        if(cname.getText().equals("")
                || String.valueOf(cpass.getPassword()).equals(""))
        {
            JOptionPane.showMessageDialog(this,"Invalid Current Username OR Password.");
            return false;
        }
        boolean check = false;
        String name = cname.getText();
        String pass = String.valueOf(cpass.getPassword());
        try {
            PreparedStatement stmt = con.prepareStatement("select * from user");
            ResultSet result = stmt.executeQuery();
            while(result.next())
            {
                if(name.equals(result.getString(1)) && pass.equals(result.getString(2)))
                {
                    check = true;
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(settings.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    public void update()
    {
        cname.setText("");
        cpass.setText("");
        chname.setText(title);
        chpasscon.setText("");
        newuser.setText("");
        newpass.setText("");
        dname.setText("");
        dpass.setText("");
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        currentdata = new javax.swing.JPanel();
        cname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cpass = new javax.swing.JPasswordField();
        currentlabel = new javax.swing.JLabel();
        changepassword = new javax.swing.JPanel();
        currentlabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        chpasscon = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        changepass = new javax.swing.JButton();
        chname = new javax.swing.JTextField();
        DeleteUser = new javax.swing.JPanel();
        deleteuser = new javax.swing.JButton();
        dpass = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        currentlabel3 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dname = new javax.swing.JTextField();
        NewUser = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        currentlabel2 = new javax.swing.JLabel();
        newuser = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        newpass = new javax.swing.JPasswordField();
        saveuser = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        currentdata.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        cname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("User Name :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Password :");

        cpass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        currentlabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        currentlabel.setText("البيانات الحالية للمستخدم");

        javax.swing.GroupLayout currentdataLayout = new javax.swing.GroupLayout(currentdata);
        currentdata.setLayout(currentdataLayout);
        currentdataLayout.setHorizontalGroup(
            currentdataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currentdataLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(currentdataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(currentdataLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(currentdataLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)))
                .addGroup(currentdataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cname, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                    .addComponent(cpass))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(currentdataLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(currentlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        currentdataLayout.setVerticalGroup(
            currentdataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, currentdataLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(currentlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(currentdataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(currentdataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cpass, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        changepassword.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        currentlabel1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        currentlabel1.setText("تغيير كلمة السر واسم المستخدم");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("New Password :");

        chpasscon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("New Username :");

        changepass.setBackground(new java.awt.Color(255, 255, 255));
        changepass.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        changepass.setText("Save");
        changepass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        changepass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changepassActionPerformed(evt);
            }
        });

        chname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout changepasswordLayout = new javax.swing.GroupLayout(changepassword);
        changepassword.setLayout(changepasswordLayout);
        changepasswordLayout.setHorizontalGroup(
            changepasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changepasswordLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(changepasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, changepasswordLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chname))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, changepasswordLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chpasscon, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(changepasswordLayout.createSequentialGroup()
                        .addComponent(changepass, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148)))
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changepasswordLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(currentlabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        changepasswordLayout.setVerticalGroup(
            changepasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changepasswordLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(currentlabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(changepasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chname, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(changepasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chpasscon, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(changepass, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        DeleteUser.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        deleteuser.setBackground(new java.awt.Color(255, 255, 255));
        deleteuser.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        deleteuser.setText("Delete");
        deleteuser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteuserActionPerformed(evt);
            }
        });

        dpass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Password :");

        currentlabel3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        currentlabel3.setText("مسح المستخدم");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("User Name :");

        dname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout DeleteUserLayout = new javax.swing.GroupLayout(DeleteUser);
        DeleteUser.setLayout(DeleteUserLayout);
        DeleteUserLayout.setHorizontalGroup(
            DeleteUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteUserLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DeleteUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(DeleteUserLayout.createSequentialGroup()
                        .addGroup(DeleteUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(DeleteUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dpass, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                            .addComponent(dname)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DeleteUserLayout.createSequentialGroup()
                        .addGroup(DeleteUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DeleteUserLayout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(currentlabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DeleteUserLayout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(deleteuser, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(166, 166, 166)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        DeleteUserLayout.setVerticalGroup(
            DeleteUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteUserLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(currentlabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(DeleteUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dname, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(DeleteUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dpass, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteuser, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        NewUser.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("New User Name :");

        currentlabel2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        currentlabel2.setText("إضافة مستخدم جديد");

        newuser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("New Password :");

        newpass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        saveuser.setBackground(new java.awt.Color(255, 255, 255));
        saveuser.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        saveuser.setText("Save");
        saveuser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveuserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NewUserLayout = new javax.swing.GroupLayout(NewUser);
        NewUser.setLayout(NewUserLayout);
        NewUserLayout.setHorizontalGroup(
            NewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewUserLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(NewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NewUserLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(NewUserLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)))
                .addGroup(NewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(newuser, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                    .addComponent(newpass))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(NewUserLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(currentlabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NewUserLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveuser, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        NewUserLayout.setVerticalGroup(
            NewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NewUserLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(currentlabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(NewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newuser, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(NewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newpass, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(saveuser, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DeleteUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(currentdata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(changepassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NewUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(changepassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(currentdata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NewUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
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

    private void changepassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changepassActionPerformed
        
        if(chname.getText().equals("")
                || String.valueOf(chpasscon.getPassword()).equals(""))
        {
            JOptionPane.showMessageDialog(this,"Invalid New Username OR Password.");
            return;
        }
        if(isExist())
        {
            try {
                PreparedStatement stmt = con.prepareStatement("update user set username = ? , password = ? where username = ? AND password = ?");
                stmt.setString(1,chname.getText());
                stmt.setString(2,String.valueOf(chpasscon.getPassword()));
                stmt.setString(3,cname.getText());
                stmt.setString(4,String.valueOf(cpass.getPassword()));
                if(stmt.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(this,"Changes Saved Successfully.");
                    update();
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"ERROR .. Changes not Saved.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(settings.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Icorrect Username OR Password.");
        }
        
    }//GEN-LAST:event_changepassActionPerformed

    private void deleteuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteuserActionPerformed
        
        if(dname.getText().equals("")
                || String.valueOf(dpass.getPassword()).equals(""))
        {
            JOptionPane.showMessageDialog(this,"Invalid Username OR Password.");
            return;
        }
        if(isExist())
        {
            try {
                PreparedStatement stmt = con.prepareStatement("delete from user where username = ? AND password = ?");
                stmt.setString(1,dname.getText());
                stmt.setString(2,String.valueOf(dpass.getPassword()));
                if(stmt.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(this,"User Deleted Successfully.");
                    update();
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"ERROR .. User not Deleted.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(settings.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Icorrect Username OR Password.");
        }
        
    }//GEN-LAST:event_deleteuserActionPerformed

    private void saveuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveuserActionPerformed
        
        if(newuser.getText().equals("")
                || String.valueOf(newpass.getPassword()).equals(""))
        {
            JOptionPane.showMessageDialog(this,"Invalid New Username OR Password.");
            return;
        }
        if(isExist())
        {
            try {
                PreparedStatement stmt = con.prepareStatement("insert into user (username , password) values ( ? , ? ) ");
                stmt.setString(1,newuser.getText());
                stmt.setString(2,String.valueOf(newpass.getPassword()));
                if(stmt.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(this,"New User Saved Successfully.");
                    update();
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"ERROR .. Changes not Saved.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(settings.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Icorrect Username OR Password.");
        }
        
    }//GEN-LAST:event_saveuserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DeleteUser;
    private javax.swing.JPanel NewUser;
    private javax.swing.JButton changepass;
    private javax.swing.JPanel changepassword;
    private javax.swing.JTextField chname;
    private javax.swing.JPasswordField chpasscon;
    private javax.swing.JTextField cname;
    private javax.swing.JPasswordField cpass;
    private javax.swing.JPanel currentdata;
    private javax.swing.JLabel currentlabel;
    private javax.swing.JLabel currentlabel1;
    private javax.swing.JLabel currentlabel2;
    private javax.swing.JLabel currentlabel3;
    private javax.swing.JButton deleteuser;
    private javax.swing.JTextField dname;
    private javax.swing.JPasswordField dpass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField newpass;
    private javax.swing.JTextField newuser;
    private javax.swing.JButton saveuser;
    // End of variables declaration//GEN-END:variables
}
