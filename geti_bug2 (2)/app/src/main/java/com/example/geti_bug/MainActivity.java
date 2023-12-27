package com.example.geti_bug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.chip.Chip;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView8 = findViewById(R.id.imageView10);

        Glide.with(this).load(R.raw.gif1).into(imageView8);
    }

    public void cameraBtn(View view) {
        Chip chip1 = findViewById(R.id.chip1);
        ImageView iv = findViewById(R.id.imageView4);

        chip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToCameraActivity();
            }
        });

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToCameraActivity();

            }
        });
    }

    private void navigateToCameraActivity() {
        Intent intent = new Intent(MainActivity.this, CameraActivity.class);
        startActivity(intent);
    }

    public void information2(View view) {
        Chip chip2 = findViewById(R.id.chip2);
        ImageView iv = findViewById(R.id.imageView5);

        chip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToInformationActivity();
            }
        });

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToInformationActivity();
            }
        });
    }

    private void navigateToInformationActivity() {
        Intent intent = new Intent(MainActivity.this, InformationActivity.class);
        startActivity(intent);
    }

    public void onImageViewClick(View view) {
        String url = "https://www.cesco.co.kr/homepage/qna/list";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    public void ee(View view) {
        Intent intent = new Intent(MainActivity.this, EasterEggActivity.class);
        startActivity(intent);
    }

    public void giude(View view) {
        Intent intent = new Intent(MainActivity.this, GiudeActivity.class);
        startActivity(intent);
    }
}