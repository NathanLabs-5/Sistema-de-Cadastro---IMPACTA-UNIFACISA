package work;

import java.time.LocalDateTime;

public class Plantio extends Acao {

    private int qtdMudas;

    public Plantio(int id, String titulo, String descricao, LocalDateTime data, int maxParticipantes, int quantidadeMudas) {
        super(id, titulo, descricao, data, maxParticipantes);
        this.qtdMudas = quantidadeMudas;
    }

    public int getQuantidadeMudas() {
        return qtdMudas;
    }

    @Override
    public int calcularPontuacao() {
        return 5 + (2 * qtdMudas);
    }

    @Override
    public String toString() {
        return super.toString() + "Plantio\n" +
                "quantidadeMudas: " + qtdMudas;
    }
}
