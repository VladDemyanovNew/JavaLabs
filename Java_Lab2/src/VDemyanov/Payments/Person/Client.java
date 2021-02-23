package VDemyanov.Payments.Person;

import VDemyanov.Payments.Card.Card;
import VDemyanov.Payments.Repository.CardRepository;

import java.math.BigDecimal;

public class Client extends Person {
    public Client(String name, String lastName, String middleName, String passportData) {
        super(name, lastName, middleName, passportData);
    }

    public BigDecimal getBalance(String cardNumber, CardRepository cardRepository) {
        try {
            boolean isCardFound = false;
            for (Card card : cardRepository.getCards()) {
                if (card.getCardNumber().equals(cardNumber)) {
                    isCardFound = true;
                    if (!card.isCardBlock())
                        return card.getBalance();
                    else
                        System.out.println("Карта заблокирована!");
                }
            }
            if (!isCardFound)
                throw new Exception("Карта не найдена!");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new BigDecimal(0);
    }

    public void blockCard(boolean action, String cardNumber, CardRepository cardRepository) {
        try {
            boolean isCardFound = false;
            for (Card card : cardRepository.getCards()) {
                if (card.getCardNumber().equals(cardNumber)) {
                    isCardFound = true;
                    card.setCardBlock(action);
                }
            }
            if (!isCardFound)
                throw new Exception("Карта не найдена!");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void makeDeposit(BigDecimal deposit, String cardNumber, CardRepository cardRepository) {
        try {
            boolean isCardFound = false;
            for (Card card : cardRepository.getCards()) {
                if (card.getCardNumber().equals(cardNumber)) {
                    isCardFound = true;
                    if (!card.isCardBlock())
                        card.makeDeposit(deposit);
                    else
                        System.out.println("Карта заблокирована!");
                }
            }

            if (!isCardFound)
                throw new Exception("Карта не найдена!");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void sendPayment(BigDecimal deposit, String cardNumber, CardRepository cardRepository) {
        try {
            boolean isCardFound = false;
            for (Card card : cardRepository.getCards()) {
                if (card.getCardNumber().equals(cardNumber)) {
                    isCardFound = true;
                    if (!card.isCardBlock())
                        card.sendPayment(deposit);
                    else
                        System.out.println("Карта заблокирована!");
                }
            }
            if (!isCardFound)
                throw new Exception("Карта не найдена!");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
