
/**
 * Write a description of class SentenceBuilder here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SentenceBuilder
{
    //the string arrays
    static String[] nouns = {"Dylan" , "slayer" , "soul" , "savage" , "John"};
    static String[] verbs = {"sings" , "walks" , "jumps" , "sees" , "eats"};
    static String[] adjectives = {"tall" , "rageful" , "barbaric" , "short" , "stout"};
    static String[] determiners = {"the" , "my" , "your" , "his" , "her"};
    static String[] adverbs = {"cruelly" , "angrily" , "quickly" , "forcefully" , "never"};
    static String[] prepositions = {"near" , "behind" , "under" , "ahead" , "on"};
    
    //all the random word getters
    public static String getRandomNoun(){
        String noun = nouns[(int)(Math.random()*nouns.length)];
        return noun;
    }
    
    public static String getRandomVerb(){
        String verb = verbs[(int)(Math.random()*verbs.length)];
        return verb;
    }
    
    public static String getRandomAdjective(){
        String adjective = adjectives[(int)(Math.random()*adjectives.length)];
        return adjective;
    }
    
    public static String getRandomDeterminer(){
        String determiner = determiners[(int)(Math.random()*determiners.length)];
        return determiner;
    }
    
    public static String getRandomAdverb(){
        String adverb = adverbs[(int)(Math.random()*adverbs.length)];
        return adverb;
    }
    
    public static String getRandomPreposition(){
        String preposition = prepositions[(int)(Math.random()*prepositions.length)];
        return preposition;
    }
    
    //phrase getters
     static String getNounPhrase(){
        String nounPhrase = getRandomDeterminer() + " " + getRandomAdjective() + " " + getRandomNoun();
        return nounPhrase;
    }
    
    public static String getVerbPhrase(){
        String verbPhrase = getRandomAdverb() + " " + getRandomVerb();
        return verbPhrase;
    }
    
    public static String getPrepositionalPhrase(){
        String prepositionalPhrase = getRandomPreposition() + " " + getRandomDeterminer() + " " + getRandomAdjective() + " " + getRandomNoun();
        return prepositionalPhrase;
    }
    
    //the sentence making
    public static String loadSentence(){
        String sentence = getNounPhrase() + " " + getVerbPhrase() + " " + getPrepositionalPhrase();
        return sentence;
    }
    
    public static void run(){
        System.out.println(SentenceBuilder.loadSentence());
    }
}
