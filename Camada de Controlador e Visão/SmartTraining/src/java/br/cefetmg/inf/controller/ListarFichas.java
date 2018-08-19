package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Ficha;
import br.cefetmg.inf.model.services.IManterFicha;
import br.cefetmg.inf.model.services.impl.ManterFicha;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class ListarFichas implements Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp;

        try {
            IManterFicha manterFicha = new ManterFicha();
            String codCpfAluno = (String) request.getAttribute("codCpfAluno").toString().replaceAll("[^0-9]", "");
            ArrayList<Ficha> listaFichas = manterFicha.pesquisarPorAluno(codCpfAluno);

            if (listaFichas != null) {
                request.setAttribute("listaFichas", listaFichas);
                jsp = "/ListaFichas.jsp";
            } else {
                String erro = "Nao existe registro de ficha!";
                request.setAttribute("erro", erro);
                jsp = "/erro.jsp";
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao listar fichas!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        }
        return jsp;
    }
}
