package com.example.attendencemanagementproject.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.attendencemanagementproject.Modle.Student_Detail;
import com.example.attendencemanagementproject.Util.Util;

import java.util.ArrayList;
import java.util.List;

import static com.example.attendencemanagementproject.Util.Util.DATABASE_NAME;
import static com.example.attendencemanagementproject.Util.Util.DATABASE_VERSION;
import static com.example.attendencemanagementproject.Util.Util.KEY_ID;
import static com.example.attendencemanagementproject.Util.Util.KEY_STUDENT_ID;
import static com.example.attendencemanagementproject.Util.Util.TABLE_NAME;

public class DATABASE_HANDLER_Student extends SQLiteOpenHelper {


    public DATABASE_HANDLER_Student(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    // we create our table
    @Override
    public void onCreate(SQLiteDatabase db) {
        /*
         Util.TABLE_NAME,Util.KEY_INDEX, Util.KEY_STUDENT_ID, Util.KEY_STUDENT_NAME, Util.KEY_PHONE_NUMBER, Util.KEY_FATHER_NAME, Util.KEY_BRANCH, Util.KEY_GENDER, Util.KEY_ROLL_NUMBER, Util.KEY_YEAR, Util.KEY_SEMESTER,Util.KEY_STUDENT_COURSE,Util.KEY_DOB,Util.KEY_PASSWORD
         */

        String CREATE_CONTACT_TABLE = "CREATE TABLE "+ TABLE_NAME+"("+ KEY_ID+" INTEGER PRIMARY KEY,"+ KEY_STUDENT_ID+" INTEGER UNIQUE,"+ Util.KEY_STUDENT_NAME+" TEXT,"+ Util.KEY_PHONE_NUMBER
                                       +" TEXT,"+ Util.KEY_FATHER_NAME+" TEXT,"+ Util.KEY_BRANCH+" TEXT,"+ Util.KEY_GENDER+" TEXT,"+ Util.KEY_ROLL_NUMBER+" INTEGER,"+ Util.KEY_YEAR+" INTEGER,"+ Util.KEY_SEMESTER+" INTEGER,"
                + Util.KEY_STUDENT_COURSE+" TEXT,"+ Util.KEY_DOB+" TEXT,"+ Util.KEY_PASSWORD+" TEXT" +")";
        db.execSQL(CREATE_CONTACT_TABLE);//to create table
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE = String.valueOf("DROP TABLE IF EXISTS");
        db.execSQL(DROP_TABLE, new String[]{Util.DATABASE_NAME});
        //to Create a table again
        onCreate(db);
    }
    public  void add_student_detail(Student_Detail student_detail)
    {
        // can get the primary key value on inserting a new row
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(Util.KEY_STUDENT_NAME, student_detail.getName());
        values.put(Util.KEY_PHONE_NUMBER,student_detail.getPhone_number());
        values.put(Util.KEY_FATHER_NAME,student_detail.getFather_name());
        values.put(Util.KEY_STUDENT_ID,student_detail.getStudent_id());
        values.put(Util.KEY_ROLL_NUMBER,student_detail.getRoll_number());
        values.put(Util.KEY_BRANCH,student_detail.getBranch());
        values.put(Util.KEY_GENDER,student_detail.getGender());
        values.put(Util.KEY_SEMESTER,student_detail.getSemester());
        values.put(Util.KEY_STUDENT_COURSE,student_detail.getCourse());
        values.put(Util.KEY_YEAR,student_detail.getYear());
        values.put(Util.KEY_DOB,student_detail.getDob());
        values.put(Util.KEY_PASSWORD,student_detail.getPassword());
        db.insert(Util.TABLE_NAME,null,values);
        db.close();
    }
    /*
     Util.KEY_BRANCH, Util.KEY_GENDER, Util.KEY_ROLL_NUMBER, Util.KEY_YEAR, Util.KEY_SEMESTER,Util.KEY_STUDENT_COURSE
     */

    public Student_Detail get_detail(String student_id )
    {
        SQLiteDatabase db = this.getReadableDatabase();
       /* String[] projection = {Util.KEY_ID, Util.KEY_STUDENT_ID,
                Util.KEY_STUDENT_NAME, Util.KEY_PHONE_NUMBER, Util.KEY_FATHER_NAME,
                Util.KEY_BRANCH, Util.KEY_GENDER, Util.KEY_ROLL_NUMBER, Util.KEY_YEAR,
                Util.KEY_SEMESTER,Util.KEY_STUDENT_COURSE};
*/
// Filter results WHERE "title" = 'My Title'
        String selection = Util.KEY_STUDENT_ID + " = ?";
        String[] selectionArgs = { student_id };
        Cursor cursor = db.query(Util.TABLE_NAME,   // The table to query
                null,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,null                // don't filter by row group
        );
       if(cursor != null)
            cursor.moveToFirst();
        Student_Detail student_detail = new Student_Detail();
        student_detail.setId(Integer.parseInt(cursor.getString(0)));
        student_detail.setStudent_id(Integer.parseInt(cursor.getString(1)));
        student_detail.setName(cursor.getString(2));
        student_detail.setPhone_number(cursor.getString(3));
        student_detail.setFather_name(cursor.getString(4));
        student_detail.setBranch(cursor.getString(5));
        student_detail.setGender(cursor.getString(6));
        student_detail.setRoll_number(Integer.parseInt(cursor.getString(7)));
        student_detail.setYear(Integer.parseInt(cursor.getString(8)));
        student_detail.setSemester(Integer.parseInt(cursor.getString(9)));
        student_detail.setCourse(cursor.getString(10));
        student_detail.setDob(cursor.getString(11));
        student_detail.setPassword(cursor.getString(12));
        return student_detail;
    }
    //to get all contact
    public List<Student_Detail> getAll_Stu_Detail() {
        List<Student_Detail> student_detailList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectAll = "SELECT * FROM " + Util.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAll, null);
        //to loop through our data
        if (cursor.moveToFirst()) {
            do {
                Student_Detail student_detail = new Student_Detail();
               student_detail.setId(Integer.parseInt(cursor.getString(0)));
                student_detail.setStudent_id(Integer.parseInt(cursor.getString(1)));
                student_detail.setName(cursor.getString(2));
                student_detail.setPhone_number(cursor.getString(3));
                student_detail.setFather_name(cursor.getString(4));
                student_detail.setBranch(cursor.getString(5));
                student_detail.setGender(cursor.getString(6));
                student_detail.setRoll_number(Integer.parseInt(cursor.getString(7)));
                student_detail.setYear(Integer.parseInt(cursor.getString(8)));
                student_detail.setSemester(Integer.parseInt(cursor.getString(9)));
                student_detail.setCourse(cursor.getString(10));
                student_detail.setDob(cursor.getString(11));
                student_detail.setPassword(cursor.getString(12));
                student_detailList.add(student_detail);
            } while (cursor.moveToNext());
        }
        return student_detailList;
    }
    //To update database
    public int updateStudentDetail(Student_Detail student_detail)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(Util.KEY_STUDENT_NAME, student_detail.getName());
        values.put(Util.KEY_PHONE_NUMBER,student_detail.getPhone_number());
        values.put(Util.KEY_FATHER_NAME,student_detail.getFather_name());
        values.put(Util.KEY_STUDENT_ID,student_detail.getStudent_id());
        values.put(Util.KEY_ROLL_NUMBER,student_detail.getRoll_number());
        values.put(Util.KEY_BRANCH,student_detail.getBranch());
        values.put(Util.KEY_GENDER,student_detail.getGender());
        values.put(Util.KEY_SEMESTER,student_detail.getSemester());
        values.put(Util.KEY_STUDENT_COURSE,student_detail.getCourse());
        values.put(Util.KEY_YEAR,student_detail.getYear());
        values.put(Util.KEY_DOB,student_detail.getDob());
        values.put(Util.KEY_PASSWORD,student_detail.getPassword());
        return db.update(Util.TABLE_NAME,values,Util.KEY_STUDENT_ID+"=?",
                new String[]{String.valueOf(student_detail.getStudent_id())});
    }
    //TO delete a Contact
    public void delete_Stu_detail(Student_Detail student_detail)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Util.TABLE_NAME,Util.KEY_STUDENT_ID+"=?",
                new String[]{String.valueOf(student_detail.getStudent_id())});
        db.close();
    }
    //To count the Contacts
    public int getCount()
    {
        String countQuery ="SELECT * FROM "+ Util.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        return cursor.getCount();
    }
    //to check password
    public boolean check_Password(String student_id,String password)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection ={Util.KEY_PASSWORD,Util.KEY_STUDENT_ID};
        String selection = Util.KEY_STUDENT_ID + " = ?";
        String[] selectionArgs = { student_id };
        Cursor cursor = db.query(Util.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,null);
        if(cursor!=null)
            cursor.moveToNext();
        assert cursor != null;
        String check_pass = cursor.getString(cursor.getColumnIndex(Util.KEY_PASSWORD));
        if(check_pass.equals( password))
        {
            return true;
        }
        else {
            return false;
        }
    }

}
