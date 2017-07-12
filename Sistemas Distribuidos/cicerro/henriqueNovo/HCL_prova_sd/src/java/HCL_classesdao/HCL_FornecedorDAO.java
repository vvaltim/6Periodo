package HCL_classesdao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
*/
// Retorna result set ou list de objetos


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;// linked e resultset
import java.util.logging.Level;
import java.util.logging.Logger;
import HCL_objeto.HCL_Fornecedor;
import HCL_utilitarios.HCL_Conexao;

/**
 *
 *
 * @author USUARIO
 */





public class HCL_FornecedorDAO {
  
    Connection HCL_conn;

    public HCL_FornecedorDAO() {
        HCL_conn = new HCL_Conexao().HCL_conectar();
    }
    
    public void  HCL_salvar(HCL_Fornecedor HCL_forn){
        
        try{
           
            PreparedStatement HCL_ppStmt = HCL_conn.prepareStatement("INSERT INTO fornecedor"
                    + "(nome, cpf, email, telefone) values(?,?,?,?)");
              //   ppStmt.setString(0, c.getId());//
                 HCL_ppStmt.setString(1, HCL_forn.getHCL_nome());
                 HCL_ppStmt.setString(2, HCL_forn.getHCL_Cpf());
                 HCL_ppStmt.setString(3, HCL_forn.getHCL_Email());
                 HCL_ppStmt.setString(4, HCL_forn.getHCL_Telefone()); 
                 HCL_ppStmt.execute();
        }
        catch(SQLException HCL_ex){
        Logger.getLogger(HCL_FornecedorDAO.class.getName()).log(Level.SEVERE, null, HCL_ex);
    }      
}
    int HCL_i=0;
    int[] HCL_nroId = new int[1000];
    
    public void HCL_excluir(int HCL_z){ // z é a mesma coisa de HCL_i , só que HCL_i está sendo usado
        try {
            // Consultar ID da linha que se deseja HCL_excluir no banco
            PreparedStatement HCL_ppStmt = HCL_conn.prepareStatement("SELECT * FROM fornecedor"
                   + " ORDER BY id ASC");
             ResultSet HCL_rs = HCL_ppStmt.executeQuery();
            
           while(HCL_rs.next()){
               HCL_i++;
               //System.out.println("rs = "+rs.getInt(1)+" Numero"+HCL_i);
               HCL_nroId[HCL_i] = HCL_rs.getInt(1);
        //       System.out.println(HCL_nroId[HCL_i]);
         }
           
           
           
           // Excluir ID referente a linha que se deseja HCL_excluir no banco
           PreparedStatement HCL_ppStmt2 = HCL_conn.prepareStatement("DELETE FROM fornecedor"
                 //  + " WHERE ID ="+HCL_nroId[100]+"");
                    + " WHERE ID = "+HCL_nroId[HCL_z]+"");
            HCL_ppStmt2.execute();
            
            
          }       
          catch (SQLException HCL_ex) {
            Logger.getLogger(HCL_FornecedorDAO.class.getName()).log(Level.SEVERE, null, HCL_ex);
        }
    }
    
        public void HCL_editar(int HCL_z,HCL_Fornecedor HCL_forn){ // z é a mesma coisa de HCL_i , só que HCL_i já está sendo usado
        try {
            // Consultar ID da linha que se deseja HCL_excluir no banco
            PreparedStatement ppStmt = HCL_conn.prepareStatement("SELECT * FROM fornecedor"
                   + " ORDER BY id ASC"); 
             ResultSet HCL_rs = ppStmt.executeQuery();
            
           while(HCL_rs.next()){
               HCL_i++;
               //System.out.println("rs = "+rs.getInt(1)+" Numero"+HCL_i);
               HCL_nroId[HCL_i] = HCL_rs.getInt(1);
               System.out.println(HCL_nroId[HCL_i]);
         }
           
           
           
           // Excluir ID referente a linha que se deseja HCL_excluir no banco
           PreparedStatement HCL_ppStmt2 = HCL_conn.prepareStatement("UPDATE fornecedor "
                    + "SET nome = ? , cpf = ? ,"
                    +     "email = ?, telefone= ? "
                    + " WHERE ID = "+HCL_nroId[HCL_z]+"");
               HCL_ppStmt2.setString(1, HCL_forn.getHCL_nome());
               HCL_ppStmt2.setString(2, HCL_forn.getHCL_Cpf());
               HCL_ppStmt2.setString(3, HCL_forn.getHCL_Email());
               HCL_ppStmt2.setString(4, HCL_forn.getHCL_Telefone()); 
       //    UPDATE `carro2` SET `modelo` = '4', `marca` = '4', `placa` = '4', `ano` = '4' WHERE `carro2`.`id` = 46
            HCL_ppStmt2.execute();
            
            
          }       
          catch (SQLException HCL_ex) {
            Logger.getLogger(HCL_FornecedorDAO.class.getName()).log(Level.SEVERE, null, HCL_ex);
        }
    }
    
  
  public  List<HCL_Fornecedor> getHCL_Fornecedores(){
     List<HCL_Fornecedor> HCL_LstForn = new LinkedList<>();
    
     
     
     try{
         PreparedStatement HCL_ppStmt = HCL_conn.prepareStatement("SELECT * FROM fornecedor");
         ResultSet HCL_rs = HCL_ppStmt.executeQuery();
         while(HCL_rs.next()){
             HCL_LstForn.add(getHCL_Fornecedore(HCL_rs));
         }
     }
     
     catch(SQLException HCL_ex){
         Logger.getLogger(HCL_FornecedorDAO.class.getName()).log(Level.SEVERE, null, HCL_ex);
         System.out.println("Fail");
     }

return HCL_LstForn;  }
  
     private HCL_Fornecedor getHCL_Fornecedore(ResultSet HCL_rs) throws SQLException{
         HCL_Fornecedor HCL_forn = new HCL_Fornecedor();
         HCL_forn.setHCL_nome(HCL_rs.getString("nome"));
         HCL_forn.setHCL_Cpf(HCL_rs.getString("cpf"));
         HCL_forn.setHCL_Email(HCL_rs.getString("email"));
         HCL_forn.setHCL_Telefone(HCL_rs.getString("telefone"));
         return HCL_forn;
     }
  
}
    


