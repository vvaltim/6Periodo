package ws;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import javax.ws.rs.client.WebTarget;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author vvalt
 */
@Path("gestor")
public class GestorResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GestorResource
     */
    public GestorResource() {
    }
    
    /* --------------- metodos do grupo do WALTER --------------- */
    /* --------------- metodos do produto --------------- */
    //http://localhost:8080/Gestor/webresources/gestor/produto/cadastrarproduto
    @Path("produto/cadastrarproduto")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void cadastrarProduto(String content) throws IOException {
        System.out.println(content);
        
        String url = "http://localhost:8080/WVDRJ_WSProdutoEEstoque/webresources/produto/cadastrarproduto";

        URL obj = new URL(url);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("PUT");
        con.setRequestProperty("User-Agent", HttpHeaders.USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en,q=0.5");

        con.setDoOutput(true);
        DataOutputStream dos = new DataOutputStream(con.getOutputStream());
        dos.writeBytes(content);
        dos.flush();
        dos.close();
        
        int respCodigo = con.getResponseCode();
        System.out.println(respCodigo);
    }
    
    //http://localhost:8080/Gestor/webresources/gestor/produto/cadastrarmarca
    @Path("produto/cadastrarmarca")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void cadastrarMarca(String content) throws IOException {
        System.out.println(content);
        
        String url = "http://localhost:8080/WVDRJ_WSProdutoEEstoque/webresources/produto/cadastrarmarca";

        URL obj = new URL(url);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("PUT");
        con.setRequestProperty("User-Agent", HttpHeaders.USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en,q=0.5");

        con.setDoOutput(true);
        DataOutputStream dos = new DataOutputStream(con.getOutputStream());
        dos.writeBytes(content);
        dos.flush();
        dos.close();
        
        
        int respCodigo = con.getResponseCode();
        System.out.println(respCodigo);
    }
    
    //http://localhost:8080/Gestor/webresources/gestor/produto/cadastrarunidademedida
    @Path("produto/cadastrarunidademedida")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void cadastrarUnidadeMedida(String content) throws IOException {
        System.out.println(content);
        
        String url = "http://localhost:8080/WVDRJ_WSProdutoEEstoque/webresources/produto/cadastrarunidademedida";

        URL obj = new URL(url);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("PUT");
        con.setRequestProperty("User-Agent", HttpHeaders.USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en,q=0.5");

        con.setDoOutput(true);
        DataOutputStream dos = new DataOutputStream(con.getOutputStream());
        dos.writeBytes(content);
        dos.flush();
        dos.close();
        
        
        int respCodigo = con.getResponseCode();
        System.out.println(respCodigo);
    }

    //http://localhost:8080/Gestor/webresources/gestor/produto/listarMarcas
    @Path("produto/listarMarcas")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String listarMarcas() {
        String json = "";
        try {
            URL url = new URL("http://localhost:8080/WVDRJ_WSProdutoEEstoque/webresources/produto/listarmarcas");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            //se a conexão for errada
            if (con.getResponseCode() != 200) {
                throw new RuntimeException("HTTP code erro: " + con.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            json = br.readLine();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return json;
    }
    
    //http://localhost:8080/Gestor/webresources/gestor/produto/listarunidadesmedida
    @Path("produto/listarunidadesmedida")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String listarUnidadesMedida() {
        String json = "";
        try {
            URL url = new URL("http://localhost:8080/WVDRJ_WSProdutoEEstoque/webresources/produto/listarunidadesmedida");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            //se a conexão for errada
            if (con.getResponseCode() != 200) {
                throw new RuntimeException("HTTP code erro: " + con.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            json = br.readLine();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return json;
    }

    //http://localhost:8080/Gestor/webresources/gestor/produto/listarprodutos
    @Path("produto/listarprodutos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String listarProdutos() {
        String json = "";
        try {
            URL url = new URL("http://localhost:8080/WVDRJ_WSProdutoEEstoque/webresources/produto/listarprodutos");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            //se a conexão for errada
            if (con.getResponseCode() != 200) {
                throw new RuntimeException("HTTP code erro: " + con.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            json = br.readLine();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return json;
    }
    
    /* --------------- metodos de estoque --------------- */
    //http://localhost:8080/Gestor/webresources/gestor/estoque/adicionar/{idProduto}/{quantidade}
    @Path("estoque/adicionar/{idProduto}/{quantidade}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String adicionarEstoque(@PathParam("idProduto") int idProduto, @PathParam("quantidade") int quantidade) {
        String json = "";
        System.out.println("Id Produto: " + idProduto);
        System.out.println("Quantidade:" + quantidade);
        try {
            URL url = new URL("http://localhost:8080/WVDRJ_WSProdutoEEstoque/webresources/estoque/adicionarestoque/"+ idProduto + "/" + quantidade);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            //se a conexão for errada
            if (con.getResponseCode() != 200) {
                throw new RuntimeException("HTTP code erro: " + con.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            json = br.readLine();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return json;
    }
    
    //http://localhost:8080/Gestor/webresources/gestor/estoque/adicionar/{idProduto}/{quantidade}
    @Path("estoque/remover/{idProduto}/{quantidade}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String removerEstoque(@PathParam("idProduto") int idProduto, @PathParam("quantidade") int quantidade) {
        String json = "";
        System.out.println("Id Produto: " + idProduto);
        System.out.println("Quantidade:" + quantidade);
        try {
            URL url = new URL("http://localhost:8080/WVDRJ_WSProdutoEEstoque/webresources/estoque/removerestoque/"+ idProduto + "/" + quantidade);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            //se a conexão for errada
            if (con.getResponseCode() != 200) {
                throw new RuntimeException("HTTP code erro: " + con.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            json = br.readLine();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return json;
    }
 
    
    
    
    
    
    
    /* --------------- metodos do grupo do IGOR --------------- */
   



    
    
    
    

    /* --------------- metodos do grupo do HENRIQUE --------------- */

    /**
     *
     * @param c
     * @return
     */
    // ListarClientes
    //http://localhost:8080/Gestor/webresources/gestor/cliente/listarclientes
    @Path("cliente/listarclientes")   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String listarClientes(){
        String json = "";
        try {
            URL url = new URL("http://localhost:8080/HCL_prova_sd/wr/c");
            
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            
            //se a conexão for errada
            if (con.getResponseCode() != 200) {
                throw new RuntimeException("HTTP code erro: " + con.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            json = br.readLine();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
         return json;
    }
    // Listar Funcionarios
     //http://localhost:8080/Gestor/webresources/gestor/cliente/listarfuncionarios
    @Path("cliente/listarfuncionarios")   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String listarFuncionarios(){
        String json = "";
        try {
            URL url = new URL("http://localhost:8080/HCL_prova_sd/wr/funcionario");
            
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            
            //se a conexão for errada
            if (con.getResponseCode() != 200) {
                throw new RuntimeException("HTTP code erro: " + con.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            json = br.readLine();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
         return json;
    }
   
 // Listar Fornecedores
 //http://localhost:8080/Gestor/webresources/gestor/cliente/listarfornecedores
    @Path("cliente/listarfornecedores")   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String listarFornecedores(){
        String json = "";
        try {
            URL url = new URL("http://localhost:8080/HCL_prova_sd/wr/fornecedor");
            
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            
            //se a conexão for errada
            if (con.getResponseCode() != 200) {
                throw new RuntimeException("HTTP code erro: " + con.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            json = br.readLine();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
         return json;
    }
       
    
    
    
    
    /* --------------- metodos do grupo da CAMILA --------------- */
    
    
    
    
    
    
}
