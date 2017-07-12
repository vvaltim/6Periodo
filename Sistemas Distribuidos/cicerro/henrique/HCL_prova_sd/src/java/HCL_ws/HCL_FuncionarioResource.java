/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HCL_ws;

import HCL_classesbo.HCL_ClienteBO;
import HCL_classesbo.HCL_FornecedorBO;
import HCL_classesbo.HCL_FuncionarioBO;
import HCL_objeto.HCL_Cliente;
import HCL_objeto.HCL_Fornecedor;
import HCL_objeto.HCL_Funcionario;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author USUARIO
 */
@Path("funcionario")
public class HCL_FuncionarioResource {

    @Context
    private UriInfo HCL_context;

    /**
     * Creates a new instance of HCL_FornecedorResource
     */
    public HCL_FuncionarioResource() {
    }

    /**
     * Retrieves representation of an instance of HCL_ws.HCL_FornecedorResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<HCL_Funcionario> getJson() {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        
        System.out.println("Teste get funcionario");
        return new HCL_FuncionarioBO().getHCL_Funcionarios();
       
       
    }

    /**
     * PUT method for updating or creating an instance of HCL_FornecedorResource
     * @param content representation for the resource
     */
@PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String HCL_content) {
    
          System.out.println("Teste put funcionario");
       // System.out.println(content);
          Gson g = new Gson();
        
          
        // HCL_Cliente c = g.fromJson(content, HCL_Cliente.class);
         System.out.println("All"+HCL_content);
      //   System.out.println("Teste:"+c.getHCL_nome()+"-"+c.getHCL_Cpf()+"-"+c.getHCL_Email()+"-"+c.getHCL_Ano());
          System.out.println("Teste nro:"+HCL_content);
          String[] HCL_nroLinha = HCL_content.split(":");
          String   HCL_nroLinhaIni =HCL_nroLinha[5].replaceAll("}", "").trim();
        //  String[] nroLinhaIni2 = nroLinhaIni.split(",");
          String HCL_nroLinhaF = HCL_nroLinha[5]; 
          HCL_nroLinhaF=HCL_nroLinhaF.replaceAll("op", ""); 
          HCL_nroLinhaF=HCL_nroLinhaF.replaceAll(",", ""); 
          HCL_nroLinhaF=HCL_nroLinhaF.replace('"', ' ').trim();
          String HCL_nroLinha2F = HCL_nroLinha[6].replaceAll("}", "");
          HCL_nroLinha2F=HCL_nroLinha2F.replace('"', ' ').trim();
          System.out.println("Número a se excluir: " + HCL_nroLinhaF);
          System.out.println("Operação a ser realizada:" + HCL_nroLinha2F );
       
          int HCL_int_nroLinhaF = Integer.valueOf(HCL_nroLinhaF); // Número a ser enviado para excluir.
          int HCL_int_nroLinha2F = Integer.valueOf(HCL_nroLinha2F);
          
        if(HCL_int_nroLinha2F ==1){
            
          HCL_Funcionario HCL_func = g.fromJson(HCL_content, HCL_Funcionario.class);
          //System.out.println("Teste:"+c.getHCL_nome()+"-"+c.getHCL_Cpf()+"-"+c.getHCL_Email()+"-"+c.getHCL_Ano());
          new HCL_FuncionarioBO().HCL_edita(HCL_int_nroLinhaF, HCL_func);
        } 

        if(HCL_int_nroLinha2F ==2) {
            
           HCL_Funcionario HCL_func = g.fromJson(HCL_content, HCL_Funcionario.class);
      //   System.out.println("All"+content);
        //System.out.println("Teste:"+c.getHCL_nome()+"-"+c.getHCL_Cpf()+"-"+c.getHCL_Email()+"-"+c.getHCL_Ano());
          new HCL_FuncionarioBO().HCL_salva(HCL_func);
        }           
         
        if(HCL_int_nroLinha2F ==3) {
            
            
           new  HCL_FuncionarioBO().HCL_exclui(HCL_int_nroLinhaF);
     
         
   //       new HCL_ClienteBO().HCL_edita(int_nroLinhaF,c);    
        }
        
   } 
}
