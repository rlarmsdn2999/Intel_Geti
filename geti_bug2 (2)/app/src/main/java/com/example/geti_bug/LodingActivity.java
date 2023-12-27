package com.example.geti_bug;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class LodingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loding);
        ImageView imageView8 = findViewById(R.id.imageView2);

        Glide.with(this).load(R.raw.loding).into(imageView8);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent ld = new Intent(LodingActivity.this, MainActivity.class);
                startActivity(ld);
                finish();
            }
        }, 3000); // 3초 후 화면 전환
    }
}