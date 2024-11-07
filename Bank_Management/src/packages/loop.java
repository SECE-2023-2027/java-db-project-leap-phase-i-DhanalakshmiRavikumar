package packages;

public class loop {
    public static void main(String[] args) {
//        int n=5;
//        for(int i=0;i<n;i++){
//            int a=1;
//            for(int j=0;j<=i;j++){
//                System.out.print(a);
//                a=a+1;
//            }
//            System.out.println();
//        }
//        int n=5;
//        for(int i=0;i<n;i++){
//            for(int j=n-1;j>=2*i+1;j--){
//                System.out.print(" ");
//            }
//        }
        int n = 5;
        int s = 5;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            int a = s;
            for (int k = 0; k < n - i; k++) {
                System.out.print(a + " ");
                --a;
            }
            System.out.println();
            --s;
//        }
//        int n=5;
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n-i;j++){
//                System.out.print(" ");
//            }
//            for(int k=0;k<=i;k++){
//                System.out.print("*"+" ");
//            }
//            System.out.println();
//        }

        }
    }
}

