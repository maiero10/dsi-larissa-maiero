package aula07;

import java.util.Scanner;

/** O switch é uma estrutura de controle de fluxo que permite executar diferentes blocos de código com base no valor 
 * de uma expressão. Ele é uma alternativa ao uso de múltiplas instruções if-else, tornando o código mais legível 
 * e organizado quando se tem várias condições a serem verificadas.*/
public class Switch {
    public static void main(String[] args) {
        // Exemplo de uso do switch para determinar o dia da semana com base em um número fornecido pelo usuário
        //try-with-resources para garantir que o Scanner seja fechado automaticamente após o uso
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Digite um número: ");
            int num = sc.nextInt();

            //case -> representa um caso específico que será comparado com o valor da expressão fornecida ao switch. Se o valor corresponder a um case, o bloco de código associado a esse case será executado.
            // uso de -> invés de : para simplificar a sintaxe do switch, eliminando a necessidade de usar break para evitar a execução de casos subsequentes.
            //default -> é usado para lidar com casos em que o valor da expressão não corresponde a nenhum dos casos especificados.
            switch (num) {
                case 1 -> System.out.println("Domingo");
                case 2 -> System.out.println("Segunda-feira");
                case 3 -> System.out.println("Terça-feira");
                case 4 -> System.out.println("Quarta-feira");
                case 5 -> System.out.println("Quinta-feira");
                case 6 -> System.out.println("Sexta-feira");
                case 7 -> System.out.println("Sábado");
                default -> System.out.println("Dia inválido");
            }
        }
    }
}