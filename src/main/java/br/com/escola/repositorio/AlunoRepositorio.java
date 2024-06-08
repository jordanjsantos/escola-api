package br.com.escola.repositorio;

import br.com.escola.entidade.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlunoRepositorio extends JpaRepository<Aluno, UUID> {

}
