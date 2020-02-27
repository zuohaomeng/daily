import java.lang.management.PlatformLoggingMXBean;

/**
 * @author 梦醉
 * @date 2020/2/27--15:03
 */
public class Solution2 {
    public boolean isMatch(String s, String p) {
        int slength = s.length();
        int plength = p.length();
        boolean[][] dp = new boolean[slength + 1][plength + 1];
        dp[0][0] = true;
        for (int j = 2; j <= slength; j++) {
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        }
        for (int i = 1; i <= slength; i++) {
            for (int j = 1; j <= plength; j++) {
                int m = i - 1;
                int n = j - 1;
                if (p.charAt(n) == '*') {
                    if (dp[i - 1][j] == true && (p.charAt(n) == s.charAt(m - 1) || p.charAt(n) == '.')) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i][j-2];
                    }
                } else {
                        dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return false;
    }
}
