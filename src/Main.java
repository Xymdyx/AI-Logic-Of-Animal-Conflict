/* author: stf8464
* desc: project 2 main class
* instructor: TJ Borreli
* Due date: 3/24/22
* */

public class Main{
    public static int main(String[] args)
    {
        if ( args.length == 0 || args.length > 4 )
        {
            System.out.println("./project02 popSize [percentHawks] [resourceAmt] [costHawk-Hawk]");
            System.exit(0);
        }
        // do the thing, man
        int popSize = Integer.parseString( args[0] );
        int hawk% = 20;
        int rscSize = 50;
        int hhCost = 100;

        //check for optional params
        if (args.length >= 2)
            hawk% = Integer.parseString( args[1] );
        if (args.length >= 3)
            rscSize = Integer.parseString( args[2] );
        if (args.length == 4)
            hhCost = Integer.parseString( args[3] );

        LOAC simulation = new LOAC( popSize, hawk%, rscSize, hhCost );
        simulation.loop();
        return 0;
    }
}
