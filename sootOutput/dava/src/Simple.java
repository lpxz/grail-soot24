import java.io.PrintStream;

public class Simple
{
    static String sharedNop;
    static int sharedV;
    static int sharedM;

    static
    {


        sharedNop = "";
        sharedV = 0;
        sharedM = 0;
    }

    public static void main(String[]  r0)
    {

        Class r1;
        Simple$1 r2;
        Simple$2 r3;
        Simple$3 r4;
        r1 = class "Simple";
        System.out.println(r1);
        r2 = new Simple$1();
        r3 = new Simple$2();
        r4 = new Simple$3();
        r2.start();
        r3.start();
        r4.start();
    }
}
