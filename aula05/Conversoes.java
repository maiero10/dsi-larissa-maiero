package aula05;

public class Conversoes {
    public static void main(String[] args) {
        // Conversão implícita (widening)
        int numInt = 100;
        double numDouble = numInt; // int é convertido para double
        System.out.println("Número inteiro: " + numInt);
        System.out.println("Número double: " + numDouble);

        // Conversão explícita (narrowing)
        double valorDouble = 3.14;
        int valorInt = (int) valorDouble; // double é convertido para int
        System.out.println("Valor double: " + valorDouble);
        System.out.println("Valor inteiro: " + valorInt);

        // Conversão de String para int
        String strNum = "123";
        int numFromString = Integer.parseInt(strNum); // String é convertido para int
        System.out.println("Número a partir da String: " + numFromString);

        // Conversão de String para double
        String strDouble = "3.14";
        double doubleFromString = Double.parseDouble(strDouble); // String é convertido para double
        System.out.println("Número double a partir da String: " + doubleFromString);
    }
}