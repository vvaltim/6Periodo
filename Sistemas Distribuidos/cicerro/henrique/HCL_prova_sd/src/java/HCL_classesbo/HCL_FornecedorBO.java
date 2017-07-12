package HCL_classesbo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import HCL_classesdao.HCL_FornecedorDAO;
import java.util.List;
import HCL_objeto.HCL_Fornecedor;

/*
 *
 * @author USUARIO
*/

public class HCL_FornecedorBO // Business Object{
    
{
    
    HCL_FornecedorDAO HCL_cDAO;

    public HCL_FornecedorBO() { // interface serviço -> BO -> DAO -> Salva no banco de dados atraves dessa conexão
        // É camada e não MVC
        HCL_cDAO = new HCL_FornecedorDAO();
    }

    
    public void HCL_salva(HCL_Fornecedor HCL_forn){
        
        HCL_cDAO.HCL_salvar(HCL_forn);
     
    }
    
    public void HCL_exclui(int HCL_i){
        
        HCL_cDAO.HCL_excluir(HCL_i);
     
    }    
    
    public void HCL_edita (int HCL_i, HCL_Fornecedor HCL_forn){
        
         HCL_cDAO.HCL_editar(HCL_i, HCL_forn);
    }
    
    public List<HCL_Fornecedor> getHCL_Fornecedores(){ // Importar java.util.list
        
        return HCL_cDAO.getHCL_Fornecedores();
        
    }



    
}

