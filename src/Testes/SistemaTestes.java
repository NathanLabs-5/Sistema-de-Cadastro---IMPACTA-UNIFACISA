package Testes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import work.Sistema;
import work.Voluntario;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaTestes {

    private Sistema sistema;
    private Voluntario voluntario1;
    private Voluntario voluntario2;

    @BeforeEach
    public void setUp(){
         sistema = new Sistema();

        voluntario1 = new Voluntario("Carlos", "carlos@email.com", "001");
        voluntario2 = new Voluntario("Joao", "joao@email.com", "002");

    }

    @Test
    @DisplayName("CadastroDeUsuarios")
    public void deveCadastrarUsuarios() throws Exception {

        boolean resultado = sistema.cadastrarVoluntario(
                voluntario1.getNome(),
                voluntario1.getEmail(),
                voluntario1.getMatricula()
        );

        assertTrue(resultado);
    }

}
