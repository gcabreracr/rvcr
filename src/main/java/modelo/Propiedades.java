/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Propiedades {

    File archivo;
    Properties prop;

    public Propiedades() {
        this.archivo = new File("config.properties");
        this.prop = new Properties();
    }

    public void crearArchivo() throws FileNotFoundException, IOException {

        try (OutputStream outputStream = new FileOutputStream(archivo)) {
            prop.setProperty("db.usuario", "");
            prop.store(outputStream, "Config");
        } 

    }

    public void ipServidor() throws FileNotFoundException, IOException {       

        try (InputStream inputStream = new FileInputStream(archivo)) {
            prop.load(inputStream);
            Variables.URL_SERVER = prop.getProperty("db.url.server");            
            Variables.IP_DB = "jdbc:mysql://"+prop.getProperty("db.ip.server")+":3306/";
            Variables.DB_NAME=prop.getProperty("db.name");
            
        }
      
    }
     public String leerUsuario() throws FileNotFoundException, IOException {      

        String usuario;
         try (InputStream inputStream = new FileInputStream(archivo)) {
            prop.load(inputStream);
            usuario=prop.getProperty("ultimo.usuario");           
        }
      return usuario;
    }


    public void updateUsuario(String codUsuario) {

        try (InputStream inputStream = new FileInputStream(archivo)) {
            prop.load(inputStream);
            
            try (OutputStream outputStream = new FileOutputStream(archivo)) {
                prop.setProperty("ultimo.usuario", codUsuario);
                prop.store(outputStream, "Config");
            }
        } catch (IOException ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
