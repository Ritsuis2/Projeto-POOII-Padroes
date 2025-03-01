
package classes;

import java.net.ProtocolFamily;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    // Apliquei o Singleton aqui, removendo a declaração direta de db, utilizando o método getInstance
    static DataBase db = DataBase.getInstance();
    static int opcao;
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        db = DataBase.getInstance();

        db.exportarDadosEstudante();
        menuPrincipal();

        entrada.close();
    }

    public static void menuPrincipal() {
        System.out.println("Selecione a opção:");
        System.out.println("1- Acessar como Coordenador");
        System.out.println("2 - Acessar como Professor");

        opcao = entrada.nextInt();
        entrada.nextLine();

        switch (opcao) {
            case 1:
                menuCoordenador();
                break;
            case 2:
                menuProfessor();
                break;
            default:
                System.out.println("Opção inválida!");
                menuPrincipal();
                break;
        }
    }

    public static void menuSenhaProfessor() {
        System.out.println("Digite a senha do professor");
        String senha = entrada.nextLine();

        if (senha.equals("senhaProfessor")) {
            System.out.println("Senha correta! Acessando menu do professor...");
        } else {
            System.out.println("Senha incorreta");
        }
    }

    public static void selecionarMenu() {
        System.out.print("Digite a senha para acessar como professor: ");
        String senha = entrada.next();
        if (senha.equals("professor")) {
            menuProfessor();
        } else {
            menuCoordenador();
        }
    }

    public static void menuCoordenador() {
        do {
            System.out.println("╔═════════════════════════════════════════╗");
            System.out.println("║                MENU                     ║");
            System.out.println("╠═════════════════════════════════════════╣");
            System.out.println("║     1 - Cadastrar um professor          ║");
            System.out.println("║     2 - Vincular um prof. a turma       ║");
            System.out.println("║     3 - Cadastrar um estudante          ║");
            System.out.println("║     4 - Vincular estud. a turma         ║");
            System.out.println("║     5 - Cadastrar um curso              ║");
            System.out.println("║     6 - Cadastrar uma turma             ║");
            System.out.println("║     7 - Cadastrar um coordenador        ║");
            System.out.println("║  8 - Atribuir notas aos estudantes      ║");
            System.out.println("║     9 - Mostrar a estatística           ║");
            System.out.println("║      10 - Lista de recuperação          ║");
            System.out.println("║          11 - Lista geral               ║");
            System.out.println("║           12 - Histórico                ║");
            System.out.println("║     13 - Exportar dados do estudante    ║");
            System.out.println("║     14 - Importar dados do estudante    ║"); 
            System.out.println("║             0 - Sair                    ║");
            System.out.println("╚═════════════════════════════════════════╝");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarProfessor();
                    break;
                case 2:
                    vincularProfessorTurma();
                    break;
                case 3:
                    cadastrarAluno();
                    break;
                case 4:
                    vincularEstudanteTurma();
                    break;
                case 5:
                    cadastrarCurso();
                    break;
                case 6:
                    cadastrarTurma();
                    break;
                case 7:
                    cadastarCoordenador();
                    break;
                case 8:
                    cadastrarNotas();
                    break;
                case 9:
                    mostrarEstatistica();
                    break;
                case 10:
                    exibirListaRecuperacao();
                    break;
                case 11:
                    exibirListaGeral();
                    break;
                case 12:

                case 13:
                    exportarDadosEstudante(); 
                break;

            case 14:
                importDadosEstudanteMEC(); 
                break;
                    exibirHistorico();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static void menuProfessor() {
        do {
            System.out.println("╔═════════════════════════════════════════╗");
            System.out.println("║                MENU                     ║");
            System.out.println("╠═════════════════════════════════════════╣");
            System.out.println("║  1 - Atribuir notas aos estudantes      ║");
            System.out.println("║     2 - Mostrar a estatística           ║");
            System.out.println("║      3 - Lista de recuperação           ║");
            System.out.println("║           4 - Histórico                 ║");
            System.out.println("║             0 - Sair                    ║");
            System.out.println("╚═════════════════════════════════════════╝");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarNotas();
                    break;
                case 2:
                    mostrarEstatistica();
                    break;
                case 3:
                    exibirListaRecuperacao();
                    break;
                case 4:
                    exibirHistorico();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static String exportarDadosEstudante() {
        ArrayList<String[]> data = new ArrayList<>();
        ExportData exp = new ExportData();
        ArrayList<Aluno> alunos = db.getAlunos();

        for (Aluno aluno : alunos) {
            data.add(new String[]{"matricula", aluno.getMatricula()});
            data.add(new String[]{"nome", aluno.getNome()});
            data.add(new String[]{"cpf", aluno.getCpf()});
            data.add(new String[]{"telefone", aluno.getTelefone()});
            data.add(new String[]{"endereco", aluno.getEndereco()});
        }

        String xmlData = exp.ArrayToXMLFormat(data, 5, "student");
        System.out.println("Dados exportados:");
        System.out.println(xmlData);
        return xmlData;
    }

    public static void importDadosEstudanteMEC() {
        String xmlData = exportarDadosEstudante(); 
        String jsonData = XMLToJSONAdapter.convert(xmlData); 
        ImportDataMEC imec = new ImportDataMEC();
        imec.importData(jsonData);
        System.out.println("Dados importados com sucesso!");
    }
}

    public static void cadastarCoordenador() {

        System.out.println("Lista de professores:");
        for (int i = 0; i < db.getProfessores().size(); i++) {
            System.out.printf("%d - %s\n", i + 1, db.getProfessores().get(i).getNome());
        }

        System.out.print("Escolha o professor coordenador: ");
        int escolhaProfessor = entrada.nextInt();

        if (escolhaProfessor < 0 || escolhaProfessor > db.getProfessores().size() - 1) {
            System.out.println("Escolha inválida.");
            return;
        }

        System.out.print("Escolha o curso para vinculá-lo como coordenador: ");
        for (int i = 0; i < db.getCursos().size(); i++) {
            System.out.printf("%d - %s\n", i + 1, db.getCursos().get(i).getNomeCurso());
        }
        int escolhaCurso = entrada.nextInt();

        if (escolhaCurso < 0 || escolhaCurso > db.getCursos().size() - 1) {
            System.out.println("Escolha inválida.");
            return;
        }

        db.getCursos().get(escolhaCurso).vincularCoordenador(db.getProfessores().get(escolhaProfessor));
        System.out.println(db.getProfessores().get(escolhaProfessor).getNome() + " agora é o coordenador.");
    }

    public static void cadastrarNotas() {
        System.out.println(" ---- Cadastrar Notas ----");

        System.out.println("Selecione a turma");

        for (int i = 0, totalTurmas = db.getTurmas().size(); i < totalTurmas; i++) {
            System.out.println(i + " - " + db.getTurmas().get(i).getIdentificacao() + " Curso " + db.getTurmas().get(i).getCurso().getNomeCurso());
        }

        int escolhaTurma = entrada.nextInt();

        if (escolhaTurma < 0 || escolhaTurma > db.getTurmas().size() - 1) {
            System.out.println("Escolha inválida.");
            return;
        }

        System.out.println("Turma " + db.getTurmas().get(escolhaTurma).getIdentificacao() + " selecionada, selecione o estudante");

        for (int i = 0, totalAlunos = db.getTurmas().get(escolhaTurma).getAlunosTurma().size(); i < totalAlunos; i++) {
            System.out.println(i + " - " + db.getTurmas().get(escolhaTurma).getAlunosTurma().get(i).getAluno().getNome());
        }

        int escolhaEstudante = entrada.nextInt();

        if (escolhaEstudante < 0 || escolhaEstudante > db.getTurmas().get(escolhaTurma).getAlunosTurma().size() - 1) {
            System.out.println("Escolha inválida.");
            return;
        }

        Aluno aluno = db.getTurmas().get(escolhaTurma).getAlunosTurma().get(escolhaEstudante).getAluno();
        Nota nota = db.getTurmas().get(escolhaTurma).getAlunosTurma().get(escolhaEstudante).getNota();

        System.out.printf("Notas do aluno(a): %s\n", aluno.getNome());

        System.out.print("Informe a nota 1: ");
        nota.setNota1(entrada.nextDouble());

        System.out.print("Informe a nota 2: ");
        nota.setNota2(entrada.nextDouble());

        System.out.print("Informe a nota 3: ");
        nota.setNota3(entrada.nextDouble());

        System.out.printf("Média: %.2f\n", nota.calcularMedia());
        System.out.print("Situação: ");
        db.getTurmas().get(escolhaTurma).getAlunosTurma().get(escolhaEstudante).setNota(nota);
        nota.verificarSituacao();
    }

    public static void mostrarEstatistica() {
        System.out.println("Estatísticas");
        for (int i = 0; i < db.getTurmas().size(); i++) {
            System.out.println("Dados da turma " + db.getTurmas().get(i).getIdentificacao());
            db.getTurmas().get(i).setEstatica();
            System.out.println();
        }
    }

    public static void exibirListaRecuperacao() {
        System.out.println("Estudantes em recuperação");
        for (int i = 0; i < db.getTurmas().size(); i++) {
            db.getTurmas().get(i).exibirRecuperacao();
        }
    }

    public static void exibirListaGeral() {
        System.out.println("Lista Geral");
        for (int i = 0; i < db.getTurmas().size(); i++) {
            db.getTurmas().get(i).exibirListaGeral();
        }
    }

    public static void exibirHistorico() {
        System.out.println("Histórico do Estudante");
        for (int i = 0; i < db.getTurmas().size(); i++) {
            for (int j = 0; j < db.getTurmas().get(i).getAlunosTurma().size(); j++) {
                db.getTurmas().get(i).getAlunosTurma().get(j).getAluno().exibirHistorico();
            }
        }
    }

    public static void cadastrarCurso() {

        System.out.print("Nome do curso: ");
        String nomeCurso = entrada.nextLine();

        System.out.print("Código do curso: ");
        String codigoCurso = entrada.nextLine();

        Curso curso = new Curso(nomeCurso, codigoCurso);
        db.getCursos().add(curso);
        System.out.println("Curso cadastrado com sucesso!");
    }

    public static void cadastrarTurma() {
        System.out.print("Identificação da turma: ");
        String identificacao = entrada.nextLine();

        System.out.print("Período da turma: ");
        String periodo = entrada.nextLine();

        System.out.print("Selecione o curso para a turma: ");
        for (int i = 0; i < db.getCursos().size(); i++) {
            System.out.printf("%d - %s\n", i + 1, db.getCursos().get(i).getNomeCurso());
        }

        int escolhaCurso = entrada.nextInt();
        if (escolhaCurso < 0 || escolhaCurso > db.getCursos().size() - 1) {
            System.out.println("Escolha inválida.");
            return;
        }

        Turma turma = new Turma(identificacao, periodo, db.getCursos().get(escolhaCurso));
        db.getTurmas().add(turma);
        System.out.println("Turma cadastrada com sucesso!");

    }

    public static void cadastrarProfessor() {
        System.out.println("Informe o nome do professor:");
        String nomeProfessor = entrada.nextLine();

        Professor professor = new Professor(nomeProfessor);
        db.getProfessores().add(professor);

        System.out.println("Professor cadastrado com sucesso!");
    }

    public static void cadastrarAluno() {
        System.out.print("Nome do aluno: ");
        String nomeAluno = entrada.nextLine();

        System.out.print("Matrícula: ");
        String matricula = entrada.nextLine();

        Aluno aluno = new Aluno(nomeAluno, matricula);
        db.getAlunos().add(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public static void vincularEstudanteTurma() {
    }

    public static void vincularProfessorTurma() {
    }
}
