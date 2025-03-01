package classes;

public class Nota implements iObserver {
  
import java.util.ArrayList;
import java.util.List;

public class Nota {
private Double nota1;
private Double nota2;
private Double nota3;
private Double notaRecuperacao;
private boolean bloqueado;
  
  public Nota(){
   this.nota1 = 0.0;
   this.nota2 = 0.0;
   this.nota3 = 0.0;
   this.notaRecuperacao = 0.0;
  }


  public Nota(Double nota1, Double nota2, Double nota3) {

    if (!bloqueado){
    this.nota1 = (nota1 != null) ? nota1 : 0.0;
    this.nota2 = (nota2 != null) ? nota2 : 0.0;
    this.nota3 = (nota3 != null) ? nota3 : 0.0; 
   }
}


public Double getNota1() {
  return this.nota1;
}

public void setNota1(Double nota1) {
   if (!bloqueado){
  this.nota1 = nota1;
  notifyObservers();
  }
}



public Double getNota2() {
  return this.nota2;
}

public void setNota2(Double nota2) {
  if (!bloqueado){
  this.nota2 = nota2;
  notifyObservers();
    }
}


public Double getNota3() {
  return this.nota3;
}

public void setNota3(Double nota3) {
   if (!bloqueado){
  this.nota3 = nota3;
  notifyObservers();
  }
}


public double calcularMedia() {
  return (this.nota1 + this.nota2 + this.nota3)/ 3;
}
  

public boolean verificarSituacao() {
  boolean aprovado = false;
  double media = this.calcularMedia();

  if (media < 2.5) {
    System.out.println("Reprovado");
  } else if (media < 7) {
    System.out.println("Em recuperação");
  } else {
    System.out.println("Aprovado");
    aprovado = true;
  }

  return aprovado;
}

public void setNotaRecuperacao(double nota){
  this.notaRecuperacao = nota;
  notifyObservers();
}
      public void setAtivo(boolean ativo) {
      this.ativo = ativo;
      notifyObservers();
        System.out.println("Estado 'ativo' alterado para: " + ativo);
    }


public String toString(){
  return this.nota1 + " , " + this.nota2 + " " + this.nota3;
}

public  void update(Boolean param){
  bloqueado = !param;
}
}
