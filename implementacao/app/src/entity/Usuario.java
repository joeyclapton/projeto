package entity;

public abstract class Usuario {

    protected int matricula;
    protected String nome;
    protected String senha;
    protected boolean logado;

    public Usuario() {

    }

    public Usuario(int matricula, String nome, String senha) {
        this.setNome(nome);
        this.setSenha(senha);
        this.setMatricula(matricula);
    }

    // #region Getters and Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public int getMatricula() {

        return matricula;
    }

    public String getSenha() {
        return senha;
    }
    // #endregion
}
