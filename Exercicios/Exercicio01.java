package Exercicios;
import java.util.Scanner;
public class Exercicio01 {
    public static void main(String[] args) {
        //Lendo dados inseridos
        try (Scanner sc = new Scanner(System.in)) {
            //Lendo dados inseridos
            System.out.println("Digite seu nome: ");
            String nome = sc.nextLine();
            
            System.out.println("Digite o número de horas que trabalha no mês: ");
            int horasTrabalhadas = sc.nextInt();
            
            System.out.println("Digite o valor recebido por hora de trabalho: ");
            double recebidoHora = sc.nextDouble();
            
            System.out.println("Digite número de filhos com menos de 14 anos: ");
            int filhosMenor = sc.nextInt();
            
            System.out.println("Digite sua idade: ");
            int idade = sc.nextInt();
            
            System.out.println("Digite seu tempo de serviço em anos: ");
            double anosServico = sc.nextDouble();
            
            System.out.println("Digite o valor da bonificação por filho (salário família): ");
            double bonificacaoFilho = sc.nextDouble();
            
            //CÁLCULOS
            //salário bruto
            double recebidoMes = recebidoHora * horasTrabalhadas;
            double bonificacaoTotal = bonificacaoFilho * filhosMenor;
            double salarioBruto = recebidoMes + bonificacaoTotal;
            
            //desconto INPS
            double descontoINPS = salarioBruto * (8.5/100);
            
            //imposto de renda
            double IR = 0;
            if (salarioBruto > 1500.00) {
                IR = salarioBruto * (15.0/100);
            } else if (salarioBruto > 500.00) {
                IR = salarioBruto * (8.0/100);
            } 
            
            //adicional
            double ADIC = 0;
            if (idade > 40) {
                ADIC = salarioBruto * (2.0/100);
            } else if (anosServico > 15) {
                ADIC = salarioBruto * (3.5/100);
            } else if (anosServico > 5 && anosServico <= 15 && idade > 30) {
                ADIC = salarioBruto * (1.5/100);
            }

            //totais
            double totalDescontos = descontoINPS + IR;
            double salarioLiquido = salarioBruto - totalDescontos + ADIC;

            //prints
            System.out.println("--------------------------------- \n");
            System.out.println("Nome: " + nome);
            System.out.println("Slário bruto: R$" + salarioBruto);
            System.out.println("Salário família: R$" + bonificacaoTotal);
            System.out.println("Desconto INPS: R$" + descontoINPS);
            System.out.println("Imposto de renda: R$" + IR);
            System.out.println("Total de descontos: R$" + totalDescontos);
            System.out.println("Adicional: R$" + ADIC);
            System.out.println("Salário líquido: R$" + salarioLiquido);
        }
    }
}