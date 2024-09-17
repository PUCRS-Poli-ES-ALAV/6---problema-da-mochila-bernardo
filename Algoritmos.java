public class Algoritmos {

    public Algoritmos() {

    }

    public int fiboRec(int n) {
        if (n <= 1)
            return n;
        else {
            return fiboRec(n - 1) + fiboRec(n - 2);
        }

    }

    public int fibo(int n) {
        int f[] = new int[n + 1];
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public int memoizedFibo(int n) {
        int f[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            f[i] = -1;
        }
        return lookupFibo(n, f);

    }

    private int lookupFibo(int n, int[] f) {
        if (f[n] >= 0)
            return f[n];

        if (n <= 1) {
            f[n] = n;
        } else {
            f[n] = lookupFibo(n - 1, f) + lookupFibo(n - 2, f);
        }
        return f[n];

    }

    public int knapSack(int capacity, int[] price, int[] weight, int n) {
        if (n == 0 || capacity == 0)
            return 0;

        if (weight[n - 1] > capacity)
            return knapSack(capacity, price, weight, n - 1);

        return Math.max(knapSack(capacity, price, weight, n - 1), (price[n - 1] +
                knapSack((capacity - weight[n - 1]), price, weight, n - 1)));

    }

    public int knapSackBottomUp(int n, int capacity, int[][] itens) {
        int[][] maxTab = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                maxTab[i][j] = 0;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (itens[i][0] <= j) {
                    maxTab[i][j] = Math.max(maxTab[i - 1][j], itens[i][1] + maxTab[i - 1][j - itens[i][0]]);
                } else {
                    maxTab[i][j] = maxTab[i - 1][j];
                }
            }
        }
        return maxTab[n][capacity];

    }

    public int distRec(String s, String t, int i, int j) {
        if (i == 0 && j == 0) {
            return 0;
        }
        if (i == 0) {
            return j;
        }
        if (j == 0) {
            return i;
        }

        if (s.charAt(i) == s.charAt(i)) {
            distRec(s, t, i - 1, j - 1);
        }

        return Math.min(Math.min(distRec(s, t, i - 1, j) + 1, distRec(s, t, i, j - 1) + 1),
                distRec(s, t, i - 1, j - 1) + 1);

    }

    public int distEdProgDina(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] matriz = new int[m + 1][n + 1];
        int custoExtra;
        matriz[0][0] = 0;

        for (int i = 1; i <= m; i++) {
            matriz[i][0] = matriz[i - 1][0] + 1;
        }

        for (int i = 1; i <= n; i++) {
            matriz[0][i] = matriz[0][i - 1] + 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    custoExtra = 0;
                } else {
                    custoExtra = 1;
                }

                matriz[i][j] = Math.min(matriz[i - 1][j] + 1,
                        Math.min(matriz[i][j - 1] + 1, matriz[i - 1][j - 1] + custoExtra));

            }
        }

        return matriz[m][n];

    }

}
