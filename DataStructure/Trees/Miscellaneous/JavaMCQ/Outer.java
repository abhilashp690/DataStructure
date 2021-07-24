package Trees.Miscellaneous.JavaMCQ;
public class Outer
{
    Outer()
    {
        System.out.print("out");
    }

    class Inner
    {
        Inner()
        {
            System.out.print("in");
        }
        public void go()
        {
            System.out.print("go_in");
        }
    }

    public static void main (String [] args)
    {
        Outer obj = new Outer();
        obj.fun();
    }
    void fun()
    {
        (new Inner() {}).go();
    }
}
