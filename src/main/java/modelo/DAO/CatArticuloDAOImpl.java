package modelo.DAO;

import interfaces.CatArticuloDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import modelo.PoolConexion;
import modelo.VO.CatArticuloVO;

public class CatArticuloDAOImpl implements CatArticuloDAO {

    @Override
    public Vector<CatArticuloVO> llenaComboBox() throws SQLException {

        Vector<CatArticuloVO> listaCategorias = new Vector<>();

        CatArticuloVO categoria;

        String sql = "SELECT codCategoria, desCategoria FROM catart";

        try (Connection conn = PoolConexion.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {

            try (ResultSet rs = ps.executeQuery();) {

                categoria = new CatArticuloVO();
                categoria.setCodCategoria(0);
                categoria.setDesCategoria("Seleccione una categoria");
                listaCategorias.add(categoria);

                while (rs.next()) {
                    categoria = new CatArticuloVO();
                    categoria.setCodCategoria(rs.getInt("codCategoria"));
                    categoria.setDesCategoria(rs.getString("desCategoria"));
                    listaCategorias.add(categoria);
                }
            }
        }
        return listaCategorias;

    }

}
