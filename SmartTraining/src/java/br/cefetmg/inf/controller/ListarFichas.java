package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Ficha;
import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterFicha;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.model.services.impl.ManterAluno;
import br.cefetmg.inf.model.services.impl.ManterFicha;

public class ListarFichas extends Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp;

        try {
            IManterFicha manterFicha = new ManterFicha();
            IManterUsuario manterAluno = new ManterAluno();
            String codCpfAluno = (String) request.getParameter("codCpfAluno").replaceAll("[^0-9]", "");
            Usuario aluno = manterAluno.pesquisarPorCpf(codCpfAluno);
            ArrayList<Ficha> listaFichas = manterFicha.pesquisarPorAluno(aluno.getCpf());

            if (!listaFichas.isEmpty()) {
                request.setAttribute("fichas", listaFichas);
                request.setAttribute("aluno", aluno);
                jsp = "/ListaFichas";
            } else {
                String erro = "Nao existe registro de ficha!";
                request.setAttribute("erro", erro);
                jsp = "/erro";
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao listar fichas!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        }
        return defineView(request, jsp);
    }
}
