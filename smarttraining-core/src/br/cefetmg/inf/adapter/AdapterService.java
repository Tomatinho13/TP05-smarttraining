package br.cefetmg.inf.adapter;

import br.cefetmg.inf.Servidor;
import br.cefetmg.inf.model.domain.*;
import br.cefetmg.inf.model.services.impl.*;
import br.cefetmg.inf.model.services.*;
import br.cefetmg.inf.util.Pacote;
import br.cefetmg.inf.util.TipoOperacao;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdapterService implements Runnable {

    private InetAddress enderecoIP;
    private int portaCliente;
    private Pacote pacote;
    private Gson gson;

    public AdapterService(InetAddress enderecoIP, int portaCliente, Pacote pacote) {
        this.enderecoIP = enderecoIP;
        this.portaCliente = portaCliente;
        this.pacote = pacote;
        gson = new Gson();
    }

    @Override
    public void run() {
        analisaRequisicao();
        return;
    }

    public void enviaResposta(Pacote pacoteResposta) throws IOException {
        Servidor.enviaDados(enderecoIP, portaCliente, pacoteResposta);
    }

    public void analisaRequisicao() {
        TipoOperacao tipoOperacao = pacote.getTipoOperacao();
        Pacote pacoteResposta;

        IManterAparelho manterAparelho = new ManterAparelho();
        IManterAtividade manterAtividade = new ManterAtividade();
        IManterAvaliacao manterAvaliacao = new ManterAvaliacao();
        IManterExercicio manterExercicio = new ManterExercicio();
        IManterFicha manterFicha = new ManterFicha();
        IManterMusculo manterMusculo = new ManterMusculo();
        IManterObjetivo manterObjetivo = new ManterObjetivo();
        IManterRegiaoCorporal manterRegiaoCorporal = new ManterRegiaoCorporal();
        IManterTreino manterTreino = new ManterTreino();

        switch (tipoOperacao) {
            case PESQ_APARELHO_NUM: {
                Aparelho aparelho = new Aparelho();
                try {
                    aparelho = manterAparelho.pesquisar(pacote.getDados().get(0));
                } catch (SQLException ex) {
                    Logger.getLogger(AdapterService.class.getName()).log(Level.SEVERE, null, ex);
                }

                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(aparelho));

                pacoteResposta = new Pacote(TipoOperacao.RESPOSTA, dados);

                try {
                    enviaResposta(pacoteResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterService.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
            }
            case PESQ_APARELHO_NOME: {
                Aparelho aparelho = new Aparelho();
                try {
                    aparelho = manterAparelho.pesquisar(pacote.getDados().get(0));
                } catch (SQLException ex) {
                    Logger.getLogger(AdapterService.class.getName()).log(Level.SEVERE, null, ex);
                }
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(aparelho));

                pacoteResposta = new Pacote(TipoOperacao.RESPOSTA, dados);

                try {
                    enviaResposta(pacoteResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterService.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
            }
            case LISTA_APARELHO: {
                ArrayList<Aparelho> listaAparelhos = new ArrayList<>();
                try {
                    listaAparelhos = manterAparelho.pesquisarTodos();
                } catch (SQLException ex) {
                    Logger.getLogger(AdapterService.class.getName()).log(Level.SEVERE, null, ex);
                }
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(listaAparelhos));

                pacoteResposta = new Pacote(TipoOperacao.RESPOSTA, dados);

                try {
                    enviaResposta(pacoteResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterService.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
            }
            case CAD_APARELHO: {
                break;
            }
            case ALTERA_APARELHO: {
                break;
            }
            case EXCLUI_APARELHO: {
                break;
            }
            case PESQ_ATIVIDADE: {
                break;
            }
            case CAD_ATIVIDADE: {
                break;
            }
            case ALTERA_ATIVIDADE: {
                break;
            }
            case EXCLUI_ATIVIDADE: {
                break;
            }
            case LISTA_AVALIACAO_ALUNO: {
                break;
            }
            case PESQ_AVALIACAO: {
                break;
            }
            case CAD_AVALIACAO: {
                break;
            }
            case ALTERA_AVALIACAO: {
                break;
            }
            case EXCLUI_AVALIACAO: {
                break;
            }
            case PESQ_EXERCICIO_COD: {
                break;
            }
            case PESQ_EXERCICIO_NOME: {
                break;
            }
            case PESQ_APARELHOEXERCICIO: {
                break;
            }
            case LISTA_EXERCICIO_REGIAO: {
                break;
            }
            case LISTA_EXERCICIO_MUSCULO: {
                break;
            }
            case LISTA_EXERCICIO: {
                break;
            }
            case CAD_EXERCICIO: {
                break;
            }
            case CAD_APARELHOEXERCICIO: {
                break;
            }
            case ALTERA_EXERCICIO: {
                break;
            }
            case EXCLUI_EXERCICIO: {
                break;
            }
            case PESQ_FICHA: {
                break;
            }
            case LISTA_FICHA_ALUNO: {
                break;
            }
            case CAD_FICHA: {
                break;
            }
            case ALTERA_FICHA: {
                break;
            }
            case EXCLUI_FICHA: {
                break;
            }
            case PESQ_MUSCULO: {
                break;
            }
            case LISTA_MUSCULO: {
                break;
            }
            case CAD_MUSCULO: {
                break;
            }
            case ALTERA_MUSCULO: {
                break;
            }
            case EXCLUI_MUSCULO: {
                break;
            }
            case PESQ_OBJETIVO_COD: {
                break;
            }
            case PESQ_OBJETIVO_NOME: {
                break;
            }
            case LISTA_OBJETIVO_AVALIACAO: {
                break;
            }
            case LISTA_OBJETIVO: {
                break;
            }
            case CAD_OBJETIVO: {
                break;
            }
            case ALTERA_OBJETIVO: {
                break;
            }
            case EXCLUI_OBJETIVO: {
                break;
            }
            case PESQ_REGCORP: {
                break;
            }
            case CAD_REGCORP: {
                break;
            }
            case ALTERA_REGCORP: {
                break;
            }
            case EXCLUI_REGCORP: {
                break;
            }
            case PESQ_TREINO: {
                break;
            }
            case LISTA_TREINO_FICHA: {
                break;
            }
            case CAD_TREINO: {
                break;
            }
            case ALTERA_TREINO: {
                break;
            }
            case EXCLUI_TREINO: {
                break;
            }
            case PESQ_ALUNO_CPF: {
                break;
            }
            case PESQ_ALUNO_NOME: {
                break;
            }
            case CAD_ALUNO: {
                break;
            }
            case LISTA_ALUNO: {
                break;
            }
            case ALTERA_ALUNO: {
                break;
            }
            case EXCLUI_ALUNO: {
                break;
            }
            case PESQ_INSTRUTOR_CPF: {
                break;
            }
            case PESQ_INSTRUTOR_NOME: {
                break;
            }
            case CAD_INSTRUTOR: {
                break;
            }
            case LISTA_INSTRUTOR: {
                break;
            }
            case ALTERA_INSTRUTOR: {
                break;
            }
            case EXCLUI_INSTRUTOR: {
                break;
            }
        }
    }
}