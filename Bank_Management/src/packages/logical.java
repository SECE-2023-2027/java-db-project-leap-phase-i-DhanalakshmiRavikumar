package packages;

public class logical
{
    public static void main(String[] args)
    {
        int a=1;
        int b=3;
        int c=5;
        if(a>b && a>c)
        {
            System.out.println("A is largest");
        }
        else if (b>a && b>c)
        {
            System.out.println("B id largest");
        }
        else
        {
            System.out.println("C is largest");
        }
    }
}

