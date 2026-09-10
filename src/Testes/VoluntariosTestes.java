package Testes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import work.Impacta;
import work.Voluntario;
import exceptions.EmailDuplicadoException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VoluntariosTestes {

    private Impacta sistema;

    private Voluntario julia;
    private Voluntario bruno;
    private Voluntario carla;

    @BeforeEach
    public void setUp() {
        sistema = new Impacta();

        julia = new Voluntario("Julia", "ana@gmail.com", "1");
        bruno = new Voluntario("Bruno", "bruno@gmail.com", "2");
        carla = new Voluntario("Carla", "carla@gmail.com", "3");
    }

    @Test
    @DisplayName("Deve cadastrar voluntário com sucesso")
    public void deveCadastrarVoluntarioComSucesso() {
        assertEquals(true, sistema.cadastrarVoluntario("Julia", "julia@gmail.com", "1"
        ));
    }

    @Test
    @DisplayName("Não deve cadastrar e-mail duplicado")
    public void naoDeveCadastrarEmailDuplicado() {
        Voluntario v1 = new Voluntario("Marluce", "marluce@gmail.com", "2023001");
        Voluntario v2 = new Voluntario("Outra Pessoa", "marluce@gmail.com", "2023002");
        sistema.cadastrarVoluntario(v1.getNome(), v1.getEmail(), v1.getMatricula()
        );

        assertThrows(EmailDuplicadoException.class, () -> sistema.cadastrarVoluntario(
                        v2.getNome(),
                        v2.getEmail(),
                        v2.getMatricula()
                )
        );
    }

    @Test
    @DisplayName("Deve registrar participação e acumular pontuação")
    public void deveRegistrarParticipanteAcumulandoPontos() {
        Voluntario voluntario = new Voluntario("Mariane", "mariane@gmail.com", "1");
        voluntario.registrarParticipacao(15);

        assertEquals(1, voluntario.getQuantidadeAcoes());
        assertEquals(15, voluntario.getPontuacao());

    }

    @Test
    @DisplayName("Deve listar em ordem decrescente")
    public void deveListarEmOrdemDecrescente() {

        sistema.cadastrarVoluntario(bruno.getNome(), bruno.getEmail(), bruno.getMatricula());
        sistema.cadastrarVoluntario(carla.getNome(), carla.getEmail(), carla.getMatricula());
        int idMutirao = sistema.cadastrarMutirao("Mutirão de teste", "Ação utilizada para testar o ranking", "2030-12-20T10:00:00", 2, 5);

        sistema.inscreverVoluntario(bruno.getEmail(), idMutirao);
        sistema.inscreverVoluntario(carla.getEmail(), idMutirao);

        String[] ranking = sistema.listarVoluntarios();

        assertEquals("Bruno - 1 ações - 20 pontos", ranking[0]);
        assertEquals("Carla - 1 ações - 20 pontos", ranking[1]);
    }
}
