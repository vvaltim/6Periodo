/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesdao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import objetos.IAM_Entrada;
import objetos.IAM_Itens_Entrada;

import utilitarios.Conexao;
/**
 *
 * @author jonh
 */
public class IAM_Itens_EntradaDAO {
      
    
      Connection IAM_conn;
    
    
     public IAM_Itens_EntradaDAO() {
        IAM_conn = new Conexao().conectar();
    }

  
     
      public void salvar(IAM_Itens_Entrada e)
    {
        try
        {
            PreparedStatement ppStmt = IAM_conn.prepareStatement("INSERT INTO iam_itens_entrada(cod_Produto, valor_Unitario, quantidade,idEntradas) values(?,?,?,?)");
            ppStmt.setInt(1, e.getCod_Produto());
            ppStmt.setFloat(2, e.getValor_Unitario());
            ppStmt.setInt(3, e.getQuantidade());
            ppStmt.setInt(4, e.getCodEntrada());
             
          //  ppStmt.setInt(4, e.getCodEntrada());
            ppStmt.execute();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
      
     public List<IAM_Itens_Entrada> getEntradaItens(int id)
    {
        List<IAM_Itens_Entrada> lstC = new LinkedList<>();
        try
        {
            PreparedStatement ppStmt = IAM_conn.prepareStatement("SELECT * FROM iam_itens_entrada WHERE idEntradas= ?");
            ppStmt.setInt(1, id);
            ResultSet rs = ppStmt.executeQuery();
            while(rs.next())
            {
                lstC.add(getEntradaItem(rs));
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return lstC;
    }
    
    private IAM_Itens_Entrada getEntradaItem(ResultSet rs) throws SQLException
    {
        IAM_Itens_Entrada ie = new IAM_Itens_Entrada();
        
        ie.setCodEntrada(rs.getInt("idEntradas"));
        ie.setCod_Produto(rs.getInt("cod_Produto"));
        ie.setQuantidade(rs.getInt("quantidade"));
        ie.setValor_Unitario(rs.getFloat("valor_Unitario"));
        
        return ie;
    }
   	
    }


