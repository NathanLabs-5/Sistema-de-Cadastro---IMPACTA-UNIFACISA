package Testes;

import work.Acao;
import work.Sistema;
import work.Voluntarios;

import java.util.HashSet;
import java.util.Set;

public class Sistema_testes {


    private Sistema sistema = new Sistema();



    @BeforreEach
    public void setup(){
        sistema = new Sistema()
    }


}
