/* author: stf8464
* desc: project 2 LOAC class
* instructor: TJ Borreli
* Due date: 3/24/22
* */
import java.util.*; //for arraylist and scanner

public class LOAC{
//fields
    private int popSize;
    private int hawkPercent;
    private int rscSize;
    private int hhCost;
    private ArrayList<Individual> indvs;
    private ArrayList<Individual> aliveIndvs;
    private int encounters;
    private Random rng;

    //initialize the initial population correctly
    private void initIndivs()
    {
        int hawkNum = ((this.hawkPercent * this.popSize / 100));
        this.indvs = new ArrayList<Individual>();
        this.aliveIndvs = new ArrayList<Individual>();

        for( int num = 0; num < popSize; num++ ){
            // make hawks first and then the rest is doves
            if( num < hawkNum ) {
                Hawk h = new Hawk();
                indvs.add(h);
                aliveIndvs.add(h);
            }
            else {
                Dove d = new Dove();
                indvs.add(d);
                aliveIndvs.add(d);
            }
        }
    }

//CONSTRUCTOR
    public LOAC( int popSize, int hawkPercent, int rscSize, int hhCost )
    {
        this.popSize = popSize;
        this.hawkPercent = hawkPercent;
        this.rscSize = rscSize;
        this.hhCost = hhCost;
        this.encounters = 0;
        this.rng = new Random( 1); //change to be truly random for final release
        initIndivs();
    }

//GET
    public int getPopSize(){ return this.popSize; }

    public int getHawkPercent(){ return this.hawkPercent; }

    public int getrscSize(){ return this.rscSize; }

    public int getHhCost(){ return this.hhCost; }

    public ArrayList<Individual> getindvs(){ return this.indvs; }

    public int getEncounters(){ return this.encounters; }

//SET
    public void setPopSize( int popSize ){ this.popSize = popSize; }

    public void setHawkPercent( int hawkPercent ){ this.hawkPercent = hawkPercent; }

    public void setRscSize( int rscSize ){ this.rscSize = rscSize; }

    public void hhCost( int hhCost ){ this.hhCost = hhCost; }

//METHODS

    // ensure there is more than one living individual alive
    private void checkPopCount()
    {
        if( aliveIndvs.size() <= 1) {
            System.out.println("Exiting early due to too few living individuals");
            System.exit(0);
        }
    }

    // get individual type for printing
    private String getIndvStr(Individual indv)
    {
        String indvStr = "Dove";
        if( indv instanceof Hawk)
            indvStr = "Hawk";
        if( indv.getStatus() == Individual.IndvStatus.DEAD)
            indvStr = "DEAD";

        return indvStr;
    }

    //display program initial stats
    public void displayStats()
    {
        int hawkNum = ((this.hawkPercent * this.popSize / 100));

        System.out.println("Population size: " + this.popSize);
        System.out.println("Percentage of Hawks: " + this.hawkPercent
        +"\n\tNumber of Hawks: " + hawkNum );

        System.out.println("\nPercentage of Doves: " + ( 100 - this.hawkPercent)
                +"\n\tNumber of Doves: " + (popSize - hawkNum));

        System.out.println("\nEach resource is worth: " + this.rscSize);
        System.out.println("Cost of Hawk-Hawk interaction: " + this.hhCost);
    }

    //display points in order of individuals and display how many alive total
    public void displayPoints()
    {
        Individual indv;
        String indvStr;

        for( int num = 0; num < indvs.size(); num++){
            indv = indvs.get(num);
            indvStr = getIndvStr(indv);
            System.out.println("Individual[" + num + "]=" + indvStr +":" + indv.getResources());
        }
        System.out.println("Living:" + aliveIndvs.size());
    }

    //sorted display by points in descending order
    public void displaySorted()
    {
        //sort in descending order
        Comparator<Individual> pointsSort =
                Comparator.comparing(Individual::getResources).reversed();

        indvs.sort(pointsSort);
        String indvStr;

        //print in sorted order
        for( Individual indv : indvs)
        {
            indvStr = getIndvStr(indv);
            System.out.println(indvStr + ":" + indv.resources);
        }
        System.out.println();
    }


