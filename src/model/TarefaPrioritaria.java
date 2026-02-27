package model;

public class TarefaPrioritaria extends Tarefa {

    private int nivelPrioridade;

    public TarefaPrioritaria(String titulo, String descricao, int nivelPrioridade) {
        super(titulo, descricao);
        this.nivelPrioridade = nivelPrioridade;
    }

    @Override
    public String exibirDetalhes() {
        return super.exibirDetalhes() +
               "\nPrioridade: " + nivelPrioridade;
    }
}