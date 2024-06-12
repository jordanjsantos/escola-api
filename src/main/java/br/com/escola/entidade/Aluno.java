package br.com.escola.entidade;

import br.com.escola.dto.AlunoDto;
import br.com.escola.enums.Curso;
import br.com.escola.enums.Modalidade;
import br.com.escola.enums.Turno;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

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
