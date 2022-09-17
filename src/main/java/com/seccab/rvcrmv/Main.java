package com.seccab.rvcrmv;

import forms.VentanaPrincipal;
import forms.Splash;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.PoolConexion;
import modelo.Propiedades;
import modelo.Variables;

/**
 *
 * @author Gonzalo Cabrera
 *
 */
public class Main {

    public static void main(String[] args) throws UnsupportedLookAndFeelException, SQLException {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
                     
        Splash splash = new Splash();
        splash.setLocationRelativeTo(null);
        splash.setVisible(true);
        
        Propiedades prop = new Propiedades();
        
        try {
            prop.ipServidor();
            splash.lblMensaje.setText("Conectando con base de datos - IP: "+Variables.IP_DB+" - URL: "+Variables.URL_SERVER);
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(splash, "Error al leer archivo de configuracion");
            splash.dispose();
            System.exit(0);
        }
        

        try (Connection conn = PoolConexion.getInstance().getConnection()) {

            VentanaPrincipal principal = new VentanaPrincipal();

        } catch (SQLException ex) {
            Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en la conexion con el servidor");

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            splash.dispose();
        }
    }

}
