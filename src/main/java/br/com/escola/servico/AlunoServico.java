package br.com.escola.servico;

import br.com.escola.dto.AlunoDto;
import br.com.escola.entidade.Aluno;
import br.com.escola.repositorio.AlunoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlunoServico {

    private final AlunoRepositorio repositorio;

    public Aluno cadastrarAluno(AlunoDto aluno) {
        var cadastroMatricula = new Aluno(aluno);
        return repositorio.save(cadastroMatricula);
    }

    public Aluno buscarPorId(Long id) {
        Optional<Aluno> busca = repositorio.findById(id);
        return busca.orElseThrow(NoSuchElementException::new);
    }

    public List<Aluno> buscarTodos() {
        return repositorio.findAll();
    }

    public Aluno atualizarAluno(AlunoDto aluno, Long id) {
        var atualizar = new Aluno(aluno);
        atualizar.setId(id);
        return repositorio.save(atualizar);
    }

    public void excluir(Long id) {
        repositorio.findById(id);
        repositorio.deleteById(id);
    }

}
