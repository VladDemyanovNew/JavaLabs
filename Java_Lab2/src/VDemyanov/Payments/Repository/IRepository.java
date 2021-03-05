package VDemyanov.Payments.Repository;

import VDemyanov.Payments.Person.Client;

import java.util.ArrayList;

public interface IRepository<T> {
    boolean addItem(T item);
    ArrayList<T> getItems();
}
