import java.util.ArrayList;
/**
 * Write a description of class Deck here.
 *
 * Quentin Verkler
 * 1108
 */
public class Deck
{
    //Array of cards
    ArrayList<Card> deck = new ArrayList<Card>();
    public Deck(){
        for(int r = 1; r < 14; r++){
            for(int c = 0; c < 4; c++){
                if(c ==0){
                    deck.add(new Card(r, "Heart"));
                }
                if(c == 1){
                    deck.add(new Card(r, "Diamond"));
                }
                if(c == 2){
                    deck.add(new Card(r, "Spade"));
                }
                if(c == 3){
                    deck.add(new Card(r, "Club"));
                }
            }
        }
    }
    public Card getCard(){
        return deck.get((int)(Math.random() * 52));
    }
}
