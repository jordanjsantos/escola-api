package br.com.escola.servico;

import br.com.escola.dto.AlunoDto;
import br.com.escola.entidade.Aluno;
import br.com.escola.enums.Curso;
import br.com.escola.enums.Modalidade;
import br.com.escola.enums.Turno;
import br.com.escola.repositorio.AlunoRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class AlunoServicoTest {


    public static final String NOME = "Carlos";
    public static final String CPF = "1234";
    public static final String TELEFONE = "123";
    public static final String MAIL = "carlos@gmail.com";

    public static final long ID = 1L;
    public static final String ID_REFERENTE_AO_ALUNO_NAO_ENCONTRADO = "ID, referente ao aluno não encontrado ";
    @InjectMocks
    private AlunoServico alunoServico;
    @Mock
    private AlunoRepositorio alunoRepositorio;
    private Aluno aluno;
    private AlunoDto alunoDto;
    private Optional<Aluno> optionalAluno;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        start();
    }
    @Test
    void cadastrarAluno() {
    }

    @Test
    void  quandoBuscarPorIdRetorneUmaInstanciaDeUsuario() {
        when(alunoRepositorio.findById(anyLong())).thenReturn(optionalAluno);
        Aluno resposta  = alunoServico.buscarPorId(ID);
        assertEquals(Aluno.class,resposta.getClass());
        assertNotNull(resposta);
        assertEquals(ID,resposta.getId());
        assertEquals(LocalDate.now(),resposta.getDataMatricula());
        assertEquals(NOME,resposta.getNome());
        assertEquals(CPF,resposta.getCpf());
        assertEquals(TELEFONE,resposta.getTelefone());
        assertEquals(MAIL,resposta.getEmail());
        assertEquals(ID,resposta.getId());
        assertEquals(Curso.BACKEND,resposta.getCurso());
        assertEquals(Turno.MANHA,resposta.getTurno());
        assertEquals(Modalidade.EAD,resposta.getId());
    }

    @Test
    void quandoBuscarPorIdRetorneElementoNaoEncontrado() {
        when(alunoRepositorio.findById(anyLong())).thenThrow(new NoSuchElementException(ID_REFERENTE_AO_ALUNO_NAO_ENCONTRADO));
        try {
            alunoServico.buscarPorId(ID);
        } catch (Exception ex) {
            assertEquals(NoSuchElementException.class, ex.getClass());
            assertEquals(ID_REFERENTE_AO_ALUNO_NAO_ENCONTRADO,ex.getMessage());
        }
    }
    @Test
    void buscarTodos() {
    }

    @Test
    void atualizarAluno() {
    }

    @Test
    void excluir() {

    }
   private void start(){


       aluno = new Aluno(ID, LocalDate.now(), NOME, CPF, TELEFONE, MAIL,
                 Curso.BACKEND, Turno.MANHA, Modalidade.EAD);
         alunoDto = new AlunoDto(ID, LocalDate.now(),NOME,CPF,TELEFONE, MAIL,
                 Curso.BACKEND, Turno.MANHA, Modalidade.EAD);

         optionalAluno = Optional.of(new Aluno(ID, LocalDate.now(),NOME,CPF,TELEFONE, MAIL,
                 Curso.BACKEND, Turno.MANHA, Modalidade.EAD));
    }

}