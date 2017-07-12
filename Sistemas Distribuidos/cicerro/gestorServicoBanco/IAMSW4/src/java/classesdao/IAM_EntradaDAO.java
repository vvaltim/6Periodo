
package classesdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import objetos.IAM_Entrada;
import utilitarios.Conexao;

public class IAM_EntradaDAO {
    
     Connection IAM_conn;

    public IAM_EntradaDAO() {
         IAM_conn = new Conexao().conectar();
    }
    
    
     public int salvar(IAM_Entrada c)
    {
        int lastId = -1;
        try
        {
           PreparedStatement ppStmt = IAM_conn.prepareStatement("INSERT INTO iam_entrada(codE, data, fornecedor, funcionario,valor_Nota) values(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ppStmt.setInt(1, c.getCodE());
            ppStmt.setString(2, c.getData());
            ppStmt.setInt(3, c.getFornecedor());
            ppStmt.setInt(4, c.getFuncionario());
            ppStmt.setFloat(5, c.getValor_Nota());
            ppStmt.execute();
             final ResultSet rs = ppStmt.getGeneratedKeys();
            if (rs.next()) {
                lastId = rs.getInt(1);
            }
         
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
         return lastId;
       
    }
     
     
      public List<IAM_Entrada> getEntrada()
    {
        List<IAM_Entrada> lstC = new LinkedList<>();
        try
        {
            PreparedStatement ppStmt = IAM_conn.prepareStatement("SELECT * FROM iam_entrada");
            ResultSet rs = ppStmt.executeQuery();
            while(rs.next())
            {
                lstC.add(getEntradaItem(rs));
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return lstC;
    }
    
    private IAM_Entrada getEntradaItem(ResultSet rs) throws SQLException
    {
        IAM_Entrada e = new IAM_Entrada();
        e.setIdEntradas(rs.getInt("identradas")); 
        e.setCodE(rs.getInt("codE"));
        e.setData(rs.getString("data"));
        e.setFornecedor(rs.getInt("fornecedor"));
        e.setFuncionario(rs.getInt("funcionario"));
        e.setValor_Nota(rs.getFloat("valor_Nota"));
        e.setLstEI(new IAM_Itens_EntradaDAO().getEntradaItens(e.getIdEntradas()));
    
        return e;
    }
    
}

