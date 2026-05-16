package aula07;

public class Loops {
    public static void main(String[] args) {
        // Exemplo de uso do loop for para imprimir os números de 1 a 10
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }

        System.out.println(" ");
        // Exemplo de uso do loop while para imprimir os números de 1 a 10
        int j = 1;
        while (j <= 10) {
            System.out.print(j + " ");
            j++;
        }

        System.out.println(" ");
        // Exemplo de uso do loop do-while para imprimir os números de 1 a 10
        int k = 1;
        do {
            System.out.print(k + " ");
            k++;
        } while (k <= 10);
    }
}
