import java.util.Arrays;

public class Main {
    int[] w = {5, 4, 6, 3};   //行
    int[] v = {10, 40, 30, 50}; //列
    int W = 10;//最高重量为10

    public void solution() {
        int[][] dp = new int[w.length + 1][W+1];

        for (int i = 0; i <= W; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= w.length; i++) {
            dp[i][0] = 0;
            for (int j = 1; j <= W; j++) {
                //比较
                if (w[i-1] <= j) {
                    dp[i][j] = Math.max((dp[i - 1][j - w[i-1]] + v[i-1]), dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }


        for (int i = 1; i <= w.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }

    public static void main(String[] args) {
        new Main().solution();
    }
}