package com.burak.sayitahmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private Button getGuess;
    private EditText guessInput;
    private TextView remainedHearthText, tipText, increasedHealth;
    Random randomizer = new Random();
    int currentHealth = 10;
    final int healthPerWin = 1;
    int winCounter = 0;

    int secretNumber = randomizer.nextInt(101);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        getGuess = findViewById(R.id.getGuess);
        guessInput = findViewById(R.id.guessInput);
        remainedHearthText = findViewById(R.id.remainedHearthText);
        tipText = findViewById(R.id.tipText);
        increasedHealth = findViewById(R.id.increasedHealth);

        remainedHearthText.setText("Kalan hakkınız: " + currentHealth);

        Log.e("Sayı","" + secretNumber);

        getGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (guessInput.getText().toString().equals("")){
                    Toast.makeText(GameActivity.this, "Boş bırakılamaz",Toast.LENGTH_SHORT).show();
                }else {
                    if (currentHealth == 1) {
                        startActivity(new Intent(GameActivity.this, LoseActivity.class));

                        secretNumber = randomizer.nextInt(101);

                        Log.e("Sayı", "" + secretNumber);

                        winCounter = 0;

                        currentHealth = 11;

                        remainedHearthText.setText("Kalan hakkınız: " + currentHealth);

                        increasedHealth.setText("Kazandığınız oyun başına artırılan can: " + winCounter);
                    }

                    if (Integer.parseInt(guessInput.getText().toString()) < secretNumber) {
                        tipText.setText("Tahminin sayıdan küçük!");

                        currentHealth--;

                        remainedHearthText.setText("Kalan hakkınız: " + currentHealth);
                    }

                    if (Integer.parseInt(guessInput.getText().toString()) > secretNumber) {
                        tipText.setText("Tahminin sayıdan büyük!");

                        currentHealth--;

                        remainedHearthText.setText("Kalan hakkınız: " + currentHealth);
                    }

                    if (Integer.parseInt(guessInput.getText().toString()) == secretNumber) {
                        startActivity(new Intent(GameActivity.this, WinActivity.class));

                        currentHealth = 10;

                        winCounter++;

                        if (winCounter > 0) {
                            int numberToAdd = healthPerWin * winCounter;
                            currentHealth += numberToAdd;
                        }

                        if (currentHealth > 20) {
                            currentHealth = 20;
                        }

                        remainedHearthText.setText("Kalan hakkınız: " + currentHealth);

                        increasedHealth.setText("Kazandığınız oyun başına artırılan can: " + winCounter);

                        secretNumber = randomizer.nextInt(101);
                        Log.e("Sayı", "" + secretNumber);


                    }
                }
                guessInput.setText(""); //onClick altına alarak, önceki tahminin silinmeme problemi çözüldü.
            }

        });

    }

}