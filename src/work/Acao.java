package work;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public abstract class Acao {

    private int idAcao;
    private String titulo;
    private String descricao;
    private LocalDateTime data;
    private int maxParticipantes;


    private Set<Voluntario> participantes = new HashSet<>();

    public Acao(int idAcao, String titulo, String descricao, LocalDateTime data, int maxParticipantes) {
        this.idAcao = idAcao;
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.maxParticipantes = maxParticipantes;
    }

    public int getId() {
        return idAcao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public int getmaxParticipantes() {
        return maxParticipantes;
    }

    public abstract int calcularPontuacao();

    public Set<Voluntario> getParticipantes() {
        return participantes;
    }

    @Override
    public String toString() {
        return "Acao\n" +
                "\ntitulo: " + titulo +
                "\ndescricao: " + descricao +
                "\ndata: " + data +
                "\nmaxParticipantes: " + maxParticipantes +
                "\npontuacao: " + calcularPontuacao() +
                "\nparticipantes: " + participantes;
    }
}