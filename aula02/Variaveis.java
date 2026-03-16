package aula02;

public class Variaveis {
    public static void main(String[] args) {
        String msgPt1 = "Olá ";
        String msgPt2 = "alunos";
        System.out.println(msgPt1.concat(msgPt2));

        int n1 = 1;
        String n2 = "2";
        System.out.println(n1 + n2);
        System.out.println(n1 + Integer.parseInt(n2));
    }
}
