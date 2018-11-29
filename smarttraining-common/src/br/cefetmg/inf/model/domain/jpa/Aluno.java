package br.cefetmg.inf.model.domain.jpa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="cod_cpf")
public class Aluno extends Usuario implements Serializable{
}
