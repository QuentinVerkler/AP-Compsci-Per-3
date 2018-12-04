
/**
 * Write a description of class PrimeGenerator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PrimeGenerator
{
    static int x = 0;
    public static void main(){
        System.out.print("\033[H\033[2J");
        primeGenerator();
    }
    
    public static void primeGenerator(){
        while(x < 1000000000){
            x++;
            if(x  % 2 != 0 && x % 3 != 0 && x % 5 != 0 && x % 7 != 0){
                System.out.println(x);
            }
            
        }
    }
}
