public class Voluntarios {

    private String nome;
    private String email;
    private int matricula;
    private int pontuacao;
    private Acao acao;

    Voluntarios(String nome, String email, int matricula, Acao acao){
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.acao = acao;
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

    public Acao getAcao(){
        return acao;
    }
}
