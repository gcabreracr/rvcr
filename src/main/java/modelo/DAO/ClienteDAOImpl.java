package modelo.DAO;

import modelo.VO.ClienteVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.PoolConexion;

public class ClienteDAOImpl {

    public static boolean consultar(ClienteVO clienteVO) throws SQLException {

        String sql = "SELECT * FROM clientes WHERE cod_cliente=?";

        try (Connection conn = PoolConexion.getInstance().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setInt(1, clienteVO.getCod_cliente());
            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    clienteVO.setNom_cliente(rs.getString("nom_cliente"));
                    clienteVO.setNom_tributa(rs.getString("nom_tributa"));
                    clienteVO.setId_tributa(rs.getString("id_tributa"));
                    clienteVO.setTipo_id(rs.getString("tipo_id"));
                    clienteVO.setEmail_cliente(rs.getString("email_cliente"));
                    clienteVO.setTipo_neg(rs.getInt("tipo_negocio"));
                    clienteVO.setNom_contacto(rs.getString("nom_contacto"));
                    clienteVO.setTel_negocio(rs.getString("tel_negocio"));
                    clienteVO.setTel_contacto(rs.getString("tel_contacto"));
                    clienteVO.setIdProvincia(rs.getInt("idProvincia"));
                    clienteVO.setProvincia(rs.getString("provincia"));
                    clienteVO.setIdCanton(rs.getInt("idCanton"));
                    clienteVO.setCanton(rs.getString("canton"));                    
                    clienteVO.setIdDistrito(rs.getInt("idDistrito"));
                    clienteVO.setDistrito(rs.getString("distrito"));
                    clienteVO.setReferencia(rs.getString("referencia"));
                    clienteVO.setPor_descto(rs.getInt("por_descto"));
                    clienteVO.setMon_credito(rs.getInt("mon_credito"));
                    clienteVO.setPlazo_credito(rs.getInt("plazo_credito"));
                    clienteVO.setVis_lun(rs.getBoolean("vis_lun"));
                    clienteVO.setVis_mar(rs.getBoolean("vis_mar"));
                    clienteVO.setVis_mie(rs.getBoolean("vis_mie"));
                    clienteVO.setVis_jue(rs.getBoolean("vis_jue"));
                    clienteVO.setVis_vie(rs.getBoolean("vis_vie"));
                    clienteVO.setVis_sab(rs.getBoolean("vis_sab"));
                    clienteVO.setVis_dom(rs.getBoolean("vis_dom"));
                    clienteVO.setCod_agencia(rs.getInt("cod_agencia"));
                    clienteVO.setCod_ruta(rs.getInt("cod_ruta"));
                    clienteVO.setStatus_cli(rs.getBoolean("status_cli"));                    
                    clienteVO.setFecapertura(rs.getString("fecapertura"));
                    clienteVO.setShareKolbi(rs.getInt("sharekolbi"));
                    clienteVO.setShareMovistar(rs.getInt("sharemovistar"));
                    clienteVO.setCodigo_itec(rs.getString("codigo_itec"));

                    return true;
                } else {
                    return false;
                }

            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } finally {
                conn.close();
            }
        }
    }

    public static ArrayList<ClienteVO> listarClientesTable(int agencia, int pdv) throws SQLException {

        ArrayList<ClienteVO> listaClientes = new ArrayList();
        ClienteVO clienteVo;

        String sql = "SELECT cod_cliente,nom_cliente,provincia,canton,distrito,referencia"
                + " FROM clientes WHERE cod_agencia=? AND cod_ruta=?"
                + " ORDER BY nom_cliente";

        try (Connection conn = PoolConexion.getInstance().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setInt(1, agencia);
            ps.setInt(2, pdv);
            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    clienteVo = new ClienteVO();
                    clienteVo.setCod_cliente(rs.getInt("cod_cliente"));
                    clienteVo.setNom_cliente(rs.getString("nom_cliente"));
                    clienteVo.setProvincia(rs.getString("provincia"));
                    clienteVo.setCanton(rs.getString("canton"));
                    clienteVo.setDistrito(rs.getString("distrito"));
                    clienteVo.setReferencia(rs.getString("referencia"));
                    listaClientes.add(clienteVo);
                }

            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaClientes;
    }

    public static ArrayList<ClienteVO> listarClientesActivos(int agencia, int pdv) throws SQLException {

        ArrayList<ClienteVO> listaClientes = new ArrayList();
        ClienteVO clienteVo;

        String sql = "SELECT cod_cliente,nom_cliente,provincia,canton,distrito,referencia"
                + " FROM clientes WHERE cod_agencia=? AND cod_ruta=? AND status_cli=1"
                + " ORDER BY nom_cliente";

        try (Connection conn = PoolConexion.getInstance().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setInt(1, agencia);
            ps.setInt(2, pdv);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    clienteVo = new ClienteVO();
                    clienteVo.setCod_cliente(rs.getInt("cod_cliente"));
                    clienteVo.setNom_cliente(rs.getString("nom_cliente"));
                    clienteVo.setProvincia(rs.getString("provincia"));
                    clienteVo.setCanton(rs.getString("canton"));
                    clienteVo.setDistrito(rs.getString("distrito"));
                    clienteVo.setReferencia(rs.getString("referencia"));
                    listaClientes.add(clienteVo);
                }

            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaClientes;
    }

    public static int incluir(ClienteVO cliente) throws SQLException {

        int codNuevo = 0;

        String sql = "INSERT INTO clientes (nom_cliente, nom_tributa, id_tributa, tipo_id, email_cliente, nom_contacto,"
                + "tel_negocio, tel_contacto, provincia, idProvincia, canton, idCanton, distrito, idDistrito, referencia, por_descto, mon_credito, plazo_credito,"
                + "vis_lun, vis_mar, vis_mie, vis_jue, vis_vie, vis_sab, vis_dom, cod_agencia, cod_ruta, status_cli,"
                + "fecapertura, sharekolbi, sharemovistar, codigo_itec)"
                + "  VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = PoolConexion.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {

            ps.setString(1, cliente.getNom_cliente());
            ps.setString(2, cliente.getNom_tributa());
            ps.setString(3, cliente.getId_tributa());
            ps.setString(4, cliente.getTipo_id());
            ps.setString(5, cliente.getEmail_cliente());
            ps.setString(6, cliente.getNom_contacto());
            ps.setString(7, cliente.getTel_negocio());
            ps.setString(8, cliente.getTel_contacto());
            ps.setString(9, cliente.getProvincia());            
            ps.setInt(10, cliente.getIdProvincia());
            ps.setString(11, cliente.getCanton());
            ps.setInt(12, cliente.getIdCanton());
            ps.setString(13, cliente.getDistrito());
            ps.setInt(14, cliente.getIdDistrito());
            ps.setString(15, cliente.getReferencia());
            ps.setInt(16, cliente.getPor_descto());
            ps.setInt(17, cliente.getMon_credito());
            ps.setInt(18, cliente.getPlazo_credito());
            ps.setBoolean(19, cliente.isVis_lun());
            ps.setBoolean(20, cliente.isVis_mar());
            ps.setBoolean(21, cliente.isVis_mie());
            ps.setBoolean(22, cliente.isVis_jue());
            ps.setBoolean(23, cliente.isVis_vie());
            ps.setBoolean(24, cliente.isVis_sab());
            ps.setBoolean(25, cliente.isVis_dom());
            ps.setInt(26, cliente.getCod_agencia());
            ps.setInt(27, cliente.getCod_ruta());
            ps.setBoolean(28, cliente.isStatus_cli());            
            ps.setString(29, cliente.getFecapertura());
            ps.setInt(30, cliente.getShareKolbi());
            ps.setInt(31, cliente.getShareMovistar());
            ps.setString(32, cliente.getCodigo_itec());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {

                if (rs.next()) {
                    codNuevo = rs.getInt(1);
                }

            }
        } 
        return codNuevo;
    }// Fin de incluir

    public static void actualiza(ClienteVO cliente) throws SQLException {

        String sql = "UPDATE clientes SET nom_cliente=?,nom_tributa=?,id_tributa=?,tipo_id=?,email_cliente=?,nom_contacto=?,"
                + "tel_negocio=?,tel_contacto=?,idProvincia=?,provincia=?,idCanton=?,canton=?,idDistrito=?,distrito=?,referencia=?,por_descto=?,mon_credito=?,"
                + "plazo_credito=?,vis_lun=?,vis_mar=?,vis_mie=?,vis_jue=?,vis_vie=?,vis_sab=?,vis_dom=?,cod_agencia=?,"
                + "cod_ruta=?,status_cli=?,sharekolbi=?,sharemovistar=?,codigo_itec=?,feccamsta=? "
                + "WHERE cod_cliente=?";

        try (Connection conn = PoolConexion.getInstance().getConnection(); // This should return a NEW connection!
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setString(1, cliente.getNom_cliente());
            ps.setString(2, cliente.getNom_tributa());
            ps.setString(3, cliente.getId_tributa());
            ps.setString(4, cliente.getTipo_id());
            ps.setString(5, cliente.getEmail_cliente());
            ps.setString(6, cliente.getNom_contacto());
            ps.setString(7, cliente.getTel_negocio());
            ps.setString(8, cliente.getTel_contacto());
            ps.setInt(9, cliente.getIdProvincia());
            ps.setString(10, cliente.getProvincia());
            ps.setInt(11, cliente.getIdCanton());
            ps.setString(12, cliente.getCanton());
            ps.setInt(13, cliente.getIdDistrito());
            ps.setString(14, cliente.getDistrito());
            ps.setString(15, cliente.getReferencia());
            ps.setInt(16, cliente.getPor_descto());
            ps.setInt(17, cliente.getMon_credito());
            ps.setInt(18, cliente.getPlazo_credito());
            ps.setBoolean(19, cliente.isVis_lun());
            ps.setBoolean(20, cliente.isVis_mar());
            ps.setBoolean(21, cliente.isVis_mie());
            ps.setBoolean(22, cliente.isVis_jue());
            ps.setBoolean(23, cliente.isVis_vie());
            ps.setBoolean(24, cliente.isVis_sab());
            ps.setBoolean(25, cliente.isVis_dom());
            ps.setInt(26, cliente.getCod_agencia());
            ps.setInt(27, cliente.getCod_ruta());
            ps.setBoolean(28, cliente.isStatus_cli());
            ps.setInt(29, cliente.getShareKolbi());
            ps.setInt(30, cliente.getShareMovistar());
            ps.setString(31, cliente.getCodigo_itec());
            ps.setString(32, cliente.getFeccamsta());
            ps.setInt(33, cliente.getCod_cliente());
            ps.executeUpdate();

        } 
    }// Fin de actualizar

}
