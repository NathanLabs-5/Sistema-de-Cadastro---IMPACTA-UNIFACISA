import exceptions.DoubleEmailError;

import java.util.ArrayList;
import java.util.zip.DataFormatException;


public class Sistema {

    ArrayList<Voluntarios> alunos = new ArrayList<>();


    public Boolean CadastrarVoluntarios(Voluntarios voluntarios) throws DoubleEmailError {

        for(Voluntarios pessoas : alunos){
            if(pessoas.getEmail().equals(voluntarios.getEmail())){
                throw new DoubleEmailError("ERRO! email duplicado!");
            }
        }
        alunos.add(voluntarios);
        return true;
    }

}
