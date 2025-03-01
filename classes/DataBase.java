package classes;

import java.util.ArrayList;

public class DataBase implements IObservable {

    private static DataBase instance;
    private ArrayList<Aluno> alunos;
    private ArrayList<Professor> professores;
    private ArrayList<Curso> cursos;
    private ArrayList<Turma> turmas;
    private ArrayList<IObserver> observers;

    private DataBase() {
        this.alunos = new ArrayList<>();
        this.professores = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.turmas = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public static synchronized DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Object arg) {
        for (IObserver observer : observers) {
            observer.update(arg);
        }
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
        notifyObservers(true);
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(ArrayList<Professor> professores) {
        this.professores = professores;
        notifyObservers(true);
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
        notifyObservers(true);
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas = turmas;
        notifyObservers(true);
    }

    public void exportarDadosEstudante() {
        System.out.println("Exportando dados dos estudantes...");
        for (Aluno aluno : alunos) {
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Matrícula: " + aluno.getMatricula());
            System.out.println("CPF: " + aluno.getCpf());
            System.out.println("Telefone: " + aluno.getTelefone());
            System.out.println("Endereço: " + aluno.getEndereco());
            System.out.println("-------------------------------------");
        }
    }

}
