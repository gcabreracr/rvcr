package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.PoolConexion;

public class DocRecibidoDAOImpl {

    public static boolean consultaClave(String clave) throws SQLException {

        String sql = "SELECT clave_fe FROM doc_rec WHERE clave_fe=?";

        try (Connection conn = PoolConexion.getInstance().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setString(1, clave);

            try (ResultSet rs = ps.executeQuery()) {

                return rs.next();

            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }

        }
    }

}
