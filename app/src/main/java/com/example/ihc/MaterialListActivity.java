package com.example.ihc;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MaterialListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_list);

        String[] materials = {
                "Papel y cartón",
                "Vidrio",
                "Plástico",
                "Metal",
                "Electrónicos",
                "Pilas y baterías",
                "Textiles",
                "Orgánicos"
        };

        ListView listView = findViewById(R.id.materialListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                materials
        );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedMaterial = materials[position];
                Toast.makeText(MaterialListActivity.this,
                        "Diste clic a " + selectedMaterial,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}