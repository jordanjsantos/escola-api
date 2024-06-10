package br.com.escola.controle;


import br.com.escola.dto.AlunoDto;
import br.com.escola.servico.AlunoServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("aluno")
@RequiredArgsConstructor
public class AlunoControle {

    private final AlunoServico servico;

    @PostMapping
    public ResponseEntity<AlunoDto>cadastrarAluno(@RequestBody AlunoDto aluno){
        var cadastroMatricula = servico.cadastrarAluno(aluno);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("aluno/{uri}")
                .buildAndExpand(cadastroMatricula.getId()).toUri();
        return ResponseEntity.created(uri).body(new AlunoDto(cadastroMatricula));
    }

    @GetMapping("{id}")
    public ResponseEntity<AlunoDto>buscarPorId(@PathVariable Long id){
        var busca = servico.buscarPorId(id);
        return ResponseEntity.ok(new AlunoDto(busca));
    }
}
