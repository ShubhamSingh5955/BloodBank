package com.example.dell.bloodbank;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.dell.bloodbank.helper.DatabaseAdapter;
import com.example.dell.bloodbank.helper.DonorAdapter;
import com.example.dell.bloodbank.model.Donor;

import java.util.ArrayList;
import java.util.List;

public class ViewDonorActivity extends AppCompatActivity {
    private DonorAdapter mAdapter;
    private List<Donor> donorsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Spinner spinner;
    private DatabaseAdapter databaseAdapter;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_donor);
        spinner=(Spinner)findViewById(R.id.viewDonor_spinner);
        recyclerView=(RecyclerView)findViewById(R.id.viewDonor_recyclerView);
        button=(Button)findViewById(R.id.viewDonor_search_button);

        databaseAdapter=new DatabaseAdapter(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.group_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String blood_group=spinner.getSelectedItem().toString();
                donorsList=databaseAdapter.getDonor(blood_group);

                mAdapter = new DonorAdapter(ViewDonorActivity.this, donorsList);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setAdapter(mAdapter);

            }
        });



    }
}
