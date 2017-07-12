
package objetos;

import static java.util.Collections.list;
import java.util.LinkedList;
import java.util.List;

public class IAM_Entrada {

    private int idEntradas;
    private int codE;
    private String data;
    private int fornecedor;
    private int funcionario;
    private float valor_Nota;  
    private List<IAM_Itens_Entrada> lstEI;

    public int getCodE() {
        return codE;
    }

    public void setCodE(int codE) {
        this.codE = codE;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(int funcionario) {
        this.funcionario = funcionario;
    }

    public float getValor_Nota() {
        return valor_Nota;
    }

    public void setValor_Nota(float valor_Nota) {
        this.valor_Nota = valor_Nota;
    }

    public List<IAM_Itens_Entrada> getLstEI() {
        return lstEI;
    }

    public void setLstEI(List<IAM_Itens_Entrada> lstEI) {
        this.lstEI = lstEI;
    }
    
      public int getIdEntradas() {
        return idEntradas;
    }

    public void setIdEntradas(int idEntrada) {
        this.idEntradas = idEntrada;
    }
   

    
}
