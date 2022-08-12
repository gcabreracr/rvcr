package interfaces;

import java.sql.SQLException;
import java.util.Vector;
import modelo.VO.CantonVO;
import modelo.VO.DistritoVO;
import modelo.VO.ProvinciaVO;

public interface DistGeoDAO {

    Vector<ProvinciaVO> llenaComboProvincias() throws SQLException;

    Vector<CantonVO> llenaComboCantones(int idProvincia) throws SQLException;

    Vector<DistritoVO> llenaComboDistritos(int idProvincia, int idCanton) throws SQLException;
}
