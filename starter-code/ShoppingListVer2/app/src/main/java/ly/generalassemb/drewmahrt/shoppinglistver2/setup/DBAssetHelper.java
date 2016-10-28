package ly.generalassemb.drewmahrt.shoppinglistver2.setup;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

import ly.generalassemb.drewmahrt.shoppinglistver2.ItemsObject;
import ly.generalassemb.drewmahrt.shoppinglistver2.MainActivity;

/**
 * Created by drewmahrt on 12/29/15.
 */
public class DBAssetHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "SHOPPING_DB";
    private static final int DATABASE_VERSION = 7;
    private static final java.lang.String CREATE_SHOPPING_TABLE = "shopping_table";
    private static final String SHOPPING_TABLE_NAME = "shopping";

    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_PRICE = "price";

    public static final String[] SHOPPING_COLUMNS = {COL_ID, COL_NAME, COL_PRICE};

    public static final String CREATE_SHOPPING_TABLE =
            "CREATE TABLE " + SHOPPING_TABLE_NAME +
                    "(" +
                    COL_ID + " INTEGER PRIMARY KEY, " +
                    COL_NAME + " TEXT, " +
                    COL_PRICE + "FLOAT)";

    public DBAssetHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static DBAssetHelper instance;

    public static DBAssetHelper getInstance(Context context) {

        if (instance == null) {
            instance = new DBAssetHelper(context.getApplicationContext());
        }
        return instance;
    }

    private DBAssetHelper(Context, context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_SHOPPING_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + SHOPPING_TABLE_NAME);
        onCreate(db);
    }

    public List<ItemsObject> searchForFoodItem(String query) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                SHOPPING_TABLE_NAME,
                SHOPPING_COLUMNS,
                COL_PRICE + " > ?",
                new String[]{query},
                null, null,
                COL_PRICE,
                null);

        List<ItemsObject> groceries = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                ItemsObject f = new ItemsObject(cursor.getString(cursor.getColumnIndex(COL_NAME))),
                cursor.getInt(cursor.getColumnIndex(COL_PRICE));
                groceries.add(f);
                cursor.moveToNext();
            }
        }
        return groceries;

        }

    public List<ItemsObject> searchSimilarNames(String query) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                SHOPPING_TABLE_NAME,
                SHOPPING_COLUMNS,
                COL_NAME + " LIKE ?",
                new String[]{query + "%"},
                null, null, null, null);

        List<ItemsObject> groceries = new ArrayList<>();

        if(cursor.moveToFirst()) {
            while(!cursor.isAfterLast()) {
                ItemsObject f = new ItemsObject(cursor.getString(cursor.getColumnIndex(COL_NAME))),
                        cursor.getInt(cursor.getColumnIndex(COL_PRICE));
                groceries.add(f);
                cursor.moveToNext()

            }
        }
        return groceries;

    }
}
