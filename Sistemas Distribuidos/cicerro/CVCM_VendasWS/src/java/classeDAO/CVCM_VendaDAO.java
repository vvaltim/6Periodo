/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classeDAO;

import banco.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import objetos.CVCM_Venda;

/**
 *
 * @author D E L L
 */
public class CVCM_VendaDAO {
     Connection CVCM_conn;

    public CVCM_VendaDAO() {
         CVCM_conn = new Conexao().conectar();
    }
    
    
     public int salvar(CVCM_Venda c)
    {
        int lastId = -1;
        try
        {
           PreparedStatement ppStmt = CVCM_conn.prepareStatement("INSERT INTO cvcm_venda(codV, idCliente, idVendedor) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ppStmt.setInt(1, c.getCodVe());
            ppStmt.setInt(2, c.getIdCliente());
            ppStmt.setInt(3, c.getIdVendedor());
            ppStmt.execute();
             final ResultSet rs = ppStmt.getGeneratedKeys();
            if (rs.next()) {
                lastId = rs.getInt(1);
            }
         
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
         return lastId;
       
    }
     
     
      public List<CVCM_Venda> getVenda()
    {
        List<CVCM_Venda> lstC = new LinkedList<>();
        try
        {
            PreparedStatement ppStmt = CVCM_conn.prepareStatement("SELECT * FROM cvcm_venda");
            ResultSet rs = ppStmt.executeQuery();
            while(rs.next())
            {
                lstC.add(getVendaItem(rs));
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return lstC;
    }
    
    private CVCM_Venda getVendaItem(ResultSet rs) throws SQLException
    {
        CVCM_Venda e = new CVCM_Venda();
        e.setCodVe(rs.getInt("codV"));
        e.setIdCliente(rs.getInt("idCliente"));
        e.setIdVendedor(rs.getInt("idVendedor"));
        e.setIdVendas(rs.getInt("idVendas")); 
        
       
        
       
        e.setLstV(new CVCM_Vendas_ItensDAO().getVendaItens(e.getIdVendas()));
    
        return e;
    }
}
