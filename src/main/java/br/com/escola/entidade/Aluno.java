package br.com.escola.entidade;

import br.com.escola.dto.AlunoDto;
import br.com.escola.enums.Curso;
import br.com.escola.enums.Modalidade;
import br.com.escola.enums.Turno;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "alunos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataMatricula;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private Curso curso;
    private Turno turno;
    private Modalidade modalidade;

    public Aluno(AlunoDto aluno) {
        this.id = aluno.id();
        this.dataMatricula = aluno.dataMatricula();
        this.nome = aluno.nome();
        this.cpf = aluno.cpf();
        this.telefone = aluno.telefone();
        this.email = aluno.email();
        this.curso = aluno.curso();
        this.turno = aluno.turno();
        this.modalidade = aluno.modalidade();
    }

}