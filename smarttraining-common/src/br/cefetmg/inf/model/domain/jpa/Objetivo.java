package br.cefetmg.inf.model.domain.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Tomatinho
 */
@Entity
public class Objetivo implements Serializable {
    @Id
    @Column(name="cod_objetivo")
    private int codigo;
    
    @Column(name="nom_objetivo")
    private String nome;
    
    @Column(name="des_objetivo")
    private String descricao;

    public Objetivo() {
    }

    public Objetivo(int codigo, String nome, String descricao) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}