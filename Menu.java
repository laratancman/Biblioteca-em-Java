import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        List<Emprestimo> listaEmprestimos = new ArrayList<>();
        List<Livro> listaLivros = new ArrayList<>();

        listaLivros.add(new Livro("1984", "George Orwell", LocalDate.of(1949, 6, 8), false));
        listaLivros.add(new Livro("Dom Casmurro", "Machado de Assis", LocalDate.of(1899, 1, 1), false));
        listaLivros.add(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", LocalDate.of(1954, 7, 29), false));

        Scanner sc = new Scanner(System.in);
        String continuar = "Sim";

        while (continuar.equalsIgnoreCase("Sim")) {
            System.out.println("\nSeja bem-vindo à Biblioteca Borba");
            System.out.println("Escolha uma das opções:");
            System.out.println("1 - Ver todos os Livros");
            System.out.println("2 - Exibir Detalhes do Livro");
            System.out.println("3 - Realizar Empréstimo");
            System.out.println("4 - Verificar Empréstimo");
            System.out.println("5 - Sair");

            int opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    for (Livro livro : listaLivros) {
                        System.out.println("-----------------");
                        System.out.println(livro.getTitulo());
                        System.out.println("-----------------");
                    }
                    break;

                case 2:
                    for (Livro livro : listaLivros) {
                        System.out.println("-----------------");
                        System.out.println(livro.exibirDetalhes());
                        System.out.println("-----------------");
                    }
                    break;

                case 3:
                    Usuario usuario = new Usuario();
                    Emprestimo emprestimo = new Emprestimo();

                    System.out.print("Digite o nome do usuário: ");
                    usuario.setNome(sc.nextLine());

                    System.out.print("Digite a matrícula do usuário: ");
                    usuario.setMatricula(sc.nextInt());

                    System.out.println("Digite o tipo de usuário:");
                    System.out.println("1 - Aluno");
                    System.out.println("2 - Professor");
                    int tipo = sc.nextInt();
                    sc.nextLine(); // limpar buffer

                    if (tipo == 1) {
                        usuario.setTipoUsuario(TipoUsuario.ALUNO);
                    } else if (tipo == 2) {
                        usuario.setTipoUsuario(TipoUsuario.PROFESSOR);
                    } else {
                        System.out.println("Opção inválida!");
                        break;
                    }

                    System.out.print("Digite o nome do livro: ");
                    String nomeLivro = sc.nextLine();

                    boolean livroEncontrado = false;
                    for (Livro livro : listaLivros) {
                        if (livro.getTitulo().equalsIgnoreCase(nomeLivro)) {
                            emprestimo.setLivro(livro);
                            emprestimo.setUsuario(usuario);
                            emprestimo.setDataDevolucao(LocalDate.now().plusDays(7));
                            System.out.println(usuario.realizarEmprestimo(usuario, livro));
                            listaEmprestimos.add(emprestimo);
                            livroEncontrado = true;
                            break;
                        }
                    }

                    if (!livroEncontrado) {
                        System.out.println("Livro não encontrado!");
                    }
                    break;

                case 4:
                    System.out.print("Digite o nome do livro: ");
                    String tituloLivro = sc.nextLine();

                    boolean emprestimoEncontrado = false;
                    for (Emprestimo emp : listaEmprestimos) {
                        if (emp.getLivro().getTitulo().equalsIgnoreCase(tituloLivro)) {
                            System.out.println(emp.verificarDadosEmprestimo(emp.getLivro()));
                            emprestimoEncontrado = true;
                            break;
                        }
                    }

                    if (!emprestimoEncontrado) {
                        System.out.println("Não foi encontrado empréstimo para o livro: " + tituloLivro);
                    }
                    break;

                case 5:
                    System.out.println("Saindo...");
                    continuar = "Não";
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

            if (!continuar.equalsIgnoreCase("Não")) {
                System.out.print("Deseja continuar? (Sim/Não): ");
                continuar = sc.nextLine();
            }
        }

        sc.close();
    }
}
