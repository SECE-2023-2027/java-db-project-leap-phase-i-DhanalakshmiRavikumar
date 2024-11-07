package packages;

class parentclass
{
    void display()
    {
        System.out.println("Parent class");
    }
}
class childclass extends parentclass
{
    void display()
    {
        System.out.println("Child class");
    }
}

public class overriding
{
    public static void main(String[] args)
    {
        childclass c = new childclass();
        c.display();
        parentclass p = new parentclass();
        p.display();
    }
}
