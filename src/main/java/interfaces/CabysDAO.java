/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.SQLException;
import java.util.Vector;
import modelo.VO.CabysVO;


public interface CabysDAO {
    
    public CabysVO consultaCabys(String codigo) throws SQLException;
    public Object[][] listarCabys(String busqueda) throws SQLException;
    public Vector<CabysVO> vectorCabys(String busqueda) throws SQLException;
    
}
