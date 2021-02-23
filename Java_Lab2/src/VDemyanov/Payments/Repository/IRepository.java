package VDemyanov.Payments.Repository;

import java.util.ArrayList;

public interface IRepository<T> {
    boolean addItem(T item);
}
