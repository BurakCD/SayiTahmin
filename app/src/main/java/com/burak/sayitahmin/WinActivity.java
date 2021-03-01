package com.burak.sayitahmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WinActivity extends AppCompatActivity {

    private Button retryGame, returnMainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        retryGame = findViewById(R.id.retryGame);
        returnMainMenu = findViewById(R.id.returnMainMenu);

        retryGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(WinActivity.this, GameActivity.class));
                WinActivity.super.onBackPressed();
            }
        });

        returnMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WinActivity.this, MainActivity.class));
            }
        });
    }
}