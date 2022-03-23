/* author: stf8464
* desc: project 2 main class
* instructor: TJ Borreli
* Due date: 3/24/22
* */

public class Main{
    public static final int HAWKPERCENT_DEF = 20;
    public static final int RSCSIZE_DEF = 50;
    public static final int HHCOST_DEF = 100;

    public static void main(String[] args)
    {
        if ( args.length == 0 || args.length > 4 )
        {
            System.err.println("./project02 popSize [percentHawks] [resourceAmt] [costHawk-Hawk]");
            System.exit(0);
        }
        // do the thing, man
        int popSize = Integer.parseInt( args[0] );
        int hawkPercent = HAWKPERCENT_DEF;
        int rscSize = RSCSIZE_DEF;
        int hhCost = HHCOST_DEF;

        //check for optional params
        if (args.length >= 2)
            hawkPercent = Integer.parseInt( args[1] );
        if (args.length >= 3)
            rscSize = Integer.parseInt( args[2] );
        if (args.length == 4)
            hhCost = Integer.parseInt( args[3] );
        
        LOAC simulation = new LOAC( popSize, hawkPercent, rscSize, hhCost );
        simulation.loop();

    /* default values w 100: a few hawks die before equilibrium is achieved... All Doves of course live...
    * 100 pop, 50 hawk... more hawks die before equilibrium is achieved. Hawks still have mnost points by a slim margin (300 pts)
    * 100 pop, 80 hawk... more hawks die ( 74) before equilibrium achieved. Hawks ahead by a significant margin (8k pts)
    * 100 pop, all hawks
    * */
    }
}
