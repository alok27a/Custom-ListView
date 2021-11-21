package com.alok.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.alok.customlistview.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {
    TextView name1;
    TextView regno1;
    TextView dob1;
    TextView branch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        name1=findViewById(R.id.textView);
        regno1=findViewById(R.id.textView2);
        dob1=findViewById(R.id.textView3);
        branch1=findViewById(R.id.textView4);



        Intent intent = this.getIntent();
        String name = intent.getStringExtra("name");
        String regno = intent.getStringExtra("registerno");
        String dob = intent.getStringExtra("dob");
        String branch = intent.getStringExtra("branch");

        name1.setText("Name : "+name);
        regno1.setText("Register Number : "+regno);
        dob1.setText("DOB : "+dob);
        branch1.setText("Branch : "+branch);
    }
}