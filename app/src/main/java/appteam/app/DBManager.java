package appteam.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;


public class DBManager extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "LocalDB.db";
    public static final String OWNGIFTS_TABLE_NAME = "own_gifts";
    public static final String OWNGIFTS_COLUMN_ID = "id";
    public static final String OWNGIFTS_COLUMN_TITLE = "title";
    public static final String OWNGIFTS_COLUMN_PRICE = "price";
    public static final String OWNGIFTS_COLUMN_LOC_LAT = "location_lat";
    public static final String OWNGIFTS_COLUMN_LOC_LON = "location_lon";
    public static final String OWNGIFTS_COLUMN_URL = "url";
    public static final String OWNGIFTS_COLUMN_IMG_PATH = "image_path";
    private HashMap hp;

    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table own_gifts " +
                        "(id integer primary key,title text,price integer,location_lat integer,location_lon integer,url text,image_path text )"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS own_gifts");
        onCreate(db);
    }

    public boolean insertGift(String title, String price, String location_lat, String location_lon, String url, String image_path) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("price", price);
        contentValues.put("location_lat", location_lat);
        contentValues.put("street", location_lon);
        contentValues.put("url", url);
        //contentValues.put("image_path", image_path);
        db.insert("own_gifts", null, contentValues);
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from own_gifts where id=" + id + "", null);
        return res;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, OWNGIFTS_TABLE_NAME);
        return numRows;
    }

    public boolean updateGift(Integer id,String title, String price, String location_lat, String location_lon, String url, String image_path) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("price", price);
        contentValues.put("location_lat", location_lat);
        contentValues.put("location_lon", location_lon);
        contentValues.put("url", url);
        contentValues.put("image_path", image_path);
        db.update("own_gifts", contentValues, "id = ? ", new String[]{Integer.toString(id)});
        return true;
    }

    /*
    public boolean checkGiftDB(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("price", price);
        contentValues.put("location_lat", location_lat);
        contentValues.put("location_lon", location_lon);
        contentValues.put("url", url);
        contentValues.put("image_path", image_path);
        db.update("own_gifts", contentValues, "id = ? ", new String[]{Integer.toString(id)});
        return true;
    }
    */

    public Integer deleteGift(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("own_gifts",
                "id = ? ",
                new String[]{Integer.toString(id)});
    }

    public ArrayList<String> getAllGifts() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from own_gifts", null);
        res.moveToFirst();

        while (!res.isAfterLast()) {
            array_list.add(res.getString(res.getColumnIndex(OWNGIFTS_TABLE_NAME)));
            res.moveToNext();
        }
        return array_list;
    }
}

