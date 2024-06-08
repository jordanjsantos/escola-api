package br.com.escola.entidade;

import br.com.escola.enums.Curso;
import br.com.escola.enums.Modalidade;
import br.com.escola.enums.Turno;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Entity
@Table(name = "alunos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private int matrícula = new Random().nextInt(1000 + 1);
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataMatricula = LocalDateTime.now();
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private Curso curso;
    private Turno turno;
    private Modalidade modalidade;
}
