import java.util.Scanner;
/**
 * Write a description of class StudentList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class StudentList
{
    ArrayList<Student> studentList;
    public StudentList(){
        studentList = new ArrayList<Student>();
    }
    
    public int addStudentToList(){
        System.out.println("Please type in student name.");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        String firstName;
        String middleName;
        String lastName;
        //if First Middle Last
        
        Student s1 = new Student();
        if(name.indexOf(",") == -1){
            int endFirstName = name.indexOf(" ");
            s1.setFirstName(name.substring(0, endFirstName));
            int endMiddleName = name.indexOf(" ", endFirstName);
            s1.setMiddleName(name.substring(endFirstName, endMiddleName));
            s1.setLastName(name.substring(endMiddleName));
        }else 
        //if Last, First Middle
        if(name.indexOf(" ", name.indexOf(", ")) == -1){
            int endLastName = name.indexOf(",");
            s1.setLastName(name.substring(0, endLastName));
            int endFirstName = name.indexOf(" ", name.indexOf(", "));
            s1.setFirstName(name.substring(endLastName, endFirstName));
            s1.setMiddleName(name.substring(endFirstName));
        }
        //if Last, First
        else{
            int endLastName = name.indexOf(",");
            s1.setLastName(name.substring(0, endLastName));
            s1.setFirstName(name.substring(endLastName));
        }
        //gets the student number
        System.out.println("Please type in student number");
        String num = input.nextLine();
        int number = Integer.parseInt(num);
        s1.setStuNum(number);
        //gets the student gpa
        System.out.println("Please type in gpa");
        String dub = input.nextLine();
        double gpa = Double.parseDouble(dub);
        studentList.add(s1);
        System.out.println("Your student has been added");
        return 0;
    }
    public void printStudent(){
        System.out.println("Please type in student name or student number");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        String checkResponse = " ";
        //checks if name exists
        for(int i = 0; i <= studentList.size(); i++){
            Student stuObject = studentList.get(i);
            //Parses input into just name
            int endFirstName = name.indexOf(" ");
            int endSecondName = name.indexOf(" ", endFirstName);
            String section = name.substring(0, endFirstName);
            String stringNum = Integer.toString(stuObject.getStuNumber());
            //if the student exists, it will print out all the information of the student
            if(stuObject.getFullName().indexOf(section) != -1 || stringNum.indexOf(section) != -1){
                //makes a string that will be used check if a name was found
                checkResponse = "Name: " + stuObject.getFullName();
                System.out.println(checkResponse);
                System.out.println("Student number: " + stuObject.getStuNumber());
                System.out.println("GPA: " + stuObject.getGPA());
            }
        }
        //if a name was not found, then print name was not found
        if(checkResponse.equals(" ") == true){
            System.out.println("Sorry, that student does not exist in our data base");
        }
    }

    public void deleteStudent(){
        System.out.println("Please put in the last name of the student you want to delete.");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        String checkResponse = " ";
        //goes through all Student objects to find the student
        for(int i = 0; i <= studentList.size(); i++){
            Student stuObject = studentList.get(i);
            if(stuObject.getFullName().indexOf(name) != -1){
                studentList.remove(i);
                checkResponse = "Student " + name + " has been removed.";
                System.out.println(checkResponse);
            }
        }
        //if the student does not exist, then it will tell user
        if(checkResponse.equals(" ") == true){
            System.out.println("Student " + name + " does not exist.");
        }
    }
    
    public void editStudent(){
        System.out.println("Please enter the last name of the student or the number you wish to edit.");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        String checkResponse = " ";
        for(int i = 0; i <= studentList.size(); i++){
            Student stuObject = studentList.get(i);
            String stringNum = Integer.toString(stuObject.getStuNumber());
            if(stuObject.getFullName().indexOf(name) != -1 || stringNum.indexOf(name) != -1){
                checkResponse = "Your student information is:";
                System.out.println(checkResponse);
                System.out.println(stuObject.getFullName());
                System.out.println(stuObject.getStuNumber());
                System.out.println(stuObject.getGPA());
                i = studentList.size();
            }
        }
        if(!checkResponse.equals(" ")){
            System.out.println("What would you like to change?");
            System.out.println("1 = First Name");
            System.out.println("1 = First Name");
        }
    }
}
