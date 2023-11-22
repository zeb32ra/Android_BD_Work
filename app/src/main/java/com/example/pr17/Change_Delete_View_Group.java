package com.example.pr17;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Change_Delete_View_Group extends AppCompatActivity {

    EditText Name, Count;
    Button Change, Delete;
    int id, StudentsCount;
    String Group_Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_delete_view_group);
        Name = findViewById(R.id.name_for_change);
        Count = findViewById(R.id.count_for_change);
        Change = findViewById(R.id.change_btn);
        Delete = findViewById(R.id.delete_btn);
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            id = extras.getInt("ID");
            Group_Name = extras.getString("Name");
            StudentsCount = extras.getInt("Count");
            Name.setText(Group_Name);
            Count.setText(StudentsCount + "");
        }

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBaseHelper.deleteGroups(id);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Group group = new Group(id, Name.getText().toString(), Integer.parseInt(Count.getText().toString()));
                dataBaseHelper.changeGroups(group);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}