import java.util.ArrayList;
import java.util.List;

public class FreelaRepository {
    private List<Freela> freelas = new ArrayList<>();
    private Long proximoId = 1L;

    // CREATE
    public void adicionar(Freela freela) {
        freela.setId(proximoId);
        freelas.add(freela);
        proximoId++;
    }

    // READ - Listar todos
    public List<Freela> listarTodos() {
        return freelas;
    }

    // READ - Buscar por ID
    public Freela buscarPorId(Long id) {
        for (Freela f : freelas) {
            if (f.getId().equals(id)) {
                return f;
            }
        }
        return null;
    }

    // UPDATE
    public void atualizar(Long id, Freela freeellaAtualizada) {
        Freela f = buscarPorId(id);
        if (f != null) {
            f.setNome(freeellaAtualizada.getNome());
            f.setEmail(freeellaAtualizada.getEmail());
            f.setTelefone(freeellaAtualizada.getTelefone());
            f.setEspecialidade(freeellaAtualizada.getEspecialidade());
            f.setNotaAvaliacao(freeellaAtualizada.getNotaAvaliacao());
        }
    }

    // DELETE
    public void deletar(Long id) {
        Freela f = buscarPorId(id);
        if (f != null) {
            freelas.remove(f);
        }
    }
}
