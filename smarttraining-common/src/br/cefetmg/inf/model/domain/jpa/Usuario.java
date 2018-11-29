package br.cefetmg.inf.model.domain.jpa;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {

    @Id
    @Column(name = "cod_cpf")
    protected String cpf;

    @Column(name = "nom_usuario")
    protected String usuario;

    @Column(name = "idt_tipo")
    protected char tipo;

    @Column(name = "txt_senha")
    protected String senha;

    @Column(name = "des_email")
    protected String email;

    @Column(name = "dat_nascimento")
    protected LocalDate dataNascimento;

    public Usuario() {

    }

    public Usuario(String cpf, String nome, char tipo, String senha, String email, LocalDate dataNascimento) {
        this.cpf = cpf;
        this.usuario = nome;
        this.tipo = tipo;
        this.senha = senha;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.usuario = nome;
    }

    public String getNome() {
        return usuario;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public char getTipo() {
        return tipo;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
