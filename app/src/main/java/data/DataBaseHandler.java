package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import model.Student;
import utils.Util;

public class DataBaseHandler extends SQLiteOpenHelper {
    public DataBaseHandler(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STUDENTS_TABLE = "CREATE TABLE " + Util.TABLE_NAME + "(" +
                Util.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Util.KEY_FACULTY + " TEXT," +
                Util.KEY_SECONDNAME + " TEXT," +
                Util.KEY_FIRSTNAME + " TEXT," +
                Util.KEY_AVERAGESCORE + " REAL" + ")";
        db.execSQL(CREATE_STUDENTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Util.TABLE_NAME);
        onCreate(db);
    }


    public void addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Util.KEY_FACULTY, student.getFaculty());
        contentValues.put(Util.KEY_SECONDNAME, student.getSecondName());
        contentValues.put(Util.KEY_FIRSTNAME, student.getFirstName());
        contentValues.put(Util.KEY_AVERAGESCORE, student.getAverageScore());

        db.insert(Util.TABLE_NAME, null, contentValues);
        db.close();
    }

    public Student getStudent(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Util.TABLE_NAME, new String[]{Util.KEY_ID, Util.KEY_FACULTY, Util.KEY_SECONDNAME, Util.KEY_FIRSTNAME, Util.KEY_AVERAGESCORE}, Util.KEY_ID + "=?", new String[]{String.valueOf(id)},
                null, null, null, null);
        Student student = new Student();
        if (cursor != null) {
            try {
            cursor.moveToFirst();
            student = new Student(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), Double.parseDouble(cursor.getString(4)));
            } finally {
                cursor.close();
                db.close();
            }
        }
        return student;
    }

    public List<Student> getAllStudents() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Student> students = new ArrayList<>();
        String selectAllCars = "SELECT * FROM " + Util.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAllCars, null);
        if (cursor.moveToFirst()) {
            try {
            do {
                Student student = new Student();
                student.setId(Integer.parseInt(cursor.getString(0)));
                student.setFaculty(cursor.getString(1));
                student.setSecondName(cursor.getString(2));
                student.setFirstName(cursor.getString(3));
                student.setAverageScore(Double.parseDouble(cursor.getString(4)));
                students.add(student);
            } while (cursor.moveToNext());
        } finally {
                cursor.close();
            }
            }
        return students;
    }
    public int updateStudents(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Util.KEY_FACULTY, student.getFaculty());
        contentValues.put(Util.KEY_SECONDNAME, student.getSecondName());
        contentValues.put(Util.KEY_FIRSTNAME, student.getFirstName());
        contentValues.put(Util.KEY_AVERAGESCORE, student.getAverageScore());

        return db.update(Util.TABLE_NAME, contentValues, Util.KEY_ID + "=?", new String[] {String.valueOf(student.getId())});
    }
    public void deleteStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(Util.TABLE_NAME, Util.KEY_ID + "=?", new String[] {String.valueOf(student.getId())});
        db.close();
    }
    public int getStudentsCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        String countQuery = "SELECT * FROM " + Util.TABLE_NAME;
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = -1;
        try {
            count = cursor.getCount();
        } finally {
            cursor.close();
            db.close();
        }
        return count;
    }
}
