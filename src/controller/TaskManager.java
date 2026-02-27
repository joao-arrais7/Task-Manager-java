package controller;

import model.Tarefa;
import model.ITarefa;
import exceptions.TarefaNaoEncontradaException;

import java.util.ArrayList;

public class TaskManager {

    private ArrayList<ITarefa> tarefas;

    public TaskManager() {
        tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(ITarefa tarefa) {
        tarefas.add(tarefa);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    public void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }

        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println("\nID: " + i);
            System.out.println(tarefas.get(i).exibirDetalhes());
        }
    }

    public void concluirTarefa(int id) throws TarefaNaoEncontradaException {
        if (id < 0 || id >= tarefas.size()) {
            throw new TarefaNaoEncontradaException("ID inválido.");
        }

        tarefas.get(id).marcarComoConcluida();
        System.out.println("Tarefa concluída!");
    }

    public void removerTarefa(int id) throws TarefaNaoEncontradaException {
        if (id < 0 || id >= tarefas.size()) {
            throw new TarefaNaoEncontradaException("ID inválido.");
        }

        tarefas.remove(id);
        System.out.println("Tarefa removida com sucesso!");
    }
}