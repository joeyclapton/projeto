import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import commons.ClassificacaoDisciplinaEnum;

public class Aluno extends Usuario {

    private static final int MAX_OBRIGATORIAS = 2;
    private static final int MAX_OPCIONAIS = 3;
    protected List<Disciplina> disciplinasObrigatorias = new ArrayList<>();
    protected List<Disciplina> disciplinasOpcionais = new ArrayList<>();
    protected Curso curso;

    public Aluno(String nome, String senha, int matricula, Curso curso) {
        this.setMatricula(matricula);
        this.setNome(nome);
        this.setSenha(senha);
        this.setCurso(curso);

    }

    public void cadastrarDisciplinasObrigatorias(Disciplina disciplina) throws Exception {
        try {
            if (vericaLimiteDisciplinaObrigatoria() && verificaLimiteGeralDisciplina()) {
                this.disciplinasObrigatorias.add(disciplina);
            }
        } catch (Exception e) {
            throw new Exception("Limite de disciplinas alcançado");
        }
    }

    public void cadastrarDisciplinasOpcionais(Disciplina disciplina) throws Exception {
        try {
            if (vericaLimiteDisciplinaOpcional() && verificaLimiteGeralDisciplina()) {
                this.disciplinasOpcionais.add(disciplina);
            }
        } catch (Exception e) {
            throw new Exception("É necessária ter matrícula em uma disciplina obrigatória!");
        }
    }

    public boolean verificaLimiteGeralDisciplina() {

        return ((disciplinasObrigatorias.size() + disciplinasOpcionais.size()) <= 4);
    }

    public boolean vericaLimiteDisciplinaObrigatoria() {
        return (disciplinasObrigatorias.size() < MAX_OBRIGATORIAS);
    }

    public boolean vericaLimiteDisciplinaOpcional() {
        return (disciplinasObrigatorias.size() > 0 && disciplinasOpcionais.size() < MAX_OPCIONAIS);
    }

    public void cancelarDisciplina(Disciplina disciplinaCancelar) {

        if (disciplinaCancelar.getTipo() == ClassificacaoDisciplinaEnum.OPTATIVA) {
            for (Disciplina disciplina : disciplinasOpcionais) {
                if (disciplina == disciplinaCancelar) {
                    disciplinasOpcionais.remove(disciplina);
                    System.out.println("Disiciplina removida" + disciplina.getNome());
                }

            }

        } else {

            for (Disciplina disciplina : disciplinasObrigatorias) {
                if (disciplina == disciplinaCancelar) {
                    disciplinasObrigatorias.remove(disciplina);
                    System.out.println("Disiciplina removida" + disciplina.getNome());
                }
            }

        }

    }

    public void exibirMatriculas() {

        System.out.println("Disciplinas Obrigatórias e Opcionais Matriculadas :");
        for (Disciplina disciplina : disciplinasObrigatorias) {
            System.out.println(disciplina.getId() + " " + disciplina.getNome() + " "
                    + disciplina.getNum_creditosDisciplina() + " " + disciplina.getTipo());
        }

        for (Disciplina disciplina : disciplinasOpcionais) {

            System.out.println(disciplina.getId() + " " + disciplina.getNome() + " "
                    + disciplina.getNum_creditosDisciplina() + " " + disciplina.getTipo());

        }

    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }
}
