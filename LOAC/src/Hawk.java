/* author: stf8464
* desc: project 2 Dove
* instructor: TJ Borreli
* Due date: 3/24/22
* */

public class Hawk extends Individual{

    public Hawk()
    {
        this.status = IndvStatus.ALIVE;
        this.resources = 0;
    }

    @Override
    public int[] interact( Individual indv, int rsc, int hhCost )
    {
       // hawk and dove
        int[] gains = new int[2];
        gains[0] = rsc;

        //hawk on hawk
        if( indv instanceof Hawk ){
            gains[0] = rsc - hhCost;
            gains[1] = -hhCost;
        }

        // update
        this.addResources(gains[0]);
        if( gains[1] != 0)
            indv.addResources(gains[1]);

        return gains;
    }
}
