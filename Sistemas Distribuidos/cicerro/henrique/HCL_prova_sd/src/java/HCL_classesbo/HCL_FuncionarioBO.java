package HCL_classesbo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import HCL_classesdao.HCL_FuncionarioDAO;
import java.util.List;
import HCL_objeto.HCL_Funcionario;

/*
 *
 * @author USUARIO
*/

public class HCL_FuncionarioBO // Business Object{
    
{
    
    HCL_FuncionarioDAO HCL_cDAO;

    public HCL_FuncionarioBO() { // interface serviço -> BO -> DAO -> Salva no banco de dados atraves dessa conexão
        // É camada e não MVC
        HCL_cDAO = new HCL_FuncionarioDAO();
    }

    
    public void HCL_salva(HCL_Funcionario HCL_func){
        
        HCL_cDAO.HCL_salvar(HCL_func);
     
    }
    
    public void HCL_exclui(int HCL_i){
        
        HCL_cDAO.HCL_excluir(HCL_i);
     
    }    
    
    public void HCL_edita (int HCL_i, HCL_Funcionario HCL_func){
        
         HCL_cDAO.HCL_editar(HCL_i, HCL_func);
    }
    
    public List<HCL_Funcionario> getHCL_Funcionarios(){ // Importar java.util.list
        
        return HCL_cDAO.getHCL_Funcionarios();
        
    }



    
}

