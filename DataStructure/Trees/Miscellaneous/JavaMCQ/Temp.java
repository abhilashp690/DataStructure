package Trees.Miscellaneous.JavaMCQ;

class MyThread extends Thread
{
    MyThread()
    {
        System.out.print(" Thread");
    }
    public void run()
    {
        System.out.print(" 2");
    }
    public void run(String s)
    {
        System.out.println(" 3");
    }
}
public class Temp
{
    public static void main (String [] args)
    {
//        String __$1____str="These Variables!";
//        String $s=__$1___str;
//        int a=31,b=a++;
//        int @q=12;
//        if ($s=="These Variables")
//            System.out.println("True");
//        else
//            System.out.println("False");
    }
}



class Test extends Thread
{
    final StringBuffer str1 = new StringBuffer();
    final StringBuffer str2 = new StringBuffer();

    public static void main(String args[])
    {
        final Test obj = new Test();

        new Thread()
        {
            public void run()
            {
                synchronized(this)
                {
                    obj.str1.append("1");
                    obj.str2.append("A");
                    System.out.println(obj.str1);
                    System.out.println(obj.str2);
                }
            }
        }.start();

        new Thread()
        {
            public void run()
            {
                synchronized(this)
                {
                    obj.str1.append("2");
                    obj.str2.append("B");
                    System.out.println(obj.str2);
                    System.out.println(obj.str1);
                }
            }
        }.start();
    }
}















class MyThread2 extends Thread
{
    MyThread2() {}
    MyThread2(Runnable r) {super(r); }
    public void run()
    {
        System.out.print("Inside Thread ");
    }
}
class RunnableDemo implements Runnable
{
    public void run()
    {
        System.out.print(" Inside Runnable");
    }
}
class ThreadDemo
{
    public static void main(String[] args)
    {
        new MyThread2().start();
        new MyThread2(new RunnableDemo()).start();
    }
}