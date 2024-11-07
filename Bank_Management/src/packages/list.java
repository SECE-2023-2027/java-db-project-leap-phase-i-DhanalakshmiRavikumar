package packages;
import java.util.*;

class function {
    public static int min(List<Integer>a) {
        int min = 0;
        for (int e : a) {
            if (e < min) {
                min = e;
            }
        }
        return min;

    }

    public static int max(List<Integer> a)
    {
        int max = 0;
        for (int e : a) {
            if (e > max) {
                max = e;
            }
        }
        return max;
    }

    public static void duplicate(List<Integer>a)
    {
        List<Integer> list = new ArrayList<>();
        System.out.println("Duplicate are :");
        for (int i = 0; i < a.size(); i++) {
            for(int j = i+1; j < a.size()-1; j++) {
                if (a.get(i) == a.get(j)) {
                    System.out.println(a.get(i));
                }
            }
        }
    }

    public class list
    {
        public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);
            List<Integer> l = new ArrayList<Integer>();
            System.out.println("Enter the size of the list");
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                l.add(sc.nextInt());
            }
            int min = function.min(l);
            int max = function.max(l);
            System.out.println("Minimum number is : " + min);
            System.out.println("Maxmium number is : " + max);
            function.duplicate(l);

        }
    }
}
