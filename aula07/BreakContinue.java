package aula07;

public class BreakContinue {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                break; // Interrompe o loop quando i é igual a 5
            }
            System.out.println("Valor de i: " + i);
        }

        System.out.println("Loop interrompido com break.");

        for (int j = 0; j < 10; j++) {
            if (j % 2 == 0) {
                continue; // Pula para a próxima iteração quando j é par
            }
            System.out.println("Valor de j: " + j);
        }

        System.out.println("Loop com continue para pular números pares.");
    }
}