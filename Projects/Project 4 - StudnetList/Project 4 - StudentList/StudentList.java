
/**
 * Write a description of class StudentList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class StudentList
{
    private static String firstName;
    private static String middleName;
    private static String lastName;
    private static int stuNumber;
    private static double gpa;
    private static  ArrayList<StudentList> studentList = new ArrayList<StudentList>();
    public static void studentListConstructor(String name1, String name2, String name3, int num, double grade){
        firstName = name1;
        middleName = name2;
        lastName = name3;
        stuNumber = num;
        gpa = grade;
    }
    public static void addStudentToList(String name, int number, double grade){
        //if First Middle Last
        if(name.indexOf(",") == -1){
            int endFirstName = name.indexOf(" "); 
            firstName = name.substring(0, endFirstName);
            int endMiddleName = name.indexOf(" ", endFirstName);
            middleName = name.substring(endFirstName + 1, endMiddleName);
            lastName = name.substring(endMiddleName + 1);
        }else 
        //if Last, First Middle
        if(name.indexOf(" ", name.indexOf(", ")) == -1){
            int endLastName = name.indexOf(",");
            lastName = name.substring(0, endLastName);
            int endFirstName = name.indexOf(" ", name.indexOf(", "));
            firstName = name.substring(endLastName + 2, endFirstName);
            middleName = name.substring(endFirstName + 1);
        }
        //if Last, First
        else{
            int endLastName = name.indexOf(",");
            lastName = name.substring(0, endLastName);
            firstName = name.substring(endLastName + 2);
        }
        stuNumber = number;
        gpa = grade;
        studentList.add(studentListConstructor(lastName, firstName, middleName, stuNumber, gpa));
    }
    public static void printStudentList(String statement){
        //checks if name exists
        if(statement.indexOf(firstName) != -1
            || statement.indexOf(middleName) != -1
            || statement.indexOf(lastName) != -1){
            System.out.println(lastName + " , " + firstName + " " + middleName);
            System.out.println(gpa);
            System.out.println(stuNumber);
        }else{
            System.out.println("Student does not exist");
        }
    }
    public static void printStudentList(int stuNum){
        if(stuNum == 0){
        System.out.println(lastName + " , " + firstName + " " + middleName);
        System.out.println(gpa);
        System.out.println(stuNumber);
    }else{
        System.out.println("Student does not exist");
    }
    }
    public static String getFullName(){
        return lastName + " , " + firstName + " " + middleName;
    }
    public static double getGPA(){
        return gpa;
    }
    public static int getStuNumber(){
        return stuNumber;
    }
    public static void setFirstName(String name){
        firstName = name;
    }
    public static void setMiddleName(String name){
        middleName = name;
    }
    public static void setLastName(String name){
        lastName = name;
    }
    public static void setStuNum(int num){
        stuNumber = num;
    }
    public static void setGPA(double dec){
        gpa = dec;
    }
}
