package fr.dalbanchin.savwar.storage.utility;

import java.util.List;

public interface Storage<T> {
    void insert(T object);

    List<T> findAll();

    T find(int id);

    T findDate();

    List<T> findAllDate();

    List<T> findAllAnimaux();
    List<T> findAllCuisine();
    List<T> findAllEspace();
    List<T> findAllGeographie();
    List<T> findAllHistoire();
    List<T> findAllHumain();
    List<T> findAllNature();

    List<T> findAllFavoring();

    int size();

    void update(int id, T object);

    void updateDate(String date, int id, T object);

    void updateFavoring(int fav, int id, T object);

    void delete(int id);
}
