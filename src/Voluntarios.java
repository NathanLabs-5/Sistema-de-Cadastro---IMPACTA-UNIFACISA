public class Voluntarios {

    private String nome;
    private String email;
    private int matricula;

    Voluntarios(String nome, String email, int matricula){
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
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


}
