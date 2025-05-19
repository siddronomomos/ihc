package com.example.EcoSort;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.EcoSort.models.LoginRequest;
import com.example.EcoSort.models.LoginResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private EditText etUsername, etPassword;
    private Button btnLogin, btnRegister;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }


            try {
                authenticateUser(username, password);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        btnRegister.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    private void authenticateUser(String username, String password) throws InterruptedException {
        LoginRequest loginRequest = new LoginRequest(username, password); // Cambiado para usar username

        ApiClient.getClient(this).login(loginRequest).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    LoginResponse loginResponse = response.body();
                    SessionManager.saveToken(LoginActivity.this, loginResponse.getToken());
                    SessionManager.saveUserId(LoginActivity.this, loginResponse.getUserId());
                    SessionManager.saveUsername(LoginActivity.this, username);

                    Intent intent = new Intent(LoginActivity.this, Principal.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this,
                            "Credenciales incorrectas",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this,
                        "Error de conexión: " + t.getMessage(),
                        Toast.LENGTH_LONG).show();
                Log.e(TAG, "Error de autenticación", t);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}