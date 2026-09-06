package Testes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import work.Sistema;
import work.Voluntario;
import exceptions.EmailDuplicadoException;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VoluntariosTestes {

    private Sistema sistema;

    private Voluntario julia;
    private Voluntario bruno;
    private Voluntario carla;

    @BeforeEach
    public void setUp() {
        sistema = new Sistema();

        julia = new Voluntario("Julia", "ana@gmail.com", "1");
        bruno = new Voluntario("Bruno", "bruno@gmail.com", "2");
        carla = new Voluntario("Carla", "carla@gmail.com", "3");
    }

    @Test
    @DisplayName("Deve cadastrar voluntário com sucesso")
    public void deveCadastrarVoluntarioComSucesso() {
        assertEquals(true, sistema.cadastrarVoluntario(
                "Julia",
                "ana@gmail.com",
                "1"
        ));
    }

    @Test
    @DisplayName("Não deve cadastrar e-mail duplicado")
    public void naoDeveCadastrarEmailDuplicado() {
        Voluntario v1 = new Voluntario("Marluce", "marluce@gmail.com", "2023001");
        Voluntario v2 = new Voluntario("Outra Pessoa", "marluce@gmail.com", "2023002");
        sistema.cadastrarVoluntario(
                v1.getNome(),
                v1.getEmail(),
                v1.getMatricula()
        );

        assertThrows(EmailDuplicadoException.class, () ->
                sistema.cadastrarVoluntario(
                        v2.getNome(),
                        v2.getEmail(),
                        v2.getMatricula()
                )
        );
    }

    @Test
    @DisplayName("Deve registrar participação e acumular pontuação")
    public void deveRegistrarParticipanteAcumulandoPontos() {
        Voluntario v = new Voluntario("Mariane", "mariane@gmail.com", "1");
        v.registrarParticipacao(15);
        assertEquals(1, v.getQuantidadeAcoes());
        assertEquals(15, v.getPontuacao());

    }

    @Test
    @DisplayName("Deve listar voluntários em ordem decrescente de pontuação, com desempate por nome")
    public void deveListarEmOrdemDecrescente() {

        julia.registrarParticipacao(10);
        bruno.registrarParticipacao(20);
        carla.registrarParticipacao(20);

        sistema.cadastrarVoluntario(julia);
        sistema.cadastrarVoluntario(bruno);
        sistema.cadastrarVoluntario(carla);

        String[] ranking = sistema.listarVoluntarios();

        assertEquals("Bruno - 1 ações - 20 pontos", ranking[0]);
        assertEquals("Carla - 1 ações - 20 pontos", ranking[1]);
        assertEquals("Julia - 1 ações - 10 pontos", ranking[2]);
    }
}
