/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author D E L L
 */
public class CVCM_Vendas_Itens {
   
   
    private int codVenda;
    private int idProdutos;
    
    private int qtd;
    private float valor_Uni;

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public int getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(int idProdutos) {
        this.idProdutos = idProdutos;
    }

   
    

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public float getValor_Uni() {
        return valor_Uni;
    }

    public void setValor_Uni(float valor_Uni) {
        this.valor_Uni = valor_Uni;
    }
    
    
}
