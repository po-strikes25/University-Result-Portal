
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Shilpi Mazumdar
 */
public class SignUpStudent extends javax.swing.JFrame {

    /**
     * Creates new form SignUpStudent
     */
    
    Connection connection;
    PreparedStatement prestatement;
    
    public SignUpStudent() {
        initComponents();
        try {
            try {
                // To establish connection with the SQL DB and server (link/stream)
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SignUpStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
            // To establish connection with database
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/studentmavendatabase", "root", "Lakshmi@06");
        } catch (SQLException ex) {
            Logger.getLogger(SignUpStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TO create the AdminID automatically for the admin
        autoID();
    }

    // MOST IMPORTANT FUNCTION FOR CONNECTION WITH SQL DB
    public void autoID() {
        try {
            //The above established connection helps to create statement
            java.sql.Statement statement = connection.createStatement();
            
            // Obtaining and storing the result of the statement and executing query indirectly on MYsql software
            ResultSet res = statement.executeQuery("Select MAX(rollno) from studentdata");
            
            // Next pointer/record
            res.next();
        
            //Handling the obtained result
            if(res.getString("MAX(rollno)") == null) {
                //Setting default customerID when res null
                rollno.setText("AUST660001");
            } else {
                // Get the MAX result and extract subtring (Last 3 Numbers) and increment
                long iD = Long.parseLong(res.getString("MAX(rollno)").substring(6,res.getString("MAX(rollno)").length()));
                iD++;

                rollno.setText("AUST66" + String.format("%03d", iD));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SignUpStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String doHashing(String password) {
        try {
            //In this Hashing Function we have used Message Digest Algorithm to secure the admin password
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());
            byte[] resultByteArray = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            
            for (byte b : resultByteArray) 
                sb.append(String.format("%02x", b));
            
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SignUpStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        banner = new javax.swing.JLabel();
        PassengerID = new javax.swing.JLabel();
        rollno = new javax.swing.JTextField();
        FirstName = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();
        Email = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        Password = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        LastName = new javax.swing.JLabel();
        lastname = new javax.swing.JTextField();
        Gender = new javax.swing.JLabel();
        btech = new javax.swing.JRadioButton();
        barch = new javax.swing.JRadioButton();
        Age = new javax.swing.JLabel();
        branch = new javax.swing.JComboBox<>();
        Contactno = new javax.swing.JLabel();
        contactno = new javax.swing.JTextField();
        verify = new javax.swing.JButton();
        createProfile = new javax.swing.JButton();
        resetdata = new javax.swing.JButton();
        cancelprofile = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 442));
        setMinimumSize(new java.awt.Dimension(800, 442));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(800, 442));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        banner.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        banner.setForeground(new java.awt.Color(255, 255, 255));
        banner.setText("New Student Profile Creation");
        getContentPane().add(banner, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 300, 29));

        PassengerID.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        PassengerID.setForeground(new java.awt.Color(255, 255, 255));
        PassengerID.setText("Roll No.");
        getContentPane().add(PassengerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 89, -1));

        rollno.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        rollno.setBorder(null);
        getContentPane().add(rollno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 180, 30));

        FirstName.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        FirstName.setForeground(new java.awt.Color(255, 255, 255));
        FirstName.setText("First Name");
        getContentPane().add(FirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 89, -1));

