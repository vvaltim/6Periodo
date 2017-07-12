/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author D E L L
 */
public class Conexao {
    
    final private String driver = "com.mysql.jdbc.Driver";
    final private String url = "jdbc:mysql://localhost/bdcamila";
    final private String usuario = "root";
    final private String senha = "vertrigo";
    
    public Connection conectar()
    {
        Connection conn = null;
        try
        {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, senha);
        }
        catch(ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return conn;
    }
}
