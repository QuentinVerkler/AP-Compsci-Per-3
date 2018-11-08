import java.util.ArrayList;
/**
 * Write a description of class FR2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FR2
{
    public static void main(){
        System.out.println(transformILike("I like people"));
    }
    public static String transformILike(String str){
        ArrayList <String> phrases = new ArrayList<String>();
        phrases.add("Why do you like");
        phrases.add("Do you eat");
        phrases.add("What are");
        phrases.add("What color are");
        String object = str.substring(str.indexOf(" ", 4));
        int phraseSelector = (int)((Math.random() * 4));
        String beginning = phrases.get(phraseSelector);
        return beginning + object + "?";
    }
}
