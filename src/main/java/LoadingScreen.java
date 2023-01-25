

import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Shilpi Mazumdar
 */
public class LoadingScreen extends javax.swing.JFrame {

    /**
     * Creates new form LoadingScreen
     */
    public LoadingScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InternationalAirlineMavenPortal = new javax.swing.JLabel();
        poweredby = new javax.swing.JLabel();
        loadingBar = new javax.swing.JProgressBar();
        loading = new javax.swing.JLabel();
        loadvalue = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(480, 270));
        setMinimumSize(new java.awt.Dimension(480, 270));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        InternationalAirlineMavenPortal.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        InternationalAirlineMavenPortal.setForeground(new java.awt.Color(255, 255, 255));
        InternationalAirlineMavenPortal.setText("Alleyweis Technical University Portal");
        getContentPane().add(InternationalAirlineMavenPortal, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 350, -1));

        poweredby.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        poweredby.setForeground(new java.awt.Color(255, 255, 255));
        poweredby.setText("Powered by honeyBeeED");
        getContentPane().add(poweredby, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 180, -1));
        getContentPane().add(loadingBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 480, 20));

        loading.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        loading.setForeground(new java.awt.Color(255, 255, 255));
        loading.setText("Loading ...");
        getContentPane().add(loading, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 410, -1));

        loadvalue.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        loadvalue.setForeground(new java.awt.Color(255, 255, 255));
        loadvalue.setText("0 %");
        getContentPane().add(loadvalue, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Shilpi Mazumdar\\Desktop\\Acciojob Projects\\Student Mgmt\\wallpaperflare.com_wallpaper (25) (1).jpg")); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(480, 270));
        jLabel2.setMinimumSize(new java.awt.Dimension(480, 270));
        jLabel2.setPreferredSize(new java.awt.Dimension(480, 270));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 270));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        LoadingScreen loadingscreen = new LoadingScreen();
        loadingscreen.setVisible(true);
        
        try {
            for(int i = 0 ; i <= 100 ; i++) {
                Thread.sleep(100);
                loadingscreen.loadvalue.setText(i + "%");
                
                if(i == 10) 
                    loadingscreen.loading.setText("Establishing connection with the Management System . . .");
                if(i == 20) 
                    loadingscreen.loading.setText("Loading Student Data Files . . .");
                if(i == 40) 
                    loadingscreen.loading.setText("Loading Schedule and Curriculum . . .");
                if(i == 70) 
                    loadingscreen.loading.setText("Connection Successful !");
                if(i == 90) 
                    loadingscreen.loading.setText("Launching Application");
                loadingscreen.loadingBar.setValue(i);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        loadingscreen.setVisible(false);
        new MandatoryCheck().setVisible(true);
        loadingscreen.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel InternationalAirlineMavenPortal;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel loading;
    private javax.swing.JProgressBar loadingBar;
    private javax.swing.JLabel loadvalue;
    private javax.swing.JLabel poweredby;
    // End of variables declaration//GEN-END:variables
}
