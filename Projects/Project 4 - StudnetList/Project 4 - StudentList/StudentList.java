
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
    ArrayList<Student> studentList = new ArrayList<Student>();
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
            firstName = name.substring(0, endFirstName);
            s1.setFirstName(firstName);
            int endMiddleName = name.indexOf(" ", endFirstName + 1);
            s1.setMiddleName(name.substring(endFirstName, endMiddleName + 1));
            s1.setLastName(name.substring(endMiddleName + 1));
        }else 
        //if Last, First Middle
        if(name.indexOf(" ", name.indexOf(", ")) == -1){
            int endLastName = name.indexOf(",");
            s1.setLastName(name.substring(0, endLastName));
            int endFirstName = name.indexOf(" ", name.indexOf(", "));
            s1.setFirstName(name.substring(endLastName, endFirstName + 1));
            s1.setMiddleName(name.substring(endFirstName));
        }
        //if Last, First
        else{
            int endLastName = name.indexOf(",");
            s1.setLastName(name.substring(0, endLastName));
            s1.setFirstName(name.substring(endLastName + 1));
        }
        //gets the student number
        System.out.println("Please type in student number");
        String num = input.nextLine();
        int number = Integer.parseInt(num);
        s1.setStuNum(number);
        //gets the student gpa
        System.out.println("Please type in gpa in decimals");
        String dub = input.nextLine();
        double gpa = Double.parseDouble(dub);
        s1.setGPA(gpa);
        studentList.add(s1);
        System.out.println("Your student has been added. Press anything to continue");
        String exit = input.nextLine();
        System.out.print("\u000c");

    }
    public void printStudent(){
        System.out.println("Please type in the last name of the student or student number");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        String checkResponse = " ";
        //checks if name exists
        for(int i = 0; i < studentList.size(); i++){
            Student stuObject = studentList.get(i);
            //Parses input into just name
            //int endFirstName = name.indexOf(" ");
            //int endSecondName = name.indexOf(" ", endFirstName);
            //String section = name.substring(0, endFirstName);
            String stringNum = Integer.toString(stuObject.getStuNumber());
            //if the student exists, it will print out all the information of the student
            if(stuObject.getFullName().indexOf(name) != -1 || stringNum.indexOf(name) != -1){
                //makes a string that will be used check if a name was found
                checkResponse = "Name: " + stuObject.getFullName();
                System.out.println(checkResponse);
                System.out.println("Student number: " + stuObject.getStuNumber());
                System.out.println("GPA: " + stuObject.getGPA());
                System.out.println("Press anything to continue");
                String exit = input.nextLine();
                System.out.print("\u000c");
            }
        }
        //if a name was not found, then print name was not found
        if(checkResponse.equals(" ") == true){
            System.out.println("Sorry, that student does not exist in our data base. Press anything to contiune");
            String exit = input.nextLine();
            System.out.print("\u000c");
        }
    }

    public void deleteStudent(){
        System.out.println("Please put in the last name of the student you want to delete.");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        String checkResponse = " ";
        //goes through all Student objects to find the student
        for(int i = 0; i < studentList.size(); i++){
            Student stuObject = studentList.get(i);
            if(stuObject.getFullName().indexOf(name) != -1){
                studentList.remove(i);
                checkResponse = "Student " + name + " has been removed. Press anything to continue";
                System.out.println(checkResponse);
                String exit = input.nextLine();
                System.out.print("\u000c");
            }
        }
        //if the student does not exist, then it will tell user
        if(checkResponse.equals(" ") == true){
            System.out.println("Student " + name + " does not exist. Press anything to continue");
            String exit = input.nextLine();
            System.out.print("\u000c");
        }
    }
    
    public void editStudent(){
        System.out.println("Please enter the last name of the student or the number you wish to edit.");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        String checkResponse = " ";
        for(int i = 0; i < studentList.size(); i++){
            Student stuObject = studentList.get(i);
            String stringNum = Integer.toString(stuObject.getStuNumber());
            if(stuObject.getFullName().indexOf(name) != -1 || stringNum.indexOf(name) != -1){
                checkResponse = "Your student information is:";
                System.out.println(checkResponse);
                System.out.println(stuObject.getFullName());
                System.out.println(stuObject.getStuNumber());
                System.out.println(stuObject.getGPA());
                //i = studentList.size();
                //Gives them a window to see what they want to change
                if(!checkResponse.equals(" ")){
                    System.out.println("What would you like to change?");
                    System.out.println("1 = First Name");
                    System.out.println("2 = Middle Name");
                    System.out.println("3 = Last Name");
                    System.out.println("4 = Student Number");
                    System.out.println("5 = GPA");
                    String num = input.nextLine();
                    //will change first name
                    if(num.equals("1")){
                        System.out.println("What is the new first name?");
                        num = input.nextLine();
                        stuObject.setFirstName(num);
                        System.out.println("The first name has been changed");
                    }
                    //will change middle name
                    if(num.equals("2")){
                        System.out.println("What is the new middle name?");
                        num = input.nextLine();
                        stuObject.setMiddleName(num);
                        System.out.println("The middle name has been changed");
                    }
                    //will change last name
                    if(num.equals("3")){
                        System.out.println("What is the new last name?");
                        num = input.nextLine();
                        stuObject.setLastName(num);
                        System.out.println("The last name has been changed");
                    }
                    //will change ID number
                    if(num.equals("4")){
                        System.out.println("What is the new student number?");
                        num = input.nextLine();
                        int stuID = Integer.parseInt(num);
                        stuObject.setStuNum(stuID);
                        System.out.println("The student number has been changed");
                    }
                    //will change GPA
                    if(num.equals("5")){
                        System.out.println("What is the new GPA? Please input a decimal number");
                        num = input.nextLine();
                        double stuID = Double.parseDouble(num);
                        stuObject.setGPA(stuID);
                        System.out.println("The GPA has been changed");
                    }
                    System.out.println("Your changes have been made. Press anything to continue");
                    String exit = input.nextLine();
                    System.out.print("\u000c");
                }

            }
        }
        //if nothing is found, then it wil tell the user
        if(checkResponse.equals(" ")){
            System.out.println("This student does not exist. Press anything to continue");
            String exit = input.nextLine();
            System.out.print("\u000c");
        }
        
    }
    
    public void clearList(){
        System.out.println("Are you sure? Yes/No");
        Scanner input = new Scanner(System.in);
        String yesNo = input.nextLine();
        if(yesNo.equals("Yes")){
            studentList.clear();
            System.out.println("The list has been cleared. Press anything to continue");
            String exit = input.nextLine();
            System.out.print("\u000c");
        }
        
    }
    
    public void printAllStudents(){
        Scanner input = new Scanner(System.in);
        //for lood that gets all students
        for(int i = 0; i < studentList.size(); i++){
            Student stuObject = studentList.get(i);
            System.out.println(stuObject.getFullName());
            System.out.println(stuObject.getStuNumber());
            System.out.println(stuObject.getGPA());
            System.out.println(" ");
        }
        System.out.println("Press anything to continue");
        String exit = input.nextLine();
        System.out.print("\u000c");
    }
    
    public void filterSearchStudentList(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please input the lowest GPA or student number you wish to search for");
        String num = input.nextLine();
        String checkResponse = " ";
        //if it has a decimal point, it's a gpa. Looks using gpa
        if(num.indexOf(".") != -1){
            double gpa = Double.parseDouble(num);
            for(int i = 0; i < studentList.size(); i++){
                Student stuObject = studentList.get(i);
                if(stuObject.getGPA() > gpa){
                    checkResponse = "Good";
                    System.out.println(stuObject.getFullName());
                    System.out.println(stuObject.getStuNumber());
                    System.out.println(stuObject.getGPA());
                    System.out.println(" ");
                }
            }
        }
        //if it doesn't have a decimal point, it's a student number. Looks using student number
        else{
            int stuNum = Integer.parseInt(num);
            for(int i = 0; i < studentList.size(); i++){
                Student stuObject = studentList.get(i);
                if(stuObject.getStuNumber() > stuNum){
                    checkResponse = "Good";
                    System.out.println(stuObject.getFullName());
                    System.out.println(stuObject.getStuNumber());
                    System.out.println(stuObject.getGPA());
                    System.out.println(" ");
                }
            }
        }
        //if nothing is found, then prints so such student exists
        if(checkResponse.equals(" ")){
            System.out.println("No such student exists");
        }
        System.out.println("Press anything to continue");
        String end = input.nextLine();

            
        
        if(checkResponse.equals(" ")){
            System.out.println("This student does not exist. Press anything to continue");
            String exit = input.nextLine();
            System.out.print("\u000c");
        }
    }
    
    public void sortList(){
        Scanner input = new Scanner(System.in);
        System.out.println("What do you want to sort by? 1: Name. 2: Number.");
        String choice = input.nextLine();
        //if the input is a letter, sort by letter. If it's a number, sort by number
        if(choice.equals("1")){
            
        }else{
            mergeSortInt(studentList, studentList.size());
        }
    }
    
    public void mergeSortInt(ArrayList<Student> nums, int size){
        //int size = nums.size();
        if(size < 2)
            return;
        int mid = size/2;
        ArrayList<Student> l = new ArrayList<Student>();
        ArrayList<Student> r = new ArrayList<Student>();
        for(int i = 0; i < mid; i++){
            l.add(nums.get(i));
        }
        for(int i = mid; i < size; i++){
            r.add(nums.get(i));
        }
        //int[] l = new int[mid];
        //int[] r = new int[size-mid];
        for(int i = 0; i < mid; i++){
            Student stuObj = studentList.get(i);
            l.set(i, stuObj);
        }
        for(int i = mid; i < size; i++){
            Student stuObj = studentList.get(i);
            r.set(i - mid, stuObj);
        }
        mergeSortInt(l, mid);
        mergeSortInt(r, size-mid);
        
        mergeInt(nums, l, r, mid, size);
    }
    
    public void mergeInt(ArrayList<Student> a, ArrayList<Student> l, 
                        ArrayList<Student> r, int left, int right){
        int i = 0, j = 0, k = 0;
        while(i < left && j < right){
            Student stuI = l.get(i);
            Student stuJ = r.get(j);
            if(stuI.getStuNumber() <= stuJ.getStuNumber())
                a.set(k++, l.get(i++));
            else
                a.set(k++, r.get(j++));
        }
        while (i < left){
            a.set(k++, l.get(i++));
        }
        while (j < right){
            a.set(k++, r.get(j++));
        }
    }
}
