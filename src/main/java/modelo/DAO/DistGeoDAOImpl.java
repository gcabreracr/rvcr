package modelo.DAO;

import interfaces.DistGeoDAO;
import modelo.VO.DistritoVO;
import modelo.VO.DireccionVO;
import modelo.VO.ProvinciaVO;
import modelo.VO.CantonVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import modelo.PoolConexion;

public class DistGeoDAOImpl implements DistGeoDAO {

    public static ArrayList<DireccionVO> listaDirecciones() throws SQLException {

        String sql = "SELECT idProvincia,idCanton,idDistrito,CONCAT(nomProvincia,', ',nomCanton,', ',nomDistrito,', ',nomBarrio) AS direccion FROM codificacion_geo where 1";

        ArrayList<DireccionVO> direcciones = new ArrayList<>();
        DireccionVO direccion;

        try (Connection conn = PoolConexion.getInstance().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    direccion = new DireccionVO();
                    direccion.setIdProvincia(rs.getInt("idProvincia"));
                    direccion.setIdCanton(rs.getInt("idCanton"));
                    direccion.setIdDistrito(rs.getInt("idDistrito"));
                    direccion.setDireccion(rs.getString("direccion"));
                    direcciones.add(direccion);

                }
            } 
        }

        return direcciones;
    }

    @Override
    public Vector<ProvinciaVO> llenaComboProvincias() throws SQLException {

        String sql = "SELECT idProvincia,nomProvincia FROM codificacion_geo GROUP BY idProvincia";

        Vector<ProvinciaVO> provincias = new Vector<>();
        ProvinciaVO provincia;

        try (Connection conn = PoolConexion.getInstance().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {

            try (ResultSet rs = ps.executeQuery()) {

                provincia = new ProvinciaVO();
                provincia.setIdProvincia(0);
                provincia.setNomProvincia("Seleccione una Provincia");
                provincias.add(provincia);

                while (rs.next()) {
                    provincia = new ProvinciaVO();
                    provincia.setIdProvincia(rs.getInt("idProvincia"));
                    provincia.setNomProvincia(rs.getString("nomProvincia"));
                    provincias.add(provincia);
                }
            } 
        }

        return provincias;

    }

    @Override
    public Vector<CantonVO> llenaComboCantones(int idProvincia) throws SQLException {

        String sql = "SELECT idCanton,nomCanton FROM codificacion_geo "
                + " WHERE idProvincia=" + idProvincia + " AND idCanton>0 GROUP BY idCanton";

        Vector<CantonVO> cantones = new Vector<>();
        CantonVO canton;

        try (Connection conn = PoolConexion.getInstance().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {

            try (ResultSet rs = ps.executeQuery()) {

                canton = new CantonVO();
                canton.setIdCanton(0);
                canton.setNomCanton("Seleccione un Canton");
                cantones.add(canton);

                while (rs.next()) {
                    canton = new CantonVO();
                    canton.setIdCanton(rs.getInt("idCanton"));
                    canton.setNomCanton(rs.getString("nomCanton"));
                    cantones.add(canton);
                }
            }
        }

        return cantones;

    }

    @Override
    public Vector<DistritoVO> llenaComboDistritos(int idProvincia, int idCanton) throws SQLException {

        String sql = "SELECT idDistrito,nomDistrito FROM codificacion_geo "
                + " WHERE idProvincia=" + idProvincia + " AND idCanton=" + idCanton + " AND idDistrito>0 GROUP BY idDistrito";

        Vector<DistritoVO> distritos = new Vector<>();
        DistritoVO distrito;

        try (Connection conn = PoolConexion.getInstance().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {

            try (ResultSet rs = ps.executeQuery()) {

                distrito = new DistritoVO();
                distrito.setIdDistrito(0);
                distrito.setNomDistrito("Seleccione un Canton");
                distritos.add(distrito);

                while (rs.next()) {
                    distrito = new DistritoVO();
                    distrito.setIdDistrito(rs.getInt("idDistrito"));
                    distrito.setNomDistrito(rs.getString("nomDistrito"));
                    distritos.add(distrito);
                }
            }
        }

        return distritos;
    }

}
