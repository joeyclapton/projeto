import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Teste {

    public static void main(String[] args) {

        Curso curso1 = new Curso("Engenharia de Software", 590);
        /*
         * Menu srcretária , cadastra curso , cadastra disciplinas em curso , adiciona
         * disciplina ao curso
         */

        System.out.println(curso1.getNome());
        System.out.println(curso1.getNumCreditos());

        Disciplina desenvolvimentoSoftware = new Disciplina("Deselvolvimento de Softaware", 89, 8,
                ClassificacaoDisciplina.OBRIGATORIA);
        Disciplina modular = new Disciplina("Modular", 45, 9, ClassificacaoDisciplina.OPTATIVA);
        Disciplina inteligenciaArtificial = new Disciplina("Inteligência Artifical ", 63, 6,
                ClassificacaoDisciplina.OPTATIVA);
        Disciplina engenhariaRequisitos = new Disciplina("Engenharia Requisitos", 9, 25,
                ClassificacaoDisciplina.OPTATIVA);
        Disciplina computadoresSociedade = new Disciplina("Computadores e Sociedade", 144, 2,
                ClassificacaoDisciplina.OBRIGATORIA);
        Disciplina aed1 = new Disciplina("AED I", 6, 3, ClassificacaoDisciplina.OBRIGATORIA);
        System.out.println(desenvolvimentoSoftware.getNome());
        System.out.println(desenvolvimentoSoftware.getId());
        System.out.println(modular.getNome());
        System.out.println(modular.getId());

        curso1.cadastrarDisciplina(desenvolvimentoSoftware);
        curso1.cadastrarDisciplina(modular);
        curso1.cadastrarDisciplina(inteligenciaArtificial);
        curso1.cadastrarDisciplina(engenhariaRequisitos);
        curso1.cadastrarDisciplina(computadoresSociedade);
        curso1.cadastrarDisciplina(aed1);

        System.out.println(curso1.getDisciplinas());
        curso1.removerDisciplina(modular);
        Disciplina projetoSoftware = new Disciplina("Projeto Software", 76, 5, ClassificacaoDisciplina.OBRIGATORIA);
        curso1.cadastrarDisciplina(projetoSoftware);
        System.out.println(curso1.getDisciplinas()); /* verifica inserção de disciplinas na lista */
        curso1.disciplinasCurso(); /* mostra disciplinas do curso */

        Aluno joao = new Aluno("João", "678", 384);
        joao.cadastrarDisciplinas();

        System.out.println(curso1.disciplinas.size());

    }
}
