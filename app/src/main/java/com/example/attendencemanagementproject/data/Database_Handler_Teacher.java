package com.example.attendencemanagementproject.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.attendencemanagementproject.Model.Teacher_Detail;
import com.example.attendencemanagementproject.R;
import com.example.attendencemanagementproject.Util.Util_Student;
import com.example.attendencemanagementproject.Util.Util_Teacher;

import java.util.ArrayList;
import java.util.List;

import static com.example.attendencemanagementproject.Util.Util_Student.KEY_STUDENT_ID;


public class Database_Handler_Teacher extends SQLiteOpenHelper {


    public Database_Handler_Teacher(Context context) {
        super(context, Util_Teacher.DATABASE_NAME, null,Util_Teacher.DATABASE_VERSION);
    }
    // to create our table
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TEACHER_TABLE = "CREATE TABLE "+ Util_Teacher.TABLE_NAME+"("+ Util_Teacher.KEY_ID+" INTEGER PRIMARY KEY,"+ Util_Teacher.KEY_TEACHER_ID+" INTEGER UNIQUE,"+Util_Teacher.KEY_NAME+" TEXT,"+ Util_Teacher.KEY_MOBILE_NO+" TEXT,"+Util_Teacher.KEY_PASSWORD+" TEXT"+")";
        db.execSQL(CREATE_TEACHER_TABLE);//to create table
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE = String.valueOf(R.string.DROP_TABLE);
        db.execSQL(DROP_TABLE, new String[]{DROP_TABLE});
        //to Create a table again
        onCreate(db);
    }
    // to add detail of a teacher
    public  void add_Teacher_detail(Teacher_Detail teacher_detail)
    {
        // can get the primary key value on inserting a new row
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(Util_Teacher.KEY_NAME,teacher_detail.getName());
        values.put(Util_Teacher.KEY_MOBILE_NO,teacher_detail.getMobile_no());
        values.put(Util_Teacher.KEY_TEACHER_ID,teacher_detail.getTeacher_id());
        values.put(Util_Teacher.KEY_PASSWORD,teacher_detail.getPassword());
        db.insert(Util_Teacher.TABLE_NAME,null,values);
        db.close();
    }
    // to get a individual teacher detail
    public Teacher_Detail get_detail(String Teacher_id )
    {
        SQLiteDatabase db = this.getReadableDatabase();

        // Filter results WHERE "title" = 'My Title'
        String selection = Util_Teacher.KEY_TEACHER_ID + " = ?";
        String[] selectionArgs = { Teacher_id };
        Cursor cursor = db.query(Util_Teacher.TABLE_NAME,   // The table to query
                null,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,null                // don't filter by row group
        );
        if(cursor != null)
            cursor.moveToFirst();
        Teacher_Detail teacher_detail = new Teacher_Detail();
        teacher_detail.setId(Integer.parseInt(cursor.getString(0)));
        teacher_detail.setTeacher_id(Integer.parseInt(cursor.getString(1)));
        teacher_detail.setName(cursor.getString(2));
        teacher_detail.setMobile_no(cursor.getString(3));
        teacher_detail.setPassword(cursor.getString(4));
        return teacher_detail;
    }
    //to get all Teacher Detail
    public List<Teacher_Detail> getAll_Teacher_Detail() {
        List<Teacher_Detail> teacherDetailList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectAll = "SELECT * FROM " + Util_Teacher.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAll, null);
        //to loop through our data
        if (cursor.moveToFirst()) {
            do {
                Teacher_Detail teacher_detail = new Teacher_Detail();
                teacher_detail.setId(Integer.parseInt(cursor.getString(0)));
                teacher_detail.setTeacher_id(Integer.parseInt(cursor.getString(1)));
                teacher_detail.setName(cursor.getString(2));
                teacher_detail.setMobile_no(cursor.getString(3));
                teacher_detail.setPassword(cursor.getString(4));
                teacherDetailList.add(teacher_detail);
            } while (cursor.moveToNext());
        }
        return teacherDetailList;
    }
    //To update database
    public int updateTeacherDetail(Teacher_Detail teacher_detail)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(Util_Teacher.KEY_NAME,teacher_detail.getName());
        values.put(Util_Teacher.KEY_MOBILE_NO,teacher_detail.getMobile_no());
        values.put(Util_Teacher.KEY_TEACHER_ID,teacher_detail.getTeacher_id());
        values.put(Util_Teacher.KEY_PASSWORD,teacher_detail.getPassword());
        return db.update(Util_Teacher.TABLE_NAME,values, Util_Teacher.KEY_TEACHER_ID+"=?",
                new String[]{String.valueOf(teacher_detail.getTeacher_id())});
    }
    //TO delete a Teacher detail
    public void delete_Teacher_detail(Teacher_Detail teacher_detail)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Util_Teacher.TABLE_NAME, Util_Teacher.KEY_TEACHER_ID+"=?",
                new String[]{String.valueOf(teacher_detail.getTeacher_id())});
        db.close();
    }
    //To count the Teacher
    public int getCount()
    {
        String countQuery ="SELECT * FROM "+ Util_Teacher.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        return cursor.getCount();
    }
    //to check password
    public boolean check_Password(String teacher_id,String password)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection ={Util_Teacher.KEY_PASSWORD, Util_Teacher.KEY_TEACHER_ID};
        String selection = Util_Teacher.KEY_TEACHER_ID+ " = ?";
        String[] selectionArgs = { teacher_id };
        Cursor cursor = db.query(Util_Teacher.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,null);
        if(cursor!=null)
            cursor.moveToNext();
        assert cursor != null;
        String check_pass = cursor.getString(cursor.getColumnIndex(Util_Teacher.KEY_PASSWORD));
        if(check_pass.equals( password))
        {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean if_avilable(String teacher_Id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectAll = "SELECT "+ Util_Teacher.KEY_TEACHER_ID+" FROM " + Util_Teacher.TABLE_NAME +" where " + Util_Teacher.KEY_TEACHER_ID+ " =? ";
        String[] selectionArgs = {teacher_Id };
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

