package work;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import exceptions.*;

public class Sistema {

    private Set<Voluntario> alunos = new HashSet<>();
    private Set<Acao> atividades = new HashSet<>();

    public boolean cadastrarVoluntario(String nome, String email, String matricula)
            throws EmailDuplicadoException {

        for (Voluntario pessoas : alunos) {
            if (pessoas.getEmail().equals(email)) {
                throw new EmailDuplicadoException("ERRO! email duplicado!");
            }
        }

        Voluntario voluntario = new Voluntario(nome, email, matricula);

        alunos.add(voluntario);
        return true;
    }
    public boolean cadastrarVoluntario(Voluntario voluntario)
            throws EmailDuplicadoException {

        for (Voluntario pessoa : alunos) {
            if (pessoa.getEmail().equals(voluntario.getEmail())) {
                throw new EmailDuplicadoException("ERRO! email duplicado!");
            }
        }

        alunos.add(voluntario);
        return true;
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

    public int cadastrarPlantio(int id, String titulo, String descricao, LocalDateTime data,
                                int maxParticipantes, int quantidadeMudas)
            throws InscricaoDuplicadaException {

        for (Acao acao : atividades) {
            if (acao.getId() == id) {
                throw new InscricaoDuplicadaException(
                        "Já existe uma ação cadastrada com esse ID!");
            }
        }

        Acao plantio = new Plantio(
                id, titulo, descricao, data, maxParticipantes, quantidadeMudas);

        atividades.add(plantio);

        return plantio.getId();
    }

    public int cadastrarMutirao(int id, String titulo, String descricao, LocalDateTime data,
                                int maxParticipantes, int duracaoHoras)
            throws InscricaoDuplicadaException {

        for (Acao acao : atividades) {
            if (acao.getId() == id) {
                throw new InscricaoDuplicadaException(
                        "ERRO! Já existe uma ação cadastrada com esse ID!");
            }
        }

        Mutirao mutirao = new Mutirao(
                id, titulo, descricao, data, maxParticipantes, duracaoHoras);

        atividades.add(mutirao);

        return mutirao.getId();
    }

    public int cadastrarOficina(int id, String titulo, String descricao, LocalDateTime data,
                                int maxParticipantes, int duracaoHoras, boolean kitMaterial)
            throws InscricaoDuplicadaException {

        for (Acao acao : atividades) {
            if (acao.getId() == id) {
                throw new InscricaoDuplicadaException(
                        "ERRO! Já existe uma ação cadastrada com esse ID!");
            }
        }

        Oficina oficina = new Oficina(
                id, titulo, descricao, data, maxParticipantes, duracaoHoras, kitMaterial);

        atividades.add(oficina);

        return oficina.getId();
    }

    public boolean inscreverVoluntario(String emailVoluntario, int id) {

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

        for (Acao acao : atividades) {
            if (acao.getId() == id) {
                acaoEncontrada = acao;
                break;
            }
        }

        if (acaoEncontrada == null) {
            throw new AcaoNaoEncontrada("Ação não encontrada");
        }

        if (acaoEncontrada.getParticipantes().contains(voluntarioEncontrado)) {
            throw new InscricaoDuplicadaException(
                    "Voluntário já está inscrito nessa ação!");
        }

        if (acaoEncontrada.getParticipantes().size()
                >= acaoEncontrada.getmaxParticipantes()) {

            throw new AcaoLotada("Ação lotada!");
        }

        acaoEncontrada.getParticipantes().add(voluntarioEncontrado);

        int pontos = acaoEncontrada.calcularPontuacao();

        voluntarioEncontrado.registrarParticipacao(pontos);

        return true;
    }

    public String exibirDetalhesAcao(int id) {

        for (Acao acao : atividades) {
            if (acao.getId() == id) {
                return acao.toString();
            }
        }

        return "Ação não encontrada.";
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
}