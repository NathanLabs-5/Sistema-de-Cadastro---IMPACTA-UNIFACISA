package impacta;

import java.time.LocalDateTime;

public class Plantio extends Acao{

    private int quantidadeMudas;

    public Plantio(int id, String titulo, String descricao, LocalDateTime data, int maxParticipantes, int quantidadeMudas) {
        super(id, titulo, descricao, data, maxParticipantes);
        this.quantidadeMudas = quantidadeMudas;
    }

    public int getQuantidadeMudas() {
        return quantidadeMudas;
    }

    @Override
    public int calcularPontuacao() {
        return 5 + (2 * quantidadeMudas);
    }
}
