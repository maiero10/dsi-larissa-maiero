package aula06;

public class Logica {
    public static void main(String[] args) {
        // && operador lógico AND
        boolean a = true;
        boolean b = false;
        System.out.println(a && b);

        int x = 5;
        System.out.println(x > 3 && x < 10);

        // || operador lógico OR
        System.out.println(a || b);

        int x = 5;
        System.out.println(x > 3 || x < 4);

        // ! operador lógico NOT
        System.out.println(!a);

        int x = 5;
        System.out.println(!(x > 3 && x < 10));
    }
}