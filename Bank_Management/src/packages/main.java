package packages;

import java.util.Scanner;

public class main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Marks : ");
        int mark=sc.nextInt();
        if(mark>=80 && mark<100)
        {
            System.out.println("Grade : S");
        }
        else if (mark >=50 && mark<80)
        {
            System.out.println("Grade : A");
        }
        else if(mark>=30 && mark<50)
        {
            System.out.println("Grade : B");
        }
        else
        {
            System.out.println("Grade : C");
        }
    }
}
