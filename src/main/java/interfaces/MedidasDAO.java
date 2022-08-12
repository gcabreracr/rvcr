
package interfaces;

import java.sql.SQLException;
import java.util.Vector;
import modelo.VO.MedidasVO;


public interface MedidasDAO {

    Vector<MedidasVO> llenaComboBox() throws SQLException;
    
}
