package br.com.escola.controle;


import br.com.escola.dto.AlunoDto;
import br.com.escola.servico.AlunoServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
@CrossOrigin(origins = "*")
public class AlunoControle {

    private final AlunoServico servico;

    @PostMapping
    @Operation(summary = "Rota responsável pelo cadastro de alunos")
    @ApiResponse(responseCode = "201",description = "aluno cadastrado com sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<AlunoDto> cadastrarAluno(@RequestBody @Valid AlunoDto aluno) {
        var cadastroMatricula = servico.cadastrarAluno(aluno);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("aluno/{id}")
                .buildAndExpand(cadastroMatricula.getId()).toUri();
        return ResponseEntity.created(uri).body(new AlunoDto(cadastroMatricula));
    }

    @GetMapping("{id}")
    @Operation(summary = "Rota responsável pela busca de aluno pelo id")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<AlunoDto> buscarPorId(@PathVariable Long id) {
        var busca = servico.buscarPorId(id);
        return ResponseEntity.ok(new AlunoDto(busca));
    }
    @GetMapping
    @Operation(summary = "Rota responsável pela busca de todos os alunos")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<List<AlunoDto>> buscarTodos() {
        var buscar = servico.buscarTodos().stream().map(AlunoDto::new).toList();
        return ResponseEntity.ok(buscar);

    }
    @PutMapping
    @Operation(summary = "Rota responsável por atualizar o aluno pelo id")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<AlunoDto>atualizarAluno(@RequestBody @Valid AlunoDto aluno,@PathVariable Long id){
        var atualize = servico.atualizarAluno(aluno, id);
        return ResponseEntity.ok().body(new AlunoDto(atualize));
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Rota responsável por deletar o aluno pelo id")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<Void>excluir(@PathVariable Long id){
        servico.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
