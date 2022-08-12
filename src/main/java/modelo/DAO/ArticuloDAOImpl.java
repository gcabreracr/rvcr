package modelo.DAO;

import modelo.VO.ArticuloVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.PoolConexion;

public class ArticuloDAOImpl {

    public static boolean consultaArtxCodInt(ArticuloVO articulo) throws SQLException {

        String sql = "SELECT nom_lar_art,nom_cor_art,codMedida, uni_med, codCategoria, cod_barra, tipo_item, codigoCabys, status_art FROM articulos WHERE codigo_art=?";

        try (Connection conn = PoolConexion.getDataSource().getConnection(); 
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setInt(1, articulo.getCodigo_art());

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    articulo.setNom_lar_art(rs.getString("nom_lar_art"));
                    articulo.setNom_cor_art(rs.getString("nom_cor_art"));
                    articulo.setCodMedida(rs.getInt("codMedida"));
                    articulo.setUni_med(rs.getString("uni_med"));
                    articulo.setCodCategoria(rs.getInt("codCategoria"));
                    articulo.setCod_barra(rs.getString("cod_barra"));
                    articulo.setTipo_item(rs.getInt("tipo_item"));
                    articulo.setCodCabys(rs.getString("codigoCabys"));
                    articulo.setEsActivo(rs.getBoolean("status_art"));
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ArticuloDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }

        }
    }

    public static ArrayList<ArticuloVO> listarArticuloTable() throws SQLException {

        ArrayList<ArticuloVO> listaArticulos = new ArrayList();
        ArticuloVO articuloVO;

        String sql = "SELECT codigo_art,nom_lar_art FROM articulos ORDER BY nom_lar_art";

        try (Connection conn = PoolConexion.getDataSource().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {

            try (ResultSet rs = ps.executeQuery();) {

                while (rs.next()) {
                    articuloVO = new ArticuloVO();
                    articuloVO.setCodigo_art(rs.getInt("codigo_art"));
                    articuloVO.setNom_lar_art(rs.getString("nom_lar_art"));
                    listaArticulos.add(articuloVO);
                }
            }

        }

        return listaArticulos;
    }

    public static void actualizar(ArticuloVO articulo) throws SQLException {

        String sql = "UPDATE articulos SET nom_lar_art=?, nom_cor_art=?, codMedida=?, uni_med=?, codCategoria=?,cod_barra=?,tipo_item=?, codigoCabys=?, status_art=?"
                + " WHERE codigo_art=?";

        try (Connection conn = PoolConexion.getDataSource().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setString(1, articulo.getNom_lar_art());
            ps.setString(2, articulo.getNom_cor_art());
            ps.setInt(3, articulo.getCodMedida());
            ps.setString(4, articulo.getUni_med());
            ps.setInt(5, articulo.getCodCategoria());
            ps.setString(6, articulo.getCod_barra());
            ps.setInt(7, articulo.getTipo_item());
            ps.setString(8, articulo.getCodCabys());
            ps.setBoolean(9, articulo.getEsActivo());
            ps.setInt(10, articulo.getCodigo_art());
            ps.executeUpdate();

        }

    }// Fin Actualizar

    public static int incluir(ArticuloVO articulo) throws SQLException {
        int codNuevo = 0;
        String sql = "INSERT INTO articulos (nom_lar_art, nom_cor_art, codMedida, uni_med, codCategoria, cod_barra, tipo_item, codigoCabys, status_art)"
                + " VALUES(?,?,?,?,?,?,?,?,?)";

        try (Connection conn = PoolConexion.getDataSource().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {

            ps.setString(1, articulo.getNom_lar_art());
            ps.setString(2, articulo.getNom_cor_art());
            ps.setInt(3, articulo.getCodMedida());
            ps.setString(4, articulo.getUni_med());
            ps.setInt(5, articulo.getCodCategoria());
            ps.setString(6, articulo.getCod_barra());
            ps.setInt(7, articulo.getTipo_item());
            ps.setString(8, articulo.getCodCabys());
            ps.setBoolean(9, true);
            ps.execute();

            try (ResultSet rs = ps.getGeneratedKeys()) {

                if (rs.next()) {
                    codNuevo = rs.getInt(1);
                }
            }
        }
        return codNuevo;
    }// Fin Incluir

    public static boolean consultaArtxCodBarra(ArticuloVO articulo) throws SQLException {

        String sql = "SELECT codigo_art, nom_lar_art, nom_cor_art, codMedida, uni_med, codCategoria, tipo_item, codigoCabys, status_art FROM articulos WHERE cod_barra=?";

        try (Connection conn = PoolConexion.getDataSource().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setString(1, articulo.getCod_barra());

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    articulo.setNom_lar_art(rs.getString("nom_lar_art"));
                    articulo.setNom_cor_art(rs.getString("nom_cor_art"));
                    articulo.setCodMedida(rs.getInt("codMedida"));
                    articulo.setUni_med(rs.getString("uni_med"));
                    articulo.setCodCategoria(rs.getInt("codCategoria"));
                    articulo.setCodigo_art(rs.getInt("codigo_art"));
                    articulo.setTipo_item(rs.getInt("tipo_item"));
                    articulo.setCodCabys(rs.getString("codigoCabys"));
                    articulo.setEsActivo(rs.getBoolean("status_art"));
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
}
