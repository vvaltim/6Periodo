/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HCL_utilitarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author USUARIO
 */
public class HCL_Conexao {
        
    final private String HCL_driver = "com.mysql.jdbc.Driver";
    final private String HCL_url = "jdbc:mysql://localhost/hcl_prova_sd";
    final private String HCL_usuario = "root";
    final private String HCL_senha = "vertrigo";
    
    public Connection HCL_conectar(){       
        
        Connection HCL_conn = null;
        try{
            Class.forName(HCL_driver);
            HCL_conn = DriverManager.getConnection(HCL_url,HCL_usuario,HCL_senha);
        }
        catch(ClassNotFoundException HCL_ex){
            HCL_ex.printStackTrace();
        }
        catch(SQLException HCL_ex){
            HCL_ex.printStackTrace();
        }
    return HCL_conn;}//
    
}
