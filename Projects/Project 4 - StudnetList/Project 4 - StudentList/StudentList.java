
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
        System.out.println("If the list is sorted based on number, press 1. If the list is sorted based on name, press 2. If the list isn't sorted, press 3");
        String choice = input.nextLine();
        //do this if list isn't sorted
        if(choice.equals("3")){
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
        }else 
        //if the list was sorted on name, do this
        if(choice.equals("2")){
            System.out.println("Method inoperable. Sorry. Press anything to continue");
            String exit = input.nextLine();
            System.out.print("\u000c");
        }else
        //if the list was storted based on student number, do this
        if(choice.equals("1")){
            int num = Integer.parseInt(name);
            Student stuObject = binarySearchNum(studentList, studentList.size(), num);
            checkResponse = "Name: " + stuObject.getFullName();
            System.out.println(checkResponse);
            System.out.println("Student number: " + stuObject.getStuNumber());
            System.out.println("GPA: " + stuObject.getGPA());
            System.out.println("Press anything to continue");
            String exit = input.nextLine();
            System.out.print("\u000c");
        }
        //if a name was not found, then print name was not found
        if(checkResponse.equals(" ") == true){
            System.out.println("Sorry, that student does not exist in our data base. Press anything to contiune");
            String exit = input.nextLine();
            System.out.print("\u000c");
        }
    }
    
    public Student binarySearchNum(ArrayList<Student> list, int size, int num){
        if(size == 1 && list.get(0).getStuNumber() == num)
            return list.get(0);
        Student place = list.get(size/2);
        if(place.getStuNumber() < num){
            ArrayList<Student> upperHalf = new ArrayList<Student>();
            for(int i = size/2; i < size; i++){
                upperHalf.add(list.get(i));
            }
            return binarySearchNum(upperHalf, upperHalf.size(), num);
        }else if(place.getStuNumber() > num){
            ArrayList<Student> lowerHalf = new ArrayList<Student>();
            for(int i = 0; i < size/2; i++){
                lowerHalf.add(list.get(i));
            }
            return binarySearchNum(lowerHalf, lowerHalf.size(), num);
        }else 
            return place;
        
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
            mergeSortStr(studentList, studentList.size());
            System.out.println("The list has been sorted based on name. Press anything to continue");
        }else{
            mergeSortInt(studentList, studentList.size());
            System.out.println("The list has been sorted based on the student number. Press anything to continue");
        }
        String exit = input.nextLine();
        System.out.print("\u000c");
    }
    
    public void mergeSortStr(ArrayList<Student> students, int size){
        if(size < 2)
            return;
        int mid = size/2;
        ArrayList<Student> l = new ArrayList<Student>();
        ArrayList<Student> r = new ArrayList<Student>();
        //loading left array and right array
        for(int i = 0; i < mid; i++){
            l.add(students.get(i));
        }
        for(int i = mid; i < size; i++){
            r.add(students.get(i));
        }
        //do it again for both sides until gets to size of one
        mergeSortStr(l, mid);
        mergeSortStr(r, size - mid);
        //part that actually compares and changes
        mergeStr(students, l, r, mid, size - mid);
    }
    
    public void mergeStr(ArrayList<Student> a, ArrayList<Student> l, 
                        ArrayList<Student> r, int left, int right){
        //place variables
        int i =  0, j = 0, k = 0;
        //actual comparer, will change place
        while(i < left && j < right){
            Student stuI = l.get(i);
            Student stuJ = r.get(j);
            if(compareNames(stuI.getFullName(), stuJ.getFullName()) == 1)
                a.set(k++, l.get(i++));
            else
                a.set(k++, r.get(i++));
        }
        while (i < left){
            a.set(k++, l.get(i++));
        }
        while (j < right){
            a.set(k++, r.get(j++));
        }
    }
    
    public int compareNames(String name1, String name2){
        name1 = name1.toUpperCase();
        name2 = name2.toUpperCase();
        //if either name is now empter, it will return the empty name to be first
        if(name1.length() == 1)
            return 1;
        if(name2.length() == 2)
            return 2;
        //if the first name is higher in alphabet, will return 1
        if(name1.charAt(0) < name2.charAt(0))
            return 1;
        //if the second name is higher, will return 2
        if(name2.charAt(0) < name1.charAt(0))
            return 2;
        //if the letters are the same, then will go through it again
        if(name1.charAt(0) == name2.charAt(0))
            return compareNames(name1.substring(1), name2.substring(1));
        return 0;
    }
    
    public void mergeSortInt(ArrayList<Student> nums, int size){
        if(size < 2)
            return;
        int mid = size/2;
        ArrayList<Student> l = new ArrayList<Student>();
        ArrayList<Student> r = new ArrayList<Student>();
        //loading left array and right array
        for(int i = 0; i < mid; i++){
            l.add(nums.get(i));
        }
        for(int i = mid; i < size; i++){
            r.add(nums.get(i));
        }
        //do it again for both sides until gets to size of one
        mergeSortInt(l, mid);
        mergeSortInt(r, size-mid);
        //part that actually compares and change
        mergeInt(nums, l, r, mid, size - mid);
    }
    
    //connects to mergeSortInt
    public void mergeInt(ArrayList<Student> a, ArrayList<Student> l, 
                        ArrayList<Student> r, int left, int right){
        //place variables
        int i = 0, j = 0, k = 0;
        //actual comparer, will change place
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
