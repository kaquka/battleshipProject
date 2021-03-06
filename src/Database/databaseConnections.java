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
    private static final String dbName = "sql10489691";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String userName = "sql10489691";
    private static final String password = "yQkdRGx1Hk";
    
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
                ResultSet rs=stmt.executeQuery("SELECT Nombre_jug FROM Jugador WHERE Nombre_jug='"+nombre+"' AND Date_nacimiento ='"+fecha+"'");
                
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
    
    public String consultaID(String nombre, String fechaNacimiento) {
        Connection conn = null;
        
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(url+dbName, userName, password);

            if (!conn.isClosed()) {
                Statement stmt=conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT IDJugador FROM Jugador WHERE Nombre_jug='"+nombre+"' AND Date_nacimiento='"+fechaNacimiento+"'");
		rs.next();
                return rs.getString(1);
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
        return "";
    }
    
    public void agregarPartida(String id, int barcosHundidos) {
        Connection conn = null;
        int aux;
        
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(url+dbName, userName, password);

            if (!conn.isClosed()) {
                Statement stmt=conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT NumJuegos FROM Jugador WHERE IDJugador="+id);
                rs.next();
                aux=rs.getInt(1)+1;
                stmt.execute("UPDATE Jugador SET NumJuegos="+aux+" WHERE IDJugador="+id);
                stmt.execute("INSERT INTO partida (Barcos_hundidos, IDJugador) VALUES( '"+barcosHundidos+"', "+id+")");
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
    
    public String mostrarScore(String jugador, String fecha, int edad, String id) {
        Connection conn = null;
        
        String NombreJugador = "JUGADOR:";
        String EdadJugador = "EDAD: ";
        String NPartidas = "VECES QUE HA JUGADO: ";
        String DatosJuegos = "";
        
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(url+dbName, userName, password);

            if (!conn.isClosed()) {
                Statement stmt=conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT NumJuegos FROM Jugador WHERE Nombre_jug='"+jugador+"' AND Date_nacimiento ='"+fecha+"'");
                NombreJugador += jugador;
                EdadJugador += edad;
                rs.next();
                NPartidas += rs.getString(1);
                
                //Ahora vamos con determinar las partidas
                rs=stmt.executeQuery("SELECT Barcos_hundidos FROM partida WHERE IDJugador='"+id+"'");
                int i=1;
                while(rs.next()){
                    
                    if(Integer.parseInt(rs.getString(1))==10){
                        
                        DatosJuegos += "\tJuego "+i+": GANADOR.\n";
                    }else{
                        if(Integer.parseInt(rs.getString(1))==1){
                            DatosJuegos += "\tJuego "+i+": PERDEDOR  "+rs.getString(1)+" barco hundido.\n";
                        }else{
                            DatosJuegos += "\tJuego "+i+": PERDEDOR  "+rs.getString(1)+" barcos hundidos.\n";
                        }
                    }
                    i++;
                }
                
                
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
        return NombreJugador + "\n" + EdadJugador + " a??os.\n" + NPartidas + "\n"
            + DatosJuegos + "\n" ;
    }

    public Connection getConexion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
