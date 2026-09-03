package Testes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import work.Acao;
import work.Plantio;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Acao_testes {
    private Acao acao;
    private LocalDateTime data;

    @BeforeEach
    public void setUp() {
        data = LocalDateTime.of(2030, 12, 20, 10,12);
        acao = new Plantio(1,"plantio", "mudas",data,20,10);
    }

    @Test
    @DisplayName("Deve armazenar Dados")
    public void deveArmazenarDados() {
        assertEquals(1, acao.getId());
        assertEquals("Plantio", acao.getTitulo());
        assertEquals("mudas", acao.getDescricao());
        assertEquals(data, acao.getData());
        assertEquals(20, acao.getmaxParticipantes());
    }


}
