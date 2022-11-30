package com.sonia.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText text = findViewById(R.id.newText);
        Button addBtn = findViewById(R.id.addBtn);

        ArrayList<String> listData = new ArrayList<>();

        ArrayAdapter<String> adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                listData
        );

        ListView list = findViewById(R.id.listTest);
        list.setAdapter(adapter);

        addBtn.setOnClickListener(
                v->{
                    String textValue = text.getText().toString();
                    if(textValue.isEmpty()){
                        Toast.makeText(this, "Please enter the text!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        listData.add(textValue);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(this, "New value is added!", Toast.LENGTH_SHORT).show();
                        text.setText("");
                    }

                }
        );
        //adapter.notifyDataSetChanged();
    }
}