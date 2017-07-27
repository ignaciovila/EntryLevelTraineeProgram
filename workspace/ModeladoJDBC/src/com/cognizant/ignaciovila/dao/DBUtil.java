package com.cognizant.ignaciovila.dao;

import java.sql.*;

public class DBUtil {
    public static Connection recuperarConeccion() throws ClassNotFoundException, SQLException {
        String nombreDriver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/ejemplo";
        Connection connection = null;
        Class.forName(nombreDriver);
        return DriverManager.getConnection(url, "root", "ignacio");
    }

    public static void cerrarConeccion(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
