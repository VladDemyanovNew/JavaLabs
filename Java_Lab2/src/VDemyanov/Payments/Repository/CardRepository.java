package VDemyanov.Payments.Repository;

import VDemyanov.Payments.Account.Account;
import VDemyanov.Payments.Card.Card;

import java.util.ArrayList;

public class CardRepository implements IRepository<Card>{
    private ArrayList<Card> cards;

    public CardRepository() {
        this.cards = new ArrayList<Card>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getLength() {
        return cards.size();
    }

    public boolean addItem(Card card) {
        for (Card item : cards) {
            if (item.getCardNumber().equals(card.getCardNumber()))
                return false;
        }
        cards.add(card);
        return true;
    }
}
