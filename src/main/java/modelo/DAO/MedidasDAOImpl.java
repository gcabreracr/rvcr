package modelo.DAO;

import interfaces.MedidasDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import modelo.VO.MedidasVO;
import modelo.PoolConexion;

public class MedidasDAOImpl implements MedidasDAO {

    @Override
    public Vector<MedidasVO> llenaComboBox() throws SQLException {
        Vector<MedidasVO> listaMedidas = new Vector<>();

        MedidasVO medida;

        String sql = "SELECT codMedida, desMedida FROM medidasFE";

        try (Connection conn = PoolConexion.getDataSource().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {

            try (ResultSet rs = ps.executeQuery();) {
                medida = new MedidasVO();
                medida.setCodMedida(0);
                medida.setDesMedida("Seleccione una medida");
                listaMedidas.add(medida);

                while (rs.next()) {
                    medida = new MedidasVO();
                    medida.setCodMedida(rs.getInt("codMedida"));
                    medida.setDesMedida(rs.getString("desMedida"));
                    listaMedidas.add(medida);
                }
            }
        }
        return listaMedidas;
    }

}
