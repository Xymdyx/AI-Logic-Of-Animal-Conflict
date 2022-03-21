/* author: stf8464
* desc: project 2 main class
* instructor: TJ Borreli
* Due date: 3/24/22
* */

public class Main{
    public static void main(String[] args)
    {
        if ( args.length == 0 || args.length > 4 )
        {
            System.out.println("./project02 popSize [percentHawks] [resourceAmt] [costHawk-Hawk]");
            System.exit(0);
        }
        // do the thing, man
        int popSize = Integer.parseInt( args[0] );
        int hawkPercent = 20;
        int rscSize = 50;
        int hhCost = 100;

        //check for optional params
        if (args.length >= 2)
            hawkPercent = Integer.parseInt( args[1] );
        if (args.length >= 3)
            rscSize = Integer.parseInt( args[2] );
        if (args.length == 4)
            hhCost = Integer.parseInt( args[3] );
        
        LOAC simulation = new LOAC( popSize, hawkPercent, rscSize, hhCost );
        simulation.loop();
    }
}
