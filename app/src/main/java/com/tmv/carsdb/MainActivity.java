package com.tmv.carsdb;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import data.DataBaseHandler;
import model.Student;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        DataBaseHandler dataBaseHandler = new DataBaseHandler(this);
        dataBaseHandler.addStudent(new Student("Design", "Pupkin", "Ivan", 4.1));
        dataBaseHandler.addStudent(new Student("Management", "Sidorov", "Sergey", 3.4));
        dataBaseHandler.addStudent(new Student("ComputerScience", "Ivanov", "Pavel", 4.9));
        dataBaseHandler.addStudent(new Student("Sports", "Lomakin", "Artur", 2.1));
        dataBaseHandler.addStudent(new Student("Math", "Olenin", "Ruslan", 4.5));

        List<Student> studentList = dataBaseHandler.getAllStudents();
        for (Student student : studentList) {
            Log.d("Student Info: ", "ID " + student.getId() + ", faculty " + student.getFaculty()
                    + ", secondName  " + student.getSecondName() + ", firstName " +
                    student.getFirstName() + ", averageScore " + student.getAverageScore());
        }
    }
}