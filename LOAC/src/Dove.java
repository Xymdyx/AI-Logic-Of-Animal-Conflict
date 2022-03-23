/* author: stf8464
* desc: project 2 Dove
* instructor: TJ Borreli
* Due date: 3/24/22
* */

public class Dove extends Individual{
    public Dove()
    {
        this.status = IndvStatus.ALIVE;
        this.resources = 0;
    }


    @Override
    public int[] interact( Individual indv, int rsc, int hhCost )
    {
        // dove and hawk
        int[] gains = new int[2];
        gains[1] = rsc;

        //dove on dove
        if( indv instanceof Dove){
            gains[0] = rsc/2;
            gains[1] =  rsc/2;
        }

        //update
        if( gains[0] != 0)
            this.addResources(gains[0]);
        indv.addResources(gains[1]);

        return gains;
    }

}
