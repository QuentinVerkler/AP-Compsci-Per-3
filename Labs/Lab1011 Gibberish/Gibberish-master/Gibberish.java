
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
        while(sourceString.contains(">")){
            int index = sourceString.indexOf("<");
            //if there is no more "<", then it will exit
            if(index == -1){
            //if not, then replace the word with a gibberish one
            }else{
                int beginning = index;
                //check if it's a noun
                if(sourceString.indexOf("<N>") == index){
                    int end = sourceString.indexOf("</>");
                    if(wordlist5000.getRandomWordString("N") != null){
                        sourceString = sourceString.substring(0, index) + wordlist5000.getRandomWordString("N") + sourceString.substring(end+ 3);
                    }
                    //then checks if a verb
                }else if(sourceString.indexOf("<v>") == index){
                    int end = sourceString.indexOf("</>");
                    if(wordlist5000.getRandomWordString("v") != null){
                        sourceString = sourceString.substring(0, index) + wordlist5000.getRandomWordString("v") + sourceString.substring(end+ 3);
                    }
                }
                //then checks if an adjective
                else if(sourceString.indexOf("<t>") == index){
                    int end = sourceString.indexOf("</>");
                    if(wordlist5000.getRandomWordString("v") != null){
                        sourceString = sourceString.substring(0, index) + wordlist5000.getRandomWordString("t") + sourceString.substring(end+ 3);
                    }
                }
            }
            
        }
        //if everthing checks out, it will return the revised sourceString
        return sourceString;
    }
}
