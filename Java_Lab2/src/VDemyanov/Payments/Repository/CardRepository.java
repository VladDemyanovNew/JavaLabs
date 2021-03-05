package VDemyanov.Payments.Repository;

import VDemyanov.Payments.Account.Account;
import VDemyanov.Payments.Card.Card;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CardRepository implements IRepository<Card>{
    private ArrayList<Card> cards;

    public CardRepository() {
        this.cards = new ArrayList<Card>();
    }

    public ArrayList<Card> getItems() {
        return cards;
    }

    public int getLength() {
        return cards.size();
    }

    /**
     * добавление карты в коллекцию
     * @param card
     * @return
     */
    public boolean addItem(Card card) {
        for (Card item : cards) {
            if (item.getCardNumber().equals(card.getCardNumber()))
                return false;
        }
        cards.add(card);
        return true;
    }

    /**
     * подсчёт денег хранящихся на всех счетах клиента
     * @param passportData
     * @return
     */
    public double countAllMoneyByPassportData(String passportData) {
        return cards.stream()
                .filter(card -> card.getClient().getPassportData().equals(passportData))
                .collect(Collectors.groupingBy(Card::getAccount))
                .entrySet().stream().map(item->item.getValue().get(0))
                .reduce(0.0, (x, y) -> x + y.getBalance().doubleValue(), (x, y)-> x + y );
    }
}
