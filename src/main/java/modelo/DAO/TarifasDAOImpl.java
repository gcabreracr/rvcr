/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import interfaces.TarifasDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import modelo.PoolConexion;
import modelo.VO.TarifasVO;

/**
 *
 * @author Usuario
 */
public class TarifasDAOImpl implements TarifasDAO {

    @Override
    public Vector<TarifasVO> llenaComboBox() throws SQLException {

        Vector<TarifasVO> listaTarifas = new Vector<>();

        TarifasVO tarifa;

        String sql = "SELECT codTarifa, desTarifa, porTarifa FROM tarifasFE";

        try (Connection conn = PoolConexion.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {

            try (ResultSet rs = ps.executeQuery();) {
                tarifa = new TarifasVO();
                tarifa.setCodTarifa(0);
                tarifa.setDesTarifa("Seleccione tarifa");
                tarifa.setPorTarifa(0);

                listaTarifas.add(tarifa);

                while (rs.next()) {
                    tarifa = new TarifasVO();
                    tarifa.setCodTarifa(rs.getInt("codTarifa"));
                    tarifa.setDesTarifa(rs.getString("desTarifa"));
                    tarifa.setPorTarifa(rs.getDouble("porTarifa"));
                    listaTarifas.add(tarifa);
                }
            }
        }
        return listaTarifas;
    }

}
