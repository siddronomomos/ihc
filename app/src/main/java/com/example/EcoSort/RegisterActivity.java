package com.example.EcoSort;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.util.Log;
import com.example.EcoSort.models.RegisterRequest;
import com.example.EcoSort.models.RegisterResponse;

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = "RegisterActivity";

    private EditText etUsername;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private Button btnRegister;
    private Button btnBack;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initializeViews();
        setupListeners();
    }

    private void initializeViews() {
        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        btnBack = findViewById(R.id.btnBack);
    }

    private void setupListeners() {
        btnRegister.setOnClickListener(v -> attemptRegistration());
        btnBack.setOnClickListener(v -> finish());
    }

    private void attemptRegistration() {
        // Obtener y limpiar los valores de entrada
        String username = etUsername.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString();
        String confirmPassword = etConfirmPassword.getText().toString();

        // Validar los campos
        if (!validateInputs(username, email, password, confirmPassword)) {
            return;
        }

        // Mostrar diálogo de progreso
        showProgressDialog();

        // Crear solicitud de registro
        RegisterRequest registerRequest = new RegisterRequest(username, email, password);

        // Realizar la llamada a la API
        ApiClient.getClient(this).register(registerRequest).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                dismissProgressDialog();

                if (response.isSuccessful() && response.body() != null) {
                    RegisterResponse registerResponse = response.body();
                    if ("success".equals(registerResponse.getStatus())) {
                        Toast.makeText(RegisterActivity.this,
                                "Registro exitoso. Por favor, inicie sesión.",
                                Toast.LENGTH_LONG).show();

                        // Regresar a la pantalla de login
                        finish();
                    } else {
                        showError("Error en el registro: " + registerResponse.getError());
                    }
                } else {
                    showError("Error en el registro. Por favor, intente nuevamente.");
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                dismissProgressDialog();
                showError("Error de conexión: " + t.getMessage());
                Log.e(TAG, "Error de registro", t);
            }
        });
    }

    private boolean validateInputs(String username, String email, String password, String confirmPassword) {
        // Validar usuario
        if (username.isEmpty()) {
            etUsername.setError("El nombre de usuario es requerido");
            etUsername.requestFocus();
            return false;
        }

        // Validar email
        if (email.isEmpty()) {
            etEmail.setError("El email es requerido");
            etEmail.requestFocus();
            return false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Por favor ingrese un email válido");
            etEmail.requestFocus();
            return false;
        }

        // Validar contraseña
        if (password.isEmpty()) {
            etPassword.setError("La contraseña es requerida");
            etPassword.requestFocus();
            return false;
        }
        if (password.length() < 6) {
            etPassword.setError("La contraseña debe tener al menos 6 caracteres");
            etPassword.requestFocus();
            return false;
        }

        // Validar confirmación de contraseña
        if (!password.equals(confirmPassword)) {
            etConfirmPassword.setError("Las contraseñas no coinciden");
            etConfirmPassword.requestFocus();
            return false;
        }

        return true;
    }

    private void showProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Registrando usuario...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    private void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    private void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismissProgressDialog();
    }
}