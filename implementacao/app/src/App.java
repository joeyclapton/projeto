import java.awt.*;
import java.lang.reflect.AnnotatedArrayType;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import commons.ClassificacaoDisciplinaEnum;
import entity.*;
import entity.Menu;

public class App {

        public static void main(String[] args) throws Exception {

                Menu menu = new Menu();

                // Curso curso1 = new Curso("Engenharia de Software", 590);

                // System.out.println(curso1.getNome());
                // System.out.println(curso1.getNumCreditos());
                // Professor caram = new Professor("Caram", "35577");

                // Disciplina desenvolvimentoSoftware = new Disciplina("Deselvolvimento de
                // Softaware", 8,
                // ClassificacaoDisciplinaEnum.OBRIGATORIA, curso1, caram);
                // Disciplina modular = new Disciplina("Modular", 9,
                // ClassificacaoDisciplinaEnum.OBRIGATORIA, curso1,
                // caram);
                // Disciplina inteligenciaArtificial = new Disciplina("Inteligência Artifical ",
                // 6,
                // ClassificacaoDisciplinaEnum.OPTATIVA, curso1, caram);
                // Disciplina engenhariaRequisitos = new Disciplina("Engenharia Requisitos", 25,
                // ClassificacaoDisciplinaEnum.OPTATIVA, curso1, caram);
                // Disciplina computadoresSociedade = new Disciplina("Computadores e Sociedade",
                // 2,
                // ClassificacaoDisciplinaEnum.OBRIGATORIA, curso1, caram);
                // Disciplina aed1 = new Disciplina("AED I", 20,
                // ClassificacaoDisciplinaEnum.OBRIGATORIA, curso1, caram);
                // // adiciona disciplinas para o professor
                // caram.addDisciplina(desenvolvimentoSoftware);
                // caram.addDisciplina(computadoresSociedade);
                // caram.addDisciplina(engenhariaRequisitos);
                // System.out.println(desenvolvimentoSoftware.getNome());
                // System.out.println(desenvolvimentoSoftware.getId());
                // System.out.println(modular.getNome());
                // System.out.println(modular.getId());

                // curso1.cadastrarDisciplina(desenvolvimentoSoftware);
                // curso1.cadastrarDisciplina(modular);
                // curso1.cadastrarDisciplina(inteligenciaArtificial);
                // curso1.cadastrarDisciplina(engenhariaRequisitos);
                // curso1.cadastrarDisciplina(computadoresSociedade);
                // curso1.cadastrarDisciplina(aed1);

                // System.out.println(curso1.getDisciplinas());
                // curso1.removerDisciplina(modular);
                // Disciplina projetoSoftware = new Disciplina("Projeto Software", 5,
                // ClassificacaoDisciplinaEnum.OBRIGATORIA, curso1, caram);
                // curso1.cadastrarDisciplina(projetoSoftware);
                // System.out.println(curso1.getDisciplinas()); /* verifica inserção de
                // disciplinas na lista */
                // curso1.toString(); /* mostra disciplinas do curso */

                // Aluno joao = new Aluno("João", "678", curso1);
                // Aluno carla = new Aluno("Carla", "562", curso1);
                // joao.cadastrarDisciplinasObrigatorias(desenvolvimentoSoftware); // cadastra
                // disciplina obrigatória

                // joao.cadastrarDisciplinasObrigatorias(projetoSoftware);
                // joao.cadastrarDisciplinasOpcionais(engenhariaRequisitos); // cadastra
                // disciplina opcional
                // joao.cadastrarDisciplinasOpcionais(inteligenciaArtificial);
                // System.out.println("-----------");

                // joao.exibirMatriculas();
                // // joao.cancelarDisciplina(engenhariaRequisitos); // cancela disciplina
                // // joao.cancelarDisciplina(desenvolvimentoSoftware); // cancela disciplina
                // joao.cadastrarDisciplinasObrigatorias(modular); // cadastra nova
                // joao.exibirMatriculas(); // exibe as matriculas realizadas

                // carla.cadastrarDisciplinasObrigatorias(aed1);
                // carla.cadastrarDisciplinasObrigatorias(modular);
                // carla.cadastrarDisciplinasOpcionais(engenhariaRequisitos);

                // Matricula novaMatricula = new Matricula(joao, engenhariaRequisitos); //
                // matricula joao
                // novaMatricula.efetuarMatricula();
                // Matricula novaMatricula2 = new Matricula(carla, engenhariaRequisitos); //
                // matricula carla
                // novaMatricula2.efetuarMatricula();
                // System.out.println(engenhariaRequisitos.getAlunos().size()); // verifica
                // quantos alunos estão
                // // matriculados

                // novaMatricula.cancelarMatricula(); // cancela matricula

                // System.out.println(engenhariaRequisitos.getAlunos().size()); // verifica
                // quantos alunos estão
                // // matriculados

                // if (engenhariaRequisitos.estadoDisciplina() == false) {
                // curso1.removerDisciplina(engenhariaRequisitos); // remove disciplina que
                // possui menos de 3
                // // alunos
                // }

                // curso1.toString(); // mostra disciplina removida do curso

                // // SECRETÁRIA

                // Secretaria num1 = new Secretaria("Anna", "34567");

                // num1.manterInformacoesAluno(carla); // mostra informações carla

                // // num1.manterInformacoesDisciplinas(engenhariaRequisitos);// mostra
                // informações
                // // disciplina
                // num1.manterInformacoesProfessor(caram); // mostra informação professor

                // caram.listarAlunosMatriculados(engenhariaRequisitos); // mostra os alunos
                // matriculados na disciplina

                /*
                 * Pontos a resolver : Há períodos para efetuar matrículas, durante os quais um
                 * aluno pode acessar o sistema para se matricular em disciplinas e/ou para
                 * cancelar matrículas feitas anteriormente. -- Melhorar realização matricula --
                 * Criar sistema cobranças Após um aluno se inscrever para um semestre, o
                 * sistema de cobranças é notificado pelo sistema de matrículas, de modo que o
                 * aluno possa ser cobrado pelas disciplinas daquele semestre.
                 * 
                 * -- Desenvolver e aplicar Em nenhum dos testes os usuários estão fazendo login
                 * primeiro Todos os usuários do sistema têm senhas que são utilizadas para
                 * validação do respectivo login.
                 * 
                 * Corrigir gambiarras
                 * 
                 * 
                 */

        }
}