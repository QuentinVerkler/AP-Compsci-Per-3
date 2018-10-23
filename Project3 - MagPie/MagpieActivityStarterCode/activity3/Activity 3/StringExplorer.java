/**
 * A program to allow students to try out different 
 * String methods. 
 * @author Laurie White
 * @version April 2012
 */
public class StringExplorer
{

    public static void main()
    {
        String sample = "The quick brown fox jumped over the lazy dog.";
        
        //  Demonstrate the indexOf method.
        int position = sample.indexOf("quick");
        System.out.println ("sample.indexOf(\"quick\") = " + position);
        
        //  Demonstrate the toLowerCase method.
        String lowerCase = sample.toLowerCase();
        System.out.println ("sample.toLowerCase() = " + lowerCase);
        System.out.println ("After toLowerCase(), sample = " + sample);
        
        //  Try other methods here:
            findKeyword("She's my sister", "sister", 0);
            findKeyword("Brother Tom is helpful", "brother", 0);
            findKeyword("I can't catch wild cats.", "cat", 0);
            findKeyword("I know nothing about snow plows.", "no", 0);

    }
    private static int findKeyword(String statement, String goal, int startPos){
        //turns both the given statement and phrase being looked for into lower case 
        String phrase = statement.trim().toLowerCase();
        goal = goal.toLowerCase();
        
        //sets position to posistion of the phrase being looked for starting at the given position
        int psn = phrase.indexOf(goal, startPos);
        
        //this parts sees if the goal is its own word
        String before = " ", after = " ";
        while(psn >= 0){
            //the two if statements discover if what's before and after the word
            if(psn > 0){
                before = phrase.substring(psn - 1, psn);
            }
            if(psn + goal.length() < phrase.length()){
                after = phrase.substring(psn + goal.length(), psn + goal.length() + 1);
            }
            
            //if the position before and after are not letters, then we're good
            if(((before.compareTo("a") < 0) || (before.compareTo("z") > 0))
                            && ((after.compareTo("a") < 0) || (after.compareTo("z") > 0)))
            {
                return psn;
            }
            
            //now it moves onto the next position
            psn = phrase.indexOf(goal, psn + 1);
        }
        
        //if there is a letter before or after, then it returns -1, meaning that the phrase 
        //will be treated as a random
        return -1;
    }

}
