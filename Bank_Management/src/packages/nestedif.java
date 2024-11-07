package packages;
import java.util.Scanner;
public class nestedif
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the age: ");
        int age =sc.nextInt();
        if(age>18)
        {
            System.out.println("You are eligible to vote");
            if(age>=80)
            {
                System.out.println("You are eligible for the pension");
            }
        }
    }
}
