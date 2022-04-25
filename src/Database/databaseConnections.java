/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.*;

/**
 *
 * @author avalo
 */
public class databaseConnections {
    private static final String url = "jdbc:mysql://sql10.freesqldatabase.com:3306/";
    private static final String dbName = "sql10487845";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String userName = "sql10487845";
    private static final String password = "Hk79fsHWJJ";
    

    public void consultaTemplate() {
        Connection conn = null;
        
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(url+dbName, userName, password);

            if (!conn.isClosed()) {
                Statement stmt=conn.createStatement();
                stmt.execute("");
		//aca se hace la consulta
            }
	} catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
	} finally {
            try {
		if (conn != null) {
                    conn.close();
		}
            } catch (SQLException e) {
                System.err.println("Exception: " + e.getMessage());
            }
	}
    }
    
    public boolean verificaJugador(String nombre, String fecha){
        Connection conn = null;
        
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(url+dbName, userName, password);

            if (!conn.isClosed()) {
                Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery("SELECT Nombre_jug FROM Jugador WHERE Nombre_jug = '"+nombre+"' AND Date_nacimiento = '"+fecha+"'");
                
                while (rs.next()) {
                    String databaseName = rs.getString(1);
                    if (databaseName.equals(nombre)) {
				return true;
                    }
                }
		//aca se hace la consulta
            }
	} catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
	} finally {
            try {
		if (conn != null) {
                    conn.close();
		}
            } catch (SQLException e) {
                System.err.println("Exception: " + e.getMessage());
            }
	}
        return false;
    }
    
    public void registro(String nombre, String fecha){
        Connection conn = null;
        
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(url+dbName, userName, password);

            if (!conn.isClosed()) {
                Statement stmt=conn.createStatement();
                stmt.execute("INSERT INTO Jugador (Nombre_jug, Date_nacimiento) VALUES ('"+nombre+"','"+fecha+"')");
		//aca se hace la consulta
            }
	} catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
	} finally {
            try {
		if (conn != null) {
                    conn.close();
		}
            } catch (SQLException e) {
                System.err.println("Exception: " + e.getMessage());
            }
	}
    }

}
