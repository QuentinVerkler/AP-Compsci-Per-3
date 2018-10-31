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
    
    public void addStudentToList(){
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
            s1.setMiddleName(name.substring(endFirstName + 1, endMiddleName));
            s1.setLastName(name.substring(endMiddleName + 1));
        }else 
        //if Last, First Middle
        if(name.indexOf(" ", name.indexOf(", ")) == -1){
            int endLastName = name.indexOf(",");
            s1.setLastName(name.substring(0, endLastName));
            int endFirstName = name.indexOf(" ", name.indexOf(", "));
            s1.setFirstName(name.substring(endLastName + 2, endFirstName));
            s1.setMiddleName(name.substring(endFirstName + 1));
        }
        //if Last, First
        else{
            int endLastName = name.indexOf(",");
            s1.setLastName(name.substring(0, endLastName));
            s1.setFirstName(name.substring(endLastName + 2));
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
    }
    public void printStudentList(){
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

    
}
