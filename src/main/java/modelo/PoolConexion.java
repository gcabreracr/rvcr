package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;


public class PoolConexion {

    private static PoolConexion dataSource;
    private final BasicDataSource bds;

   
   
    // Conexion remota Recargas Virtuales
    private final String DB_NAME = Variables.DB_NAME;
    private final String DB_USER = "rvcr";
    private final String DB_PASS = "Rvcr$2323";
    private final String URL=Variables.IP_DB+DB_NAME;
    //private final String URL = "jdbc:mysql://198.71.225.61:3306/" + DB_NAME;

    private PoolConexion() {
        bds = new BasicDataSource();
        bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        bds.setUsername(DB_USER);
        bds.setPassword(DB_PASS);
        bds.setUrl(URL);
        
        bds.setValidationQuery("select 1");

    }

    public static PoolConexion getDataSource() {

        if (dataSource == null) {
            dataSource = new PoolConexion();
        }

        return dataSource;
    }

    public Connection getConnection() throws SQLException {
 
        return this.bds.getConnection();

    }

}
