package work;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import exceptions.InscricaoDuplicadaException;
import exceptions.EmailDuplicadoException;

public class Sistema {

    private Set<Voluntario> alunos = new HashSet<>();
    private Set<Acao> atividades = new HashSet<>();

    public Boolean CadastrarVoluntarios(Voluntario voluntario) throws EmailDuplicadoException {

        for(Voluntario pessoas : alunos){
            if(pessoas.getEmail().equals(voluntario.getEmail())){
                throw new EmailDuplicadoException("ERRO! email duplicado!");
            }
        }
        alunos.add(voluntario);
        return true;
    }

    public List<Voluntario> listarVoluntariosOrdemDecrescente() {

            List<Voluntario> ranking = new ArrayList<>(alunos);
            List<Voluntario> resultado = new ArrayList<>();

            for (int i = 0; i < ranking.size(); i++) {

                Voluntario maior = null;

                for (Voluntario pessoas : ranking) {

                    if (resultado.contains(pessoas)) {
                        continue;
                    }

                    if (maior == null
                            || pessoas.getPontuacao() > maior.getPontuacao()
                            || (pessoas.getPontuacao() == maior.getPontuacao()
                            && pessoas.getNome().compareToIgnoreCase(maior.getNome()) < 0)) {

                        maior = pessoas;
                    }
                }

                resultado.add(maior);
            }

            return resultado;
        }
    public int cadastrarPlantio(int id, String titulo, String descricao, LocalDateTime data, int maxParticipantes, int quantidadeMudas) throws InscricaoDuplicadaException {

        for (Acao acao : atividades) {
            if (acao.getId() == id) {
                throw new InscricaoDuplicadaException("ERRO! NÃO É PERMITIDO MESMO USUARIO INSCREVER-SE NA MESMA MODALIDADE!");
            }
        }
        Acao plantio = new Plantio(id, titulo, descricao, data, maxParticipantes, quantidadeMudas);
        atividades.add(plantio);
        return plantio.getId();

    }

    public int cadastrarMutirao(int id, String titulo, String descricao, LocalDateTime data, int maxParticipantes, int duracaoHoras) throws InscricaoDuplicadaException {

        for (Acao acao : atividades) {
            if (acao.getId() == id) {
                throw new InscricaoDuplicadaException("ERRO! Já existe uma ação cadastrada com esse ID!");
            }
        }
        Mutirao mutirao = new Mutirao(id, titulo, descricao, data, maxParticipantes, duracaoHoras);
        atividades.add(mutirao);
        return mutirao.getId();
    }

    public int cadastrarOficina(int id, String titulo, String descricao, LocalDateTime data, int maxParticipantes, int duracaoHoras, boolean kitMaterial) throws InscricaoDuplicadaException {

        for (Acao acao : atividades) {
            if (acao.getId() == id) {
                throw new InscricaoDuplicadaException("ERRO! Já existe uma ação cadastrada com esse ID!");
            }
        }
        Oficina oficina = new Oficina(id, titulo, descricao, data, maxParticipantes, duracaoHoras, kitMaterial);
        atividades.add(oficina);
        return oficina.getId();
    }

    public boolean inscreverVoluntario(String emailVoluntario, int id){
        return false;
    }

    public String exibirDetalhesAcao(int id){
        for (Acao acao : atividades){
            if (acao.getId() == id){
                return acao.toString();
            }
        }
        return "Ação não encontrada.";
    }

}


