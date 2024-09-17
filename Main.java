public class Main {
    public static void main(String[] args) {

        Algoritmos a = new Algoritmos();

        long startTime = System.nanoTime();

        // System.out.println(a.fiboRec(4));
        // System.out.println(a.fiboRec(8));
        // System.out.println(a.fiboRec(16));
        // System.out.println(a.fiboRec(32));
        // System.out.println(a.fibo(4));
        // System.out.println(a.fibo(8));
        // System.out.println(a.fibo(16));
        // System.out.println(a.fibo(32));
        // System.out.println(a.fibo(128));
        // System.out.println(a.fibo(1000));
        // System.out.println(a.fibo(1000000000));
        // System.out.println(a.memoizedFibo(4));
        // System.out.println(a.memoizedFibo(8));
        // System.out.println(a.memoizedFibo(16));
        // System.out.println(a.memoizedFibo(32));
        // System.out.println(a.memoizedFibo(128));
        // System.out.println(a.memoizedFibo(1000));
        // System.out.println(a.memoizedFibo(10000));

        // teste 1
        int[] price = { 92, 57, 49, 68, 60, 43, 67, 84, 87, 72 };
        int[] weight = { 23, 31, 29, 44, 53, 38, 63, 85, 89, 82 };

        // teste 2

        // int [] price = {50, 50, 64, 46, 50, 05};
        // int [] weight = {56, 59, 80, 64, 75, 17};

        System.out.println("Maior valor: " + a.knapSack(165, price, weight, price.length));

        int[][] itens = new int[price.length + 1][2];
        for (int i = 0; i < price.length; i++) {
            itens[i + 1][0] = weight[i]; // Peso
            itens[i + 1][1] = price[i]; // Valor
        }

        itens[0][0] = 0;
        itens[0][1] = 0;

        System.out.println("Maior valor(otimizado): " + a.knapSackBottomUp(price.length, 165, itens));

        String d = "casa";
        String e = "meta";

        System.out.println(a.distRec(d, e, d.length() - 1, e.length() - 1));
        System.out.println(a.distEdProgDina(d, e));

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Tempo de execução: " + duration / 1000000 + "ms");
    }

}