package com.example.geti_bug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        ListView listView = findViewById(R.id.listview);

        List<String> list = new ArrayList<>();
        list.add("곱등이");
        list.add("그리마");
        list.add("빈대");
        list.add("집게벌레");
        list.add("쌀바구미");
        list.add("나방파리");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String data = (String) adapterView.getItemAtPosition(position);
                Intent intent = new Intent(view.getContext(), BugActivity.class);
                intent.putExtra("이름", data);
                startActivity(intent);
            }
        });

        ImageView imageView8 = findViewById(R.id.imageView11);

        Glide.with(this).load(R.raw.gif3).into(imageView8);
    }
}