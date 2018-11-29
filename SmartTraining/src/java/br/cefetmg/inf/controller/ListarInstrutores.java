package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.proxy.ManterInstrutorProxy;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

public class ListarInstrutores extends Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp = "";

        try {
            jsp="ListaInstrutores";
            IManterUsuario manterInstrutor = new ManterInstrutorProxy();

            ArrayList<Usuario> listaInstrutores = manterInstrutor.pesquisarTodos();

            if(listaInstrutores == null){
                String erro="Nenhum instrutor encontrado!";
                jsp = "erro.jsp";
                request.setAttribute("erro", erro);
                return defineView(request, jsp);
            }
            
            request.setAttribute("instrutores", listaInstrutores);

        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro="Erro ao carregar lista de instrutores";
            jsp = "erro.jsp";
            request.setAttribute("erro", erro);
        } catch (RemoteException ex) {
            Logger.getLogger(ListarInstrutores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return defineView(request, jsp);
    }
}
