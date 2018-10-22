/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if (findKeyword(statement, "no") >= 0)
        {
            response = "Why so negative?";
        }
        else if (findKeyword(statement, "mother") >= 0
                || findKeyword(statement, "father") >= 0
                || findKeyword(statement, "sister") >= 0
                || findKeyword(statement, "brother") >= 0)
        {
            response = "Tell me more about your family.";
        }
        //the responses they want
        else if(findKeyword(statement, "dog") >= 0 || findKeyword(statement, "cat") >= 0){
                response = "Tell me more about your pets.";
          }
        else if(findKeyword(statement, "Malloy") >= 0 
                || findKeyword(statement, "Ettlin") >= 0){
            response = "He sounds good. Do you want to kill him?";
          }
        else if(statement.trim().length() == 0){
            response = "Please talk to me.";
          }
          //My three responses
        else if(findKeyword(statement, "kill") >= 0){
            response = "Yes, kill";
        }
        else if(findKeyword(statement, "capitalism") >= 0){
            response = "Kill capitalism";
        }
        else if(findKeyword(statement, "love") >= 0){
            response = "Love is a lie.";
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }
    
    private int findKeyword(String statement, String goal, int startPos){
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
        
        //if there is a letter before or after, then do nothing
        return -1;
    }
    
    private int findKeyword(String statement, String goal){
            return findKeyword(statement, goal, 0);
    }
    
    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 4;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        //my new random responses
        else if(whichResponse == 4){
            response = "Continue.";
          }
        else if(whichResponse == 5){
            response = "Keep on going.";
          }

        return response;
    }
}
