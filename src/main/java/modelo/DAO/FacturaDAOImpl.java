
package modelo.DAO;

import modelo.VO.FacturaVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.PoolConexion;


public class FacturaDAOImpl {
    
     public static ArrayList<FacturaVO> listarFacturas(int agencia, int pdv, String fecha) throws SQLException {

        ArrayList<FacturaVO> listaFacturas = new ArrayList();
        FacturaVO facturaVo;

        String sql = "SELECT num_factura,consecutivo_fe,nom_factura,mon_subtotal,mon_descto,mon_impto"
                + " FROM facturas WHERE cod_agencia=? AND cod_pdv=? AND fec_factura=?"
                + " ORDER BY num_factura";

        try (Connection conn = PoolConexion.getDataSource().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setInt(1, agencia);
            ps.setInt(2, pdv);
            ps.setString(3, fecha);
            
            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    facturaVo = new FacturaVO();
                    facturaVo.setNum_factura(rs.getInt("num_factura"));
                    facturaVo.setConsecutivo_fe(rs.getString("consecutivo_fe"));
                    facturaVo.setNom_factura(rs.getString("nom_factura"));
                    facturaVo.setMon_subtotal(rs.getDouble("mon_subtotal"));
                    facturaVo.setMon_descto(rs.getDouble("mon_descto"));
                    facturaVo.setMon_impto(rs.getDouble("mon_impto"));                                       
                    listaFacturas.add(facturaVo);
                }

            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaFacturas;
    }
     
     
    
}
