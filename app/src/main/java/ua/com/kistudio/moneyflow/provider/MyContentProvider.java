package ua.com.kistudio.moneyflow.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import ua.com.kistudio.moneyflow.db.DBHelper;
import ua.com.kistudio.moneyflow.util.Prefs;

public class MyContentProvider extends ContentProvider {

    private DBHelper dbHelper;
    private SQLiteDatabase database;

    private static UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    private static final int URI_CODE_EXPENSE = 1;

    static {
        uriMatcher.addURI(Prefs.URI_AUTORITIES,
                Prefs.URI_TYPE_EXPENSE,
                URI_CODE_EXPENSE);
    }

    public MyContentProvider() {}

    @Override
    public boolean onCreate() {
        dbHelper = new DBHelper(getContext(),Prefs.DB_CURRENT_VERSION);
        return true;
    }



    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        database = dbHelper.getWritableDatabase();

        long id;
        Uri insertUri = null;

        switch (uriMatcher.match(uri)){
            case URI_CODE_EXPENSE:
                id = database.insert(Prefs.TABLE_NAME_EXPENCIES,null,values);
                insertUri = ContentUris.withAppendedId(uri,id);
            break;
        }
        return insertUri;
    }


    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        database = dbHelper.getWritableDatabase();

        Cursor cursor = null;
        switch (uriMatcher.match(uri)){
            case URI_CODE_EXPENSE:
                cursor = database.query(Prefs.TABLE_NAME_EXPENCIES,
                        projection,selection,selectionArgs,null,null,sortOrder);
                break;
        }
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
