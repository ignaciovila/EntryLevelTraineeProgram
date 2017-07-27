package com.cognizant;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DBUtil.recuperarConeccion();

            Statement consulta = connection.createStatement();
            String sql = "select last_name from actor group by last_name order by last_name ASC";
            ResultSet resultado = consulta.executeQuery(sql);
            while (resultado.next() == true) {
                System.out.println("Apellido: " + resultado.getString("last_name"));
            }

            sql = "insert into country (country) values (?)";
            PreparedStatement comandoInsert = connection.prepareStatement(sql);
            comandoInsert.setString(1, "Antigua y Barbuda");
            consulta = connection.createStatement();
            comandoInsert.execute();

            sql = "select * from country order by country ASC";
            resultado = consulta.executeQuery(sql);
            while (resultado.next() == true) {
                System.out.println(resultado.getString("country"));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error de DRIVER");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error SQL");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }
            System.out.println("Fin del Programa");
        }
    }
}