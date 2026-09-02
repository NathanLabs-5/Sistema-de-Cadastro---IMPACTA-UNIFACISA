import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import exceptions.DoubleEmailError;

public class Sistema {

    private Set<Voluntarios> alunos;

    public Sistema(Set<Voluntarios> alunos) {
        this.alunos = alunos;
    }

    public Sistema() {
        this.alunos = new HashSet<>();
    }

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

        List<Voluntarios> listaOrdenada = new ArrayList<>(alunos);

        Comparator<Voluntarios> comparador = Comparator
                .comparing(Voluntarios::getPontuacao).reversed()
                .thenComparing(Voluntarios::getNome);

        listaOrdenada.sort(comparador);

        return listaOrdenada;
    }

    public int cadastrarPlantio(int id, String titulo, String descricao, LocalDateTime data, int maxParticipantes, int quantidadeMudas) {
        Plantio plantio = new Plantio(id, titulo, descricao, data, maxParticipantes, quantidadeMudas);
        Acao.add(plantio);
        return plantio.getId();
    }

    public int cadastrarMutirao(String titulo, String descricao, String data, int maxParticipantes, int duracaoHoras){

    }

    public int cadastrarOficina(String titulo, String descricao, String data, int maxParticipantes, int duracaoHoras, boolean kitMaterial){

    }

    public boolean inscreverVoluntario(String emailVoluntario, int id){

    }

    public String exibirDetalhesAcao(int id){

    }

}
