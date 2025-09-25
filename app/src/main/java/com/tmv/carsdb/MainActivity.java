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
import model.Car;

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
        Log.d("CarsCount:", String.valueOf(dataBaseHandler.getCarsCount()));
//        dataBaseHandler.addCar(new Car("Toyota", "$30000)"));
//        dataBaseHandler.addCar(new Car("Opel", "$25000)"));
//        dataBaseHandler.addCar(new Car("Mercedes", "$50000)"));
//        dataBaseHandler.addCar(new Car("Kia", "$28000)"));
//        dataBaseHandler.addCar(new Car("Masda", "$30000)"));
//        dataBaseHandler.addCar(new Car("Honda", "$25000)"));
//        dataBaseHandler.addCar(new Car("Skoda", "$50000)"));
//        dataBaseHandler.addCar(new Car("Hundai", "$28000)"));

        List<Car> carList = dataBaseHandler.getAllCars();

//        Car deletedCar = dataBaseHandler.getCar(7);
//        dataBaseHandler.deleteCar(deletedCar);
        for (Car car : carList) {
            Log.d("Car Info: ", "ID " + car.getId() + ", name " + car.getName() + ", price  " + car.getPrice());
        }
//        Car car = dataBaseHandler.getCar(1);
//        car.setName("Tesla");
//        car.setPrice("$50000");
//        int updatedCarId = dataBaseHandler.updateCar(car);
//        Log.d("Car Info: ", "ID " + car.getId() + ", name " + car.getName() + ", price  " + car.getPrice() + ", updatedCarId " + updatedCarId);

    }
}