package com.example.dell.bloodbank;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dell.bloodbank.helper.DatabaseAdapter;

public class AddDonorActivity extends AppCompatActivity {

    private TextInputLayout nameText,phoneText,addressText;
    private Spinner spinner;
    private DatabaseAdapter helper;
    private Button addDonor_button;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donor);

        nameText=(TextInputLayout)findViewById(R.id.addDonor_name_);
        phoneText=(TextInputLayout)findViewById(R.id.addDonor_phone);
        addressText=(TextInputLayout)findViewById(R.id.addDonor_address);
        spinner=(Spinner)findViewById(R.id.addDonor_spinner);
        addDonor_button=(Button)findViewById(R.id.addDonor_addbutton);

        helper=new DatabaseAdapter(this);



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                                                R.array.group_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        addDonor_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String name = nameText.getEditText().getText().toString();
                String phone = phoneText.getEditText().getText().toString();
                String address = addressText.getEditText().getText().toString();
                String group =spinner.getSelectedItem().toString();

            long id=  helper.insertDonor(name,phone,address,group);
                if(id<0){
                Toast.makeText(AddDonorActivity.this," data is not inserted",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(AddDonorActivity.this," data is inserted",Toast.LENGTH_LONG).show();
                }



            }
        });

    }
}
