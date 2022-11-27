package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addedData extends AppCompatActivity {

    Button save;
    EditText name, surname, car, model, country, home_town, street;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_added_data);

        save = findViewById(R.id.bsave);
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        car = findViewById(R.id.car);
        model = findViewById(R.id.model);
        country = findViewById(R.id.addressCountry);
        home_town = findViewById(R.id.addressCity);
        street = findViewById(R.id.street);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(addedData.this, MainActivity.class);
                String save_name = name.getText().toString();
                String save_surname = surname.getText().toString();
                String save_car = car.getText().toString();
                String save_model = model.getText().toString();
                String save_country = country.getText().toString();
                String save_home_town = home_town.getText().toString();
                String save_street = street.getText().toString();

                intent.putExtra("name", save_name);
                intent.putExtra("surname", save_surname);
                intent.putExtra("car", save_car);
                intent.putExtra("model", save_model);
                intent.putExtra("country", save_country);
                intent.putExtra("city", save_home_town);
                intent.putExtra("street", save_street);

                startActivity(intent);
            }
        });

    }
}