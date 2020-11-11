package fr.dalbanchin.savwar.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import fr.dalbanchin.savwar.model.Savoir;
import fr.dalbanchin.savwar.storage.utility.BaseDeDonnee;

public class SavoirDatabaseStorage extends BaseDeDonnee<Savoir> {
    private static final String TABLE_NAME = "savoir";
    private static final int NUM_ID = 0;
    private static final String KEY_INFORMATION = "information";
    private static final int NUM_INFORMATION = 1;
    private static final String KEY_IMAGE = "image";
    private static final int NUM_IMAGE = 2;
    private static final String KEY_THEME  = "theme";
    private static final int NUM_THEME = 3;
    private static final String KEY_LIEN = "lien";
    private static final int NUM_LIEN = 4;
    private static final String KEY_FAVORING = "favoring"; // Boolean
    private static final int NUM_FAVORING = 5;
    private static final String KEY_DATE = "date";
    private static final int NUM_DATE = 6;

    private static SavoirDatabaseStorage STORAGE;

    public static SavoirDatabaseStorage get(Context context) {
        if (STORAGE == null) {
            STORAGE = new SavoirDatabaseStorage(context);
        }
        return STORAGE;
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "Savoir.db";

        private static final String SQL_CREATE_SAVOIR_ENTRIES = "CREATE TABLE " + TABLE_NAME + " ("
                + BaseColumns._ID + " INTEGER PRIMARY KEY,"
                + KEY_INFORMATION + " TEXT," + KEY_IMAGE + " BLOB," + KEY_THEME  + " TEXT,"
                + KEY_LIEN + " TEXT," + KEY_FAVORING + " BOOLEAN," + KEY_DATE + " TEXT)";

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_SAVOIR_ENTRIES);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    private SavoirDatabaseStorage(Context context) {
        super(new DatabaseHelper(context), TABLE_NAME);
    }

    @Override
    protected ContentValues objectToContentValues(int id, Savoir object) {
        ContentValues values = new ContentValues();
        values.put(KEY_INFORMATION, object.getInfo());
        values.put(KEY_IMAGE, object.getImage_data());
        values.put(KEY_THEME , object.getTheme());
        values.put(KEY_LIEN, object.getLien());
        values.put(KEY_FAVORING, object.getFavoring());
        values.put(KEY_DATE, object.getDate());
        return null;
    }

    @Override
    protected Savoir cursorToObject(Cursor cursor) {
        return new Savoir(cursor.getInt(NUM_ID),
                cursor.getString(NUM_INFORMATION),
                cursor.getString(NUM_IMAGE),
                cursor.getString(NUM_THEME),
                cursor.getString(NUM_LIEN),
                cursor.getString(NUM_FAVORING),
                cursor.getString(NUM_DATE));
    }
}

