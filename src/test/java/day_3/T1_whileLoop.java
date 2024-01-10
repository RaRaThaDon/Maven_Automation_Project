package day_3;

import java.util.ArrayList;

public class T1_whileLoop {
    public static void main(String[] args) {
        //declare an arraylist of boroughs
        ArrayList<String> boroughs = new ArrayList<>();
        boroughs.add("Brooklyn");
        boroughs.add("Manhattan");
        boroughs.add("Queens");
        boroughs.add("Bronx");
        boroughs.add("Staten Island");
        //set the initial counter for the while loop
        int i=0;
        while ((i < boroughs.size())) {
            i = i + 1;


            //iteration
            //first 0< 5
            //second 1 < 5
            //third 2 < 5
            //fourth 3 <5
            //fifth < 4 < 5
            //sixth it becomes false because 5 < 5 is not correct
            //print out the value of i to see which iteration we are on
            System.out.println("index number or iteration number is " + i);
            //print out all the countries
            System.out.println("My borough is " + boroughs.get(i));
            //i++; is the same as i = i+ 1;
            //counter
            //increment operator
            //i = i + 1;
        }//end of while loop

    }//end of main
}//end of class
