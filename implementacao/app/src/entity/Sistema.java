package entity;

import commons.ClassificacaoDisciplinaEnum;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import static java.nio.file.Files.readAllLines;

public class Sistema {
    private ArrayList<Usuario> usuarios;
    private List<String> dadosUsuarios;

    private ArrayList<Disciplina> disciplinas;
    private List<String> dadosDisciplinas;

    private ArrayList<Curso> cursos;
    private List<String> dadosCursos;

    public Sistema() throws IOException {
        this.init();
    }

    public void init() throws IOException {
        this.usuarios = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.cursos = new ArrayList<>();

        this.popularDados();
    }

    // #region Getters and Setters
    public ArrayList<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return this.disciplinas;
    }
    // #endregion

    private void cadastrarUsuarios() {
        for (int i = 0; i < this.dadosUsuarios.size(); i++) {
            String dadoUsuario[] = this.dadosUsuarios.get(i).split(";");
            String tipo = dadoUsuario[0];
            String nome = dadoUsuario[1];
            int matricula = Integer.parseInt(dadoUsuario[2]);
            String senha = dadoUsuario[3];

            if (tipo.equals("ALUNO")) {
                this.usuarios.add(new Aluno(matricula, nome, senha, null));
            } else if (tipo.equals("PROFESSOR")) {
                this.usuarios.add(new Professor(matricula, nome, senha));
            } else {
                this.usuarios.add(new Secretaria(matricula, nome, senha));
            }
        }
    }

    private void cadastrarCursos() {
        for (int i = 0; i < this.dadosCursos.size(); i++) {
            String dadoCurso[] = this.dadosCursos.get(i).split(";");
            int id = Integer.parseInt(dadoCurso[0]);
            String nome = dadoCurso[1];
            int numMatriculas = Integer.parseInt(dadoCurso[2]);

            this.cursos.add(new Curso(id, nome, numMatriculas));
        }
    }

    private void cadastrarDisciplinas() {
        for (int i = 0; i < this.dadosDisciplinas.size(); i++) {
            String dadoDisciplina[] = this.dadosDisciplinas.get(i).split(";");
            int id = Integer.parseInt(dadoDisciplina[0]);
            String nome = dadoDisciplina[1];
            int num_creditos = Integer.parseInt(dadoDisciplina[2]);
            String tipo = dadoDisciplina[3];

            if (tipo.equals("OBRIGATORIA")) {
                this.disciplinas.add(
                        new Disciplina(id, nome, num_creditos, ClassificacaoDisciplinaEnum.OBRIGATORIA, null, null));
            } else {
                this.disciplinas
                        .add(new Disciplina(id, nome, num_creditos, ClassificacaoDisciplinaEnum.OPTATIVA, null, null));
            }
        }
    }

    private void popularDados() throws IOException {
        String pathUsuarios = ("implementacao/app/src/data/usuarios.txt");
        String pathDisciplinas = ("implementacao/app/src/data/disciplinas.txt");
        String pathCursos = ("implementacao/app/src/data/cursos.txt");

        this.dadosUsuarios = readAllLines(Paths.get(pathUsuarios), Charset.defaultCharset());
        this.dadosDisciplinas = readAllLines(Paths.get(pathDisciplinas), Charset.defaultCharset());
        this.dadosCursos = readAllLines(Paths.get(pathCursos), Charset.defaultCharset());

        this.cadastrarUsuarios();
        this.cadastrarDisciplinas();
        this.cadastrarCursos();
    }

}
