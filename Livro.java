import java.time.LocalDate;

public class Livro {

    private String titulo;
    private String autor;
    private LocalDate anoPublicacao;
    private boolean statusLivro;

    // Construtor com parâmetros
    public Livro(String titulo, String autor, LocalDate anoPublicacao, boolean statusLivro) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.statusLivro = statusLivro;
    }

    // Construtor padrão
    public Livro() {
    }

    // Retorna o título do livro
    public String getTitulo() {
        return titulo;
    }

    // Define o título do livro
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Retorna o autor do livro
    public String getAutor() {
        return autor;
    }

    // Define o autor do livro
    public void setAutor(String autor) {
        this.autor = autor;
    }

    // Retorna o ano de publicação do livro
    public LocalDate getAnoPublicacao() {
        return anoPublicacao;
    }

    // Define o ano de publicação do livro
    public void setAnoPublicacao(LocalDate anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    // Retorna o status do livro (true = emprestado, false = disponível)
    public boolean isStatusLivro() {
        return statusLivro;
    }

    // Define o status do livro
    public void setStatusLivro(boolean statusLivro) {
        this.statusLivro = statusLivro;
    }

    // Retorna os detalhes do livro em formato de texto
    public String exibirDetalhes() {
        return "Título: " + getTitulo() +
               "\nAutor: " + getAutor() +
               "\nAno de Publicação: " + getAnoPublicacao().getYear() +
               "\nStatus do Livro: " + (isStatusLivro() ? "Emprestado" : "Disponível");
    }
}
