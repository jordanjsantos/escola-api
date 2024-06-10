package br.com.escola.dto;

import br.com.escola.entidade.Aluno;
import br.com.escola.enums.Curso;
import br.com.escola.enums.Modalidade;
import br.com.escola.enums.Turno;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public record AlunoDto(
        Long id,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataMatricula,
        String nome,
        String cpf,
        String telefone,
        String email,
        @Enumerated(EnumType.STRING)
        Curso curso,
        @Enumerated(EnumType.STRING)
        Turno turno,
        @Enumerated(EnumType.STRING)
        Modalidade modalidade) {
    public AlunoDto(Aluno cadastroMatricula) {
        this(
                cadastroMatricula.getId(),
                cadastroMatricula.getDataMatricula(),
                cadastroMatricula.getNome(),
                cadastroMatricula.getCpf(),
                cadastroMatricula.getTelefone(),
                cadastroMatricula.getEmail(),
                cadastroMatricula.getCurso(),
                cadastroMatricula.getTurno(),
                cadastroMatricula.getModalidade());
    }
}
