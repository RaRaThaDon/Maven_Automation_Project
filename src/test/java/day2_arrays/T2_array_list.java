package day2_arrays;

import java.util.ArrayList;

public class T2_array_list {
    public static void main(String[] args) {
        //declare an array list variable
        ArrayList<String> countries = new ArrayList<>();
        //add some values to the countries array list
        countries.add("USA");
        countries.add("INDIA");
        countries.add("Pakistan");
        countries.add("Bangladesh");
        //print out USA
        System.out.println("The first country is  " + countries.get(0));
        //print out total size of array list
        System.out.println("The total size of the countries arraylist is " + countries.size());
        //delcare an integer arraylist
        ArrayList<Integer> studentGrades = new ArrayList<>();
        //add values to studentGrades
        studentGrades.add(90);
        studentGrades.add(80);
        studentGrades.add(20);
        //print out the last students grade
        System.out.println("The third student grade is " + studentGrades.get(2));
    }
}//end of class
