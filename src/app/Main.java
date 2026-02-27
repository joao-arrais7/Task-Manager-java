package app;

import controller.TaskManager;
import model.Tarefa;
import model.TarefaPrioritaria;
import exceptions.TarefaNaoEncontradaException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        int opcao;

        do {
            System.out.println("\n===== GERENCIADOR DE TAREFAS =====");
            System.out.println("1. Criar nova tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Marcar tarefa como concluída");
            System.out.println("4. Remover tarefa");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Título: ");
                        String titulo = scanner.nextLine();

                        System.out.print("Descrição: ");
                        String descricao = scanner.nextLine();

                        System.out.print("É prioritária? (s/n): ");
                        String resp = scanner.nextLine();

                        if (resp.equalsIgnoreCase("s")) {
                            System.out.print("Nível de prioridade (1-5): ");
                            int nivel = scanner.nextInt();
                            scanner.nextLine();
                            manager.adicionarTarefa(
                                    new TarefaPrioritaria(titulo, descricao, nivel)
                            );
                        } else {
                            manager.adicionarTarefa(
                                    new Tarefa(titulo, descricao)
                            );
                        }
                        break;

                    case 2:
                        manager.listarTarefas();
                        break;

                    case 3:
                        System.out.print("Digite o ID da tarefa: ");
                        int idConcluir = scanner.nextInt();
                        scanner.nextLine();
                        manager.concluirTarefa(idConcluir);
                        break;

                    case 4:
                        System.out.print("Digite o ID da tarefa: ");
                        int idRemover = scanner.nextInt();
                        scanner.nextLine();
                        manager.removerTarefa(idRemover);
                        break;

                    case 5:
                        System.out.println("Encerrando sistema...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }

            } catch (TarefaNaoEncontradaException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Entrada inválida!");
                scanner.nextLine();
            }

        } while (opcao != 5);

        scanner.close();
    }
}