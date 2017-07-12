package HCL_classesbo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import HCL_classesdao.HCL_ClienteDAO;
import java.util.List;
import HCL_objeto.HCL_Cliente;

/*
 *
 * @author USUARIO
*/

public class HCL_ClienteBO // Business Object{
    
{
    
    HCL_ClienteDAO HCL_cDAO;

    public HCL_ClienteBO() { // interface serviço -> BO -> DAO -> Salva no banco de dados atraves dessa conexão
        // É camada e não MVC
        HCL_cDAO = new HCL_ClienteDAO();
    }

    
    public void HCL_salva(HCL_Cliente HCL_c){
        
        HCL_cDAO.HCL_salvar(HCL_c);
     
    }
    
    public void HCL_exclui(int HCL_i){
        
        HCL_cDAO.HCL_excluir(HCL_i);
     
    }    
    
    public void HCL_edita (int HCL_i, HCL_Cliente HCL_c){
        
         HCL_cDAO.HCL_editar(HCL_i, HCL_c);
    }
    
    public List<HCL_Cliente> getHCL_Clientes(){ // Importar java.util.list
        
        return HCL_cDAO.getHCL_Clientes();
        
    }



    
}

