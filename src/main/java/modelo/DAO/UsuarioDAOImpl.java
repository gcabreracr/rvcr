/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;


import modelo.VO.UsuarioVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.PoolConexion;


/**
 *
 * @author gcabr
 */
public class UsuarioDAOImpl{
         
    
    public static boolean registrar(UsuarioVO user) {
        return true;
    }

    public static boolean consultar(UsuarioVO usr) throws SQLException {

        //String sql = "SELECT * FROM usuarios WHERE codigo_usu=?";
        String sql = "SELECT u.codigo_usu,u.nombre_usu,u.pass_usu,u.tipo_usu,u.cod_pdv,r.cat_pdv,r.nom_pdv,u.cod_agencia,a.nom_agencia,"
                + "u.cod_bodega,u.status_usu "
                + "FROM usuarios AS u "
                + "INNER JOIN agencias AS a ON u.cod_agencia=a.cod_agencia "
                + "INNER JOIN rutas AS r ON u.cod_agencia=r.cod_agencia AND u.cod_pdv=r.cod_pdv "
                + "WHERE u.codigo_usu=?";

        try (Connection conn = PoolConexion.getInstance().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setString(1, usr.getCodigoUsu());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usr.setCodigoUsu(rs.getString("codigo_usu"));
                    usr.setNombreUsu(rs.getString("nombre_usu"));
                    usr.setPassUsu(rs.getString("pass_usu"));
                    usr.setTipoUsu(rs.getInt("tipo_usu"));
                    usr.setCodPDV(rs.getInt("cod_pdv"));
                    usr.setCatPDV(rs.getInt("cat_pdv"));
                    usr.setNomPDV(rs.getString("nom_pdv"));
                    usr.setCodAgencia(rs.getInt("cod_agencia"));
                    usr.setNomAgencia(rs.getString("nom_agencia"));
                    usr.setCodBodega(rs.getString("cod_bodega"));
                    usr.setStatusUsu(rs.getBoolean("status_usu"));
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
    }
        

    

    public static boolean login(UsuarioVO usr) throws SQLException {

        //  String sql = "SELECT * FROM usuarios WHERE codigo_usu=?";
        String sql = "SELECT u.codigo_usu,u.nombre_usu,u.pass_usu,u.tipo_usu,u.cod_pdv,r.nom_pdv,u.cod_agencia,a.nom_agencia,"
                + "u.cod_bodega,u.status_usu "
                + "FROM usuarios AS u "
                + "INNER JOIN agencias AS a ON u.cod_agencia=a.cod_agencia "
                + "INNER JOIN rutas AS r ON u.cod_agencia=r.cod_agencia AND u.cod_pdv=r.cod_pdv "
                + "WHERE u.codigo_usu=?";

        try (Connection conn = PoolConexion.getInstance().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setString(1, usr.getCodigoUsu());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    if (usr.getPassUsu().equals(rs.getString("pass_usu"))) {
                       // usr.setCodigoUsu(rs.getString("codigo_usu"));
                        usr.setNombreUsu(rs.getString("nombre_usu"));
                      //  usr.setPassUsu(rs.getString("pass_usu"));
                        usr.setTipoUsu(rs.getInt("tipo_usu"));
                        usr.setCodPDV(rs.getInt("cod_pdv"));
                        usr.setNomPDV(rs.getString("nom_pdv"));
                        usr.setCodAgencia(rs.getInt("cod_agencia"));
                        usr.setNomAgencia(rs.getString("nom_agencia"));
                        usr.setCodBodega(rs.getString("cod_bodega"));
                        usr.setStatusUsu(rs.getBoolean("status_usu"));
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }

    }

    public static void actualizar(UsuarioVO usr) {
        
       

        String sql = "UPDATE usuarios SET nombre_usu=?, tipo_usu=?, cod_agencia=?, cod_pdv=?, cod_bodega=?, status_usu=?"
                + " WHERE codigo_usu=?";

        try (Connection conn = PoolConexion.getInstance().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {
            
            
            ps.setString(1, usr.getNombreUsu());
            ps.setInt(2, usr.getTipoUsu());
            ps.setInt(3, usr.getCodAgencia());
            ps.setInt(4, usr.getCodPDV());
            ps.setString(5, usr.getCodBodega());
            ps.setBoolean(6, usr.getStatusUsu());
            ps.setString(7, usr.getCodigoUsu());
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// Fin Actualizar usuario

    public static void incluir(UsuarioVO usr) {
        
        

        String sql = "INSERT INTO usuarios (codigo_usu, nombre_usu, tipo_usu, cod_agencia, cod_pdv, cod_bodega, status_usu, pass_usu)"
                + "  VALUES(?,?,?,?,?,?,?,?)";

       try (Connection conn = PoolConexion.getInstance().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {
                    
            ps.setString(1, usr.getCodigoUsu());
            ps.setString(2, usr.getNombreUsu());
            ps.setInt(3, usr.getTipoUsu());
            ps.setInt(4, usr.getCodAgencia());
            ps.setInt(5, usr.getCodPDV());
            ps.setString(6, usr.getCodBodega());
            ps.setBoolean(7, usr.getStatusUsu());
            ps.setString(8, usr.getPassUsu());
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// Fin de incluir usuario
    
    public static void actualizaPin(UsuarioVO usr) {
        
        String sql = "UPDATE usuarios SET pass_usu=?"
                + " WHERE codigo_usu=?";

        try (Connection conn = PoolConexion.getInstance().getConnection(); 
                PreparedStatement ps = conn.prepareStatement(sql);) {
            
            
            ps.setString(1, usr.getPassUsu());
            ps.setString(2, usr.getCodigoUsu());
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// Fin Actualizar Password Usuario
}
