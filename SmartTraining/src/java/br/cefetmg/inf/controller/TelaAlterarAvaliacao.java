package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Avaliacao;
import br.cefetmg.inf.model.domain.Objetivo;
import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterAvaliacao;
import br.cefetmg.inf.model.services.IManterObjetivo;
import br.cefetmg.inf.model.services.impl.ManterAluno;
import br.cefetmg.inf.model.services.impl.ManterAvaliacao;
import br.cefetmg.inf.model.services.impl.ManterObjetivo;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import br.cefetmg.inf.model.services.IManterUsuario;

public class TelaAlterarAvaliacao implements Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp;
        try {
            jsp = "AlterarAvaliacao.jsp";
            String codCpfAluno = request.getParameter("codCpfAluno").trim();
            LocalDate dataAvaliacao = Date.valueOf(request.getParameter("dataAvaliacao")).toLocalDate();

            IManterUsuario manterAluno = new ManterAluno();
            IManterAvaliacao manterAvaliacao = new ManterAvaliacao();
            IManterObjetivo manterObjetivo = new ManterObjetivo();

            Usuario aluno = manterAluno.pesquisarPorCpf(codCpfAluno);

            Avaliacao avaliacao = manterAvaliacao.pesquisarPorAluno(codCpfAluno, dataAvaliacao);

            ArrayList<Objetivo> listaObjetivos = manterObjetivo.pesquisarPorAvaliacao(codCpfAluno, dataAvaliacao);
            if (avaliacao == null) {
                String erro = "Avaliacao nao encontrada no sistema!";
                request.setAttribute("erro", erro);
                jsp = "erro.jsp";
                return jsp;
            }
            else if(listaObjetivos.isEmpty()){
                String erro = "Nao ha objetivos cadastrados no sistema!";
                request.setAttribute("erro", erro);
                jsp = "erro.jsp";
                return jsp;
            }

            request.setAttribute("aluno", aluno);
            request.setAttribute("avaliacao", avaliacao);
            request.setAttribute("objetivos", listaObjetivos);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao encontrar avaliacao no sistema!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        }
        return jsp;
    }

}
