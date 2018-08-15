package br.cefetmg.inf.controller;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletWeb extends HttpServlet {

    private String jsp;
    private final HashMap<String, Controller> controllers;

    public ServletWeb() {        
        controllers = new HashMap<>();
        controllers.put("Logar", new FazerLogin());
        controllers.put("AlterarAvaliacao", new AlterarAvaliacao());
        controllers.put("AlterarExercicio", new AlterarExercicio());
        controllers.put("AlterarUsuario", new AlterarUsuario());
        controllers.put("CadastrarAluno", new CadastrarAluno());
        controllers.put("CadastrarInstrutor", new CadastrarInstrutor());
        controllers.put("CadastrarAvaliacao", new CadastrarAvaliacao());
        controllers.put("CadastrarExercicio", new CadastrarExercicio());
        controllers.put("ListarAvaliacoes", new ListarAvaliacoes());
        controllers.put("ListarExercicios", new ListarExercicios());
        controllers.put("ListarFichas", new ListarFichas());
        controllers.put("ListarUsuarios", new ListarUsuarios());
        controllers.put("RemoverExercicio", new RemoverExercicio());
        controllers.put("RemoverUsuario", new RemoverUsuario());
        controllers.put("TelaRemoverUsuario", new TelaRemoverUsuario());
        controllers.put("TelaRemoverExercicio", new TelaRemoverExercicio());
        controllers.put("TelaCadastrarAvaliacao", new TelaCadastrarAvaliacao());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Controller controller = determinaController(request);
        jsp = controller.execute(request);
        
        //Redirecionando pagina
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }
    
    private Controller determinaController(HttpServletRequest request){
        return controllers.get(request.getParameter("acao"));
    }
}
