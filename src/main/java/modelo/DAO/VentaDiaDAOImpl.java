package modelo.DAO;

import modelo.VO.VentaDiaVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.PoolConexion;

public class VentaDiaDAOImpl {

    public static ArrayList<VentaDiaVO> listaCargaDia(int age, int pdv, String fecha) throws SQLException {

        ArrayList<VentaDiaVO> listaCargaDia = new ArrayList();
        VentaDiaVO ventaDiaVo;

        String sql = "SELECT vd.codigo_art,nom_lar_art,carga_ini,recargas FROM ventadiaria AS vd"
                + " INNER JOIN articulos AS a ON vd.codigo_art=a.codigo_art"
                + " WHERE cod_agencia=? AND cod_pdv=? AND fecha_liq=? ORDER BY vd.codigo_art";

        try (Connection conn = PoolConexion.getDataSource().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setInt(1, age);
            ps.setInt(2, pdv);
            ps.setString(3, fecha);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    ventaDiaVo = new VentaDiaVO();
                    ventaDiaVo.setCodigo_art(rs.getInt("codigo_art"));
                    ventaDiaVo.setNom_lar_art(rs.getString("nom_lar_art"));
                    ventaDiaVo.setCarga_ini(rs.getInt("carga_ini"));
                    ventaDiaVo.setRecargas(rs.getInt("recargas"));
                    listaCargaDia.add(ventaDiaVo);
                }
            }

        }
        return listaCargaDia;
    }

    public static boolean consultaCargaArt(VentaDiaVO ventaDia) throws SQLException {

        String sql = "SELECT carga_ini,recargas FROM ventadiaria WHERE codigo_art=? AND cod_agencia=? AND cod_pdv=? AND fecha_liq=?";

        try (Connection conn = PoolConexion.getDataSource().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setInt(1, ventaDia.getCodigo_art());
            ps.setInt(2, ventaDia.getCod_agencia());
            ps.setInt(3, ventaDia.getCod_pdv());
            ps.setString(4, ventaDia.getFecha_liq());

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    ventaDia.setCarga_ini(rs.getInt("carga_ini"));
                    ventaDia.setRecargas(rs.getInt("recargas"));

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

    public static void incluyeCargaDia(VentaDiaVO ventaDia) throws SQLException {

        String sql = "INSERT INTO ventadiaria (codigo_art,cod_agencia,cod_pdv,fecha_liq,carga_ini,recargas) "
                + "VALUES(?,?,?,?,?,?)";

        try (Connection conn = PoolConexion.getDataSource().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setInt(1, ventaDia.getCodigo_art());
            ps.setInt(2, ventaDia.getCod_agencia());
            ps.setInt(3, ventaDia.getCod_pdv());
            ps.setString(4, ventaDia.getFecha_liq());
            ps.setInt(5, ventaDia.getCarga_ini());
            ps.setInt(6, ventaDia.getRecargas());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Fin Incluye Carga Diaria

    public static void actualizar(VentaDiaVO ventaDia) {

        String sql = "UPDATE ventadiaria SET carga_ini=?,recargas=?"
                + " WHERE codigo_art=? AND cod_agencia=? AND cod_pdv=? AND fecha_liq=?";

        try (Connection conn = PoolConexion.getDataSource().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setInt(1, ventaDia.getCarga_ini());
            ps.setInt(2, ventaDia.getRecargas());
            ps.setInt(3, ventaDia.getCodigo_art());
            ps.setInt(4, ventaDia.getCod_agencia());
            ps.setInt(5, ventaDia.getCod_pdv());
            ps.setString(6, ventaDia.getFecha_liq());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Fin Actualizar

}