    // display message if hawk has died
    private void checkIfDead( Individual indv, String numStr )
    {
        if (indv.getStatus() == Individual.IndvStatus.DEAD) {
            if( indv instanceof Dove){
                System.out.println("Why did a Dove die? I quit!\n");
                System.exit(-1);
            }
            System.out.println("Hawk " + numStr + " has died!");
            aliveIndvs.remove(indv);
        }
    }

    //run an interaction
    public void interact()
    {
        int ranIdx1;
        int ranIdx2;
        int[] indvGains;
        Individual indv1;
        Individual indv2;
        String indvStr1 = "Dove";
        String indvStr2 = "Dove";
        String indvSign1 = "+";
        String indvSign2 = "+";

        //randomly choose
        ranIdx1 = rng.nextInt(aliveIndvs.size());
        ranIdx2 =  rng.nextInt(aliveIndvs.size());

        while(ranIdx1 == ranIdx2)
            ranIdx2 =  rng.nextInt(aliveIndvs.size());

        indv1 = aliveIndvs.get(ranIdx1);
        indv2 = aliveIndvs.get(ranIdx2);

        if( indv1 instanceof Hawk )
            indvStr1 = "Hawk";
        if( indv2 instanceof Hawk )
            indvStr2 = "Hawk";

        //interaction
        indvGains = indv1.interact(indv2, this.rscSize, this.hhCost);
        this.encounters++;

        //update print sign before printing
        if( indvGains[0] < 0 )
            indvSign1 = "";
        if( indvGains[1] < 0 )
            indvSign2 = "";

        System.out.println( "Encounter: " + encounters );
        System.out.println("Individual " + ranIdx1 + ": " + indvStr1);
        System.out.println("Individual " + ranIdx2 + ": " + indvStr2);
        System.out.print(indvStr1 + "/" + indvStr2 + ": " );
        System.out.print(indvStr1 + ": " + indvSign1 + indvGains[0] + "\t");
        System.out.print(indvStr2 + ": " + indvSign2 + indvGains[1]);

        //hawk death messages if applicable
        System.out.println();
        checkIfDead( indv1, "one" );
        checkIfDead( indv2, "two" );

        System.out.print("Individual " + ranIdx1 + "=" + indv1.resources + "\t");
        System.out.print("individual " + ranIdx2 + "=" + indv2.resources + "\n\n");
    }

    //run the simulation
    public void runSetTimes( int num )
    {
        while( num != 0 ){
            checkPopCount();
            interact();
            num--;
        }
    }

    // run simulation by an integer N the user enter
    public void runNtimes( Scanner inScan )
    {
        System.out.print("Enter how many interactions to run:");
        int num = inScan.nextInt();
        runSetTimes( num );
    }

    //run the simulation until the user enters "stop"
    public void runStepThru( Scanner inScan )
    {
        inScan.nextLine(); //clear buffer
        String decision = "";
        System.out.print("Enter \"stop\" to return to the menu: ");
        decision = inScan.nextLine();
        while( !(decision.equalsIgnoreCase("stop")) ){
            interact();
            System.out.print("Enter \"stop\" to return to the menu: ");
            decision = inScan.nextLine();
        }
    }

    //main menu message
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

    //main input loop for the user
    public void loop()
    {
        Scanner inScan = new Scanner(System.in);
        int input;

        //want them to see this at least once
        do{
            menuMessage();
            input = inScan.nextInt();
            switch( input ) {
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
                    runSetTimes(1000);
                    break;
                case 5:
                    runSetTimes(10000);
                    break;
                case 6:
                    runNtimes(inScan);
                    break;
                case 7:
                    runStepThru(inScan);
                    break;
                case 8:
                    System.out.println("Ending LOAC Simulation\n");
                    break;
                default:
                    System.out.println("Dude, what are you going on about? Try again...\n");
            }
        } while( input != 8 && aliveIndvs.size() > 1);

        //cleanup
        inScan.close();
        checkPopCount();
    }
}
