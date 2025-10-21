package edu.uph.m23si3.manuk;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class OnboardingActivity1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding1);

        Button btnNext = findViewById(R.id.btnNext); // pastikan id-nya sama dengan xml
        btnNext.setOnClickListener(v -> {
            startActivity(new Intent(OnboardingActivity1.this, OnboardingActivity2.class));
            finish();
        });
    }
}
