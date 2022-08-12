/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.PoolConexion;
import modelo.VO.UsuarioPriVO;

/**
 *
 * @author gcabr
 */
public class UsuarioPriDAOImpl {
  
    public static void incluir(UsuarioPriVO usrPri) {

        String sql = "INSERT INTO usuarios_pri (cod_usuario,mnActDatos,mnRepCli,mnActProd,mnActPrec,mnAgencias,mnPdv,"
                + "mnEmiFac,mnAnuFac,mnAceRecFac,mnReeFacRec,mnFE_NC,mnFE_ND,mnFacCom,mnRepFac,mnLiqCarDia,mnLiqConEst,mnUsuarios)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = PoolConexion.getDataSource().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setString(1, usrPri.getCodUsuario());
            ps.setBoolean(2, usrPri.isMnActDat());
            ps.setBoolean(3, usrPri.isMnRepCli());
            ps.setBoolean(4, usrPri.isMnActProd());
            ps.setBoolean(5, usrPri.isMnActPrec());
            ps.setBoolean(6, usrPri.isMnActAgencias());
            ps.setBoolean(7, usrPri.isMnActPdv());
            ps.setBoolean(8, usrPri.isMnEmiFac());
            ps.setBoolean(9, usrPri.isMnAnuFac());
            ps.setBoolean(10, usrPri.isMnAceRecFac());
            ps.setBoolean(11, usrPri.isMnReeFacRec());
            ps.setBoolean(12, usrPri.isMnEmiNC());
            ps.setBoolean(13, usrPri.isMnEmiND());
            ps.setBoolean(14, usrPri.isMnFacCom());
            ps.setBoolean(15, usrPri.isMnRepFac());
            ps.setBoolean(16, usrPri.isMnLiqCarDia());
            ps.setBoolean(17, usrPri.isMnLiqConEst());
            ps.setBoolean(18, usrPri.isMnUsuarios());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);

        }

    }// Fin incluir 
    
    public static void modificar(UsuarioPriVO usrPri) {

        String sql = "UPDATE usuarios_pri SET mnActDatos=?,mnRepCli=?,mnActProd=?,mnActPrec=?,"
                + "mnAgencias=?,mnPdv=?,mnEmiFac=?,mnAnuFac=?,mnAceRecFac=?,mnReeFacRec=?,mnFE_NC=?,mnFE_ND=?,"
                + "mnFacCom=?,mnRepFac=?,mnLiqCarDia=?,mnLiqConEst=?,mnUsuarios=? WHERE cod_usuario=?";

        try (Connection conn = PoolConexion.getDataSource().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setBoolean(1, usrPri.isMnActDat());
            ps.setBoolean(2, usrPri.isMnRepCli());
            ps.setBoolean(3, usrPri.isMnActProd());
            ps.setBoolean(4, usrPri.isMnActPrec());
            ps.setBoolean(5, usrPri.isMnActAgencias());
            ps.setBoolean(6, usrPri.isMnActPdv());
            ps.setBoolean(7, usrPri.isMnEmiFac());
            ps.setBoolean(8, usrPri.isMnAnuFac());
            ps.setBoolean(9, usrPri.isMnAceRecFac());
            ps.setBoolean(10, usrPri.isMnReeFacRec());
            ps.setBoolean(11, usrPri.isMnEmiNC());
            ps.setBoolean(12, usrPri.isMnEmiND());
            ps.setBoolean(13, usrPri.isMnFacCom());
            ps.setBoolean(14, usrPri.isMnRepFac());
            ps.setBoolean(15, usrPri.isMnLiqCarDia());
            ps.setBoolean(16, usrPri.isMnLiqConEst());
            ps.setBoolean(17, usrPri.isMnUsuarios());
            ps.setString(18, usrPri.getCodUsuario());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// Fin incluir 

    public static boolean consulta(UsuarioPriVO usrPri) throws SQLException {

        String sql = "SELECT * FROM usuarios_pri WHERE cod_usuario=?";

        try (Connection conn = PoolConexion.getDataSource().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setString(1, usrPri.getCodUsuario());

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    usrPri.setMnActDat(rs.getBoolean("mnActDatos"));
                    usrPri.setMnRepCli(rs.getBoolean("mnRepCli"));
                    usrPri.setMnActProd(rs.getBoolean("mnActProd"));
                    usrPri.setMnActPrec(rs.getBoolean("mnActPrec"));
                    usrPri.setMnActAgencias(rs.getBoolean("mnAgencias"));
                    usrPri.setMnActPdv(rs.getBoolean("mnPdv"));
                    usrPri.setMnEmiFac(rs.getBoolean("mnEmiFac"));
                    usrPri.setMnAnuFac(rs.getBoolean("mnAnuFac"));
                    usrPri.setMnAceRecFac(rs.getBoolean("mnAceRecFac"));
                    usrPri.setMnReeFacRec(rs.getBoolean("mnReeFacRec"));
                    usrPri.setMnEmiNC(rs.getBoolean("mnFE_NC"));
                    usrPri.setMnEmiND(rs.getBoolean("mnFE_ND"));
                    usrPri.setMnFacCom(rs.getBoolean("mnFacCom"));
                    usrPri.setMnRepFac(rs.getBoolean("mnRepFac"));
                    usrPri.setMnLiqCarDia(rs.getBoolean("mnLiqCarDia"));
                    usrPri.setMnLiqConEst(rs.getBoolean("mnLiqConEst"));
                    usrPri.setMnUsuarios(rs.getBoolean("mnUsuarios"));

                    return true;
                } else {
                    return false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
    }

}
