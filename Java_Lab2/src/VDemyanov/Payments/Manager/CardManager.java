package VDemyanov.Payments.Manager;

import VDemyanov.Payments.Account.Account;
import VDemyanov.Payments.Card.Card;
import VDemyanov.Payments.Card.CreditCard;
import VDemyanov.Payments.Card.DebitCard;
import VDemyanov.Payments.Card.Enum.ECardType;
import VDemyanov.Payments.Person.Client;
import VDemyanov.Payments.Repository.CardRepository;

import java.util.ArrayList;

public class CardManager {
    /**
     * создание новой карты
     * @param cardRepository
     * @param account
     * @param client
     * @param eCardType
     */
    public static void createCard(CardRepository cardRepository, Account account, Client client, ECardType eCardType) {
        switch (eCardType) {
            case DEBIT_CARD:
                DebitCard debCard = new DebitCard("c" + cardRepository.getLength(), account, client);
                cardRepository.addItem(debCard);
                break;
            case CREDIT_CARD:
                CreditCard credCard = new CreditCard("c" + cardRepository.getLength(), account, client);
                cardRepository.addItem(credCard);
                break;
        }
    }
}
