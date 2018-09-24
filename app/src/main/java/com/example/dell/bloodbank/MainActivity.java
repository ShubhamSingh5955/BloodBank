package com.example.dell.bloodbank;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.dell.bloodbank.helper.DatabaseAdapter;

public class MainActivity extends AppCompatActivity {

   private ImageView addDonorButton,viewDonorButton;
        DatabaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addDonorButton=(ImageView)findViewById(R.id.addDonorButton);
        viewDonorButton=(ImageView)findViewById(R.id.viewDonorButtton);

        adapter=new DatabaseAdapter(this);

        addDonorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AddDonorActivity.class);
                startActivity(intent);
            }
        });

        viewDonorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ViewDonorActivity.class);
                startActivity(intent);
            }
        });


    }



}
