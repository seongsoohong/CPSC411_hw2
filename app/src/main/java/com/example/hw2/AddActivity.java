package com.example.hw2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button addVehicleButton = findViewById(R.id.addButton);
        addVehicleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableLayout addVehicleTable = findViewById(R.id.addVehicleTable);
                addVehicleTable.setVisibility(View.VISIBLE);
            }
        });




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_done) {
            EditText firstNameEditText = findViewById(R.id.firstNameEditText);
            EditText lastNameEditText = findViewById(R.id.lastNameEditText);
            EditText CWIDEditText = findViewById(R.id.CWIDEditText);
            String newStudentFirstName = firstNameEditText.getText().toString();
            String newStudentLastName = lastNameEditText.getText().toString();
            String newStudentCWID = CWIDEditText.getText().toString();
            Student newStudent = new Student(newStudentFirstName, newStudentLastName, newStudentCWID);

            Intent resultIntent = new Intent();
            resultIntent.putExtra("newStudent", newStudent);
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
