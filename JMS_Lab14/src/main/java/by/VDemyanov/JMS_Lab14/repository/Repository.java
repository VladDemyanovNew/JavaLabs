package by.VDemyanov.JMS_Lab14.repository;

import java.util.List;

public interface Repository <T> {
    boolean add(T item);
    List<T> getAll();
    boolean update(T item);
    boolean remove(int id);
}
