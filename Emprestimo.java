import java.time.LocalDate;

public class Emprestimo {

    private Livro livro;
    private Usuario usuario;
    private LocalDate dataDevolucao;

    // Retorna o livro do empréstimo
    public Livro getLivro() {
        return livro;
    }

    // Define o livro do empréstimo
    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    // Retorna o usuário do empréstimo
    public Usuario getUsuario() {
        return usuario;
    }

    // Define o usuário do empréstimo
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Retorna a data de devolução do empréstimo
    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    // Define a data de devolução do empréstimo
    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    // Verifica os dados do empréstimo com base em um livro fornecido
    public String verificarDadosEmprestimo(Livro livro) {
        if (this.livro != null && livro != null && this.livro.getTitulo().equalsIgnoreCase(livro.getTitulo())) {
            return "Livro: " + this.livro.getTitulo() +
                   "\nUsuário: " + this.usuario.getNome() +
                   "\nData de Devolução: " + this.dataDevolucao;
        } else {
            return "Não foi encontrado empréstimo para o livro: " + livro.getTitulo();
        }
    }
}
