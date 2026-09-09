package Testes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import work.Impacta;
import work.Voluntario;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaTestes {

    private Impacta sistema;
    private Voluntario voluntario1;
    private Voluntario voluntario2;

    @BeforeEach
    public void setUp(){
         sistema = new Impacta();

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
