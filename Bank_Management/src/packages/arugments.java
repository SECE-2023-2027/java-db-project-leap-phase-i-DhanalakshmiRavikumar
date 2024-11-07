package packages;
import java.util.Scanner;
class functions
{
    Scanner sc = new Scanner(System.in);
    public int get_age()
    {
        System.out.println("Enter age : ");
        int age=sc.nextInt();
        return age;
    }
}

public class arugments
{
    public static void main(String[] args)
    {
        functions f = new functions();
        int age = f.get_age();
        System.out.println("Your age is : "+age);
    }
}
