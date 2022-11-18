package com.example.lab09;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText Login;
    EditText Email;
    EditText Password;

    Button btnSave, btnLoad;

    SharedPreferences sPref;

    final String SAVED_TEXT = "saved_text";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Login =  findViewById(R.id.editTextLogin);
        Email =  findViewById(R.id.editTextEmail);
        Password =  findViewById(R.id.editTextPassword);

        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);

        btnLoad = findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);

        loadText();

    }

    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                saveText();
                break;
            case R.id.btnLoad:
                loadText();
                break;
            default:
                break;
        }
    }



    void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("Login", Login.getText().toString());
        ed.putString("Email", Email.getText().toString());
        ed.putString("Password", Password.getText().toString());
        ed.apply();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();

    }

    void loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        String savedText1 = sPref.getString("Login", "");
        String savedText2 = sPref.getString("Email", "");
        String savedText3 = sPref.getString("Password", "");
        Login.setText(savedText1);
        Email.setText(savedText2);
        Password.setText(savedText3);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }
}

