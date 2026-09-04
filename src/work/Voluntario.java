package work;

public class Voluntario {

    private String nome;
    private String email;
    private String matricula;
    private int quantidadeAcoes;
    private int pontuacao;

    public Voluntario(String nome, String email, String matricula, Acao acao){
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

    public String getMatricula() {
        return matricula;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public int getQuantidadeAcoes() {return quantidadeAcoes;}

    public void registrarParticipacao(int pontosDaAcao) {
        quantidadeAcoes++;
        pontuacao += pontosDaAcao;
    }
}
