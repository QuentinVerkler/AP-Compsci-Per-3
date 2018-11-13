import java.util.ArrayList;
/**
 * Write a description of class Card here.
 *
 * Quentin Verkler
 * 1108
 */
public class Card
{
    
    private int rank;
    private String suit;
    public Card(int x, String y){
        rank = x;
        suit = y;
    }
    
    public int getRank(){
        return rank;
    }
    
    public String getSuit(){
        return suit;
    }
}
