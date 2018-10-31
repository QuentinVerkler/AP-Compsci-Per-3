import java.util.Scanner;
    /**
     * Write a description of class StudListRunner here.
     *
     * @author (your name)
     * @version (a version number or a date)
     */
    import java.util.ArrayList;
    public class StudListRunner
    {
        public static String menuNumber(String input){
        String statement = input;
        if(!(statement.equals("1") || statement.equals("2") || statement.equals("3") 
        || statement.equals("4") || statement.equals("5") || statement.equals("6"))){
           System.out.println("Please press a valid key");
       }
    return statement;
    }
    public static void main(){
        System.out.println("Press 1 to add student");
        System.out.println("Press 2 to delete student");
        System.out.println("Press 3 to edit a student");
        System.out.println("Press 4 to clear the list of students");
        System.out.println("Press 5 to print all students");
        System.out.println("Press 6 to print out a certain student");
        System.out.println("Type in 'Bye' to exit");
        //Setting up StudentLIst, giving it user input
        StudentList studList = new StudentList();
        Scanner in = new Scanner (System.in);
    String input = in.nextLine();
        while(!input.equals("Bye")){
            StudListRunner.menuNumber(input);
            //input = in.nextLine();
            if(input.equals("1")){
                //int exit = 0;
                    //while(exit == 0){
                        studList.addStudentToList();
                        System.out.print("\u000c");
                        //exit = 1;
                //}
            }else if(input.equals("2")){
                studList.printStudent();
            }
            
        }
    }
    
}
