package modelo.DAO;

import modelo.VO.CatPdvVO;
import modelo.VO.ArticuloVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.PoolConexion;

public class CatPdvDAOImpl {

    public static boolean consultar(CatPdvVO catpdv) throws SQLException {

        String sql = "SELECT nom_cat_pdv FROM catpdv WHERE cat_pdv=?";

        try (Connection conn = PoolConexion.getDataSource().getConnection(); 
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setInt(1, catpdv.getCat_pdv());

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    catpdv.setNom_cat_pdv(rs.getString("nom_cat_pdv"));
                    return true;
                } else {
                    return false;
                }
            } 
        }
    }

    /*public static ArrayList<ArticuloVO> listarArticuloTable() throws SQLException {

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
    }*/

}
