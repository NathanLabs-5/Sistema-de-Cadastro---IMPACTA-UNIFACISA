package impacta;

import java.time.LocalDateTime;

public class Oficina extends Acao {

    private final int duracaoHoras;
    private final boolean kitMaterial;

    public Oficina(int id, String titulo, String descricao, LocalDateTime data, int maxParticipantes, int duracaoHoras, boolean kitMaterial) {
        super(id, titulo, descricao, data, maxParticipantes);
        this.duracaoHoras = duracaoHoras;
        this.kitMaterial = kitMaterial;
    }

    public int getDuracaoHoras() {
        return duracaoHoras;
    }

    public boolean isKitMaterial() {
        return kitMaterial;
    }

    @Override
    public int calcularPontuacao() {
        int pontos = 3 * duracaoHoras;
        if (kitMaterial) {
            pontos += 10;
        }
        return pontos;
    }
}