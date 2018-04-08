package vam.whapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by resnet on 3/28/18.
 */

public class LocalDB extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "localuser.db";

    private static final String TABLE_INV = "inventory";
    private static final String COLUMN_ITEM = "item";
    private static final String COLUMN_EXP = "exp";
    private static final String COLUMN_PRICE = "price";
    private static final String COLUMN_LOC = "location";
    private static final String COLUMN_NOTES = "notes";

    private static final String TABLE_LU = "lookup";
    private static final String COLUMN_LUITEM = "lu_item";
    private static final String COLUMN_LUEXP = "lu_exp";
    private static final String COLUMN_LUPRICE = "lu_price";
    private static final String COLUMN_LULOC = "lu_location";
    private static final String COLUMN_LUNOTES = "lu_notes";

    private static final String TABLE_WH = "warehouses";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_OWNER = "owner";
    private static final String COLUMN_MEMBERS = "members";

    private static final String TABLE_USER = "user";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PWORD = "password";
    private static final String COLUMN_PHONE = "phone";

    SQLiteDatabase db;

    private static final String CREATE_TABLE_ITEM = "create table inventory (item text primary key not null, exp text not null, price text not null, location text not null, notes text)" ;

    private static final String CREATE_TABLE_LU = "create table lookup (item text primary key not null, exp text not null, price text not null, location text not null, notes text)";

    private static final String CREATE_TABLE_WH = "create table warehouses (id text primary key not null, owner text not null, members text)";

    private static final String CREATE_TABLE_USER = "create table user (email text primary key not null, password text not null, phone text not null)";



    public LocalDB(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    void insertUser(User u){

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, u.getEmail());
        values.put(COLUMN_PWORD, u.getPword());
        values.put(COLUMN_PHONE, u.getPhone());
//        values.put(COLUMN_ID, u.getId());

        db.insert(TABLE_USER, null, values);
        db.close();
    }


    void insertItem(Item i){

        Log.d("InDB", "In DB, congrats");
        String output = (i.getName() + " " + i.getExp() + " " + i.getPrice() + " " + i.getLoc() + " " + i.getNotes());
        Log.d("DBTag", output);

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ITEM, i.getName());
        values.put(COLUMN_EXP, i.getExp());
        values.put(COLUMN_PRICE, i.getPrice());
        values.put(COLUMN_LOC, i.getLoc());
        values.put(COLUMN_NOTES, i.getNotes());

        db.insert(TABLE_INV, null, values);
        db.close();
    }


    ArrayList<String> getInv(){
        ArrayList<String> list = new ArrayList<String>();

        db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select item from " + TABLE_INV, null);

        if(c!=null){
            if(c.moveToFirst()){
                do{
                    String item = c.getString(c.getColumnIndex("item"));
                    list.add(item);

                }while(c.moveToNext());
            }
        }
        db.close();
        return list;
    }

    boolean isUser(String email, String pword){

        db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select email, password from " + TABLE_USER, null);

        if(c!=null){
            if(c.moveToFirst()){
                do{
                    if(c.getString(0).equals(email)){
                        if(c.getString(1).equals(pword)) {
                            return true;
                        }else{ return false; }
                    }
                }while(c.moveToNext());
            }
        }
        return false;
    }




    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_ITEM);
        db.execSQL(CREATE_TABLE_LU);
        db.execSQL(CREATE_TABLE_WH);
        db.execSQL(CREATE_TABLE_USER);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String query = "DROP TABLE IF EXISTS " + TABLE_INV + ", " + TABLE_LU + ", " + TABLE_WH + ", " + TABLE_USER;
        db.execSQL(query);
        this.onCreate(db);
    }
}
