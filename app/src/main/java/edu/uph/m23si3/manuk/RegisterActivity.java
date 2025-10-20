package edu.uph.m23si3.manuk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    // Deklarasi semua komponen UI
    EditText etFullName, etEmail, etPassword, etConfirmPassword;
    MaterialButton btnSignUp;
    TextView tvLoginTitle, tvWelcome, tvLogInPrompt, tvLogInLink;
    ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        // Atur agar layout menyesuaikan status bar dan navigation bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi semua view
        tvLoginTitle = findViewById(R.id.tvLoginTitle);
        tvWelcome = findViewById(R.id.tvWelcome);
        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        tvLogInPrompt = findViewById(R.id.tvLogInPrompt);
        tvLogInLink = findViewById(R.id.tvLogInLink);
        imgLogo = findViewById(R.id.imgLogo);

        // Event klik tombol Sign Up
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ambil data input dari user
                String fullName = etFullName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String confirmPassword = etConfirmPassword.getText().toString().trim();

                // Validasi sederhana
                if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    etFullName.setError(fullName.isEmpty() ? "Required" : null);
                    etEmail.setError(email.isEmpty() ? "Required" : null);
                    etPassword.setError(password.isEmpty() ? "Required" : null);
                    etConfirmPassword.setError(confirmPassword.isEmpty() ? "Required" : null);
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    etConfirmPassword.setError("Passwords do not match");
                    return;
                }

                // Misal: proses register (bisa ditambahkan logika Firebase atau database)
                // Untuk sekarang tampilkan Logcat atau pindah halaman login
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Event klik teks “Log In” → pindah ke halaman login
        tvLogInLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
