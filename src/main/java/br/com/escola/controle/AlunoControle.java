package br.com.escola.controle;


import br.com.escola.dto.AlunoDto;
import br.com.escola.servico.AlunoServico;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("aluno")
@RequiredArgsConstructor
public class AlunoControle {

    private final AlunoServico servico;

    @PostMapping
    public ResponseEntity<AlunoDto> cadastrarAluno(@RequestBody @Valid AlunoDto aluno) {
        var cadastroMatricula = servico.cadastrarAluno(aluno);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("aluno/{id}")
                .buildAndExpand(cadastroMatricula.getId()).toUri();
        return ResponseEntity.created(uri).body(new AlunoDto(cadastroMatricula));
    }

    @GetMapping("{id}")
    public ResponseEntity<AlunoDto> buscarPorId(@PathVariable Long id) {
        var busca = servico.buscarPorId(id);
        return ResponseEntity.ok(new AlunoDto(busca));
    }
    @GetMapping
    public ResponseEntity<List<AlunoDto>> buscarTodos() {
        var buscar = servico.buscarTodos().stream().map(AlunoDto::new).toList();
        return ResponseEntity.ok(buscar);

    }
}
