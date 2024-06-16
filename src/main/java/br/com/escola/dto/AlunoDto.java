package br.com.escola.dto;

import br.com.escola.entidade.Aluno;
import br.com.escola.enums.Curso;
import br.com.escola.enums.Modalidade;
import br.com.escola.enums.Turno;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record AlunoDto(
        Long id,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataMatricula,
        @NotBlank(message = "Não pode estar em branco")
        String nome,
        @NotBlank(message = "Não pode estar em branco")
        String cpf,
        @NotBlank(message = "Não pode estar em branco")
        String telefone,
        @Email
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
