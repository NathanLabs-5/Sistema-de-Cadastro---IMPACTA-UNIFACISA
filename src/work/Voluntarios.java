package work;

public class Voluntarios {

    private String nome;
    private String email;
    private int matricula;
    private int quantidadeAcoes;
    private int pontuacao;

    Voluntarios(String nome, String email, int matricula, Acao acao){
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.quantidadeAcoes = 0;
        this.pontuacao = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getMatricula() {
        return matricula;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public int getQuantidadeAcoes() {return quantidadeAcoes;}

    public int getpontuacao() {return pontuacao;}

    public void registrarParticipacao(int pontosDaAcao) {
        quantidadeAcoes++;
        pontuacao += pontosDaAcao;
    }
}
