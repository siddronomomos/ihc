package com.example.EcoSort;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.EcoSort.models.ReciclajeRequest;
import com.example.EcoSort.models.ReciclajeResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReciclarActivity extends AppCompatActivity {
    private Spinner spinnerMaterial, spinnerProducto;
    private EditText etPeso;
    private Button btnEnviar;
    private String selectedMaterial, selectedProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciclar);

        spinnerMaterial = findViewById(R.id.spinnerMaterial);
        spinnerProducto = findViewById(R.id.spinnerProducto);
        etPeso = findViewById(R.id.etPeso);
        btnEnviar = findViewById(R.id.btnEnviar);

        setupSpinners();
        setupButton();
    }

    private void setupSpinners() {
        // Materiales
        ArrayAdapter<CharSequence> materialAdapter = ArrayAdapter.createFromResource(this,
                R.array.materiales_array, android.R.layout.simple_spinner_item);
        materialAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMaterial.setAdapter(materialAdapter);

        spinnerMaterial.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedMaterial = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Productos
        ArrayAdapter<CharSequence> productoAdapter = ArrayAdapter.createFromResource(this,
                R.array.productos_array, android.R.layout.simple_spinner_item);
        productoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProducto.setAdapter(productoAdapter);

        spinnerProducto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedProducto = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void setupButton() {
        btnEnviar.setOnClickListener(v -> {
            String pesoStr = etPeso.getText().toString();
            if (pesoStr.isEmpty()) {
                Toast.makeText(this, "Ingrese el peso", Toast.LENGTH_SHORT).show();
                return;
            }

            double peso = Double.parseDouble(pesoStr);
            enviarReciclaje(selectedMaterial, selectedProducto, peso);
        });
    }

    private void enviarReciclaje(String material, String producto, double peso) {
        // Crear objeto de reciclaje y enviar al servidor
        ReciclajeRequest request = new ReciclajeRequest(material, producto, peso);

        ApiClient.getClient(this).registrarReciclaje(request).enqueue(new Callback<ReciclajeResponse>() {
            @Override
            public void onResponse(Call<ReciclajeResponse> call, Response<ReciclajeResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ReciclajeResponse reciclajeResponse = response.body();
                    Toast.makeText(ReciclarActivity.this,
                            "Reciclaje registrado! Puntos obtenidos: " + reciclajeResponse.getPuntos_obtenidos(),
                            Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Toast.makeText(ReciclarActivity.this,
                            "Error al registrar reciclaje",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ReciclajeResponse> call, Throwable t) {
                Toast.makeText(ReciclarActivity.this,
                        "Error de conexión: " + t.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}