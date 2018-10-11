
/**
 * Write a description of class Gibberish here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Gibberish
{
    private String sourceString;
    public Gibberish(){
        Template template = new Template();
        sourceString = template.getSourceString();
    }
    
    public String makeGibberish(WordList5000 wordlist5000){
        //declaring the two variables
        int currentSourceIndex = 0;
        String resultString = "";
        //the actual maker of the gibberish sentence
        while(currentSourceIndex <= sourceString.length()){
            int index = sourceString.indexOf("<");
            //if there is no more "<", then it will exit
            if(index == -1){
                resultString += sourceString.substring(index);
                currentSourceIndex = sourceString.length();
            //if not, then replace the word with a gibberish one
            }else{
                int end = sourceString.indexOf(">");
                int beginning = index +1;
                String placeHolderString = sourceString.substring(beginning, end);
                resultString += wordlist5000.getRandomWordString(placeHolderString);
                currentSourceIndex = sourceString.indexOf("</>");
            }
            
        }
        return resultString;
    }
}
