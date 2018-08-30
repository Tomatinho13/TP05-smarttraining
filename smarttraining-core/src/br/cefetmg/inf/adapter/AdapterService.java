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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdapterService implements Runnable {

    private final InetAddress enderecoIP;
    private final int portaCliente;
    private final Pacote pacote;
    private final Gson gson;

    public AdapterService(InetAddress enderecoIP, int portaCliente, Pacote pacote) {
        this.enderecoIP = enderecoIP;
        this.portaCliente = portaCliente;
        this.pacote = pacote;
        gson = new Gson();
    }

    @Override
    public void run() {
        analisaRequisicao();
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
        IManterUsuario manterAluno = new ManterAluno();
        IManterUsuario manterInstrutor = new ManterInstrutor();

        switch (tipoOperacao) {
            case PESQ_APARELHO_NUM: {
                Aparelho aparelho = new Aparelho();
                try {
                    aparelho = manterAparelho.pesquisar(gson.fromJson(pacote.getDados().get(0), int.class));
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
                    aparelho = manterAparelho.pesquisar(gson.fromJson(pacote.getDados().get(0), String.class));
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
                ArrayList<Avaliacao> listaAvaliacoes = new ArrayList<>();
                try {
                    listaAvaliacoes = manterAvaliacao.pesquisarPorAluno(pacote.getDados().get(0));
                } catch (SQLException ex) {
                    Logger.getLogger(AdapterService.class.getName()).log(Level.SEVERE, null, ex);
                }
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(listaAvaliacoes));

                pacoteResposta = new Pacote(TipoOperacao.RESPOSTA, dados);

                try {
                    enviaResposta(pacoteResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterService.class.getName()).log(Level.SEVERE, null, ex);
                }

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
                ArrayList<Exercicio> listaExercicios = new ArrayList<>();
                try {
                    listaExercicios = manterExercicio.pesquisarPorRegiao(pacote.getDados().get(0));
                } catch (SQLException ex) {
                    Logger.getLogger(AdapterService.class.getName()).log(Level.SEVERE, null, ex);
                }
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(listaExercicios));

                pacoteResposta = new Pacote(TipoOperacao.RESPOSTA, dados);

                try {
                    enviaResposta(pacoteResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterService.class.getName()).log(Level.SEVERE, null, ex);
                }

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
                ArrayList<Musculo> listaMusculos = new ArrayList<>();
                try {
                    listaMusculos = manterMusculo.pesquisarTodos();
                } catch (SQLException ex) {
                    Logger.getLogger(AdapterService.class.getName()).log(Level.SEVERE, null, ex);
                }
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(listaMusculos));

                pacoteResposta = new Pacote(TipoOperacao.RESPOSTA, dados);

                try {
                    enviaResposta(pacoteResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterService.class.getName()).log(Level.SEVERE, null, ex);
                }

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
                ArrayList<Objetivo> listaObjetivos = new ArrayList<>();
                try {
                    listaObjetivos = manterObjetivo.pesquisarPorAvaliacao(pacote.getDados().get(0), LocalDate.parse(pacote.getDados().get(1)));
                } catch (SQLException ex) {
                    Logger.getLogger(AdapterService.class.getName()).log(Level.SEVERE, null, ex);
                }
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(listaObjetivos));

                pacoteResposta = new Pacote(TipoOperacao.RESPOSTA, dados);

                try {
                    enviaResposta(pacoteResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterService.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
            }
            case LISTA_OBJETIVO: {
                ArrayList<Objetivo> listaObjetivos = new ArrayList<>();
                try {
                    listaObjetivos = manterObjetivo.pesquisarTodos();
                } catch (SQLException ex) {
                    Logger.getLogger(AdapterService.class.getName()).log(Level.SEVERE, null, ex);
                }
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(listaObjetivos));

                pacoteResposta = new Pacote(TipoOperacao.RESPOSTA, dados);

                try {
                    enviaResposta(pacoteResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterService.class.getName()).log(Level.SEVERE, null, ex);
                }

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
                Usuario aluno = new Usuario();
                try {
                    aluno = manterAluno.pesquisarPorCpf(gson.fromJson(pacote.getDados().get(0), String.class));
                } catch (SQLException ex) {
                    Logger.getLogger(AdapterService.class.getName()).log(Level.SEVERE, null, ex);
                }
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(aluno));

                pacoteResposta = new Pacote(TipoOperacao.RESPOSTA, dados);

                try {
                    enviaResposta(pacoteResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterService.class.getName()).log(Level.SEVERE, null, ex);
                }
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
                Instrutor instrutor = new Instrutor();
                try {
                    instrutor = (Instrutor) manterInstrutor.pesquisarPorCpf(gson.fromJson(pacote.getDados().get(0), String.class));
                } catch (SQLException ex) {
                    Logger.getLogger(AdapterService.class.getName()).log(Level.SEVERE, null, ex);
                }
                ArrayList<String> dados = new ArrayList<>();

                dados.add(gson.toJson(instrutor));

                pacoteResposta = new Pacote(TipoOperacao.RESPOSTA, dados);

                try {
                    enviaResposta(pacoteResposta);
                } catch (IOException ex) {
                    Logger.getLogger(AdapterService.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case PESQ_INSTRUTOR_NOME: {
                break;
            }
            case CAD_INSTRUTOR: {
                try {
                    manterInstrutor.cadastrar(gson.fromJson(pacote.getDados().get(0), Instrutor.class));
                } catch (SQLException ex) {
                    Logger.getLogger(AdapterService.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    enviaResposta(new Pacote(TipoOperacao.RESPOSTA, new ArrayList<>()));
                } catch (IOException ex) {
                    Logger.getLogger(AdapterService.class.getName()).log(Level.SEVERE, null, ex);
                }

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
