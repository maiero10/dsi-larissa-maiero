package Exercicios;
import java.util.Arrays;
import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);) {

            //armazenado valores num array para ordená-los 
            double[] ladosTriangulo = new double[3];
            System.out.println("Digite o valor do lado A: ");
            ladosTriangulo[0] = sc.nextDouble();

            System.out.println("Digite o valor do lado B: ");
            ladosTriangulo[1] = sc.nextDouble();

            System.out.println("Digite o valor do lado C: ");
            ladosTriangulo[2] = sc.nextDouble();

            //função que ordena os valores do array
            Arrays.sort(ladosTriangulo);

            //atribuindo valores ordenados
            double a = ladosTriangulo[2];
            double b = ladosTriangulo[1];
            double c = ladosTriangulo[0];

            //print dos lados em ordem decrescente
            for (int i = ladosTriangulo.length - 1; i >= 0; i--) {
                System.out.println(ladosTriangulo[i]);
            }

            //Identificação do tipo de triângulo
            if (a > (b + c)) {
                System.out.println("Não é um triângulo");
            } else if ((a * a) == ((b * b) + (c * c))) {
                System.out.println("É um triângulo retângulo");
            } else if ((a * a) > ((b * b) + (c * c))) {
                System.out.println("É um triângulo obtusângulo");
            } else if ((a * a) < ((b * b) + (c * c))) {
                System.out.println("É um triângulo acutângulo");
            }

            if (a == b && b == c) {
                System.out.println("É um triângulo equilátero");
            } else if (a == b || b == c || a == c) {
                System.out.println("É um triângulo isósceles");
            }

            sc.close();
        }
    }
}
