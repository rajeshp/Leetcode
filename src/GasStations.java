/**
 * Created by prajesh on 5/30/16.
 */
public class GasStations {

    public static void main(String[] args) {

        GasStations obj = new GasStations();

        System.out.println(obj.canCompleteCircuit(new int[]{5,3,0,1,2}, new int[]{3,2,4,1,1}));
        System.out.println(obj.canCompleteCircuit(new int[]{5}, new int[]{3}));
        System.out.println(obj.canCompleteCircuit(new int[]{4}, new int[]{5}));

    }


   /* public int canCompleteCircuit(int[] gas, int[] cost) {


        for(int i=0;i<gas.length;i++){


            int startingPoint=i;


            int j=startingPoint,remainingGas=0;

            while(j<gas.length){
                remainingGas += gas[j]-cost[j];

                if(remainingGas<0)
                    break;

                j++;
            }


            if(j==gas.length){

                j=0;

                while(j<startingPoint){
                    remainingGas += gas[j]-cost[j];

                    if(remainingGas<0)
                        break;

                    j++;
                }


                return i;
            }

        }


        return -1;
    }*/



    public int canCompleteCircuit(int[] gas, int[] cost) {

       if(gas.length != cost.length)
           return -1;


       int[] temp = new int[gas.length];

       boolean[] gasShortage = new boolean[temp.length];

       int sum=0,k=0, tempSum=0;

        for(int i=0;i<temp.length;i++){
            sum += gas[i]-cost[i];

            tempSum += gas[i] - cost[i];


            if(tempSum <0){
                tempSum=0;
               k = i+1;
            }

        }

        if(sum < 0)
            return -1;
        else
            return k;



    }

}
