import java.time.LocalDateTime;

public class Freela {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String especialidade;
    private Double notaAvaliacao;
    private LocalDateTime dataCadastro;


    // Construtor com parâmetros
    public Freela(String nome, String email, String telefone, String especialidade, Double notaAvaliacao) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.especialidade = especialidade;
        this.notaAvaliacao = notaAvaliacao;
        this.dataCadastro = LocalDateTime.now();
    }

    // Getters
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public String getEspecialidade() { return especialidade; }
    public Double getNotaAvaliacao() { return notaAvaliacao; }
    public LocalDateTime getDataCadastro() { return dataCadastro; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
    public void setNotaAvaliacao(Double notaAvaliacao) { this.notaAvaliacao = notaAvaliacao; }
}
