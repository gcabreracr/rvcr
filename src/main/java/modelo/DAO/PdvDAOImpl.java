/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;



import modelo.VO.PdvVO;
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
public class PdvDAOImpl {
    
    
    public static boolean consultar(PdvVO pdv) throws SQLException {

        String sql = "SELECT * FROM rutas WHERE cod_agencia=? AND cod_pdv=?";

        try (Connection conn = PoolConexion.getDataSource().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setInt(1, pdv.getCodAgencia());
            ps.setInt(2, pdv.getCodPdv());

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    pdv.setNomPdv(rs.getString("nom_pdv"));
                    pdv.setCodBodega(rs.getString("cod_bodega"));
                    pdv.setCatPdv(rs.getInt("cat_pdv"));
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
}
