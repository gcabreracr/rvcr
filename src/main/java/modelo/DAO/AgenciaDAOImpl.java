/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import modelo.VO.AgenciaVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.PoolConexion;

public class AgenciaDAOImpl {

    public static boolean consultar(AgenciaVO age) throws SQLException {

        String sql = "SELECT * FROM agencias WHERE cod_agencia=?";

        try (Connection conn = PoolConexion.getInstance().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setInt(1, age.getCodagencia());

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    age.setNomagencia(rs.getString("nom_agencia"));
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

}
