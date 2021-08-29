package entity;

public interface ILogin {
    public void cadastrar(String nome, String password);

    public void fazerLogin(int matricula, String password);

    public void trocarSenha(int matricula);

}
