package day2_arrays;

import java.util.ArrayList;

public class T3_loop {
    public static void main(String[] args) {
        //declare an arraylist variable
        ArrayList<String> countries = new ArrayList<>();
        //add some values to the countries array list
        countries.add("USA");
        countries.add("INDIA");
        countries.add("PAKISTAN");
        countries.add("BANGLADESH");
        countries.add("MEXICO");
        //print out all the countries from the arraylist
        for (int i=0; i <countries.size(); i++) {
            //print out the value of i to see which iteration we are on
            System.out.println("index number or iteration number is " + i);
            //print out all the countries
            System.out.println("My country is " + countries.get(i));

        }//end of loop
    }// end of main
}//end of class
