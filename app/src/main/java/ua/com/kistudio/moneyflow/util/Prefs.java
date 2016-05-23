package ua.com.kistudio.moneyflow.util;

import android.net.Uri;

/**
 * Created by Вiталя on 13.04.2016.
 */
public class Prefs {
    public static final String LOG_TAG = "MoneyFlow";

    public static final String ID_FIELD_NAME = "_id";
    public static final String FN_FIELD_NAME = "first_name";
    public static final String LN_FIELD_NAME = "last_name";
    public static final String BIRTHDAY_FIELD_NAME = "birthday";
    public static final String EMAIL_FIELD_NAME = "email";
    public static final String API_SERVER = "http://cityfinder.esy.es";

    // DB constants
    public static final String DB_NAME = "MoneyFlowDB";
    public static final String FIELD_ID = "_id";
    public static final int DB_CURRENT_VERSION = 1;

    public static final String TABLE_NAME_EXPENCIES = "expencies";
    public static final String EXPENCY_FIELD_ID_PASSIVE = "id_passive";
    public static final String EXPENCY_FIELD_VOLUME = "volume";
    public static final String EXPENCY_FIELD_DATE = "date";

    public static final String TABLE_NAME_EXPENSE_NAMES = "expense_names";
    public static final String EXPENSE_NAMES_FIELD_NAME = "name";

    // Provider constants
    public static final String URI_AUTORITIES = "com.kistudio.moneflow.provider";
    public static final String URI_TYPE_EXPENSE = "expense";
    public static final Uri URI_EXPENSE = Uri.parse("content://"+URI_AUTORITIES+"/"+URI_TYPE_EXPENSE);

}
