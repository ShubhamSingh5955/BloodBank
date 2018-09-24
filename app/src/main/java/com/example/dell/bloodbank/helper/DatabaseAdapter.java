package com.example.dell.bloodbank.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.dell.bloodbank.AddDonorActivity;
import com.example.dell.bloodbank.model.Donor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 9/22/2018.
 */

public class DatabaseAdapter  {

    DatabaseHelper databaseHelper;

    public DatabaseAdapter(Context context) {
        databaseHelper=new DatabaseHelper(context);
    }

    public long insertDonor(String name,String phone,String address,String group) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DatabaseHelper.COLUMN_NAME, name);
        values.put(DatabaseHelper.COLUMN_PHONE, phone);
        values.put(DatabaseHelper.COLUMN_ADDRESS, address);
        values.put(DatabaseHelper.COLUMN_GROUP, group);

        long id = db.insert(DatabaseHelper.TABLE_NAME, null, values);
        db.close();

        return id;
    }
    public List<Donor> getDonor(String group) {
        // get readable database as we are not inserting anything
        List<Donor> donors = new ArrayList<Donor>();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME,
                new String[]{DatabaseHelper.COLUMN_ID, DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_PHONE,DatabaseHelper.COLUMN_ADDRESS,DatabaseHelper.COLUMN_GROUP},
                DatabaseHelper.COLUMN_GROUP + "=?",
                new String[]{group}, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                Donor donor = new Donor(
                        cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_PHONE)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_ADDRESS)),
                        cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_GROUP)));

                donors.add(donor);
            } while (cursor.moveToNext());
        }
        // close the db connection
        cursor.close();

        return donors;
    }

   static class DatabaseHelper extends SQLiteOpenHelper{

        public static final String TABLE_NAME = "DONORSTABLE";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PHONE = "phone";
        public static final String COLUMN_ADDRESS = "address";
        public static final String COLUMN_GROUP = "bloodGroup";

       private static final String CREATE_TABLE="CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " VARCHAR(255), " + COLUMN_PHONE + " VARCHAR(255), " + COLUMN_ADDRESS + " VARCHAR(255), " + COLUMN_GROUP + " VARCHAR(255));";
       private static final String DROP_TABLE="DROP TABLE IF EXISTS " +TABLE_NAME ;

        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "donorsDatabase";
        private Context context;


        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context=context;
            Toast.makeText(context,"constructer called",Toast.LENGTH_SHORT).show();
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(CREATE_TABLE);
                Toast.makeText(context,"onCreate called",Toast.LENGTH_LONG).show();
            }catch (SQLiteException e){
                Toast.makeText(context,"onCreate not called",Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }



  /*  public long insertDonor(String name,String phone,String address,String group) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
         // no need to add them
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_PHONE, phone);
        values.put(COLUMN_ADDRESS, address);
        values.put(COLUMN_GROUP, group);
        // insert row
        long id = db.insert(TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public Donor getNote(String group) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME,
                new String[]{COLUMN_ID, COLUMN_NAME, COLUMN_PHONE,COLUMN_ADDRESS,COLUMN_GROUP},
                COLUMN_GROUP + "=?",
                new String[]{group}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare Donor object
        Donor donor = new Donor(
                cursor.getInt(cursor.getColumnIndex(COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndex(COLUMN_PHONE)),
                cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS)),
                cursor.getString(cursor.getColumnIndex(COLUMN_GROUP)));

        // close the db connection
        cursor.close();

        return donor;
    }
*/

    }
}
