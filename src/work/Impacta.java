package work;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import exceptions.*;

public class Impacta {

    private Set<Voluntario> alunos = new HashSet<>();
    private Set<Acao> atividades = new HashSet<>();

    private int proximoIdAcao= 1;

    private int gerarIdAcao(){
        return proximoIdAcao++;
    }

    public boolean cadastrarVoluntario(String nome, String email, String matricula) {

        for (Voluntario pessoas : alunos) {
            if (pessoas.getEmail().equals(email)) {
                throw new EmailDuplicadoException("ERRO! email duplicado!");
            }
        }

        Voluntario voluntario = new Voluntario(nome, email, matricula);

        alunos.add(voluntario);
        return true;
    }

    public String exibirVoluntario(String email) {

        Voluntario voluntarioEncontrado = null;

        for (Voluntario voluntario : alunos) {

            if (voluntario.getEmail().equals(email)) {
                voluntarioEncontrado = voluntario;
                break;
            }
        }

        if (voluntarioEncontrado == null) {
            throw new UsuarioNaoEncotrado("Voluntário não encontrado!");
        }

        return voluntarioEncontrado.getNome()
                + "\n" + voluntarioEncontrado.getEmail()
                + "\n" + voluntarioEncontrado.getPontuacao()
                + "\n" + voluntarioEncontrado.getQuantidadeAcoes();
    }


    public String[] listarVoluntarios() {

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

        String[] lista = new String[resultado.size()];

        for (int i = 0; i < resultado.size(); i++) {
            Voluntario voluntario = resultado.get(i);

            lista[i] = voluntario.getNome()
                    + " - " + voluntario.getQuantidadeAcoes()
                    + " ações - " + voluntario.getPontuacao() + " pontos";
        }

        return lista;
    }

    public int cadastrarPlantio(String titulo, String descricao, String data,
                                int maxParticipantes, int quantidadeMudas) {

        LocalDateTime dataConvertida = LocalDateTime.parse(data);
        int id = gerarIdAcao();

        Plantio plantio = new Plantio(id, titulo, descricao, dataConvertida, maxParticipantes, quantidadeMudas);

        atividades.add(plantio);

        return plantio.getId();
    }

    public int cadastrarMutirao(String titulo, String descricao, String data,
                                int maxParticipantes, int duracaoHoras) {

        LocalDateTime dataConvertida = LocalDateTime.parse(data);
        int id = gerarIdAcao();

        Mutirao mutirao = new Mutirao(
                id, titulo, descricao, dataConvertida, maxParticipantes, duracaoHoras);

        atividades.add(mutirao);

        return mutirao.getId();
    }

    public int cadastrarOficina(String titulo, String descricao, String data,
                                int maxParticipantes, int duracaoHoras, boolean kitMaterial) {

        LocalDateTime dataConvertida = LocalDateTime.parse(data);
        int id = gerarIdAcao();

        Oficina oficina = new Oficina(
                id, titulo, descricao, dataConvertida, maxParticipantes, duracaoHoras, kitMaterial);

        atividades.add(oficina);

        return oficina.getId();
    }

    public boolean inscreverVoluntario(String emailVoluntario, int idAcao) {

        Voluntario voluntarioEncontrado = null;
        Acao acaoEncontrada = null;

        for (Voluntario pessoa : alunos) {
            if (pessoa.getEmail().equals(emailVoluntario)) {
                voluntarioEncontrado = pessoa;
                break;
            }
        }

        if (voluntarioEncontrado == null) {
            throw new UsuarioNaoEncotrado("Voluntário não encontrado!");
        }

        if (acaoEncontrada == null) {
            throw new AcaoNaoEncontrada("Ação não encontrada");
        }

        if (acaoEncontrada.getParticipantes().contains(voluntarioEncontrado)) {
            throw new DuplaInscricaoException(
                    "Voluntário já está inscrito nessa ação!");
        }

        if (acaoEncontrada.getParticipantes().size()
                >= acaoEncontrada.getmaxParticipantes()) {

            throw new AcaoLotadaException("Ação lotada!");
        }

        acaoEncontrada.getParticipantes().add(voluntarioEncontrado);

        int pontos = acaoEncontrada.calcularPontuacao();

        voluntarioEncontrado.registrarParticipacao(pontos);

        return true;
    }


}