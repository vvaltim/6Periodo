/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classebo;

import classeDAO.CVCM_VendaDAO;
import classeDAO.CVCM_Vendas_ItensDAO;
import java.util.LinkedList;
import java.util.List;
import objetos.CVCM_Venda;
import objetos.CVCM_Vendas_Itens;

/**
 *
 * @author D E L L
 */
public class CVCM_VendaBO {
    
    CVCM_VendaDAO eDAO;
   CVCM_Vendas_ItensDAO eiDAO;;

   
    public CVCM_VendaBO() {
       eDAO = new CVCM_VendaDAO();
       eiDAO = new CVCM_Vendas_ItensDAO();
        
    }
     public List<CVCM_Venda> getVenda()
    {
        return eDAO.getVenda();
    }
    
    public void salvar(CVCM_Venda e)
    {
        List<CVCM_Vendas_Itens> lstV = new LinkedList<>();
        lstV = e.getLstV();
        
        int id = eDAO.salvar(e);
        if(id != -1)
        {
          
            for (CVCM_Vendas_Itens vendaItens : lstV) {
                vendaItens.setCodVenda(id);
                eiDAO.salvar(vendaItens);
            } 
        }
    }    
}
