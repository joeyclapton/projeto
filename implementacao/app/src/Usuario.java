public abstract class Usuario {

    public int matricula;
    protected String nome;
    protected String senha;

    public Usuario() {

    }

    public void trocarSenha() {

    }

    public void fazerLogin() {

    }

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

}
