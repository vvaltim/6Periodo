/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.util.List;

/**
 *
 * @author D E L L
 */
public class CVCM_Venda {
    private int idVendas;
    private int codVe;
    private int idCliente;
    private int idVendedor;
    private List<CVCM_Vendas_Itens> lstV;

    public int getIdVendas() {
        return idVendas;
    }

    public void setIdVendas(int idVendas) {
        this.idVendas = idVendas;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public List<CVCM_Vendas_Itens> getLstV() {
        return lstV;
    }

    public void setLstV(List<CVCM_Vendas_Itens> lstV) {
        this.lstV = lstV;
    }

    public int getCodVe() {
        return codVe;
    }

    public void setCodVe(int codVe) {
        this.codVe = codVe;
    }
    
    
}
