package br.com.escola.servico;

import br.com.escola.dto.AlunoDto;
import br.com.escola.entidade.Aluno;
import br.com.escola.repositorio.AlunoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        var busca = repositorio.findById(id);
        return busca.get();

    }
    public List<Aluno> buscarTodos() {

        return repositorio.findAll();
    }
}
