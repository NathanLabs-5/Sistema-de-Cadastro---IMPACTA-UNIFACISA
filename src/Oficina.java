import java.time.LocalDateTime;

public abstract class Oficina extends Acao {

    private int duracaoHoras;
    private Boolean temKit;

    Oficina(int id, String titulo, String descricao, LocalDateTime data, int maxParticipantes, int duracaoHoras, Boolean temKit) {
        super(id, titulo, descricao, data, maxParticipantes);
        this.duracaoHoras = duracaoHoras;
        this.temKit = temKit;

    }

    public int getDuracaoHoras() {
        return duracaoHoras;
    }

    public Boolean getTemKit() {
        return temKit;

    }

    @Override
    public int calcularPontuacao() {
        int calculo = duracaoHoras * 3;

        if (temKit) {
            return calculo + 10;
        }

        return calculo;
    }
}