        firstname.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        firstname.setBorder(null);
        getContentPane().add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 180, 30));

        Email.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        Email.setForeground(new java.awt.Color(255, 255, 255));
        Email.setText("Email ");
        getContentPane().add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 89, -1));

        email.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        email.setBorder(null);
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 180, 30));

        Password.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        Password.setForeground(new java.awt.Color(255, 255, 255));
        Password.setText("Password");
        getContentPane().add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 89, -1));

        password.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        password.setText("  Please create a password");
        password.setBorder(null);
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 174, 30));

        LastName.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        LastName.setForeground(new java.awt.Color(255, 255, 255));
        LastName.setText("Last Name");
        getContentPane().add(LastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 89, -1));

        lastname.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        lastname.setBorder(null);
        getContentPane().add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 174, 30));

        Gender.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        Gender.setForeground(new java.awt.Color(255, 255, 255));
        Gender.setText("Course");
        getContentPane().add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 89, -1));

        btech.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btech.setForeground(new java.awt.Color(255, 255, 255));
        btech.setText("B.Tech");
        btech.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btech.setContentAreaFilled(false);
        getContentPane().add(btech, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, -1, -1));

        barch.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        barch.setForeground(new java.awt.Color(255, 255, 255));
        barch.setText("B.Arch");
        barch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        barch.setContentAreaFilled(false);
        getContentPane().add(barch, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, 90, -1));

        Age.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        Age.setForeground(new java.awt.Color(255, 255, 255));
        Age.setText("Branch");
        getContentPane().add(Age, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, 89, -1));

        branch.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "CSE", "ECE", "EEE", "CE", "ME", "IE", "PE", "IT", "Landscape", "Urban Planner", "Restoration", "Lighting", "Extreme" }));
        branch.setBorder(null);
        getContentPane().add(branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 140, 30));

        Contactno.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        Contactno.setForeground(new java.awt.Color(255, 255, 255));
        Contactno.setText("Contact No.");
        getContentPane().add(Contactno, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 100, -1));

        contactno.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        contactno.setBorder(null);
        getContentPane().add(contactno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 180, 30));

        verify.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        verify.setText("verify");
        verify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyActionPerformed(evt);
            }
        });
        getContentPane().add(verify, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 80, -1));

        createProfile.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        createProfile.setText("Create Profile");
        createProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createProfileActionPerformed(evt);
            }
        });
        getContentPane().add(createProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 150, -1));

        resetdata.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        resetdata.setText("Reset Data");
        resetdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetdataActionPerformed(evt);
            }
        });
        getContentPane().add(resetdata, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 350, 100, -1));

        cancelprofile.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        cancelprofile.setText("Cancel Profile Creation");
        cancelprofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelprofileActionPerformed(evt);
            }
        });
        getContentPane().add(cancelprofile, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, 170, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Shilpi Mazumdar\\Desktop\\Acciojob Projects\\Student Mgmt\\wallpaperflare.com_wallpaper (8).jpg")); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(800, 450));
        jLabel1.setMinimumSize(new java.awt.Dimension(800, 450));
        jLabel1.setPreferredSize(new java.awt.Dimension(800, 450));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 0, 890, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void verifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifyActionPerformed
        // To verify the email input by the administrator :
        if (!(Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", email.getText())))
        JOptionPane.showMessageDialog(null, "Please enter a valid email", "Error", JOptionPane.ERROR_MESSAGE);
        else
        JOptionPane.showMessageDialog(null, "Email Verified", "Verified", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_verifyActionPerformed

    private void createProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createProfileActionPerformed
        // Retrieveing data input by the passenger and storing in the passengers table
        String rollNo = rollno.getText();
        String passworD = doHashing(password.getText());
        String firstName = firstname.getText();
        String lastName = lastname.getText();

        String course = "";
        if(btech.isSelected())
        course = "B.Tech";
        else if(barch.isSelected())
        course = "B.Arch";

        String emailaddress = email.getText();
        String brancH = branch.getSelectedItem().toString();
        String contact = contactno.getText();

        try {
            // Preparing a statement to run a query in SQL
            prestatement = connection.prepareStatement("insert into studentdata(rollno, password, firstName, lastName, email, course, branch, contactNo)values(?,?,?,?,?,?,?,?)");
            // Set String of every field of passengers table - Similar to the Strings created above
            prestatement.setString(1, rollNo);
            prestatement.setString(2, passworD);
            prestatement.setString(3, firstName);
            prestatement.setString(4, lastName);
            prestatement.setString(5, emailaddress);
            prestatement.setString(6, course);
            prestatement.setString(7, brancH);
            prestatement.setString(8, contact);

            //Executing the query
            prestatement.executeUpdate();

            if(btech.isSelected() && barch.isSelected()){
                //Showing a message to select one option from male and female(gender)
                JOptionPane.showMessageDialog(null, "Please select one course");
            } else
            //Showing a message after successful addition of new passenger data to the passengers table
            JOptionPane.showMessageDialog(null, "Profile creation successful !");

        } catch (SQLException ex) {
            Logger.getLogger(SignUpStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_createProfileActionPerformed

    private void resetdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetdataActionPerformed
        // To reset data :
        firstname.setText("");
        lastname.setText("");
        email.setText("");
        branch.setSelectedIndex(0);
        contactno.setText("");
        password.setText("Please create a password");
        // To remove radioButton(gender) selection
        btech.setSelected(false);
        barch.setSelected(false);
    }//GEN-LAST:event_resetdataActionPerformed

    private void cancelprofileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelprofileActionPerformed
        // To cancel the registration window
        new MandatoryCheck().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelprofileActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new SignUpStudent().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Age;
    private javax.swing.JLabel Contactno;
    private javax.swing.JLabel Email;
    private javax.swing.JLabel FirstName;
    private javax.swing.JLabel Gender;
    private javax.swing.JLabel LastName;
    private javax.swing.JLabel PassengerID;
    private javax.swing.JLabel Password;
    private javax.swing.JLabel banner;
    private javax.swing.JRadioButton barch;
    private javax.swing.JComboBox<String> branch;
    private javax.swing.JRadioButton btech;
    private javax.swing.JButton cancelprofile;
    private javax.swing.JTextField contactno;
    private javax.swing.JButton createProfile;
    private javax.swing.JTextField email;
    private javax.swing.JTextField firstname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField lastname;
    private javax.swing.JTextField password;
    private javax.swing.JButton resetdata;
    private javax.swing.JTextField rollno;
    private javax.swing.JButton verify;
    // End of variables declaration//GEN-END:variables
}