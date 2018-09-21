package br.cefetmg.inf.model.domain;
import java.time.LocalDate;

/**
 *
 * @author Tomatinho
 */

public class Usuario {
    protected String cpf;
    protected String usuario;
    protected char tipo;
    protected String senha;
    protected String email;
    protected LocalDate dataNascimento;

    public Usuario(){
            
    }
    
    public Usuario(String cpf, String nome, char tipo, String senha, String email, LocalDate dataNascimento){
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
