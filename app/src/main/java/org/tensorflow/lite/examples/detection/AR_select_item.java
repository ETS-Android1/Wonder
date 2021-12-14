package org.tensorflow.lite.examples.detection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class AR_select_item extends AppCompatActivity {

    Spinner spinner_g;
    Spinner spinner_item;

    Button item_select_complete_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_select_item);


        spinner_item=(Spinner) findViewById(R.id.spinner_item);
        ArrayAdapter itemAdapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_item_list, android.R.layout.simple_spinner_dropdown_item);
        spinner_item.setAdapter(itemAdapter);

        spinner_g = (Spinner) findViewById(R.id.spinner_g);
        ArrayAdapter gAdapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_item_list, android.R.layout.simple_spinner_dropdown_item);
        spinner_g.setAdapter(gAdapter);


        item_select_complete_btn = (Button) findViewById(R.id.item_select_complete);
        item_select_complete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DetectorActivity.class);
                startActivity(intent);
            }
        });

    }
}