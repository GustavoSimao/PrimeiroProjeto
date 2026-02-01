import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private List<Cliente> clientes = new ArrayList<>();
    private Long proximoId = 1L;

    // CREATE
    public void adicionar(Cliente cliente) {
        cliente.setId(proximoId);
        clientes.add(cliente);
        proximoId++;
    }

    // READ - Listar todos
    public List<Cliente> listarTodos() {
        return clientes;
    }

    // READ - Buscar por ID
    public Cliente buscarPorId(Long id) {
        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    // UPDATE
    public void atualizar(Long id, Cliente clienteAtualizado) {
        Cliente c = buscarPorId(id);
        if (c != null) {
            c.setNome(clienteAtualizado.getNome());
            c.setEmail(clienteAtualizado.getEmail());
            c.setTelefone(clienteAtualizado.getTelefone());
        }
    }

    // DELETE
    public void deletar(Long id) {
        Cliente c = buscarPorId(id);
        if (c != null) {
            clientes.remove(c);
        }
    }
}
