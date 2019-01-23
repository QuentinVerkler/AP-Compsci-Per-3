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
        || statement.equals("4") || statement.equals("5") || statement.equals("6")
        || statement.equals("7")) || statement.equals("8")){
           System.out.println("Please press a valid key");
       }
    return statement;
    }
    public static void main(){
        StudentList studList = new StudentList();
        String input = " ";
        System.out.print("\u000c");
        while(!input.equals("Bye")){
        System.out.println("Press 1 to add student");
        System.out.println("Press 2 to delete student");
        System.out.println("Press 3 to edit a student");
        System.out.println("Press 4 to clear the list of students");
        System.out.println("Press 5 to print all students");
        System.out.println("Press 6 to print out a certain student");
        System.out.println("Press 7 to search for students using a specific parameter");
        System.out.println("Press 8 to sort the list");
        System.out.println("Type in 'Bye' to exit");
        //Setting up StudentLIst, giving it user input
        
        Scanner in = new Scanner (System.in);
        input = in.nextLine();
        
            StudListRunner.menuNumber(input);
            
            if(input.equals("1")){
                
                        studList.addStudentToList();

            }else if(input.equals("2")){
                studList.deleteStudent();
            }else if(input.equals("3")){
                studList.editStudent();
            }else if(input.equals("4")){
                studList.clearList();
            }else if(input.equals("5")){
                studList.printAllStudents();
            }else if(input.equals("6")){
                studList.printStudent();
            }else if(input.equals("7")){
                studList.filterSearchStudentList();
            }else if(input.equals("8")){
                studList.sortList();
            }
            
        }
    }
    
}
