package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = editText.getText().toString();

                if (userName.isEmpty()
                        || !userName.matches(".*[a-zA-Z].*")
                        || userName.matches(".*[^a-zA-Z].*")) {
                    Toast.makeText(MainActivity.this,
                            "You must write the name in letters only", Toast.LENGTH_SHORT).show();
                } else {
                    //Explicit Intent
                    Intent i = new Intent(
                            getApplicationContext(),
                            MainActivity2.class
                    );

                    // Passing the name to second activity
                    i.putExtra("name", userName);
                    startActivity(i);
                }
            }
        });
    }
}