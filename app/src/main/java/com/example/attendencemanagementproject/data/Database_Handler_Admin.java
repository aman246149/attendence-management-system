package com.example.attendencemanagementproject.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.attendencemanagementproject.Model.Admin_detail;
import com.example.attendencemanagementproject.Model.Teacher_Detail;
import com.example.attendencemanagementproject.R;
import com.example.attendencemanagementproject.Util.Util_Admin;
import com.example.attendencemanagementproject.Util.Util_Teacher;

import java.util.ArrayList;
import java.util.List;

public class Database_Handler_Admin extends SQLiteOpenHelper {
    public Database_Handler_Admin(Context context) {
        super(context, Util_Admin.DATABASE_NAME, null,Util_Admin.DATABASE_VERSION);
    }
    // to create our table
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_ADMIN_TABLE = "CREATE TABLE "+ Util_Admin.TABLE_NAME+"("+ Util_Admin.KEY_ID+" INTEGER PRIMARY KEY,"+ Util_Admin.KEY_ADMIN_ID+" INTEGER UNIQUE,"+Util_Admin.KEY_NAME+" TEXT,"+ Util_Admin.KEY_MOBILE_NO+" TEXT,"+Util_Admin.KEY_PASSWORD+" TEXT"+")";
        db.execSQL(CREATE_ADMIN_TABLE);//to create table
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE = String.valueOf(R.string.DROP_TABLE);
        db.execSQL(DROP_TABLE, new String[]{Util_Admin.TABLE_NAME});
        //to Create a table again
        onCreate(db);
    }
    // to add detail of a Admin
    public  void add_Admin_detail(Admin_detail admin_detail)
    {
        // can get the primary key value on inserting a new row
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(Util_Admin.KEY_NAME,admin_detail.getName());
        values.put(Util_Admin.KEY_MOBILE_NO,admin_detail.getMobile_no());
        values.put(Util_Admin.KEY_ADMIN_ID,admin_detail.getAdmin_id());
        values.put(Util_Admin.KEY_PASSWORD,admin_detail.getPassword());
        db.insert(Util_Admin.TABLE_NAME,null,values);
        db.close();
    }
    // to get a individual Admin detail
    public Admin_detail get_detail(String admin_id )
    {
        SQLiteDatabase db = this.getReadableDatabase();

        // Filter results WHERE "title" = 'My Title'
        String selection = Util_Admin.KEY_ADMIN_ID+ " = ?";
        String[] selectionArgs = {admin_id };
        Cursor cursor = db.query(Util_Admin.TABLE_NAME,   // The table to query
                null,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,null                // don't filter by row group
        );
        if(cursor != null)
            cursor.moveToFirst();
        Admin_detail admin_detail = new Admin_detail();
        admin_detail .setId(Integer.parseInt(cursor.getString(0)));
        admin_detail .setAdmin_id(Integer.parseInt(cursor.getString(1)));
        admin_detail .setName(cursor.getString(2));
        admin_detail .setMobile_no(cursor.getString(3));
        admin_detail .setPassword(cursor.getString(4));
        return admin_detail;
    }
    //to get all Admin Detail
    public List<Admin_detail> getAll_Admin_Detail() {
        List<Admin_detail> admin_detailList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectAll = "SELECT * FROM " + Util_Admin.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAll, null);
        //to loop through our data
        if (cursor.moveToFirst()) {
            do {
                Admin_detail admin_detail = new Admin_detail();
                admin_detail.setId(Integer.parseInt(cursor.getString(0)));
                admin_detail.setAdmin_id(Integer.parseInt(cursor.getString(1)));
                admin_detail.setName(cursor.getString(2));
                admin_detail.setMobile_no(cursor.getString(3));
                admin_detail.setPassword(cursor.getString(4));
                admin_detailList.add(admin_detail);
            } while (cursor.moveToNext());
        }
        return admin_detailList;
    }
    //To update database
    public int updateAdminDetail(Admin_detail admin_detail)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(Util_Admin.KEY_NAME, admin_detail.getName());
        values.put(Util_Admin.KEY_MOBILE_NO, admin_detail.getMobile_no());
        values.put(Util_Admin.KEY_ADMIN_ID, admin_detail.getAdmin_id());
        values.put(Util_Admin.KEY_PASSWORD, admin_detail.getPassword());
        return db.update(Util_Admin.TABLE_NAME,values, Util_Admin.KEY_ADMIN_ID+" =? ",
                new String[]{String.valueOf(admin_detail.getAdmin_id())});
    }
    //TO delete a Admin detail
    public void delete_Admin_detail(Admin_detail admin_detail)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Util_Admin.TABLE_NAME, Util_Admin.KEY_ADMIN_ID+" =? ",
                new String[]{String.valueOf(admin_detail.getAdmin_id())});
        db.close();
    }
    //To count the Admin
    public int getCount()
    {
        String countQuery ="SELECT * FROM "+ Util_Admin.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        return cursor.getCount();
    }
    //to check password
    public boolean check_Password(String admin_id,String password)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection ={Util_Admin.KEY_PASSWORD, Util_Admin.KEY_ADMIN_ID};
        String selection = Util_Admin.KEY_ADMIN_ID+ " = ?";
        String[] selectionArgs = { admin_id };
        Cursor cursor = db.query(Util_Admin.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,null);
        if(cursor!=null)
            cursor.moveToNext();
        assert cursor != null;
        String check_pass = cursor.getString(cursor.getColumnIndex(Util_Admin.KEY_PASSWORD));
        if(check_pass.equals( password))
        {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean if_avilable(String admin_id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectAll = "SELECT "+ Util_Admin.KEY_ADMIN_ID+" FROM " + Util_Admin.TABLE_NAME +" where " + Util_Admin.KEY_ADMIN_ID+ " =? ";
        String[] selectionArgs = {admin_id };
        Cursor cursor = db.rawQuery(selectAll, selectionArgs);
        if(cursor.getCount()<=0)
        {
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }



}
