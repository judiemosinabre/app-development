package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String selectedItem = null;
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

        Spinner spinner = findViewById(R.id.spinner);
        // tab on AdapterView to generate full code
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();
                selectedItem =  item;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Item Declaration
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Red");
        arrayList.add("Blue");
        arrayList.add("Yellow");

        //Populate the Spinner
        ArrayAdapter<String> adt = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arrayList);
        adt.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adt);
    }

    // Function for Button
    public void sendItem(View v){
        Intent i = new Intent(this, Receiver.class);
        i.putExtra("selectedItem", selectedItem);
        startActivity(i);
    }
}