import java.time.LocalDateTime;

public class Cliente {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private LocalDateTime dataCadastro;

    // Construtor vazio
    public Cliente() {
        this.dataCadastro = LocalDateTime.now();
    }

    // Construtor com parâmetros
    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataCadastro = LocalDateTime.now();
    }

    // Getters
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public LocalDateTime getDataCadastro() { return dataCadastro; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}
