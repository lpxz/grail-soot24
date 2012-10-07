
public class Toy$InnerThread extends Thread
{

    public void run()
    {


        Toy$InnerThread.incBalance2();
        Toy$InnerThread.incBalance3();
        Toy$InnerThread.incBalance4();
        Toy$InnerThread.incBalance21();
        Toy$InnerThread.incBalance31();
        Toy$InnerThread.incBalance41();
    }

    private static synchronized void incBalance2()
    {

        byte b0;
        b0 = (byte) (byte) 2;
        Toy.balance = new Object();
        Toy.balance.hashCode();
    }

    private static synchronized void incBalance3()
    {

        byte b0;
        b0 = (byte) (byte) 2;
        Toy.balance = new Object();
        Toy.balance.hashCode();
    }

    private static synchronized void incBalance4()
    {

        byte b0;
        b0 = (byte) (byte) 2;
        Toy.balance = new Object();
        Toy.balance.hashCode();
    }

    private static synchronized void incBalance21()
    {

        byte b0;
        b0 = (byte) (byte) 2;
        Toy.balance = new Object();
        Toy.balance.hashCode();
    }

    private static synchronized void incBalance31()
    {

        byte b0;
        b0 = (byte) (byte) 2;
        Toy.balance = new Object();
        Toy.balance.hashCode();
    }

    private static synchronized void incBalance41()
    {

        byte b0;
        b0 = (byte) (byte) 2;
        Toy.balance = new Object();
        Toy.balance.hashCode();
    }
}
