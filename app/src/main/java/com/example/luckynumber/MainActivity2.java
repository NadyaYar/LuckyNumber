package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    TextView welcomeText, luckyNumberText;
    Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        welcomeText = findViewById(R.id.text_lucky);
        luckyNumberText = findViewById(R.id.text_answer);
        shareButton = findViewById(R.id.button_share);

        Intent i = getIntent();

        String userName = i.getStringExtra("name");
        int random_num = generateRandomNumber();
        luckyNumberText.setText("" + random_num);

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareDate(userName, random_num);
            }
        });


    }

    public int generateRandomNumber() {
        Random random = new Random();
        int upper_limit = 1000;

        return random.nextInt(upper_limit);
    }

    public void shareDate(String username, int randomNum) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plagin");
        i.putExtra(Intent.EXTRA_SUBJECT, username + " got lucky today");
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is: " + randomNum);
        startActivity(Intent.createChooser(i,"Choose a Platform"));
    }
}