package Testes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import work.Sistema;
import work.Voluntario;
import exceptions.EmailDuplicadoException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VoluntariosTestes {

    private Sistema sistema;

    @BeforeEach
    public void setUp() {
        sistema = new Sistema();
    }

    @Test
    @DisplayName("Deve cadastrar voluntário com sucesso")
    public void deveCadastrarVoluntarioComSucesso() {
        Voluntario v = new Voluntario("Bianca", "bianca@gmail.com", "2023001", 23,323);
        assertTrue(sistema.CadastrarVoluntarios(v));
    }

    @Test
    @DisplayName("Não deve cadastrar e-mail duplicado")
    public void naoDeveCadastrarEmailDuplicado() {
        Voluntario v1 = new Voluntario("Marluce", "marluce@gmail.com", "2023001", 21,54);
        Voluntario v2 = new Voluntario("Outra Pessoa", "marluce@gmail.com", "2023002", 56,67);
        sistema.CadastrarVoluntarios(v1);

        assertThrows(EmailDuplicadoException.class, () -> sistema.CadastrarVoluntarios(v2));
    }

    @Test
    @DisplayName("Deve registrar participação e acumular pontuação")
    public void deveRegistrarParticipanteAcumulandoPontos() {
        Voluntario v = new Voluntario("Mariane", "mariane@gmail.com", "1", 343,1);
        v.registrarParticipacao(15);
        assertEquals(1, v.getQuantidadeAcoes());
        assertEquals(15, v.getPontuacao());

    }

    @Test
    @DisplayName("Deve listar voluntários em ordem decrescente de pontuação, com desempate por nome")
    public void deveListarEmOrdemDecrescente(){
        Voluntario julia = new Voluntario("Julia", "ana@gmail.com", "1", 13,44);
        Voluntario bruno = new Voluntario("Bruno", "bruno@gmail.com", "2", 2,56);
        Voluntario carla = new Voluntario("Carla", "carla@gmail.com", "3", 12,3445);

        julia.registrarParticipacao(10);
        bruno.registrarParticipacao(20);
        carla.registrarParticipacao(20); // empate com Bruno -> desempate alfabético

        sistema.CadastrarVoluntarios(julia);
        sistema.CadastrarVoluntarios(bruno);
        sistema.CadastrarVoluntarios(carla);

        List<Voluntario> ranking = sistema.listarVoluntariosOrdemDecrescente();

        assertEquals("Bruno", ranking.get(0).getNome());
        assertEquals("Carla", ranking.get(1).getNome());
        assertEquals("Julia", ranking.get(2).getNome());
    }
}
