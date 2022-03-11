/* author: stf8464
* desc: project 2 mail
* instructor: TJ Borreli
* Due date: 3/24/22
* */

public class Main{

    public void startMessage()
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
        "================================"
        );
    }
    public static int main(String[] args)
    {
        if ( args.length == 0 || args.length > 4 )
        {
            System.out.println("./project02 popSize [percentHawks] [resourceAmt] [costHawk-Hawk]");
            System.exit(0);
        }
        // do the thing, man
        return 0;
    }
}
