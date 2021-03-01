package com.burak.sayitahmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoseActivity extends AppCompatActivity {

    private Button retryGame, returnMainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);

        retryGame = findViewById(R.id.retryGame2);
        returnMainMenu = findViewById(R.id.returnMainMenu2);

        retryGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(LoseActivity.this, GameActivity.class));
                LoseActivity.super.onBackPressed();
            }
        });

        returnMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoseActivity.this, MainActivity.class));
            }
        });
    }
}