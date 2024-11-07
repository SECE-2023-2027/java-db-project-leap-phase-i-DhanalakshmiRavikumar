package packages;
import java.util.Scanner;
public class child
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id : ");
        int id = sc.nextInt();
        System.out.println("Enter the name : ");
        String name = sc.next();
        System.out.println("Enter the age : ");
        int age = sc.nextInt();
        parent p = new parent();
        p.set_id(id);
        p.set_name(name);
        p.set_age(age);
        System.out.println(p.get_name());
        System.out.println(p.get_id());
        System.out.println(p.get_age());
    }
}
