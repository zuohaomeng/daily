import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(new Integer("12"));
        list.add(new Integer("123"));
        list.add(new Integer("1244"));
        list.add(new Integer("1255"));
        list.add(new Integer("1266"));
        list.add(new Integer("1233"));

        list.remove(12);


    }
}