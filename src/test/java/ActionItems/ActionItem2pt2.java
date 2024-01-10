package ActionItems;

public class ActionItem2pt2 {
    public static void main(String[] args) {
        //declare some int values
        int grade = 70;

        //start of the conditional statement
        if (grade >= 90) {
            System.out.println("A");
        } else if (grade < 90 && grade >= 80 ) {
            System.out.println("B");
        } else if (grade < 80 && grade >= 70 ){
            System.out.println("C");
        } else if (grade < 70 && grade >= 60 ){
            System.out.println("D");
        } else if (grade < 60 ){
            System.out.println("F");

        }//end of condition
    }//end of main
}//end of class
