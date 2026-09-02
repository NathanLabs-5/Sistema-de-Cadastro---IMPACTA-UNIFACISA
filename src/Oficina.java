import java.time.LocalDateTime;

public abstract class Oficina extends Acao {

    private int duracaoHoras;
    private Boolean kitMaterial;

    Oficina(int id, String titulo, String descricao, LocalDateTime data, int maxParticipantes, int duracaoHoras, Boolean kitMaterial) {
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
}
