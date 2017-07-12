
package classesbo;

import classesdao.IAM_EntradaDAO;
import classesdao.IAM_Itens_EntradaDAO;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import objetos.IAM_Entrada;
import objetos.IAM_Itens_Entrada;



public class IAM_EntradaBO {
    
   IAM_EntradaDAO eDAO;
   IAM_Itens_EntradaDAO eiDAO;;

   
    public IAM_EntradaBO() {
       eDAO = new IAM_EntradaDAO();
       eiDAO = new IAM_Itens_EntradaDAO();
        
    }
     public List<IAM_Entrada> getEntrada()
    {
        return eDAO.getEntrada();
    }
    
    public void salvar(IAM_Entrada e)
    {
        List<IAM_Itens_Entrada> lstEI = new LinkedList<>();
        lstEI = e.getLstEI();
        
        int id = eDAO.salvar(e);
        if(id != -1)
        {
          
            for (IAM_Itens_Entrada entradaItens : lstEI) {
                entradaItens.setCodEntrada(id);
                eiDAO.salvar(entradaItens);
            } 
        }
    }    
    
    
    
}
