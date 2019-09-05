package com.example.firebasecrud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText txtID , txtName , txtAdd , txtConNo;
    Button btnSave , btnShow , btnUpdate , btnDelete;
    DatabaseReference dbRef;
    Student std;

    private void clearControls(){
        txtID.setText("");
        txtName.setText("");
        txtAdd.setText("");
        txtConNo.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtID = findViewById(R.id.txtid);
        txtName = findViewById(R.id.txtname);
        txtAdd = findViewById(R.id.txtaddress);
        txtConNo = findViewById(R.id.txtcontact);

        btnSave = findViewById(R.id.buttonAdd);
        btnShow = findViewById(R.id.buttonshow);
        btnUpdate = findViewById(R.id.buttonUpdate);
        btnDelete = findViewById(R.id.buttonDelete);

        std = new Student();


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Student");

                try {
                    if (TextUtils.isEmpty(txtID.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter ID", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtName.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtAdd.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a Address", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtConNo.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a contact Number", Toast.LENGTH_SHORT).show();
                    else {
                        std.setID(txtID.getText().toString().trim());
                        std.setName(txtName.getText().toString().trim());
                        std.setAddress(txtAdd.getText().toString().trim());
                        std.setConNo(Integer.parseInt(txtConNo.getText().toString().trim()));

                        dbRef.push().setValue(std);

                        Toast.makeText(getApplicationContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();
                        clearControls();
                    }


                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid Contact Number", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }}







