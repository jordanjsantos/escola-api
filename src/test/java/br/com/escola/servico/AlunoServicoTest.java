package br.com.escola.servico;

import br.com.escola.controle.AlunoControle;
import br.com.escola.dto.AlunoDto;
import br.com.escola.entidade.Aluno;
import br.com.escola.enums.Curso;
import br.com.escola.enums.Modalidade;
import br.com.escola.enums.Turno;
import br.com.escola.repositorio.AlunoRepositorio;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class AlunoServicoTest {


    public static final String NOME = "Carlos";
    public static final String CPF = "1234";
    public static final String TELEFONE = "123";
    public static final String MAIL = "carlos@gmail.com";

    public static final long ID = 1L;
    public static final String ID_REFERENTE_AO_ALUNO_NAO_ENCONTRADO = "ID, referente ao aluno não encontrado ";
    public static final int INDEX = 0;
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
    void quandoCadastrarAlunoComSucesso() {
        when(alunoRepositorio.save(any())).thenReturn(aluno);
        Aluno resposta = alunoServico.cadastrarAluno(alunoDto);
        assertNotNull(resposta);
        assertEquals(Aluno.class,resposta.getClass());
        assertEquals(ID,resposta.getId());
        assertEquals(LocalDate.now() , resposta.getDataMatricula());
        assertEquals(NOME,resposta.getNome());
        assertEquals(CPF,resposta.getCpf());
        assertEquals(TELEFONE,resposta.getTelefone());
        assertEquals(MAIL,resposta.getEmail());
        assertEquals(ID,resposta.getId());
        assertEquals(Curso.BACKEND,resposta.getCurso());
        assertEquals(Turno.MANHA,resposta.getTurno());
        assertEquals(Modalidade.EAD,resposta.getModalidade());
    }

    @Test
    void  quandoBuscarPorIdRetorneUmaInstanciaDeUsuario() {
        when(alunoRepositorio.findById(anyLong())).thenReturn(optionalAluno);
        Aluno resposta  = alunoServico.buscarPorId(ID);
        assertNotNull(resposta);
        assertEquals(Aluno.class,resposta.getClass());
        assertNotNull(resposta);
        assertEquals(ID,resposta.getId());
        assertEquals(LocalDate.now(),resposta.getDataMatricula());
        assertEquals(NOME,resposta.getNome());
        assertEquals(CPF,resposta.getCpf());
        assertEquals(TELEFONE,resposta.getTelefone());
        assertEquals(MAIL,resposta.getEmail());
        assertEquals(Curso.BACKEND,resposta.getCurso());
        assertEquals(Turno.MANHA,resposta.getTurno());
        assertEquals(Modalidade.EAD,resposta.getModalidade());
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
    void quandoBuscarTodosRetorneUmaListaDeAlunos() {
        when(alunoRepositorio.findAll()).thenReturn(List.of(aluno));
        List<Aluno>resposta = alunoServico.buscarTodos();

        assertNotNull(resposta);
        assertEquals(1,resposta.size());
        assertEquals(1,resposta.size());
        assertEquals(Aluno.class,resposta.get(INDEX).getClass());
        assertEquals(ID,resposta.get(INDEX).getId());
        assertEquals(LocalDate.now(),resposta.get(INDEX).getDataMatricula());
        assertEquals(NOME,resposta.get(INDEX).getNome());
        assertEquals(CPF,resposta.get(INDEX).getCpf());
        assertEquals(TELEFONE,resposta.get(INDEX).getTelefone());
        assertEquals(MAIL,resposta.get(INDEX).getEmail());
        assertEquals(Curso.BACKEND,resposta.get(INDEX).getCurso());
        assertEquals(Turno.MANHA,resposta.get(INDEX).getTurno());
        assertEquals(Modalidade.EAD , resposta.get(INDEX).getModalidade());

    }

    @Test
    void quandoAtualizarAlunoComSucesso() {
        when(alunoRepositorio.save(any())).thenReturn(aluno);
        Aluno resposta = alunoServico.atualizarAluno(alunoDto,ID);
        assertNotNull(resposta);
        assertEquals(Aluno.class,resposta.getClass());
        assertEquals(ID,resposta.getId());
        assertEquals(LocalDate.now() , resposta.getDataMatricula());
        assertEquals(NOME,resposta.getNome());
        assertEquals(CPF,resposta.getCpf());
        assertEquals(TELEFONE,resposta.getTelefone());
        assertEquals(MAIL,resposta.getEmail());
        assertEquals(ID,resposta.getId());
        assertEquals(Curso.BACKEND,resposta.getCurso());
        assertEquals(Turno.MANHA,resposta.getTurno());
        assertEquals(Modalidade.EAD,resposta.getModalidade());

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