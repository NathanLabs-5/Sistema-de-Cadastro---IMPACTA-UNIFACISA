package impacta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PontuacaoTeste {

    private ArrayList<Acao> acoes;

    @BeforeEach
    public void setUp() {

        acoes = new ArrayList<>();

        LocalDateTime data = LocalDateTime.of(2026, 9, 20, 8, 0);
        Plantio plantio = new Plantio(1, "Plantio na praça", "Plantio de mudas", data, 10, 10);
        Mutirao mutirao = new Mutirao(2, "Mutirão de reciclagem", "Coleta de materiais", data, 15, 3);
        Oficina oficina = new Oficina(3, "Oficina ecológica", "Produção sustentável", data, 20, 2, true);

        acoes.add(plantio);
        acoes.add(mutirao);
        acoes.add(oficina);
    }

    @Test
    @DisplayName("Deve calcular pontuação das ações")
    public void deveCalcularPontuacaoDasAcoes() {

        assertEquals(25, acoes.get(0).calcularPontuacao());
        assertEquals(12, acoes.get(1).calcularPontuacao());
        assertEquals(16, acoes.get(2).calcularPontuacao());
    }
}