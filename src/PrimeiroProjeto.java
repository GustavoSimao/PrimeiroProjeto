import java.util.Scanner;

public class PrimeiroProjeto {

    public static void main(String[] args) {
        FreelaRepository repo = new FreelaRepository();
        ClienteRepository repoCliente = new ClienteRepository();
        Scanner teclado = new Scanner(System.in);

        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║       BEM-VINDO AO SISTEMA!        ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.print("\nVocê é Freelancer ou Cliente? ");
        String tipo = teclado.nextLine().toLowerCase();

        if (tipo.contains("cliente") || tipo.contains("client")) {
            menuCliente(teclado, repoCliente);
        } else if (tipo.contains("freela") || tipo.contains("freelancer")) {
            menuFreela(teclado, repo);
        } else {
            System.out.println("Opção inválida!");
        }

        teclado.close();
    }

    // ========== MENU CLIENTE ==========
    static void menuCliente(Scanner teclado, ClienteRepository repoCliente) {
        int menuCliente;
        do {
            System.out.println("\n╔═══════════════ MENU CLIENTE ═══════════════╗");
            System.out.println("║ 1 - Adicionar Cliente                      ║");
            System.out.println("║ 2 - Listar Todos                           ║");
            System.out.println("║ 3 - Buscar por ID                          ║");
            System.out.println("║ 4 - Atualizar Cliente                      ║");
            System.out.println("║ 5 - Deletar Cliente                        ║");
            System.out.println("║ 0 - Sair                                   ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.print("Escolha uma opção: ");
            menuCliente = teclado.nextInt();
            teclado.nextLine();

            switch (menuCliente) {
                case 1:
                    adicionarCliente(teclado, repoCliente);
                    break;
                case 2:
                    listarClientes(repoCliente);
                    break;
                case 3:
                    buscarClienteId(teclado, repoCliente);
                    break;
                case 4:
                    atualizarCliente(teclado, repoCliente);
                    break;
                case 5:
                    deletarCliente(teclado, repoCliente);
                    break;
                case 0:
                    System.out.println("Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (menuCliente != 0);
    }

    // ========== MENU FREELA ==========
    static void menuFreela(Scanner teclado, FreelaRepository repo) {
        int menuFreela;
        do {
            System.out.println("\n╔═══════════════ MENU FREELA ════════════════╗");
            System.out.println("║ 1 - Adicionar Freela                       ║");
            System.out.println("║ 2 - Listar Todos                           ║");
            System.out.println("║ 3 - Buscar por ID                          ║");
            System.out.println("║ 4 - Atualizar Freela                       ║");
            System.out.println("║ 5 - Deletar Freela                         ║");
            System.out.println("║ 0 - Sair                                   ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.print("Escolha uma opção: ");
            menuFreela = teclado.nextInt();
            teclado.nextLine();

            switch (menuFreela) {
                case 1:
                    adicionarFreela(teclado, repo);
                    break;
                case 2:
                    listarFreelas(repo);
                    break;
                case 3:
                    buscarFreelaId(teclado, repo);
                    break;
                case 4:
                    atualizarFreela(teclado, repo);
                    break;
                case 5:
                    deletarFreela(teclado, repo);
                    break;
                case 0:
                    System.out.println("Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (menuFreela != 0);
    }

    // ========== OPERAÇÕES CLIENTE ==========
    static void adicionarCliente(Scanner teclado, ClienteRepository repoCliente) {
        System.out.print("Nome: ");
        String nome = teclado.nextLine();
        System.out.print("Email: ");
        String email = teclado.nextLine();
        System.out.print("Telefone: ");
        String telefone = teclado.nextLine();

        Cliente cliente = new Cliente(nome, email, telefone);
        repoCliente.adicionar(cliente);
        System.out.println("Cliente " + nome + " cadastrado com sucesso!");
    }

    static void listarClientes(ClienteRepository repoCliente) {
        System.out.println("\n═══════════════ LISTA DE CLIENTES ═══════════════");
        if (repoCliente.listarTodos().isEmpty()) {
            System.out.println("Nenhum cliente cadastrado!");
            return;
        }
        for (Cliente c : repoCliente.listarTodos()) {
            System.out.println("[ID: " + c.getId() + "] " + c.getNome() +
                    " | Email: " + c.getEmail() +
                    " | Telefone: " + c.getTelefone());
        }
    }

    static void buscarClienteId(Scanner teclado, ClienteRepository repoCliente) {
        System.out.print("ID para buscar: ");
        Long id = teclado.nextLong();
        teclado.nextLine();

        Cliente c = repoCliente.buscarPorId(id);
        if (c != null) {
            System.out.println("\nCliente encontrado!");
            System.out.println("Nome: " + c.getNome());
            System.out.println("Email: " + c.getEmail());
            System.out.println("Telefone: " + c.getTelefone());
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    static void atualizarCliente(Scanner teclado, ClienteRepository repoCliente) {
        System.out.print("ID para atualizar: ");
        Long id = teclado.nextLong();
        teclado.nextLine();

        Cliente c = repoCliente.buscarPorId(id);
        if (c != null) {
            System.out.print("Novo nome: ");
            String novoNome = teclado.nextLine();
            System.out.print("Novo email: ");
            String novoEmail = teclado.nextLine();
            System.out.print("Novo telefone: ");
            String novoTelefone = teclado.nextLine();

            Cliente clienteAtualizado = new Cliente(novoNome, novoEmail, novoTelefone);
            repoCliente.atualizar(id, clienteAtualizado);
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    static void deletarCliente(Scanner teclado, ClienteRepository repoCliente) {
        System.out.print("ID para deletar: ");
        Long id = teclado.nextLong();
        teclado.nextLine();

        Cliente c = repoCliente.buscarPorId(id);
        if (c != null) {
            repoCliente.deletar(id);
            System.out.println("Cliente " + c.getNome() + " deletado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    // ========== OPERAÇÕES FREELA ==========
    static void adicionarFreela(Scanner teclado, FreelaRepository repo) {
        System.out.print("Nome: ");
        String nome = teclado.nextLine();
        System.out.print("Email: ");
        String email = teclado.nextLine();
        System.out.print("Telefone: ");
        String telefone = teclado.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = teclado.nextLine();
        System.out.print("Nota (0-5): ");
        Double nota = teclado.nextDouble();
        teclado.nextLine();

        Freela freela = new Freela(nome, email, telefone, especialidade, nota);
        repo.adicionar(freela);
        System.out.println("Freela " + nome + " cadastrado com sucesso!");
    }

    static void listarFreelas(FreelaRepository repo) {
        System.out.println("\n═══════════════ LISTA DE FREELANCERS ═══════════════");
        if (repo.listarTodos().isEmpty()) {
            System.out.println("Nenhum freela cadastrado!");
            return;
        }
        for (Freela f : repo.listarTodos()) {
            System.out.println("[ID: " + f.getId() + "] " + f.getNome() +
                    " | " + f.getEspecialidade() +
                    " | " + f.getNotaAvaliacao());
        }
    }

    static void buscarFreelaId(Scanner teclado, FreelaRepository repo) {
        System.out.print("ID para buscar: ");
        Long id = teclado.nextLong();
        teclado.nextLine();

        Freela f = repo.buscarPorId(id);
        if (f != null) {
            System.out.println("\nFreela encontrado!");
            System.out.println("Nome: " + f.getNome());
            System.out.println("Email: " + f.getEmail());
            System.out.println("Telefone: " + f.getTelefone());
            System.out.println("Especialidade: " + f.getEspecialidade());
            System.out.println("Nota: " + f.getNotaAvaliacao());
        } else {
            System.out.println("Freela não encontrado!");
        }
    }

    static void atualizarFreela(Scanner teclado, FreelaRepository repo) {
        System.out.print("ID para atualizar: ");
        Long id = teclado.nextLong();
        teclado.nextLine();

        Freela f = repo.buscarPorId(id);
        if (f != null) {
            System.out.print("Novo nome: ");
            String novoNome = teclado.nextLine();
            System.out.print("Novo email: ");
            String novoEmail = teclado.nextLine();
            System.out.print("Novo telefone: ");
            String novoTelefone = teclado.nextLine();
            System.out.print("Nova especialidade: ");
            String novaEspecialidade = teclado.nextLine();
            System.out.print("Nova nota: ");
            Double novaNota = teclado.nextDouble();
            teclado.nextLine();

            Freela freelaAtualizada = new Freela(novoNome, novoEmail, novoTelefone, novaEspecialidade, novaNota);
            repo.atualizar(id, freelaAtualizada);
            System.out.println("Freela atualizado com sucesso!");
        } else {
            System.out.println("Freela não encontrado!");
        }
    }

    static void deletarFreela(Scanner teclado, FreelaRepository repo) {
        System.out.print("ID para deletar: ");
        Long id = teclado.nextLong();
        teclado.nextLine();

        Freela f = repo.buscarPorId(id);
        if (f != null) {
            repo.deletar(id);
            System.out.println("Freela " + f.getNome() + " deletado com sucesso!");
        } else {
            System.out.println("Freela não encontrado!");
        }
    }
}
