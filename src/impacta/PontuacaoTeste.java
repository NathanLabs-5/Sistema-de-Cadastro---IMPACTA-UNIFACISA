package impacta;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PontuacaoTeste {

    private Acao plantio;
    private Acao mutirao;
    private Acao oficina;

    @BeforeEach
    public void setUp() {
        LocalDateTime data = LocalDateTime.of(2030, 12, 20, 10, 0);

        plantio = new Plantio(1, "Plantio", "Plantio de mudas", data, 10, 10);
        mutirao = new Mutirao(2, "Mutirão", "Coleta de materiais", data, 15, 3);
        oficina = new Oficina(3, "Oficina", "Produção sustentável", data, 20, 2, true);
    }

    @Test
    @DisplayName("Deve calcular a pontuação do plantio")
    public void deveCalcularPontuacaoPlantio() {
        int resultado = plantio.calcularPontuacao();
        assertEquals(25, resultado);
    }

    @Test
    @DisplayName("Deve calcular a pontuação mutirão")
    public void deveCalcularPontuacaoMutirao() {
        int resultado = mutirao.calcularPontuacao();
        assertEquals(12, resultado);
    }

    @Test
    @DisplayName("Deve calcular a pontuação da oficina")
    public void deveCalcularPontuacaoOficina() {
        int resultado = oficina.calcularPontuacao();
        assertEquals(16, resultado);
    }
}