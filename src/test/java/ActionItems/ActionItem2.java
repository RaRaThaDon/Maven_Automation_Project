package ActionItems;

import javax.print.DocFlavor;
import java.util.ArrayList;

public class ActionItem2 {
    public static void main(String[] args) {
        ArrayList<String> regions = new ArrayList<>();
        regions.add("windsor terrace");
        regions.add("kensignton");
        regions.add("tribeca");
        regions.add("east village");
        // these are the countries

        ArrayList<Integer> areaCodes = new ArrayList<>();
        //add values to areaCodes
        areaCodes.add(11218);
        areaCodes.add(11342);
        areaCodes.add(11242);
        areaCodes.add(11234);




        for (int i=0; i <regions.size(); i++) {
            //print out the value of i to see which iteration we are on
            System.out.println("my region is " + regions.get(i) + " " + "and my area code is" + " " + areaCodes.get(i));
            //print out all the countries



        }//end of loop

    }//end of main
}//end of class
