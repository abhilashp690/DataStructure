package Trees.Miscellaneous.JavaMCQ;

public class Source
{
    public void Pass(String arg)
    {
        arg = "You've got it in you!!";
    }
    public static void main (String[] args)
    {
        Source test = new Source();
        String Push = null;
        if(Push!="null")
            System.out.print("Passed");
        else
            System.out.print("Failed");
        test.Pass(Push);
        System.out.print(Push);
    }
}
