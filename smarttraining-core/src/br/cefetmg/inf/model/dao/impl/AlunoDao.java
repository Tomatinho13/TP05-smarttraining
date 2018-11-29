package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IUsuarioDao;
import br.cefetmg.inf.model.db.ConectaBd;
import com.google.gson.Gson;
import java.sql.*;
import br.cefetmg.inf.model.domain.Usuario;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AlunoDao implements IUsuarioDao {

    private Usuario aluno;
    private final Connection conn;
    private String sql;
    private final Gson gson;

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("SmartTrainingPU");
    EntityManager manager = factory.createEntityManager();

    public AlunoDao() {
        conn = ConectaBd.obterInstancia().obterConexao();
        gson = new Gson();
    }

    @Override
    public Usuario getUsuario(String codCpf) throws SQLException {
        sql = "SELECT * "
                + "FROM \"Usuario\" "
                + "WHERE cod_cpf = '" + codCpf + "' AND idt_tipo_usuario = 'A'";

        Query query = manager.createNativeQuery(sql);
        aluno = (Usuario) query.getSingleResult();

        return aluno;
    }

    @Override
    public Usuario getUsuarioPeloNome(String nome) throws SQLException {
        sql = "SELECT * "
                + "FROM \"Usuario\" "
                + "WHERE nom_usuario = '" + nome;

        Query query = manager.createNativeQuery(sql);
        aluno = (Usuario) query.getSingleResult();

        return aluno;
    }

    @Override
    public ArrayList<Usuario> getListaUsuarios() throws SQLException {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        sql = "SELECT * "
                + "FROM \"Usuario\" "
                + "WHERE idt_tipo_usuario='A'";

        Query query = manager.createNativeQuery(sql);

        return (ArrayList<Usuario>) query.getResultList();
    }

    @Override
    public boolean postUsuario(Usuario aluno) throws SQLException {
        this.aluno = aluno;
//        sql = "INSERT INTO \"Usuario\" VALUES (?,?,?,?,?,CAST(? as date));"
//                + "INSERT INTO \"Aluno\" "
//                + "VALUES((SELECT cod_cpf FROM \"Usuario\" "
//                + "WHERE cod_cpf = '" + aluno.getCpf() + "'))";

        try {
            manager.getTransaction().begin();
            manager.persist(aluno);
            manager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean putUsuario(Usuario aluno) throws SQLException {
        this.aluno = aluno;
//        sql = "UPDATE \"Usuario\" "
//                + "SET nom_usuario=?, "
//                + "idt_tipo_usuario=?, "
//                + "txt_senha=?, "
//                + "des_email=?, "
//                + "dat_nascimento=CAST(? as date) "
//                + "WHERE cod_cpf=?";

        try {
            manager.getTransaction().begin();
            manager.refresh(aluno);
            manager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean deleteUsuario(String codCpf) {
//        sql = "DELETE FROM \"Usuario\" "
//                + "WHERE cod_cpf='" + codCpf + "'";

        aluno = manager.find(Usuario.class, codCpf);
        try {
            manager.getTransaction().begin();
            manager.remove(aluno);
            manager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public void fechaConexao() {
        try {
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
