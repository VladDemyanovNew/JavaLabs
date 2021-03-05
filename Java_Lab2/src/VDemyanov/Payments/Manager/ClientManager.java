package VDemyanov.Payments.Manager;

import VDemyanov.Payments.Person.Client;
import VDemyanov.Payments.Repository.ClientRepository;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ClientManager {
    /**
     * сортировка коллекции клиентов по имени
     * @param clients
     * @return
     */
    public static ArrayList<Client> sortedClientsByName(ArrayList<Client> clients) {
        return (ArrayList<Client>) clients.stream()
                .sorted((item1, item2) -> item1.getName().compareTo(item2.getName()))
                .collect(Collectors.toList());
    }

    /**
     * вывод коллекции клиентов
     * @param clients
     */
    public static void printClients(ArrayList<Client> clients) {
        clients.stream().forEach(item -> System.out.println(item.toString()));
    }
}
