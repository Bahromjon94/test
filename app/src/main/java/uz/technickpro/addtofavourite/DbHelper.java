package uz.technickpro.addtofavourite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;
    Context context;

    private static final String DATABASE_NAME = "database.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_FAV = "favourites";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_FAV = "favourite";


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String fav = " CREATE TABLE " + TABLE_FAV + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_NAME + " TEXT, " + KEY_FAV + " TEXT);";

        db.execSQL(fav);
    }


    public long insertFav(FavPojo pojo) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, pojo.getName());
        values.put(KEY_FAV, pojo.isFav());

        long insertLong = db.insert(TABLE_FAV, null, values);
        db.close();
        return insertLong;

    }

    public void updateFav(long l,String fav) {

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_FAV, fav);

        long updateFavLong = db.update(TABLE_FAV, values, KEY_ID + "=" + l, null);
        db.close();

    }

    public List<FavPojo> pojos() {

        List<FavPojo> pojos = new ArrayList<>();
        db = this.getReadableDatabase();
        String s = "select * from " + TABLE_FAV;
        Cursor cursor = db.rawQuery(s, null);

        if (cursor.moveToFirst()) {
            do {
                pojos.add(new FavPojo(cursor.getInt(cursor.getColumnIndex(KEY_ID)),
                        cursor.getString(cursor.getColumnIndex(KEY_NAME)),
                        cursor.getString(cursor.getColumnIndex(KEY_FAV))));
            } while (cursor.moveToNext());
        }
        db.close();
        return pojos;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
