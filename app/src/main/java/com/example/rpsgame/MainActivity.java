package com.example.rpsgame;
import java.util.Random;
import android.os.Handler;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;





public class MainActivity extends AppCompatActivity {
    TextView yourScore, cpuScore, result;
    ImageView yourChoice, cpuChoice;
    ImageButton rockButton, paperButton, scissorButton, restartGame;

    int playerScore = 0;
    int computerScore = 0;
    int cpunum;

    Random random = new Random();
    String win = "Hurray! You won!!";
    String draw = "Draw, Better luck Next Time :)";
    String lose = "Oops... You Lost ＞﹏＜";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        yourScore = findViewById(R.id.yourScore);
        result = findViewById(R.id.result);
        cpuScore = findViewById(R.id.cpuScore);
        yourChoice = findViewById(R.id.yourChoice);
        cpuChoice = findViewById(R.id.cpuChoice);
        rockButton = findViewById(R.id.rockButton);
        paperButton = findViewById(R.id.paperButton);
        scissorButton = findViewById(R.id.scissorButton);
        restartGame = findViewById(R.id.restartGame);

        rockButtonMethod();
        paperButtonMethod();
        scissorButtonMethod();
        restartGameMethod();


    }
    void rockButtonMethod(){
        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cpunum = random.nextInt(3);
                yourChoice.setImageResource(R.drawable.rock);
                if (cpunum == 0){
                    cpuChoice.setImageResource(R.drawable.rock);
                    result.setText(draw);
                } else if (cpunum == 1) {
                    cpuChoice.setImageResource(R.drawable.paper);
                    result.setText(lose);
                    computerScore ++;
                    cpuScore.setText(String.valueOf(computerScore));
                }else {
                    cpuChoice.setImageResource(R.drawable.scissor);
                    result.setText(win);
                    playerScore ++;
                    yourScore.setText(String.valueOf(playerScore));
                }
                result.setVisibility(View.VISIBLE);
            }
        });
    }

    void paperButtonMethod(){
        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cpunum = random.nextInt(3);
                yourChoice.setImageResource(R.drawable.paper);
                if (cpunum == 1){
                    cpuChoice.setImageResource(R.drawable.paper);
                    result.setText(draw);
                } else if (cpunum == 2) {
                    cpuChoice.setImageResource(R.drawable.scissor);
                    result.setText(lose);
                    computerScore ++;
                    cpuScore.setText(String.valueOf(computerScore));
                }else {
                    cpuChoice.setImageResource(R.drawable.rock);
                    result.setText(win);
                    playerScore ++;
                    yourScore.setText(String.valueOf(playerScore));
                }
                result.setVisibility(View.VISIBLE);
            }
        });
    }

    void scissorButtonMethod(){
        scissorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cpunum = random.nextInt(3);
                yourChoice.setImageResource(R.drawable.scissor);
                if (cpunum == 2){
                    cpuChoice.setImageResource(R.drawable.scissor);
                    result.setText(draw);
                } else if (cpunum == 0) {
                    cpuChoice.setImageResource(R.drawable.rock);
                    result.setText(lose);
                    computerScore ++;
                    cpuScore.setText(String.valueOf(computerScore));
                }else {
                    cpuChoice.setImageResource(R.drawable.paper);
                    result.setText(win);
                    playerScore ++;
                    yourScore.setText(String.valueOf(playerScore));
                }
                result.setVisibility(View.VISIBLE);
            }
        });
    }
    void restartGameMethod(){
        restartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerScore = 0;
                computerScore = 0;
                yourScore.setText(String.valueOf(playerScore));
                cpuScore.setText(String.valueOf(computerScore));
                result.setVisibility(View.INVISIBLE);
            }
        });
    }



}
