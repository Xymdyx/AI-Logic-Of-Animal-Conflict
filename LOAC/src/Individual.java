/* author: stf8464
* desc: project 2 individual abstract class
* instructor: TJ Borreli
* Due date: 3/24/22
* */

public abstract class Individual{

    public enum IndvStatus{
        DEAD,
        ALIVE
    }

    public IndvStatus status;
    public int resources;

    private void checkDead()
    {
        if( this.resources < 0 )
            this.status = IndvStatus.DEAD;
    }

    public IndvStatus getStatus(){ return this.status; }

    public int getResources(){ return this.resources; }

    public void setStatus( IndvStatus status ){ this.status = status; }

    public void setResource( int resources)
    {
        this.resources = resources;
        checkDead();
    }

    public void addResources( int add )
    {
        this.resources += add;
        checkDead();
    }

    // we call this method if it's the first one chosen
    public abstract int[] interact( Individual indv, int rsc, int hhCost );

}
