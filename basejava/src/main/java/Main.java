import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList list = new ArrayList();
        while (sc.hasNextInt()) {
            int t = sc.nextInt();
            list.add(t);
        }
        quickSort(list,0,list.size()-1);
        for (int i = 0; i < list.size(); i++) {
            System.out.print((int)list.get(i)+" ");
        }
    }
    public static void quickSort(ArrayList list,int left,int right){
        if(left>=right){
            return;
        }
        int mid = sort(list,left,right);
        quickSort(list,left,mid-1);
        quickSort(list, mid+1, right);
    }

    private static int sort(ArrayList list, int left, int right) {
        int i = left;
        int j = right+1;
        int k = (int) list.get(left);
        while (true){
            while ((int)list.get(++i)<=k){
                if (i==right) break;
            }
            while ((int)list.get(--j)>k){
                if(j==left) break;
            }
            if(i>=j) break;
            exch(list,i,j);
        }
        exch(list, left, j);
        return j;
    }
    public static void exch(ArrayList list, int a, int b){
        int t = (int) list.get(a);
        list.set(a, (int)list.get(b));
        list.set(b,t);
    }

}
