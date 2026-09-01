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

        for(Voluntarios aluno: alunos){
            if(aluno instanceof Plantio){
                System.out.println(aluno);

            }if(aluno instanceof Oficina){
                System.out.println(aluno);

            }if(aluno instanceof Mutirao) {
                System.out.println(aluno);
            }
            System.out.println("Voluntario não encontrado!");
        }

        return null;
    }

}
