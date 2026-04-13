package aula04;

// == -> igual
// === -> estritamente igual
// => ou <= -> maior ou igual, menor ou igual
// || -> ou
// && -> e
public class ExemplosVariaveis {
    public static void main(String[] args) {
        int n1, n2;
        n1 = 5;
        n2 = n1 * 3;
        double salario = 500.50;
        String nome = "Lari";
        boolean isEstudante = true;
        float altura = 1.64f;

        System.out.println("Meu nome é " + nome + ", tenho " + n2 + " anos, altura de " + altura + " e ganho R$" + salario);
        System.out.println("Sou estudante? " + isEstudante);
    }   
}
