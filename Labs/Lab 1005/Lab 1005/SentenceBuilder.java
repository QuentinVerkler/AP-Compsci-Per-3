
/**
 * Write a description of class SentenceBuilder here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SentenceBuilder
{
    //the string arrays
    String[] nouns = {"Dylan" , "slayer" , "soul" , "savage" , "John"};
    String[] verbs = {"sings" , "walks" , "jumps" , "sees" , "eats"};
    String[] adjectives = {"tall" , "rageful" , "barbaric" , "short" , "stout"};
    String[] determiners = {"the" , "my" , "your" , "his" , "her"};
    String[] adverbs = {"cruelly" , "angrily" , "quickly" , "forcefully" , "never"};
    String[] prepositions = {"near" , "behind" , "under" , "ahead" , "on"};
    
    //all the random word getters
    public String getRandomNoun(){
        String noun = nouns[(int)(Math.random()*nouns.length)];
        return noun;
    }
    
    public String getRandomVerb(){
        String verb = verbs[(int)(Math.random()*verbs.length)];
        return verb;
    }
    
    public String getRandomAdjective(){
        String adjective = adjectives[(int)(Math.random()*adjectives.length)];
        return adjective;
    }
    
    public String getRandomDeterminer(){
        String determiner = determiners[(int)(Math.random()*determiners.length)];
        return determiner;
    }
    
    public String getRandomAdverb(){
        String adverb = adverbs[(int)(Math.random()*adverbs.length)];
        return adverb;
    }
    
    public String getRandomPreposition(){
        String preposition = prepositions[(int)(Math.random()*prepositions.length)];
        return preposition;
    }
    
    //phrase getters
    public String getNounPhrase(){
        String nounPhrase = getRandomDeterminer() + " " + getRandomAdjective() + " " + getRandomNoun();
        return nounPhrase;
    }
    
    public String getVerbPhrase(){
        String verbPhrase = getRandomAdverb() + " " + getRandomVerb();
        return verbPhrase;
    }
    
    public String getPrepositionalPhrase(){
        String prepositionalPhrase = getRandomPreposition() + " " + getRandomDeterminer() + " " + getRandomAdjective() + " " + getRandomNoun();
        return prepositionalPhrase;
    }
    
    public void loadSentences(){
        System.out.println(getNounPhrase() + " " + getVerbPhrase() + " " + getPrepositionalPhrase());
    }
}
