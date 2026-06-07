package Exercicios;
import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);) {

            //entradas
            System.out.println("Digite seu código de funcionário: ");
            int codigo = sc.nextInt();

            System.out.println("Digite seu sexo (M - F): ");
            char sexo = sc.next().charAt(0);
            char sexoMaiusculo = Character.toUpperCase(sexo);

            System.out.println("Digite seu tempo de trabalho (em anos): ");
            int tempoTrabalho = sc.nextInt();

            System.out.println("Digite seu salário atual:");
            double salarioAtual = sc.nextDouble();

            //Cálculos
            double bonus;
            if (sexoMaiusculo == 'M' && tempoTrabalho > 15) {
                bonus = salarioAtual * (20.0/100);
            } else if (sexoMaiusculo == 'F' && tempoTrabalho > 10) {
                bonus = salarioAtual * (25.0/100);
            } else {
                bonus = 100.0;
            }

            //saída
            System.out.println("--------------------------------");
            System.out.println("Código: " + codigo);
            System.out.println("Valor do Bônus de Natal: R$" + bonus);

            sc.close();
        }
    }
}
