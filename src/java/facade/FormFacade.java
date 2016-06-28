package facade;

import dao.ClienteDAO;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import model.Cliente;

/**
 *
 * @author Wesley
 */
public class FormFacade extends BaseFacade{
    //  LISTAR CLIENTES  ///////////////////////////////////////////////////////
    public String getListClientes(){
        try{
            ClienteDAO dao = new ClienteDAO();
            return html.getList(dao.listar());
        } catch (Exception ex) {
            return "Excepcion: " + ex.getMessage();
        }
    }    
    // SALVAR NUEVO CLIENTE  ////////////////////////////////////////////////////
    public String salvarCliente (HttpServletRequest req){
        try{
            // Recuperando os valores passados como parametros para el formulário            
            String noCliente = req.getParameter("cpNome");
            String emCliente = req.getParameter("cpEmail");
            String tlCliente = req.getParameter("cpTel");
            String sxCliente = req.getParameter("cpSexo");
            String dnCliente = req.getParameter("cpDataNasc");
            
            System.out.println(noCliente+" "+ emCliente+" "+ tlCliente+" "+ sxCliente+dnCliente);//Exibi dados no console para converri funcionamento. 

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            // Mostramos el objeto CandidatoVO
            Cliente c = new Cliente();
            c.setNome(noCliente);
            c.setEmail(emCliente);
            c.setTel(Long.parseLong(tlCliente));
            c.setSexo(sxCliente.charAt(0));
            c.setDtnasc(new java.sql.Date(sdf.parse(dnCliente).getTime()));
            
            // Persistindo dados atravez de ClienteDAO
            ClienteDAO dao = new ClienteDAO();
            dao.cadastar(c);
            
            System.out.println("Gravado!");//Confirmar salvamento.
            
            return "Candidato registrado correctamente";
            
        }catch (Exception ex){
            return "Excepcion: "+ex.getMessage();
        }
    }
    
    // PASA POR ID  ////////////////////////////////////////////////////////
    public String getPreencherForm(HttpServletRequest req) {
        try {
            
            String idCliente = req.getParameter("cpCodigo");
            System.out.println("Hasta ahora OK | --------- > "+idCliente);
            
            ClienteDAO dao = new ClienteDAO();
            return html.getFormAtualizar(dao.buscaporId(Integer.parseInt(idCliente)));
        } catch (Exception ex) {
            return "Excepcion: " + ex.getMessage();
        }
    }
    // ATUALIZAR CLIENTE  //////////////////////////////////////////////////////
    public String atualizarCliente (HttpServletRequest req){
        try{
            // Recuperando Los valores pasados como parametros poR formulário.            
            String idCliente = req.getParameter("cpCodigo");
            String noCliente = req.getParameter("cpNome");
            String emCliente = req.getParameter("cpEmail");
            String tlCliente = req.getParameter("cpTel");
            String sxCliente = req.getParameter("cpSexo");
            String dnCliente = req.getParameter("cpDataNasc");
            
            System.out.println(idCliente+" "+noCliente+" "+ emCliente+" "+ tlCliente+" "+ sxCliente+" "+dnCliente);//Testa se os valores estão corretos.

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            // Mostrado objeto CandidatoVO
            Cliente c = new Cliente();
            c.setId(Integer.parseInt(idCliente));
            c.setNome(noCliente);
            c.setEmail(emCliente);
            c.setTel(Long.parseLong(tlCliente));
            c.setSexo(sxCliente.charAt(0));
            c.setDtnasc(new java.sql.Date(sdf.parse(dnCliente).getTime()));
            
            // Persistindo dados no MySQL
            ClienteDAO dao = new ClienteDAO();
            dao.atualizar(c);
            
            System.out.println("Atualizado!");
            
            return "Cliente atualizado com sucesso";
            
        }catch (Exception ex){
            return "Excepcion: "+ex.getMessage();
        }
    }
    // EXCLUIR CLIENTE  ////////////////////////////////////////////////////////
    public String excluirCliente(HttpServletRequest request){
        try {
            String idCliente = request.getParameter("cpCodigo");
            
            ClienteDAO dao = new ClienteDAO();
            dao.excluir(Integer.parseInt(idCliente));            
            
            return "Cliente eliminado correctamente!";
        } catch (Exception ex) {
            return "Excepcion: " + ex.getMessage();
        }
    }
}