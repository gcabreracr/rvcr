
package interfaces;

import java.sql.SQLException;
import java.util.Vector;
import modelo.VO.TarifasVO;


public interface TarifasDAO {
    
    Vector<TarifasVO> llenaComboBox() throws SQLException;
    
}
