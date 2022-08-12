
package interfaces;

import java.sql.SQLException;
import java.util.Vector;
import modelo.VO.CatArticuloVO;


public interface CatArticuloDAO {
    
    public Vector<CatArticuloVO> llenaComboBox() throws SQLException;
    
}
