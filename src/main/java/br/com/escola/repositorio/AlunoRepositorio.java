package br.com.escola.repositorio;

import br.com.escola.entidade.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
public interface AlunoRepositorio extends JpaRepository<Aluno,Long> {
=======
import java.util.UUID;

public interface AlunoRepositorio extends JpaRepository<Aluno, UUID> {
>>>>>>> 9ab3f01ca99cb28900f399cdaab8710c682d5d52

}
