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
        //System.out.println(transformILike("I like people"));
        ArrayList<Integer> levels = new ArrayList<Integer>();
        levels.add(-3);
        levels.add(-2);
        levels.add(-1);
        levels.add(1);
        levels.add(2);
        levels.add(3);
        System.out.println(adjustMaxMin(levels, 2));
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
    public static int adjustMaxMin(ArrayList<Integer> levels, int maxLevel){
 /* Complete this mehtod */
        int minLevel = maxLevel * -1;
        int timesChanged = 0;
        for(int i = 0; i < levels.size(); i++){
            int thisLevel = levels.get(i);
            if(thisLevel > maxLevel || thisLevel < minLevel){
                timesChanged++;
            }
            while(thisLevel > maxLevel){
		thisLevel--;
            }
            while(thisLevel < minLevel){
		thisLevel++;
            }
	}
	return timesChanged;
}


}
