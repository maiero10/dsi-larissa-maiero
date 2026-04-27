package aula05;

public class Operacoes2 {
    public static void main(String[] args) {
        //= atribui um valor
        int a = 5;
        System.out.println(a);

        //+= pega a váriavel e soma com o próximo valor (5 + 3)
        int b = 5;
        b += 3;
        System.out.println(b);

        //-= pega a variável e subtrai com o próximo valor (5 - 3)
        int c = 5;
        c -= 3;
        System.out.println(c);

        //*= pega a variável e multiplica com o próximo valor (5 * 3)
        int d = 5;
        d *= 3;
        System.out.println(d);  
        
        // /= pega a variável e dividi com o próximo valor (5 / 3)
        double e = 5;
        e /= 3;
        System.out.println(e);

        //%= pega a variável e mostra o resto da divisão com o próximo valor (5 % 3)
        int f = 5;
        f %= 3;
        System.out.println(f);

        /*& compara o bit de cada número inteiro e mantém 1 apenas se houver 
        1 em ambos no mesmo lugar, se não é 0, o resultado disso equivale a um 
        outro número inteiro (bitwise AND)*/
        //5 & 3 -> 101 & 11 = 1 (1)
        int g = 5;
        g &= 3;
        System.out.println(g);


        /*| compara bit dos dois números e se houver ao menos um número 1, 
        então será 1, senão 0 (bitwise OR)*/
        //5 | 3 -> 101 | 11 = 111 (7)
        int h = 5;
        h |= 3;
        System.out.println(h);

        /*^ compara bit dos dois números, quando for bits diferentes é 1,
        iguai é 0 */
        //5 ^ 3 -> 101 ^ 11 = 110 (6)
        int i = 5;
        i ^= 3;
        System.out.println(i);

        //desloca bits x posições pra direita
        // 5 >> 3 -> 101 >> 3 = 0 (0)
        int j = 5;
        j >>= 3;
        System.out.println(j);

        //descolca bits x posições pra esquerda
        // 5 << 3 -> 101 << 3 = 101000 (40)
        int k = 5;
        k <<= 3;
        System.out.println(k);
    }
}
