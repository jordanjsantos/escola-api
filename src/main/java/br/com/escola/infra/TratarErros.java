package br.com.escola.infra;

import br.com.escola.dto.MensagemDeErro;
import br.com.escola.dto.TratandoErros;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class TratarErros {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<MensagemDeErro> tratarIdNaoEncontrado() {
        var erros = new MensagemDeErro(HttpStatus.NOT_FOUND, "ID, referente ao aluno não encontrado ");
        return new ResponseEntity<>(erros,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?>tratador400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(TratandoErros::new).toList());
    }

}