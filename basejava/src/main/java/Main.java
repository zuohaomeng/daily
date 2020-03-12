import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        if(n == 1){
            System.out.println(-1);
            return;
        }
        int[][] num = new int[2 + 1][n + 1];
        num[1][1] = 1;
        num[1][2] = 0;
        for (int i = 2; i <= n; i++) {
            if (s1.charAt(i - 1) == '.') {
                num[1][i] = num[1][i - 1] + num[2][i - 1];
            } else {
                num[1][i] = 0;
            }
            if (s2.charAt(i - 1) == '.') {
                num[2][i] = num[2][i - 1] + num[1][i - 1];
            } else {
                num[2][i] = 0;
            }
            if (num[1][i] == 0 && num[2][i] == 0) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(num[2][n]);
    }
}
/*
1
.
.
 */