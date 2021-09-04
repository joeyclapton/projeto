package controller.menu;

import java.util.Scanner;

public class Opcoes {

    public Opcoes() {
    }

    private void divisor() {
        System.out.println("-----------------------------------------");
    }

    public int menuProfessor(Scanner teclado) {
        System.out.println("Sistema professor");
        this.divisor();
        System.out.println("Digite sua opção: ");
        System.out.println("1- Listar alunos");
        System.out.println("0 - Sair");
        this.divisor();

        int opcao = teclado.nextInt();
        teclado.nextLine();

        return opcao;
    }

    public int menuAluno(Scanner teclado) {
        System.out.println("Sistema aluno");
        this.divisor();
        System.out.println("Digite sua opção: ");
        System.out.println("1- Cadastrar disciplina");
        System.out.println("0- Sair");
        this.divisor();

        int opcao = teclado.nextInt();
        teclado.nextLine();

        return opcao;
    }

    public int menuSecretaria(Scanner teclado) {
        System.out.println("Sistema secretaria");
        this.divisor();
        System.out.println("Digite sua opção: ");
        System.out.println("1- Cadastrar aluno");
        System.out.println("2- Cadastrar professor");
        System.out.println("3- Cadastrar curso");
        System.out.println("0 - Sair");
        this.divisor();

        int opcao = teclado.nextInt();
        teclado.nextLine();

        return opcao;
    }

}
