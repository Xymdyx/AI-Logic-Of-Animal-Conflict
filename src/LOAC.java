/* author: stf8464
* desc: project 2 LOAC class
* instructor: TJ Borreli
* Due date: 3/24/22
* */
import java.util.*;

public class LOAC{
//fields
    private int popSize;
    private int hawk%;
    private int rscSize;
    private int hhCost;
    private ArrayList<>() individuals;
    private int encounters;

//CONSTRUCTOR
    public LOAC( int popSize, int hawk%, int rscSize, int hhCost )
    {
        this.popSize = popSize;
        this.hawk% = hawk%;
        this.rscSize = rscSize;
        this.hhCost = hhCost;
        this.individuals = new ArrayList<Individuals>();
        this.encounters = 0;
    }

//GET
    public int getPopSize(){ return this.popSize; }

    public int getHawk%(){ return this.hawk%; }

    public int getrscSize(){ return this.rscSize; }

    public int getHhCost(){ return this.hhSize; }

    public ArrayList<Individual> getIndividuals(){ return this.individuals; }

    public int getEncounters(){ return this.encounters; }

//SET
    public void setPopSize( int popSize ){ this.popSize = popSize; }

    public void setHawk%( int hawk% ){ this.hawk% = hawk%; }

    public void setRscSize( int rscSize ){ this.rscSize = rscSize; }

    public void hhCost( int hhCost ){ this.hhCost = hhCost; }

//METHODS

    //display stats
    public void displayStats()
    {
        System.out.println();
    }

    //display points
    public void displayPoints()
    {
        System.out.println();
    }

    //sorted display
    public void displaySorted()
    {
        System.out.println();
    }

    //run the simulation
    public void runSetTimes( int num )
    {
        while( num != 0 ){
            //interact
            num--;
            this.encounters++;
        }
        return;
    }

    public void runNtimes( Scanner inScan )
    {
        int num = inScan.nextInt();
        runSetTimes( num );
        return;
    }

    //run the simulation
    public void runStepThru( Scanner inScan )
    {
        String decision = "";
        while( !(decision.Equals("STOP")) ){
            //interact
            this.encounters++;
            decision = inScan.next();
        }
        return;
    }

    public void menuMessage()
    {
        System.out.println(
                "===============MENU=============\n" +
                        "1 ) Starting Stats\n" +
                        "2 ) Display Individuals and Points\n" +
                        "3 ) Display Sorted\n" +
                        "4 ) Have 1000 interactions\n" +
                        "5 ) Have 10000 interactions\n" +
                        "6 ) Have N interactions\n" +
                        "7 ) Step through interactions \"Stop\" to return to menu\n" +
                        "8 ) Quit\n" +
                        "================================\n"
        );
    }

    public int loop()
    {
        // do the thing, man
        Scanner inScan = new Scanner(System.in);
        int input = 0;
        do:
            menuMessage();
            input = inScan.nextInt();
            switch( input ){
                case 1:
                    displayStats();
                    break;
                case 2:
                    displayPoints();
                    break;
                case 3:
                    displaySorted();
                    break;
                case 4:
                    runSetTimes( 1000);
                    break;
                case 5:
                    runSetTimes(10000);
                    break;
                case 6:
                    runNtimes();
                    break;
                case 7:
                    runStepThru();
                    break;
                case 8:
                    System.out.println("Ending LOAC Simulation");
                    break;
                default:
                    System.out.println("Dude, what are you going on about? Try again...\n");
            } while( input != 8 )
        //cleanup
        inScan.close();
        return 0;
    }
}
