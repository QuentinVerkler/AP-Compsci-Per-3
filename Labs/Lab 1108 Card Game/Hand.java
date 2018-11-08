import java.util.ArrayList;
/**
 * Write a description of class Hand here.
 *
 * Quentin Verkler
 * 1108
 */
public class Hand
{
    ArrayList <Card> hand = new ArrayList<Card>();
    Deck deck = new Deck();
    public Hand(){
        hand.add(deck.getCard());
        for(int i = 1; i < hand.size(); i++){
            int spot = 0; 
            spot++;
            if(spot < hand.size()){
                
            }
            
        }
    }
    public boolean sameSuit(Hand x){
        
    }
}
