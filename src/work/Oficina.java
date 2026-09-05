package work;

import java.time.LocalDateTime;

public class Oficina extends Acao {

    private int duracaoHoras;
    private boolean kitMaterial;

    public Oficina(int id, String titulo, String descricao, LocalDateTime data, int maxParticipantes, int duracaoHoras, boolean kitMaterial) {
        super(id, titulo, descricao, data, maxParticipantes);
        this.duracaoHoras = duracaoHoras;
        this.kitMaterial = kitMaterial;

    }

    public int getDuracaoHoras() {
        return duracaoHoras;
    }

    public Boolean getkitMaterial() {
        return kitMaterial;

    }

    @Override
    public int calcularPontuacao() {
        int calculo = duracaoHoras * 3;

        if (kitMaterial) {
            return calculo + 10;
        }

        return calculo;
    }

    @Override
    public String toString() {
        return super.toString() + "Oficina\n" +
                "duracaoHoras: " + duracaoHoras +
                ", kitMaterial: " + kitMaterial;
    }
}
