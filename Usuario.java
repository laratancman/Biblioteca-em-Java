public class Usuario {
    private String nome;
    private int matricula;
    private TipoUsuario tipoUsuario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String realizarEmprestimo(Usuario usuario, Livro livro) {
        if (!livro.isStatusLivro()) {
            livro.setStatusLivro(true);
            return "Livro \"" + livro.getTitulo() + "\" emprestado com sucesso para o usuário " + usuario.getNome() + "!";
        } else {
            return "Livro indisponível, tente novamente em outra data.";
        }
    }
}
