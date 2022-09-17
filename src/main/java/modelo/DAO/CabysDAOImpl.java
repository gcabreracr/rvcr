/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import interfaces.CabysDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.PoolConexion;
import modelo.VO.CabysVO;

/**
 *
 * @author Usuario
 */
public class CabysDAOImpl implements CabysDAO {

    @Override
    public CabysVO consultaCabys(String codigo) throws SQLException {
        CabysVO cabys = new CabysVO();
        String sql = "SELECT Codigo, Descripcion FROM cabys WHERE Codigo=?";

        try (Connection conn = PoolConexion.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setString(1, codigo);

            try (ResultSet rs = ps.executeQuery();) {

                if (rs.next()) {

                    cabys.setCodigo(rs.getString("Codigo"));
                    cabys.setDescrpcion(rs.getString("Descripcion"));
                    //cabys.setPorIVA(rs.getInt("IVA"));
                }
            }
        }
        return cabys;
    }

    @Override
    public Object[][] listarCabys(String busqueda) throws SQLException {
        Object[][] listaCabys=null;
        CabysVO codigoCabys;
        int numReg=0;
        String sql = "SELECT Codigo, Descripcion FROM cabys WHERE Descripcion LIKE '%" + busqueda.trim() + "%' ORDER BY Codigo";

        try (Connection conn = PoolConexion.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {

            try (ResultSet rs = ps.executeQuery();) {
                ResultSetMetaData rsMD = rs.getMetaData();                
                int numColumnas = rsMD.getColumnCount();

                if (rs.last()) {
                    numReg = rs.getRow();
                    rs.beforeFirst();
                }
                
                listaCabys = new Object[numReg][numColumnas];
                int idx = 0;                
                
                 while (rs.next()) {

                    for (int i = 0; i < numColumnas; i++) {

                        listaCabys[idx][i] = rs.getObject(i + 1);
                        //fila[i] = rs.getObject(i + 1);
                    }

                    idx++;
                }              
               
            }
        }

        return listaCabys;

    }

    @Override
    public Vector<CabysVO> vectorCabys(String busqueda) throws SQLException  {
        Vector<CabysVO> listaCabys = new Vector();
        CabysVO codigoCabys;
        String sql = "SELECT Codigo, Descripcion FROM cabys WHERE Descripcion LIKE '%" + busqueda + "%' ORDER BY Codigo";

        try (Connection conn = PoolConexion.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {

            try (ResultSet rs = ps.executeQuery();) {

                while (rs.next()) {
                    codigoCabys = new CabysVO();
                    codigoCabys.setCodigo(rs.getString("Codigo"));
                    codigoCabys.setDescrpcion(rs.getString("Descripcion"));
                    listaCabys.add(codigoCabys);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CabysDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            return listaCabys;
        }    

    }

}
