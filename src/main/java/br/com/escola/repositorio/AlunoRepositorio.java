package br.com.escola.repositorio;

import br.com.escola.entidade.Aluno;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepositorio extends JpaRepository<Aluno,Long> {

}
