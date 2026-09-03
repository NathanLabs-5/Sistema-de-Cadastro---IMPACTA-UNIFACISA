package work;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import exceptions.DontDoubleSubscriveForPeople;
import exceptions.DoubleEmailError;

public class Sistema {

    private Set<Voluntarios> alunos = new HashSet<>();
    private Set<Acao> talentos = new HashSet<>();



    public Boolean CadastrarVoluntarios(Voluntarios voluntarios) throws DoubleEmailError {

        for(Voluntarios pessoas : alunos){
            if(pessoas.getEmail().equals(voluntarios.getEmail())){
                throw new DoubleEmailError("ERRO! email duplicado!");
            }
        }
        alunos.add(voluntarios);
        return true;
    }

    public List<Voluntarios> listarVoluntariosOrdemDecrescente() {

        List<Voluntarios> ranking = new ArrayList<>(alunos);
        List<Voluntarios> resultado = new ArrayList<>();

        for(int i = 0; i < ranking.size();i++){
            Voluntarios maior = null;


            for(Voluntarios pessoas : ranking){

                if (resultado.contains(pessoas)) {
                    continue;
                }

                if(maior == null || pessoas.getPontuacao() > maior.getPontuacao()){
                    maior = pessoas;

                }

            }
            resultado.add(maior);
        }
        return resultado;
    }


    public int cadastrarPlantio(int id, String titulo, String descricao, LocalDateTime data, int maxParticipantes, int quantidadeMudas) throws DontDoubleSubscriveForPeople {

        for (Acao acao : talentos) {
            if (acao.getId() == id) {
                throw new DontDoubleSubscriveForPeople("ERRO! NÃO É PERMITIDO MESMO USUARIO INSCREVER-SE NA MESMA MODALIDADE!");
            }
        }
        Acao plantio = new Plantio(id, titulo, descricao, data, maxParticipantes, quantidadeMudas);
        talentos.add(plantio);
        return plantio.getId();

    }

    public int cadastrarMutirao(int id,String titulo, LocalDateTime descricao, LocalDateTime data, int maxParticipantes, int duracaoHoras){
        Mutirao mutirao = new Mutirao(id, titulo, descricao, data, maxParticipantes, duracaoHoras);
        talentos.add(mutirao);
        return mutirao.getId();

    }

    public int cadastrarOficina(String titulo, String descricao, String data, int maxParticipantes, int duracaoHoras, boolean kitMaterial){

    }

    public boolean inscreverVoluntario(String emailVoluntario, int id){

    }

    public String exibirDetalhesAcao(int id){

    }

}
