package br.com.escola.infra;

import br.com.escola.dto.MensagemDeErro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class TratarErros {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<MensagemDeErro> tratarIdNaoEncontrado() {
        var erros = new MensagemDeErro(HttpStatus.NOT_FOUND, "ID,não encontrado");
        return ResponseEntity.ok(erros);
    }
}