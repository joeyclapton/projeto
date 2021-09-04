package entity;

public interface ILogin {
    public void fazerLogin(int matricula, String senha);

    public Usuario getUsuarioLogado();

    public void trocarSenha(int matricula);

}
