package com.example.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManagerNonConfig;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.os.AsyncTask;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    boolean start_app = true;
    private FloatingActionButton floatingActionButton;
    private TabLayout tabLayout;
    String name = new String();
    String surname = new String();
    String car = new String();
    String model = new String();
    String country = new String();
    String city = new String();
    String street = new String();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null){
           getSupportFragmentManager().beginTransaction().add(R.id.MainContainer, new FragmentTable1()).commit();
        }

        if (start_app) {
            saveName("Alex", "Serzhantov");
            saveCar("Lada", "Vesta");
            saveAddress("Russia", "Nighny Novgorod", "Rostovskaya 30");
            saveName("Oleg", "Eldov");
            saveCar("Tesla", "ModelX");
            saveAddress("Russia", "Nighny Novgorod", "Rostovskaya 30");
            saveName("Olga", "Serzhantova");
            saveCar("Mercedes", "A1");
            saveAddress("Russia", "Nighny Novgorod", "Rostovskaya 30");
            saveName("Sasha", "Turshatov");
            saveCar("Lada", "Largus");
            saveAddress("Russia", "Nighny Novgorod", "Korablestroiteley 18");
            saveName("Luda", "Turshatova");
            saveCar("Lada", "Kalina");
            saveAddress("Russia", "Nighny Novgorod", "Korablestroiteley 18");
            saveName("Stella", "Serzhantova");
            saveCar("Toyota", "Supra");
            saveAddress("Russia", "Moscow", "Kashtayanca 3");
            saveName("Tessa", "Serzhantova");
            saveCar("Nissan", "Skyline");
            saveAddress("USA", "New York", "Sunny 7");
            saveName("Sergey", "Yashin");
            saveCar("Ford", "Focus");
            saveAddress("Russia", "Nighny Novgorod", "Zaozernaya 63");
            saveName("Sergey", "Voronin");
            saveCar("Audi", "A3");
            saveAddress("Russia", "Nigny Novgorod", "Zaozernaya 63");
            saveName("Denis", "Voronin");
            saveCar("Lada", "Granta");
            saveAddress("Russia", "Nighny Novgorod", "Palehskaya 21");
            start_app = false;
        }

        tabLayout = findViewById(R.id.tabLayout);
        floatingActionButton = findViewById(R.id.fab);

        Bundle data = getIntent().getExtras();

        if (data != null) {
            name = data.getString("name");
            surname = data.getString("surname");
            car = data.getString("car");
            model = data.getString("model");
            country = data.getString("country");
            city = data.getString("city");
            street = data.getString("street");

            if ((name.length() == 0) || (surname.length() == 0) || (car.length() == 0) || (model.length() == 0) || (country.length() == 0) || (city.length() == 0) || (street.length() == 0))
                Toast.makeText(MainActivity.this, "Incomplete information", Toast.LENGTH_LONG).show();
            else {
                saveName(name, surname);
                saveCar(car, model);
                saveAddress(country, city, street);
            }
        }

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, addedData.class);
                startActivity(intent);
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        getSupportFragmentManager().beginTransaction().replace(R.id.MainContainer, new FragmentTable1()).commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.MainContainer, new FragmentTable2()).commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.MainContainer, new FragmentTable3()).commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void saveName(String Name, String Surname) {
        class SaveTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {

                //creating a task
                Citizens name = new Citizens();
                name.setName(Name);
                name.setSurname(Surname);

                //adding to database
                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                        .CitizensDao()
                        .insertCitizens(name);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        }

        SaveTask st = new SaveTask();
        st.execute();
    }

    private void saveCar(String Car, String Model) {
        class SaveTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {

                //creating a task
                Cars car = new Cars();
                car.setCar(Car);
                car.setModel(Model);

                //adding to database
                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                        .CitizensDao()
                        .insertCars(car);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        }

        SaveTask st = new SaveTask();
        st.execute();
    }

    private void saveAddress(String Country, String City, String Street) {
        class SaveTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {

                //creating a task
                Addresses address = new Addresses();
                address.setCountry(Country);
                address.setCity(City);
                address.setStreet(Street);

                //adding to database
                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                        .CitizensDao()
                        .insertAddresses(address);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        }

        SaveTask st = new SaveTask();
        st.execute();
    }
}