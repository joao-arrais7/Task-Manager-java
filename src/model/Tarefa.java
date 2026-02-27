package model;

public class Tarefa implements ITarefa {

    private String titulo;
    private String descricao;
    private boolean concluida;

    public Tarefa(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluida = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isConcluida() {
        return concluida;
    }

    @Override
    public void marcarComoConcluida() {
        this.concluida = true;
    }

    @Override
    public String exibirDetalhes() {
        return "Título: " + titulo +
               "\nDescrição: " + descricao +
               "\nStatus: " + (concluida ? "Concluída" : "Pendente");
    }
}