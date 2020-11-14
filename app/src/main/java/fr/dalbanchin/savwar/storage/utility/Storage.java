package fr.dalbanchin.savwar.storage.utility;

import java.util.List;

public interface Storage<T> {
    void insert(T object);

    List<T> findAll();

    T find(int id);

    T findDate();

    int size();

    void update(int id, T object);

    void update(String date, T object);

    void delete(int id);
}
