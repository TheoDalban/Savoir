package fr.dalbanchin.savwar.storage.utility;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.net.IDN;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import fr.dalbanchin.savwar.Alea;
import fr.dalbanchin.savwar.model.Savoir;

abstract public class BaseDeDonnee<T> implements Storage<T>{

    private SQLiteOpenHelper helper;
    private String table;
    public BaseDeDonnee(SQLiteOpenHelper helper, String table) {
        this.helper = helper;
        this.table = table;
    }

    protected abstract ContentValues objectToContentValues(int id, T object);

    protected abstract ContentValues objectToContentValuesDate(String date, T object);

    protected abstract T cursorToObject(Cursor cursor);

    @Override
    public void insert(T object) {
        helper.getWritableDatabase().insert(table, null, objectToContentValues(-1,object));
    }

    @Override
    public List<T> findAll() {
        List<T> list = new ArrayList<>();

        Cursor cursor = helper.getReadableDatabase().query(table, null, null, null, null, null, null);
        while (cursor.moveToNext())
            list.add(cursorToObject(cursor));
        cursor.close();

        return list;
    }

    @Override
    public T find(int id) {
        T object = null;

        Cursor cursor = helper.getReadableDatabase().query(table, null, BaseColumns._ID + " = ?", new String[]{"" + id}, null, null, null);
        if (cursor.moveToNext()) object = cursorToObject(cursor);
        cursor.close();

        return object;
    }

    @Override
    public T findDate() {
        T object = null;

        Cursor cursor = helper.getReadableDatabase().query(table, null,   "date" + " = ?", new String[]{"vide"}, null, null,null);
        if (cursor.moveToNext()) {
            object = cursorToObject(cursor);
        }
        cursor.close();

        return object;
    }

    @Override
    public List<T> findAllDate(){
        List<T> list = new ArrayList<>();

        Cursor cursor = helper.getReadableDatabase().query(table, null,   "date" + " = ?", new String[]{"vide"}, null, null,null);

        while (cursor.moveToNext())
            list.add(cursorToObject(cursor));
        cursor.close();

        return list;
    }

    @Override
    public int size() {
        Cursor cursor = helper.getReadableDatabase().query(table, null, null, null, null, null, null);
        int size = cursor.getCount();
        cursor.close();
        return size;
    }

    @Override
    public void update(int id, T object) {
        helper.getWritableDatabase().update(table, objectToContentValues(id, object), BaseColumns._ID + " = ?", new String[]{"" + id});
    }

    @Override
    public void update(String date, T object) {
        helper.getWritableDatabase().update(table, objectToContentValuesDate(date, object), "date = ?", new String[]{"" + date});
    }

    @Override
    public void delete(int id) {
        helper.getWritableDatabase().delete(table, BaseColumns._ID + " = ?", new String[]{"" + id});
    }
}