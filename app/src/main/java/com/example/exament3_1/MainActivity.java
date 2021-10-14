package com.example.exament3_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.exament3_1.adapters.ContactAdapter;
import com.example.exament3_1.personajes.Contacto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rvContacts);
        recyclerView.setHasFixedSize(true); //Si sabes cuantos elementos tiene T si no F
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Qué layout estás utilizado?

        List<Contacto> contactos = new ArrayList<>();

        contactos.add(new Contacto(1, "Arnold", "987654123"));
        contactos.add(new Contacto(2, "Juan", "912345678"));
        contactos.add(new Contacto(3, "Pedro", "985674123"));
        contactos.add(new Contacto(4, "Jorge", "912547635"));
        contactos.add(new Contacto(5, "Andrea", "975684124"));
        contactos.add(new Contacto(6, "Denis", "968532147"));
        contactos.add(new Contacto(7, "Meyler", "975486958"));
        contactos.add(new Contacto(8, "Victor", "985647123"));
        contactos.add(new Contacto(9, "Brayan", "915784685"));
        contactos.add(new Contacto(10, "Kevin", "915736333"));

        recyclerView.setAdapter(new ContactAdapter(contactos));

    }
}