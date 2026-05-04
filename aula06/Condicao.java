package aula06;

public class Condicao {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;

        // if
        if (a > b) {
            System.out.println("a é maior que b");
        }

        // if-else
        if (a < b) {
            System.out.println("a é menor que b");
        } else {
            System.out.println("a não é menor que b");
        }

        // if-else if-else
        if (a == b) {
            System.out.println("a é igual a b");
        } else if (a > b) {
            System.out.println("a é maior que b");
        } else {
            System.out.println("a é menor que b");
        }
    }
}