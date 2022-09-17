
package modelo.DAO;

import modelo.VO.ProveedorVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.PoolConexion;


public class ProveedorDAOImpl {
    
    public static boolean consulta(ProveedorVO proveedorVo) throws SQLException {

        String sql = "SELECT * FROM proveedores WHERE id_prov=?";

        try (Connection conn = PoolConexion.getInstance().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setString(1, proveedorVo.getIdProv());
            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    proveedorVo.setTipoIdProv(rs.getString("tipo_id"));
                    proveedorVo.setNomProv(rs.getString("nom_prov"));
                    proveedorVo.setNomComProv(rs.getString("nom_comercial"));
                    proveedorVo.setEmailProv(rs.getString("email_prov"));
                    proveedorVo.setTeleProv(rs.getString("telefono_prov"));
                    return true;
                } else {
                    return false;
                }

            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } finally {
                conn.close();
            }
        }
    }// Fin consulta proveedor
    
     public static void incluir(ProveedorVO proveedor) {
        
        

        String sql = "INSERT INTO proveedores (id_prov, tipo_id, nom_prov, nom_comercial, email_prov, telefono_prov)"
                + "  VALUES(?,?,?,?,?,?)";

       try (Connection conn = PoolConexion.getInstance().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {
                    
            ps.setString(1, proveedor.getIdProv());
            ps.setString(2, proveedor.getTipoIdProv());
            ps.setString(3, proveedor.getNomProv());
            ps.setString(4, proveedor.getNomComProv());
            ps.setString(5, proveedor.getEmailProv());
            ps.setString(6, proveedor.getTeleProv());           
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// Fin de incluir proveedor
     
      public static void actualizar(ProveedorVO proveedor) {
        
       

        String sql = "UPDATE proveedores SET nom_prov=?, nom_comercial=?, email_prov=?, telefono_prov=?"
                + " WHERE id_prov=?";

        try (Connection conn = PoolConexion.getInstance().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {
               
           
            ps.setString(1, proveedor.getNomProv());
            ps.setString(2, proveedor.getNomComProv());
            ps.setString(3, proveedor.getEmailProv());
            ps.setString(4, proveedor.getTeleProv()); 
            ps.setString(5, proveedor.getIdProv());
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// Fin Actualizar proveedor
    
}
