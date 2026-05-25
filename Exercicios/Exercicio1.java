package Exercicios;
import java.util.Scanner;
public class Exercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Lendo dados inseridos
        System.out.println("Digite seu nome: ");
        String nome = sc.nextLine();

        System.out.println("Digite o número de horas que trabalha no mês: ");
        int horasTrabalhadas = sc.nextInt();

        System.out.println("Digite o valor recebido por hora de trabalho: ");
        double recebidoHora = sc.nextDouble();

        System.out.println("Digite quantos filhos tem com idade inferior a 14 anos: ");
        int filhosMenor = sc.nextInt();

        System.out.println("Digite sua idade: ");
        int idade = sc.nextInt();

        System.out.println("Digite seu tempo de serviço em anos: ");
        int anosServico = sc.nextInt();

        System.out.println("Digite o valor da bonificação por filho: ");
        double bonificacaoFilho = sc.nextDouble();

        //Cálculos
        double recebidoMes = recebidoHora * horasTrabalhadas;
        double bonificacaoTotal = bonificacaoFilho * filhosMenor;
        double salarioBruto = recebidoMes + bonificacaoTotal;
        System.out.println("Seu salário bruto é R$" + salarioBruto);

        double descontoINPS = salarioBruto - (8.5/100);
        System.out.println("Novo salário com desconto do INPS: R$" + descontoINPS);

        System.out.println("Salário da família: R$" + bonificacaoTotal);

        double IR = 0;
        if (salarioBruto > 1500.00) {
            double calcularIR = salarioBruto + (15/100);
            IR = calcularIR - salarioBruto;
            System.out.println("Imposto de Renda: R$" + IR);
        } else if (salarioBruto > 500.00 && salarioBruto < 1500.00) {
            double calcularIR = salarioBruto + (8/100);
            IR = calcularIR - salarioBruto;
            System.out.println("Imposto de Renda: R$" + IR);
        } else {
            System.out.println("Imposto de Renda: R$0.00");
        }

        double ADIC1 = 0;
        double ADIC2 = 0;
        double ADIC3 = 0;
        if (idade > 40) {
            ADIC1 = salarioBruto + (2/100);
            System.out.println("Valor adicional: R$" + ADIC1);
        } 
        if (anosServico > 15) {
            ADIC2 = salarioBruto + (3.5/100);
            System.out.println("Valor adicional: R$" + ADIC2);
        } 
        if (anosServico <= 15 && anosServico > 5 && idade > 30) {
            ADIC3 = salarioBruto + (1.5/100);
            System.out.println("Valor adicional: R$" + ADIC3);
        }

        System.out.println("Nome: " + nome);

        double totalADIC = ADIC1 + ADIC2 + ADIC3;
        System.out.println("Total de adicionais: R$" + totalADIC);

        System.out.println("Salário bruto: R$" + (salarioBruto + totalADIC));

        double totalDescontos = (descontoINPS - salarioBruto) + IR;

        double salarioLiquido = (salarioBruto - totalDescontos) + totalADIC;
        System.out.println("Salário líquido: R$" + salarioLiquido);

        sc.close();
    }
}
