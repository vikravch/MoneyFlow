package ua.com.kistudio.moneyflow.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ua.com.kistudio.moneyflow.util.Prefs;

/**
 * Created by Вiталя on 16.05.2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    /*
    Table expenses
     - _id
     - id_passive - id from table passive
     - volume - volume of money
     - date - date when expency made
     */
    private static final String CREATE_TABLE_EXPENCIES =  String.format("create table %s " +
            "( %s integer primary key autoincrement, %s integer, %s integer, %s text);",
            Prefs.TABLE_NAME_EXPENCIES, Prefs.FIELD_ID, Prefs.EXPENCY_FIELD_ID_PASSIVE,
            Prefs.EXPENCY_FIELD_VOLUME, Prefs.EXPENCY_FIELD_DATE);

    /*
    Table expense_names
     - _id
     - name - name of expense
     */
    private static final String CREATE_TABLE_EXPENSE_NAMES = String.format(
            "create table %s ( %s  integer primary key autoincrement, %s text);",
            Prefs.TABLE_NAME_EXPENSE_NAMES,
            Prefs.FIELD_ID, Prefs.EXPENSE_NAMES_FIELD_NAME
    );

    public DBHelper(Context context, int version) {
        super(context, Prefs.DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_EXPENCIES);
        db.execSQL(CREATE_TABLE_EXPENSE_NAMES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
