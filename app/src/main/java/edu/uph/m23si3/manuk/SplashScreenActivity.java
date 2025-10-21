package edu.uph.m23si3.manuk;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    private TextView manukText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView logoImage = findViewById(R.id.logoImage);
        manukText = findViewById(R.id.textManuk);

        // 1️⃣ Logo ayam berputar pelan bolak-balik
        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.logo_rotate);
        logoImage.startAnimation(rotate);

        // 2️⃣ Setelah rotasi selesai, munculkan teks "Manuk!" dengan fade-in halus
        new Handler().postDelayed(() -> {
            manukText.setVisibility(TextView.VISIBLE);
            Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
            manukText.startAnimation(fadeIn);
        }, 1000); // muncul 1 detik setelah logo mulai berputar

        // 3️⃣ Setelah teks tampil beberapa saat, lanjut ke Onboarding 1
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashScreenActivity.this, OnboardingActivity1.class));
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        }, 2800); // total durasi splash ±2.8 detik
    }
}
