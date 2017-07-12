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
import java.util.LinkedList;
import java.util.List;
import objetos.CVCM_Vendas_Itens;

/**
 *
 * @author D E L L
 */
public class CVCM_Vendas_ItensDAO {
    
    Connection CVCM_conn;
    
    
     public CVCM_Vendas_ItensDAO() {
        CVCM_conn = new Conexao().conectar();
    }

  
     
      public void salvar(CVCM_Vendas_Itens e)
    {
        try
        {
            PreparedStatement ppStmt = CVCM_conn.prepareStatement("INSERT INTO cvcm_vendas_itens(idProduto, valor_Unitario, quantidade, idVendas) values(?,?,?,?)");
            
            ppStmt.setInt(1, e.getIdProdutos());
            ppStmt.setFloat(2, e.getValor_Uni());
            ppStmt.setInt(3, e.getQtd());
            
             ppStmt.setInt(4, e.getCodVenda());
             
          //  ppStmt.setInt(4, e.getCodEntrada());
            ppStmt.execute();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
      
     public List<CVCM_Vendas_Itens> getVendaItens(int id)
    {
        List<CVCM_Vendas_Itens> lstC = new LinkedList<>();
        try
        {
            PreparedStatement ppStmt = CVCM_conn.prepareStatement("SELECT * FROM cvcm_vendas_itens WHERE idVendas= ?");
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
    
    private CVCM_Vendas_Itens getEntradaItem(ResultSet rs) throws SQLException
    {
        CVCM_Vendas_Itens ie = new CVCM_Vendas_Itens();
        
        ie.setCodVenda(rs.getInt("idVendas"));
        ie.setIdProdutos(rs.getInt("idProduto"));
        ie.setQtd(rs.getInt("quantidade"));
        ie.setValor_Uni(rs.getFloat("valor_Unitario"));
        
        return ie;
    }
}
