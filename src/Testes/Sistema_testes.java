package Testes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import work.Sistema;
import work.Voluntario;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Sistema_testes {

    private Sistema sistema;
    private Voluntario voluntario1;
    private Voluntario voluntario2;

    @BeforeEach
    public void setUp(){
         sistema = new Sistema();

        voluntario1 = new Voluntario("Carlos", "carlos@email.com", "001",0,13);
        voluntario2 = new Voluntario("Joao", "joao@email.com", "002",0,24);

    }

    @Test
    @DisplayName("CadastroDeUsuarios")
    public void deveCadastrarUsuarios()throws Exception{

        boolean resultado = sistema.CadastrarVoluntarios(voluntario1);
        assertTrue(resultado);
    }

    @Test
    public void deveListarVoluntariosEmOrdemDecrescente(){

        List<Voluntario> resultado = sistema.listarVoluntariosOrdemDecrescente();
        assertEquals(voluntario2,resultado.get(0));
    }
}
