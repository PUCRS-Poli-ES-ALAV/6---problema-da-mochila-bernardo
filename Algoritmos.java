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

public int knapSackBottomUp(int n, int capacity, int[][] itens){
    int[][] maxTab = new int[n+1][capacity+1];

    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= capacity; j++) {
            maxTab[i][j] = 0;
        }
    }

    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= capacity; j++){
            if(itens[i][0] <= j) {
                maxTab[i][j] = Math.max(maxTab[i-1][j], itens[i][1] + maxTab[i-1][j - itens[i][0]]);
            }
            else{
                maxTab[i][j] = maxTab[i-1][j];
            }
        }
    }
    return maxTab[n][capacity];

    }

}
