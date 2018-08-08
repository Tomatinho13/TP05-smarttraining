package br.cefetmg.inf.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletWeb extends HttpServlet {
    private String jsp = "";
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String acao = request.getParameter("acao");
        
        if(acao.equals("Logar"))
            jsp = FazerLogin.execute(request);
        else if (acao.equals("AlterarAvaliacao"))
            jsp = AlterarAvaliacao.execute(request);
        else if (acao.equals("AlterarExercicio"))
            jsp = AlterarExercicio.execute(request);
        else if (acao.equals("AlterarUsuario"))
            jsp = AlterarUsuario.execute(request);
        else if (acao.equals("CadastrarAluno"))
            jsp = CadastrarAluno.execute(request);
        else if (acao.equals("CadastrarInstrutor"))
            jsp = CadastrarInstrutor.execute(request);
        else if (acao.equals("CadastrarAvaliacao"))
            jsp = CadastrarAvaliacao.execute(request);
        else if (acao.equals("CadastrarExercicio"))
            jsp = CadastrarExercicio.execute(request);
        else if (acao.equals("ListarAvaliacoes"))
            jsp = ListarAvaliacoes.execute(request);
        else if (acao.equals("ListarExercicios"))
            jsp = ListarExercicios.execute(request);
        else if (acao.equals("ListarFichas"))
            jsp = ListarFichas.execute(request);
        else if (acao.equals("ListarUsuarios"))
            jsp = ListarUsuarios.execute(request);
        else if (acao.equals("RemoverExercicio"))
            jsp = RemoverExercicio.execute(request);
        else if (acao.equals("RemoverUsuario"))
            jsp = RemoverUsuario.execute(request);

        //Redirecionando pagina
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }    
}
