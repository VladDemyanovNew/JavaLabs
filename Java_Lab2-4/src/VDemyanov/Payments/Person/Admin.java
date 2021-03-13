package VDemyanov.Payments.Person;

import VDemyanov.Payments.Card.Card;
import VDemyanov.Payments.Repository.CardRepository;

import java.io.Serializable;
import java.util.ArrayList;

public class Admin extends Person implements Serializable {
    public Admin(String name, String lastName, String middleName, String passportData) {
        super(name, lastName, middleName, passportData);
    }

    public void blockCard(boolean action, String cardNumber, CardRepository cardRepository) {
        try {
            boolean isCardFound = false;
            for (Card card : cardRepository.getItems()) {
                if (card.getCardNumber().equals(cardNumber)) {
                    isCardFound = true;
                    card.setCardBlock(action);
                }
            }
            if (!isCardFound)
                throw new Exception("void blockCard: Карта не найдена!");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<Card> searchCardsByName(String name, CardRepository cardRepository) {
        ArrayList<Card> result = new ArrayList<Card>();
        try {
            boolean isCardFound = false;
            for (Card card : cardRepository.getItems()) {
                if (card.getClient().getName().equals(name)) {
                    isCardFound = true;
                    result.add(card);
                }
            }
            if (!isCardFound)
                throw new Exception("ArrayList<Card> searchCardsByName: Не найдено ни одной карты!");
            return result;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }
}
