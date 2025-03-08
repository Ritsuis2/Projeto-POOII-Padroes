package classes;

public class EstadoReprovado implements EstadoAlunoTurma {
 
    public void setNota(AlunoTurma alunoTurma, double nota) {
        System.out.println("Erro: Aluno reprovado, não é possível adicionar notas.");
    }
}
