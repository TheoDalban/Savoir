package fr.dalbanchin.savwar;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDeDonnee extends SQLiteOpenHelper {
    // BaseDeDonnee Version
    private static final int DATABASE_VERSION = 1;

    // Nom BaseDeDonnee
    private static final String DATABASE_NAME = "savwar_bdd";

    // Nom des table(s)
    private static final String DB_TABLE = "table_image";

    // Nom des colonne(s)
    private static final String KEY_NAME = "image_name"; // potentiellement que le thème pour le moment.
    private static final String KEY_IMAGE = "image_data";

    // Creation des table(s)
    private static final String CREATE_TABLE_IMAGE = "CREATE TABLE " + DB_TABLE + "("+
            KEY_NAME + " TEXT," +
            KEY_IMAGE + " BLOB);";

    // Constructeur de la BaseDeDonnee
    public BaseDeDonnee(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Creation de la table
        db.execSQL(CREATE_TABLE_IMAGE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);

        // Creation de la nouvelle table
        onCreate(db);
    }

    // Insertion dans la Base de données
    public void add( String name, byte[] image) throws SQLiteException {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME,     name);
        cv.put(KEY_IMAGE,     image);
        database.insert( DB_TABLE, null, cv );
    }

//    // Insertion de la base de données
//    SQLiteDatabase myDataBase;
//    String mPath = BaseDeDonnee.DATABASE_PATH + BaseDeDonnee.DATABASE_NAME;
//    myDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.OPEN_READWRITE);
}