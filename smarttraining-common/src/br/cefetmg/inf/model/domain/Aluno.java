package br.cefetmg.inf.model.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Gabriel
 */
@Entity
@PrimaryKeyJoinColumn(name="cod_cpf")
public class Aluno extends Usuario implements Serializable{
}
