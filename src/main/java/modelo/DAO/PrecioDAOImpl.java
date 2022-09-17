package modelo.DAO;

import modelo.VO.PrecioVO;
import modelo.VO.ItemListaVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.PoolConexion;

public class PrecioDAOImpl {

    public static boolean consultaPrecio(PrecioVO precioVO) throws SQLException {

        String sql = "SELECT * FROM precios WHERE codigo_art=? AND cat_pdv=?";

        try (Connection conn = PoolConexion.getInstance().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setInt(1, precioVO.getCodigo_art());
            ps.setInt(2, precioVO.getCat_pdv());

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    precioVO.setPrecio_art(rs.getDouble("precio_art"));
                    precioVO.setDescto_art(rs.getInt("descto_art"));
                    precioVO.setCodTarifa(rs.getInt("codTarifa"));
                    precioVO.setDesTarifa(rs.getString("desTarifa"));
                    precioVO.setImpto_art(rs.getInt("impto_art"));
                    precioVO.setExento(rs.getInt("exento_art"));
                    precioVO.setRedondeo(rs.getInt("redondeo"));
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

    public static void actualizar(PrecioVO precio) {

        String sql = "UPDATE precios SET precio_art=?,descto_art=?, codTarifa=?, desTarifa=?, impto_art=?,exento_art=?,redondeo=?"
                + " WHERE codigo_art=? AND cat_pdv=?";

        try (Connection conn = PoolConexion.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setDouble(1, precio.getPrecio_art());
            ps.setInt(2, precio.getDescto_art());
            ps.setInt(3, precio.getCodTarifa());
            ps.setString(4, precio.getDesTarifa());            
            ps.setInt(5, precio.getImpto_art());
            ps.setInt(6, precio.getExento());
            ps.setInt(7, precio.getRedondeo());
            ps.setInt(8, precio.getCodigo_art());
            ps.setInt(9, precio.getCat_pdv());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// Fin Actualizar

    public static void incluir(PrecioVO precio) {

        String sql = "INSERT INTO precios (codigo_art,cat_pdv,precio_art,descto_art,codTarifa,desTarifa,impto_art,exento_art,redondeo)"
                + " VALUES(?,?,?,?,?,?,?,?,?)";

        try (Connection conn = PoolConexion.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setInt(1, precio.getCodigo_art());
            ps.setInt(2, precio.getCat_pdv());
            ps.setDouble(3, precio.getPrecio_art());
            ps.setInt(4, precio.getDescto_art());
            ps.setInt(5, precio.getCodTarifa());
            ps.setString(6, precio.getDesTarifa());
            ps.setInt(7, precio.getImpto_art());
            ps.setInt(8, precio.getExento());
            ps.setInt(9, precio.getRedondeo());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// Fin Incluir

    public static ArrayList<ItemListaVO> listaArticuloPDV(int catPdv) throws SQLException {

        ArrayList<ItemListaVO> listaArticulos = new ArrayList();
        ItemListaVO itemListaVo;
        String sql = "SELECT p.codigo_art,nom_lar_art,precio_art,redondeo,exento_art,impto_art,codTarifa FROM precios as p"
                + " INNER JOIN articulos AS a ON p.codigo_art=a.codigo_art"
                + " WHERE p.cat_pdv=" + catPdv
                + " ORDER BY nom_lar_art";

        try (Connection conn = PoolConexion.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    itemListaVo = new ItemListaVO();
                    itemListaVo.setCodigo_art(rs.getInt("codigo_art"));
                    itemListaVo.setNombre_art(rs.getString("nom_lar_art"));
                    itemListaVo.setPrecio_art(rs.getDouble("precio_art"));
                    itemListaVo.setExento(rs.getInt("exento_art"));
                    itemListaVo.setCodTarifa(rs.getString("codTarifa"));
                    itemListaVo.setImpto_art(rs.getInt("impto_art"));
                    itemListaVo.setRedondeo(rs.getInt("redondeo"));
                    listaArticulos.add(itemListaVo);
                }
            }

        } 

        return listaArticulos;
    }

}
