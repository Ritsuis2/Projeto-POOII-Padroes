package classes;

import java.util.ArrayList;
import java.util.List;

public class Turma {

    private String identificacao;
    private Curso curso;
    private Semestre semestre;
    private ArrayList<Professor> professores = new ArrayList<>();
    private ArrayList<AlunoTurma> alunos = new ArrayList<>();

    private List<Log> logs = new ArrayList<>();

    private String estatica;

    public Turma() {

    }

    public Turma(String identificacao, Curso curso, Semestre semestre) {
        this.identificacao = identificacao;
        this.curso = curso;
        this.semestre = semestre;
        this.logs = new ArrayList<>();
    }

    public void setEstatica() {
        this.estatica = "Valor padrão ou calculado internamente";
    }

    public String getEstatica() {
        return estatica;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(ArrayList<Professor> professores) {
        this.professores = professores;
    }

    public ArrayList<AlunoTurma> getAlunosTurma() {
        return alunos;
    }

    public void setAlunos(ArrayList<AlunoTurma> alunos) {
        this.alunos = alunos;
    }

    public void adicionarProfessor(Professor professor) {
        professor.setCoordenador(false);
        professores.add(professor);
    }

    public void adicionarAluno(AlunoTurma aluno) {
        alunos.add(aluno);
    }

    public void mostrarEstatica() {
        System.out.println("Estáticas das notas dos alunos:");
        int totalAprovados = 0;
        int totalReprovados = 0;
        int totalRecuperacao = 0;
        for (AlunoTurma aluno : alunos) {

            if (aluno.getAluno() != null) {
                String nome = aluno.getAluno().getNome();
                double media = aluno.getNota().calcularMedia();

                System.out.printf("Nome: %s, Média: %.2f\n", nome, media);
                if (media < 2.5) {
                    totalReprovados++;
                } else if (media < 7) {
                    totalRecuperacao++;
                } else {
                    totalAprovados++;
                }
            }
        }

        System.out.println("Total de aprovados: " + totalAprovados);
        System.out.println("Total de reprovados: " + totalReprovados);
        System.out.println("Total de recuperação: " + totalRecuperacao);
    }

    public void alterarNotaEstudante(Professor coordenador, AlunoTurma alunoTurma, Nota novaNota) {
        if (coordenador.isCoordenador()) {
            if (!alunoTurma.getNota().isBloqueado()) {
                alunoTurma.setNota(novaNota);
            } else {
                System.out.println("As notas estão bloqueadas e não podem ser alteradas.");
            }
        } else {
            System.out.println("Somente coordenadores podem alterar notas");
        }
    }

    public void exibirDados() {
        System.out.println("Turma: " + identificacao);
        System.out.println("Professores:");
        for (Professor professor : professores) {
            professor.exibirDados();
        }
        System.out.println("Alunos");
        for (AlunoTurma aluno : alunos) {
            if (aluno.getAluno() != null) {
                aluno.getAluno().exibirDados();
            }
        }
    }
}
