import java.util.ArrayList;


public class Sistema {

    ArrayList<Voluntarios> alunos;


    public Sistema(ArrayList<Voluntarios> alunos) {
        this.alunos = alunos;
    }

    public Boolean CadastrarVoluntarios(Voluntarios voluntarios){
        alunos.add(voluntarios);
        return true;
    }

    public Voluntarios listarVoluntariosOrdemDecrescente(){


        return null;
    }

}
