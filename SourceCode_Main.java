package com.example.aplikasitodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView listView;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        button = findViewById(R.id.btn_add);

        button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
        { additems(view); }
        });
        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>( this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(itemsAdapter);
    }


    private void additems(View view) {
        EditText input = findViewById(R.id.editTextText_Tambah);
        String itemText = input.getText().toString();

        if(!(itemText.equals(""))){
            itemsAdapter.add(itemText);
            input.setText("");
        }
        else{
            Toast.makeText(getApplicationContext(),"", Toast.LENGTH_LONG).show();
        }
    }
}