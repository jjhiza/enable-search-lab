package ly.generalassemb.drewmahrt.shoppinglistver2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jay on 10/26/16.
 */

public class SQLiteHelper {

    public class SQLiteOpenHelper extends android.database.sqlite.SQLiteOpenHelper {

        public static final int DATABASE_VERSION = 7;

        public static final String DATABASE_NAME = "SHOPPING_DB";
        public static final String TABLE_NAME = "SHOPPING_LIST";
        public static final String COL_ID = "_id";
        public static final String COL_ITEM_NAME = "ITEM_NAME";
        public static final String COL_DESCRIPTION = "DESCRIPTION";
        public static final String COL_PRICE = "PRICE";
        public static final String COL_TYPE = "TYPE";

        public static final String CREATE_TABLE =

                "CREATE TABLE " + TABLE_NAME
                + "(" + COL_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_ITEM_NAME + " TEXT "
                + COL_DESCRIPTION + " TEXT "
                + COL_PRICE + " REAL "
                + COL_TYPE + " TEXT )";

        private SQLiteOpenHelper mInstance;

        public  SQLiteOpenHelper getInstance(Context context) {
            if (mInstance == null) {

                mInstance = new SQLiteOpenHelper(context.getApplicationContext());
            }
            return mInstance;
        }

        private SQLiteOpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            this.onCreate(db);
        }

        public List<ItemsObject> searchForGroceryItem(String query) {

            SQLiteDatabase db = getReadableDatabase();

            Cursor cursor = db.query(TABLE_NAME, new String[] {

                    COL_ITEM_NAME,
                    COL_DESCRIPTION,
                    COL_PRICE,
                    COL_TYPE},
                    null, null, null, null, null);

            List<ItemsObject> itemsList = new ArrayList<>();

            if (cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {
                    String name = cursor.getString(cursor.getColumnIndex(COL_ITEM_NAME));
                    String description = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION));
                    String price = cursor.getString(cursor.getColumnIndex(COL_PRICE));
                    String type = cursor.getString(cursor.getColumnIndex(COL_TYPE));

                    ItemsObject object = new ItemsObject(name, description, type, price);

                    itemsList.add(object);

                    cursor.moveToNext();
                }
            }
            cursor.close();
            return itemsList;

        }
    }
}
