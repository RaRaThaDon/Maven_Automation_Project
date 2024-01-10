package Day_4;

import java.util.HashMap;

public class T1_HashMap {
    public static void main(String[] args) {
        //create a hashmap consisting of name and age for Traige Students
        HashMap<String, Integer> triageStudents = new HashMap<>();
        //add some values for the triageStudents hashmap
        triageStudents.put("Noor",25);
        triageStudents.put("Asif",26);
        triageStudents.put("Justin",28);
        //print ouyt the size of the triageStduetns hashmap
        System.out.println("the size of the Hashmap is " + triageStudents.size());
        //print out the content of the hashmap
        System.out.println(triageStudents);
        //print out Asifs age only if Asif exists in the data set
        if (triageStudents.containsKey("Asif")) {
            int asifAge = triageStudents.get("Asif");
            System.out.println("Asifs age is " + asifAge);
        }//end of if condition

        //does not print Afsanas age because we never added her to the data set
        System.out.println("Afsana age is " + triageStudents.get("Afsana"));
    }//end of main
}//end of class
