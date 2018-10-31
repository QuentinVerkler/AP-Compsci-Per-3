
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student
{
    private  String firstName;
    private  String middleName;
    private  String lastName;
    private  int stuNumber;
    private  double gpa;
    public Student(){
        firstName = " ";
        middleName = " ";
        lastName = " ";
        stuNumber = 0;
        gpa = 0.0;
    }
    public  String getFullName(){
        return lastName + ", " + firstName + " " + middleName;
    }
    public  double getGPA(){
        return gpa;
    }
    public  int getStuNumber(){
        return stuNumber;
    }
    public  void setFirstName(String name){
        firstName = name;
    }
    public  void setMiddleName(String name){
        middleName = name;
    }
    public  void setLastName(String name){
        lastName = name;
    }
    public  void setStuNum(int num){
        stuNumber = num;
    }
    public  void setGPA(double dec){
        gpa = dec;
    }
}
