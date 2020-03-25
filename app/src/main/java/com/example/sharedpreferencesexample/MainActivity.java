package com.example.sharedpreferencesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView name;
    private TextView currName;
    private EditText changeName;
    private Button button;
    private String n;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.DefaultName);
        currName = findViewById(R.id.CustomName);
        changeName = findViewById(R.id.EditName);
        button = findViewById(R.id.button);

        final SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);

        name.setText(sharedPreferences.getString(n,name.getText().toString()));


        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                name.setText(changeName.getText());

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(n,name.getText().toString());
                editor.commit();
                Toast.makeText(MainActivity.this,"Thanks",Toast.LENGTH_LONG).show();

            }
        });
    }






}
