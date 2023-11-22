package com.example.pr17;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddGroupActivity extends AppCompatActivity {

    EditText Name, StudentsCount;
    Button Add_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_group);

        Name = findViewById(R.id.name);
        StudentsCount = findViewById(R.id.count);
        Add_btn = findViewById(R.id.add_btn);

        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);

        Add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Group group = new Group(0, Name.getText().toString(), Integer.parseInt(StudentsCount.getText().toString()));
                dataBaseHelper.addGroups(group);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}