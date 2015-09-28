import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int [] arr = new int[n];

            int [][] cache = new int[n][k];
            for (int y = 0; y < n; y++) {
                arr[y] = in.nextInt();
                for (int z = 0; z < k; z++) {
                    cache[y][z] = -1;
                }
            }
            Arrays.sort(arr);
            System.out.println(getSum(k, arr, n-1, 0, cache));
        }
    }

    public static int getSum(int k, int [] arr, int idx, int curSum, int[][] cache) {
        if (curSum == k) {
            return k;
        }
        if (curSum > k) {
            return 0;
        }
        if (idx < 0) {
            return curSum;
        }
        if (cache[idx][curSum] != -1) {
            return cache[idx][curSum];
        }

        int denom = arr[idx];
        int bestSum = 0;
        //System.out.println("d:"+denom+" div:"+(k/denom)+" curSum:"+curSum);
        for (int i = 0; i <= (k/denom); i++) {
            int subSum = curSum + (i * denom);
            int pSum = getSum(k,arr,idx-1,subSum,cache);

            if ((k - pSum) < (k - bestSum)) {
                bestSum = pSum;
            }
            if (bestSum == k) {
                return k;
            }
        }
        cache[idx][curSum] = bestSum;
        return bestSum;
    }
}