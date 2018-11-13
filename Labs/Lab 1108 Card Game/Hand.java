import java.util.ArrayList;
/**
 * Write a description of class Hand here.
 *
 * Quentin Verkler
 * 1108
 */
public class Hand
{
    Card[] hand = new Card[5];
    Deck deck = new Deck();
    public Hand(){
        hand[0] = deck.getCard();
        int i = 1;
        while(i < hand.length){
            hand[i] = deck.getCard();
            
            if(i == 1){
                if(hand[i] == hand[0] || hand[i] == hand[2]
                || hand[i] == hand[3] || hand[i] == hand[4]){
                hand[i] = null;
            }
            }else
            if(i == 2){
                if(hand[i] == hand[0] || hand[i] == hand[1]
                || hand[i] == hand[3] || hand[i] == hand[4]){
                hand[i] = null;
                }
            }else
            if(i == 3){
                if(hand[i] == hand[0] || hand[i] == hand[1]
                || hand[i] == hand[2] || hand[i] == hand[4]){
                hand[i] = null;
                }
            }else
            if(i == 4){
                if(hand[i] == hand[0] || hand[i] == hand[1]
                || hand[i] == hand[2] || hand[i] == hand[3]){
                hand[i] = null;
                }
            }
            if(hand[i] != null){
                i++;
            }
        }
    }
    
    public boolean sameSuit(Hand x){
        String hand0 = hand[0].getSuit();
        String hand1 = hand[1].getSuit();
        String hand2 = hand[2].getSuit();
        String hand3 = hand[3].getSuit();
        String hand4 = hand[4].getSuit();
        if(hand0.equals(hand1) && hand0.equals(hand2) && hand0.equals(hand3)
        && hand0.equals(hand4)){
            return true;
        }else{
            return false;
        }
    }
    
    public int onePair(Hand x){
        int hand0 = hand[0].getRank();
        int hand1 = hand[1].getRank();
        int hand2 = hand[2].getRank();
        int hand3 = hand[3].getRank();
        int hand4 = hand[4].getRank();
        int pair = 0;
        if(hand0 == hand1 || hand0 == hand2 || hand0 == hand3 || hand0 == hand4){
            pair = hand0;
        }else
        if(hand1 == hand0 || hand1 == hand2 || hand1 == hand3 || hand1 == hand4){
            pair = hand1;
        }
        if(hand2 == hand0 || hand2 == hand1 || hand2 == hand3 || hand2 == hand4){
            pair = hand2;
        }else
        if(hand3 == hand0 || hand3 == hand1 || hand3 == hand2 || hand3 == hand4){
            pair = hand3;
        }else
        if(hand4 == hand0 || hand4 == hand1 || hand4 == hand2 || hand4 == hand3){
            pair = hand4;
        }else{
            pair = -1;
        }
        return pair;
    }
}
