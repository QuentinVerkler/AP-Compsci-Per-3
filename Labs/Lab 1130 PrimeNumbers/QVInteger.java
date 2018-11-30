import java.util.ArrayList;
/**
 * Write a description of class QVInteger here.
 *
 * @author (Quentin Verkler)
 * @version (1130)
 */
public class QVInteger
{
    //global variables
    public static ArrayList<Integer> bigList = new ArrayList<Integer>();
    public static ArrayList<Integer> twoList = new ArrayList<Integer>();
    
    public static void main(){
        setListToNumber(123456, bigList);
        setListToNumber(23456, twoList);
        //addNumberToList(123456, bigList);
        addNumbers(bigList, twoList);
    }
    
    public static void setListToNumber(int n, ArrayList<Integer> n1){
        
        //loads ArrayList with all digits
        while(n > 0){
            int digit = n % 10;
            n1.add(0, digit);
            n = n/10;
        }
        //check
        for(int i = 0; i < n1.size(); i++){
            System.out.print(n1.get(i) + " ");
            
        }
        System.out.println("");
    }
    
    public static void addNumberToList(int n, ArrayList<Integer> n1){
        int num = 0;
        //getting value of bigList
        for(int i = 0; i < n1.size(); i++){
            //int placeSize = 
            int placeNum =n1.get(i) * (int)(Math.pow(10, n1.size() - i - 1));
            num = num + placeNum;
        }
        //total value of both numbers
        int total = num + n;
        //uploading into bigList
        n1.clear();
        while(total > 0){
            int digit = total % 10;
            bigList.add(0, digit);
            total = total/10;
        }
        //check
        for(int i = 0; i < n1.size(); i++){
            System.out.print(n1.get(i) + " ");
            
        }
        System.out.println("");
    }
    
    public static void addNumbers(ArrayList<Integer> n1, ArrayList<Integer> n2){
        //declaring the two variables which will hold the full number
        int totalN1 = 0;
        int totalN2 = 0;
        //loading totalN1
        for(int i = 0; i < n1.size(); i++){
            int placeNum = n1.get(i) * (int)(Math.pow(10, n1.size() - 1 - i));
            totalN1 = totalN1 + placeNum;
        }
        //lodaing totalN2
        for(int i = 0; i < n2.size(); i++){
            int placeNum = n2.get(i) * (int)(Math.pow(10, n2.size() - 1 - i));
            totalN2 = totalN2 + placeNum;
        }
        int total = totalN1 + totalN2;
        //loading total into an ArrayList
        n1.clear();
        while(total > 0){
            int digit = total % 10;
            bigList.add(0, digit);
            total = total / 10;
        }
        //check
        for(int i = 0; i < bigList.size(); i++){
            System.out.print(bigList.get(i) + " ");
            
        }
        System.out.println("");
    }
}
